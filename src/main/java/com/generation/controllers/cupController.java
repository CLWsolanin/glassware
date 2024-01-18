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
import com.generation.model.entities.Glassware;
import com.generation.model.repositories.CupRepositoryMock;
import com.generation.model.repositories.GlasswareRepository;

@WebServlet("/allcups")
public class cupController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        
        GlasswareRepository<Cup> cupRepo = new CupRepositoryMock();

        List<Glassware> cups = new ArrayList<Glassware>();

        cups.addAll(cupRepo.readAll());

        req.setAttribute("cups", cupRepo.readAll());

        req.getRequestDispatcher("/cup.ftl").forward(req, resp);
    }
}
