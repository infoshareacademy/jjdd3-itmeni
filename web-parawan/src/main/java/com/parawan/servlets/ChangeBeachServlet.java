package com.parawan.servlets;

import com.parawan.dao.BeachDao;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import com.parawan.model.Beach;
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
import java.util.List;
import java.util.Map;

@WebServlet("/parawan/change-beach")
public class ChangeBeachServlet extends HttpServlet {

    @Inject
    private ActualBeach actualBeach;

    @Inject
    private BeachDao beachDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        changeActualBeachParameters(beachDao.findById(Integer.parseInt(req.getParameter("beach"))));
        resp.sendRedirect("/parawan/main-menu");
    }

    private void changeActualBeachParameters(Beach beach){
        actualBeach.setId(beach.getId());
        actualBeach.setName(beach.getName());
        actualBeach.setMaxWidth(beach.getMaxWidth());
        actualBeach.setMaxHeight(beach.getMaxHeight());
    }
}
