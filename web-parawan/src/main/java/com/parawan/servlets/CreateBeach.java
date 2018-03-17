package com.parawan.servlets;

import com.parawan.dao.BeachDao;
import com.parawan.model.Beach;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("parawan/admin/createbeach")
public class CreateBeach extends HttpServlet {

    @Inject
    private BeachDao beachDao;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("beachName") == null
               || req.getParameter("beachX") == null
               || req.getParameter("beachY") == null){
            resp.sendRedirect("/parawan/admin");
        } else {
          beachDao.save(new Beach(null,
                    req.getParameter("beachName"),
                    Integer.parseInt(req.getParameter("beachX")),
                    Integer.parseInt(req.getParameter("beachY"))));
          resp.sendRedirect("/parawan/admin?createdBeach=true");
        }

    }
}