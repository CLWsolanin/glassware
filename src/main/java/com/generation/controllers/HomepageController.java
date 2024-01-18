package com.generation.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.model.entities.Cup;
import com.generation.model.entities.Glass;
import com.generation.model.entities.Glassware;
import com.generation.model.repositories.CupRepositoryMock;
import com.generation.model.repositories.GlassRepositoryMock;
import com.generation.model.repositories.GlasswareRepository;

@WebServlet("/homepage")
public class HomepageController extends HttpServlet
{
    @Override//R
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        //voglio il bicchiere e la tazza più costosa

        //Parlo con il model, mi faccio arrivare tutti i bicchieri e tutte le tazze
        GlasswareRepository<Cup> cupRepo = new CupRepositoryMock();
        GlasswareRepository<Glass> glRepo = new GlassRepositoryMock();

        List<Glassware> products = new ArrayList<Glassware>();

        products.addAll(cupRepo.readAll());
        products.addAll(glRepo.readAll());

        req.setAttribute("products", products);
        req.getRequestDispatcher("/homepageView.ftl").forward(req, resp);
    }

    @Override//C
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override//D
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override//U
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

    }
}
