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
@WebServlet(urlPatterns = {"/AltaDept"})
public class AltaDept extends HttpServlet {
  
  private void renderText(PrintWriter canal, String texto) {
    canal.println("<html>");
    canal.println("<head>");
    canal.println("<title>Alta de Departamento</title>");
    canal.println("<meta charset=\"UTF-8\">");
    canal.println("</head>");
    canal.println("<body bgcolor='white'>");
    canal.println(String.format("<p>%s</p>", texto));
    canal.println("</body>");
    canal.println("</html>");
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
  throws IOException,ServletException {

    int dept_no = Integer.parseInt(request.getParameter("dept_no"));
    String dnombre = request.getParameter("dnombre");
    String loc = request.getParameter("loc");
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    if (new Departamento(dept_no, dnombre, loc).alta())
      renderText(out, String.format("Se ha creado el departamento %d", dept_no));
    else
      renderText(out, "No se ha podido crear el departamento");
  }
}
