package com.parawan.servlets;

import com.parawan.dao.ItemDao;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import com.parawan.model.Item;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("parawan/admin")
public class AdminServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(AdminServlet.class);

    @Inject
    private ActualBeach actualBeach;

    @Inject
    private ItemDao itemDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> dataModel = new HashMap<>();

        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");
        if (req.getParameter("updatedItems") != null) {
            dataModel.put("updatedItems", true);
        }
        if (req.getParameter("createdBeach") != null) {
            dataModel.put("createdBeach", true);
        }
        dataModel.put("actualBeach", actualBeach);
        dataModel.put("bodytemplate", "admin");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setItems(req, resp);
    }

    private void setItems(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Item screen = itemDao.getItemByAbbreviation("s");
        Item umbrella = itemDao.getItemByAbbreviation("u");
        Item towel = itemDao.getItemByAbbreviation("t");
        Item sunbed = itemDao.getItemByAbbreviation("b");

        int newAmountOfScreens = Integer.parseInt(req.getParameter("screen"));
        int newAmountOfUmbrellas = Integer.parseInt(req.getParameter("umbrella"));
        int newAmountOfTowels = Integer.parseInt(req.getParameter("towel"));
        int newAmountOfSunbeds = Integer.parseInt(req.getParameter("sunbed"));

        screen.setQuantity(newAmountOfScreens);
        umbrella.setQuantity(newAmountOfUmbrellas);
        towel.setQuantity(newAmountOfTowels);
        sunbed.setQuantity(newAmountOfSunbeds);

        itemDao.update(screen);
        itemDao.update(umbrella);
        itemDao.update(towel);
        itemDao.update(sunbed);
        resp.sendRedirect("/parawan/admin?updatedItems=true");
    }
}
