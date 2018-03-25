package com.parawan.servlets;

import com.parawan.dao.BeachDao;
import com.parawan.dao.ItemDao;
import com.parawan.filters.IntegerValidator;
import com.parawan.model.Beach;
import com.parawan.model.Item;
import org.junit.jupiter.api.BeforeEach;

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

    @Inject
    private ItemDao itemDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("beachName") == null
               || req.getParameter("beachX") == null
               || req.getParameter("beachY") == null){
            resp.sendRedirect("/parawan/admin");
        } else  if ( !new IntegerValidator().isIntegerParameterValid("beachX", req)
        || !new IntegerValidator().isIntegerParameterValid("beachY", req )){
            resp.sendRedirect("/parawan/admin");
        } else {
            Beach newBeach = new Beach(null,
                    req.getParameter("beachName"),
                    Math.abs(Integer.parseInt(req.getParameter("beachX"))),
                    Math.abs(Integer.parseInt(req.getParameter("beachY"))));

            beachDao.save(newBeach);
            addDefaultItems(newBeach);
            resp.sendRedirect("/parawan/admin?createdBeach=true");
        }

    }

  private void addDefaultItems(Beach newBeach){
        itemDao.save(new Item("screen", "s", 0, newBeach));
        itemDao.save(new Item("umbrella", "u", 0, newBeach));
        itemDao.save(new Item("towel", "t", 0, newBeach));
        itemDao.save(new Item("sunbed", "b", 0, newBeach));
    }
}