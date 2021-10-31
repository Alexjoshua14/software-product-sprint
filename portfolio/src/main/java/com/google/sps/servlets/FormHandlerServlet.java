package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 6734233536872851287L;

    @Override
  public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    final String emailValue = Jsoup.clean(request.getParameter("email-input"), Safelist.basic());
    final String messageValue = Jsoup.clean(request.getParameter("message-input"), Safelist.basic());

    // Print the value so you can see it in the server logs.
    System.out.println("You are submitting: " + emailValue + " " + messageValue);

    final long timestamp = System.currentTimeMillis();

    final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    final KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
    final FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("email", emailValue)
            .set("message", messageValue)
            .set("timestamp", timestamp)
            .build();
    datastore.put(taskEntity);

    // Write the value to the response so the user can see it.
    response.getWriter().println("You submitted: " + emailValue + " " + messageValue);
    response.sendRedirect("/"); 
  }
}