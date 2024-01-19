package com.generation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.model.entities.Glass;
import com.generation.model.entities.User;
import com.generation.model.repositories.GlassRepositoryMock;
import com.generation.model.repositories.GlasswareRepository;
import com.generation.model.repositories.UserRepoMock;

@WebServlet("/glassadmin")
public class GlassAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cmd = req.getParameter("cmd");
        if (cmd == null) {
            manageLogin(req, resp);
            return;
        }

        switch (cmd) {
            case "update":
                manageUpdate(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String material = req.getParameter("material");
        String priceString = req.getParameter("price");
        String[] priceParts = priceString.split(",");
        int parteIntera = Integer.parseInt(priceParts[0]);
        int parteDecimale = Integer.parseInt(priceParts[1]);

        int nDecimali = priceParts[1].length();// nel mio caso varrà 4
        String divisore = "10";
        // 9,2 -> divisore è 10
        // 9,20 -> divisore è 100
        // 9,202 -> divisore è 1000
        for (int i = 1; i < nDecimali; i++)
            divisore += "0";

        divisore += ".0";
        double div = Double.parseDouble(divisore);
        double price = parteIntera + parteDecimale / div;
        int volume = Integer.parseInt(req.getParameter("volume"));
        int id = Integer.parseInt(req.getParameter("id"));
        String color = req.getParameter("color");
        String type = req.getParameter("type");

        Glass modified = new Glass(id, material, price, volume, color, type);
        GlasswareRepository<Glass> glRepo = new GlassRepositoryMock();

        glRepo.update(modified);

        req.setAttribute("glasses", glRepo.readAll());
        req.getRequestDispatcher("/glassadmin/adminPage.ftl").forward(req, resp);
        return;
    }

    // metodo per gestire tutta la parte di login
    private void manageLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepoMock uRepo = new UserRepoMock();
        GlassRepositoryMock gRepo = new GlassRepositoryMock();

        if (req.getSession().getAttribute("user") != null) {
            req.setAttribute("glasses", gRepo.readAll());
            req.getRequestDispatcher("/glassadmin/adminPage.ftl").forward(req, resp);
            return;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = uRepo.login(username, password);

        if (user != null) {
            // getSessionFromMemoryForIdSpecifiedInTheRequest
            req.getSession().setAttribute("user", user);
            req.setAttribute("glasses", gRepo.readAll());
            req.getRequestDispatcher("/glassadmin/adminPage.ftl").forward(req, resp);
        } else {

            if (password != null)
                req.setAttribute("wrongPass", true);
            req.setAttribute("source", "glass");
            req.getRequestDispatcher("/passwordRequest.ftl").forward(req, resp);
        }
    }

    private void manageUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        GlasswareRepository<Glass> glRepo = new GlassRepositoryMock();
        Glass toModify = glRepo.readById(id);
        req.setAttribute("glassToUpdate", toModify);
        req.setAttribute("glasses", glRepo.readAll());
        req.getRequestDispatcher("/glassadmin/adminPage.ftl").forward(req, resp);
    }
}
