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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String material = req.getParameter("material");
        String priceString = req.getParameter("price");
        String[] priceParts = priceString.split(",");
        int parteIntera = Integer.parseInt(priceParts[0]);
        int parteDecimale = Integer.parseInt(priceParts[1]);

        int nDecimali = priceParts[1].length();//nel mio caso varrà 4
        String divisore = "10";
        //9,2   -> divisore è 10
        //9,20  -> divisore è 100
        //9,202  -> divisore è 1000
        for(int i=1;i<nDecimali;i++)
            divisore+="0";

        divisore+=".0";
        double div = Double.parseDouble(divisore);
        double price = parteIntera + parteDecimale/div;
        int volume = Integer.parseInt(req.getParameter("volume"));
        String img_url = req.getParameter("img_url");
        boolean handle = req.getParameter("handle")!=null;
        int id = Integer.parseInt(req.getParameter("id"));

        Cup modified = new Cup(id, material, price, volume, handle, img_url);
        GlasswareRepository<Cup> cupRepo = new CupRepositoryMock();

        cupRepo.update(modified);

        req.setAttribute("cups", cupRepo.readAll());
        req.getRequestDispatcher("/cupsadmin/adminPage.ftl").forward(req, resp);
        return;
    }

    //metodo per gestire tutta la parte di login
    private void manageLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String passwordGiusta = "tazza";
        String passwordInserita = req.getParameter("password");
        String unupdate = req.getParameter("unupdate");
        if(unupdate!=null)
            passwordInserita=passwordGiusta;

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
