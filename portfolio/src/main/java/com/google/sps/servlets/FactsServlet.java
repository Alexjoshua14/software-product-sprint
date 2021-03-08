package com.google.sps.servlets;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/facts")
public class FactsServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 8931978960646374589L;

    @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> facts = new ArrayList<String>();
    facts.add("I have been playing piano for more than a decade.");
    facts.add("My favorite aspect of computer science is its endless possibilities to make the world a better place.");
    facts.add("I grew up aspiring to be an architect.");

    String json = convertToJsonUsingGson(facts);

    response.setContentType("application/json;"); 
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(ArrayList<String> list) {
      Gson gson = new Gson();
      String json = gson.toJson(list);
      return json;
  }
}
