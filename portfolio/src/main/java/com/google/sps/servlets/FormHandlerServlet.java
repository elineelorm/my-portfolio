package main.java.com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  private static final String REDIRECT_URL = "https://enuviadenu-sps-summer21.uc.r.appspot.com/index.html";

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String textValue = request.getParameter("text-input");

    System.out.println("You submitted: " + textValue);

    response.getWriter().println("You submitted: " + textValue);
    response.sendRedirect(REDIRECT_URL);
  }
}