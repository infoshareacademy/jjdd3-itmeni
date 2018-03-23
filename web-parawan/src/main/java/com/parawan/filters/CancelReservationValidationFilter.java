package com.parawan.filters;

import com.parawan.com.menu.CancelReservation;
import com.parawan.dao.ReservationDao;
import com.parawan.messages.UserOperationsMessages;
import com.parawan.model.Reservation;
import com.parawan.model.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@WebFilter(
        filterName = "CancelReservationValidationFilter",
        urlPatterns = {"/parawan/cancel-reservation"}
)

public class CancelReservationValidationFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(CancelReservationValidationFilter.class);

    @Inject
    private UserSession userSession;

    @Inject
    private ReservationDao reservationDao;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        boolean isValidationOK = true;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        CancelReservation cancelReservation = getCancelObject(httpRequest);
        List<String> messages = new ArrayList<>();

        String idParameter = httpRequest.getParameter("cancelId");
        String hourParameter = httpRequest.getParameter("cancelHour");

        if (idParameter != null && hourParameter != null) {
            if (!isThisUsersReservation(Integer.parseInt(hourParameter), Integer.parseInt(idParameter))) {
                isValidationOK = false;
            }
        }

        if (!isIntegerParameterValid("cancelId", httpRequest)) {
            messages.add(UserOperationsMessages.ID_NOT_INTEGER);
            isValidationOK = false;
        } else if (idParameter != null && !idParameter.isEmpty()) {
            cancelReservation.setCancelId(Integer.parseInt(idParameter));
        }

        if (!isIntegerParameterValid("cancelHour", httpRequest)) {
            messages.add(UserOperationsMessages.HOUR_NOT_INTEGER);
            isValidationOK = false;
        } else if (hourParameter != null && !hourParameter.isEmpty()) {
            cancelReservation.setCancelHour(Integer.parseInt(httpRequest.getParameter("cancelHour")));
        }

        if (!isValidationOK) {
            httpRequest.getSession().setAttribute("errors", messages);
            httpRequest.getSession().setAttribute("cancelReservation", cancelReservation);
            httpResponse.sendRedirect("/parawan/cancel-reservation");
            return;
        }


        filterChain.doFilter(servletRequest, servletResponse);
    }

    private CancelReservation getCancelObject(HttpServletRequest servletRequest) {
        CancelReservation cancelReservation = new CancelReservation();
        cancelReservation.setCancelId(null);
        cancelReservation.setCancelHour(null);
        return cancelReservation;
    }

    private boolean isIntegerParameterValid(String parameterKey, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(parameterKey);
        HttpServletRequest httpRequest = servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        LOG.debug("{}", String.valueOf(isPost));

        if (parameter == null || parameter.isEmpty()) {
            return !isPost;
        }

        Pattern integerPattern = Pattern.compile("\\d+");
        Matcher matcher = integerPattern.matcher(parameter);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

    private boolean isThisUsersReservation(Integer hourOfReservation, Integer placeId) {
        List<Reservation> reservations = reservationDao.findByName(userSession.getEmail());
        if (reservations == null || reservations.isEmpty()) {
            return false;
        }
        if (reservations.stream()
                .filter(x -> (x.getHourOfReservation() == hourOfReservation && x.getPlaceId() == placeId))
                .collect(Collectors.toList())
                .isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void destroy() {
    }

}
