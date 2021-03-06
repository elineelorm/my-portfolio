package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public final class HelloWorldServlet extends HttpServlet {

  private static final ArrayList<String> MOTIVATIONS = new ArrayList<String>(Arrays.asList(
                "If at first you do not succeed, try again!", "Yes you can!",
                 "If it was easy, everyone would do it!"));

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String string = getRandom(MOTIVATIONS);
    String json = convertToJson(string);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

   private String convertToJson(String motivations) {
    String json = "[";
    json += "\"" + motivations + "\"";
    json += "]";
    return json;
  }

  private String convertToJsonUsingGson(ArrayList<String> motivations) {
    Gson gson = new Gson();
    String json = gson.toJson(motivations);
    return json;
  }

  private String getRandom(ArrayList<String> motivations){
      Random rand = new Random();
      return motivations.get(rand.nextInt(motivations.size()));
  }
}
