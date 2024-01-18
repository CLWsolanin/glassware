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

@WebServlet("/serchbymat")
public class SearchByMatController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String searchKey = req.getParameter("k");
         GlasswareRepository<Cup> cupRepo = new CupRepositoryMock();
        GlasswareRepository<Glass> glRepo = new GlassRepositoryMock();

        List<Glassware> products = new ArrayList<Glassware>();

        products.addAll(cupRepo.readAll());
        products.addAll(glRepo.readAll());

        List<Glassware> filtered = products.stream().filter(p-> p.getMaterial().toLowerCase().contains(searchKey.toLowerCase())).toList();

        req.setAttribute("filtered", filtered);
        req.setAttribute("searchKey", searchKey);

        req.getRequestDispatcher("/searchresult.ftl").forward(req, resp);
    }
}
