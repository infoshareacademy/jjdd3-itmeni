package com.parawan.servlets;

import com.parawan.dao.BeachDao;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import com.parawan.model.Beach;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
import org.slf4j.Logger;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Inject
    private ActualBeach actualBeach;

    @Inject
    private BeachDao beachDao;

    private static final Logger LOG = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setActualBeachIfNotSet(actualBeach);
        Map<String, Object> dataModel = new HashMap<>();
        List<Beach> beaches = beachDao.findAll();
        dataModel.put("beaches", beaches);
        dataModel.put("actualBeach", actualBeach);
        dataModel.put("bodytemplate", "hello");
        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }

    public void setActualBeachIfNotSet(ActualBeach actualBeach) {
        if(actualBeach.getName() == null || actualBeach.getName().isEmpty()){
            List<Beach> beaches = beachDao.findAll();
            if(beaches.size() != 0) {
                Beach firstBeachFromDatabase = beaches.get(0);
                actualBeach.setId(firstBeachFromDatabase.getId());
                actualBeach.setName(firstBeachFromDatabase.getName());
                actualBeach.setMaxWidth(firstBeachFromDatabase.getMaxWidth());
                actualBeach.setMaxHeight(firstBeachFromDatabase.getMaxHeight());
            } else {
                LOG.error("Error while loading data from database");
            }
        }
    }
}
