package main.java.com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  private static final String REDIRECT_URL = "https://enuviadenu-sps-summer21.uc.r.appspot.com/contact.html";

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    
    String name = request.getParameter("name"); 
    String textValue = request.getParameter("text-input");

    writeToDatastore(name, textValue);

    System.out.println(name + " submitted: " + textValue);
    response.getWriter().println(name + " submitted: " + textValue);
    response.sendRedirect(REDIRECT_URL);
  }

  public void writeToDatastore(String name, String textValue){
     Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Tasks");
    FullEntity textEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("name", name)
            .set("text-input", textValue)
            .build();
    datastore.put(textEntity);
  }
}