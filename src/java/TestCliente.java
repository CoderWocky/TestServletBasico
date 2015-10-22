/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(urlPatterns = {"/TestCliente"})
public class TestCliente extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws IOException,ServletException{
    // Con getParameter podemos recuperar los parámetros enviados en el POST
    String nombre = request.getParameter("nombre");
    String apellidos = request.getParameter("apellidos");
    
    response.setContentType("text/html");
    
    PrintWriter out = response.getWriter(); 
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Datos de cliente</title>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("</head>");
    out.println("<body bgcolor='white'>");
    out.println("<center><h3>Datos del cliente</h3></center>");
    out.println(String.format("<p>Nombre: <strong>%s</strong></p>", nombre));
    out.println(String.format("<p>Apellidos: <strong>%s</strong></p>", apellidos));
    out.println("</body>");
    out.println("</html>");

  }
}
