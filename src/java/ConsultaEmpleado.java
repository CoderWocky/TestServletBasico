/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(urlPatterns = {"/ConsultaEmpleado"})
public class ConsultaEmpleado extends HttpServlet {
  
  private String renderHeader(String titulo) {
    return String.format("<head>\n<title>%s</title>\n<meta charset=\"UTF-8\">\n</head>", 
        titulo);
  }
  
  private void renderDatos(PrintWriter canal, Empleado empleado) {
    canal.println("<html>");
    canal.println(renderHeader("Datos del empleado"));
    canal.println("<body bgcolor='white'>");
    String cabecera = String.format("<center><h3>Datos de %s</h3></center>", 
        empleado.getApellido());
    canal.println(cabecera);
    canal.println(String.format("<p>Oficio: <strong>%s</strong></p>", 
        empleado.getOficio()));
    canal.println(String.format("<p>Salario: <strong>%d</strong></p>", 
        empleado.getSalario()));
    canal.println(String.format("<p>Comisión: <strong>%d</strong></p>", 
        empleado.getComision()));
    canal.println("</body>");
    canal.println("</html>");
  }
  
  private void renderMensaje(PrintWriter canal, String mensaje) {
    canal.println("<html>");
    canal.println(renderHeader("No encontado"));
    canal.println("<body bgcolor='white'>");
    canal.println(String.format("<p>%s</p>", mensaje));
    canal.println("</body>");
    canal.println("</html>");
   
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws IOException,ServletException {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter(); 
    
    try {
      Empleado empleado = new Empleado(request.getParameter("apellido"));
      if (empleado.buscar()) {
        renderDatos(out, empleado); 
      } else {
        renderMensaje(out, String.format("No se encuentra el empleado %s", 
            empleado.getApellido()));
      }
    } catch (SQLException ex) {
      Logger.getLogger(ConsultaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
