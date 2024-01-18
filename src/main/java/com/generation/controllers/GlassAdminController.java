package com.generation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.generation.model.entities.Glass;
import com.generation.model.repositories.GlassRepositoryMock;
import com.generation.model.repositories.GlasswareRepository;

@WebServlet("/glassadmin")
public class GlassAdminController extends HttpServlet
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
        String passwordGiusta = "bicchiere";
        String passwordInserita = req.getParameter("password");
        if(passwordInserita==null)
        {
            req.setAttribute("wrongPass", false);
            req.getRequestDispatcher("/glassadmin/passwordRequest.ftl").forward(req, resp);
            return;
        }
        //Mostrarne un altra se la password è corretta
        if(passwordInserita.equals(passwordGiusta))
        {
            GlasswareRepository<Glass> glRepo = new GlassRepositoryMock();
            req.setAttribute("glasses", glRepo.readAll());
            req.getRequestDispatcher("/glassadmin/adminPage.ftl").forward(req, resp);
            return;
        }
        //Un'altra ancora se è sbagliata
        if(!passwordInserita.equals(passwordGiusta))
        {
            req.setAttribute("wrongPass", true);
            req.getRequestDispatcher("/glassadmin/passwordRequest.ftl").forward(req, resp);
            return;
        }
    }


    private void manageUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        int id = Integer.parseInt(req.getParameter("id"));
        GlasswareRepository<Glass> glRepo = new GlassRepositoryMock();
        Glass toModify = glRepo.readById(id);
        req.setAttribute("glassToUpdate", toModify);
        req.setAttribute("glasses", glRepo.readAll());
        req.getRequestDispatcher("/glassadmin/adminPage.ftl").forward(req, resp);
    }
}   
