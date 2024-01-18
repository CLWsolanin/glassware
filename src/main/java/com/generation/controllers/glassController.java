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

@WebServlet("/allglasses")
public class glassController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        
        GlasswareRepository<Glass> glRepo = new GlassRepositoryMock();


        req.setAttribute("glasses", glRepo.readAll());
        

        req.getRequestDispatcher("/glass.ftl").forward(req, resp);
    }
}