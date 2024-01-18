package com.generation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.model.entities.Cup;
import com.generation.model.repositories.CupRepositoryMock;
import com.generation.model.repositories.GlasswareRepository;

@WebServlet("/cupsadmin")
public class CupsAdminController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String cmd= req.getParameter("cmd");
        if(cmd==null)
        {
            manageLogin(req,resp);
            return;
        }

        switch(cmd)
        {
            case "update":
                manageUpdate(req,resp);
            break;
        }
    }

    //metodo per gestire tutta la parte di login
    private void manageLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String passwordGiusta = "tazza";
        String passwordInserita = req.getParameter("password");
        if(passwordInserita==null)
        {
            req.setAttribute("wrongPass", false);
            req.getRequestDispatcher("/cupsadmin/passwordRequest.ftl").forward(req, resp);
            return;
        }
        //Mostrarne un altra se la password è corretta
        if(passwordInserita.equals(passwordGiusta))
        {
            GlasswareRepository<Cup> cupRepo = new CupRepositoryMock();
            req.setAttribute("cups", cupRepo.readAll());
            req.getRequestDispatcher("/cupsadmin/adminPage.ftl").forward(req, resp);
            return;
        }
        //Un'altra ancora se è sbagliata
        if(!passwordInserita.equals(passwordGiusta))
        {
            req.setAttribute("wrongPass", true);
            req.getRequestDispatcher("/cupsadmin/passwordRequest.ftl").forward(req, resp);
            return;
        }
    }


    private void manageUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        int id = Integer.parseInt(req.getParameter("id"));
        GlasswareRepository<Cup> cupRepo = new CupRepositoryMock();
        Cup toModify = cupRepo.readById(id);
        req.setAttribute("cupToUpdate", toModify);
        req.setAttribute("cups", cupRepo.readAll());
        req.getRequestDispatcher("/cupsadmin/adminPage.ftl").forward(req, resp);
    }
}   
