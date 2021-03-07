package com.google.sps.servlets;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -156958939047146496L;

    @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> hello = new ArrayList<String>();
    hello.add("Hej Hej!");
    hello.add("Hello!");
    hello.add("Hola");

    String json = convertToJsonUsingGson(hello);

    response.setContentType("application/json;"); 
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(ArrayList<String> list) {
      Gson gson = new Gson();
      String json = gson.toJson(list);
      return json;
  }
}
