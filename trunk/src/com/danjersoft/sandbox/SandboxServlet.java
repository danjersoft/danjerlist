package com.danjersoft.sandbox;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SandboxServlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      req.setAttribute("result", "attribute set successfully!");
      req.getRequestDispatcher("/WEB-INF/jsp/sandbox.jsp").forward(req, resp);
   }
}
