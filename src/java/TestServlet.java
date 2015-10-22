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
@WebServlet(urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {
  // Responde a peticiones POST
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException,ServletException{
    // El objeto request contiene la petición
    // En el objeto response servimos el HTML
    
    // Hay que indicar cómo estamos respondiendo
    response.setContentType("text/html"); 
    // Canal para "escribir" el HTML que servimos
    PrintWriter out = response.getWriter(); 
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Respuesta Servlet</title>");
    out.println("</head>");
    out.println("<body bgcolor='white'>");
    out.println("<center><h3>Primer ejemplo sencillo de SERVLETS</h3></center>");
    out.println("</body>");
    out.println("</html>");
  }
}
