/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */

public class Empleado {
  
  private String apellido;
  private String oficio;
  private int salario;
  private int comision;
  private Connection bd;
  
  private final String QUERY_EMPLEADO = "{ call ConsultaEmpleado(?, ?, ?, ?)}";
  
  public Empleado(String apellido) throws SQLException {
    this.apellido = apellido;
    this.bd = BaseDatos.obtenerConexion();
  }
  
  public String getApellido() {
    return this.apellido;
  }
  
  public String getOficio() {
    return this.oficio;
  }
  
  public int getSalario() {
    return this.salario;
  }
  
  public int getComision() {
    return this.comision;
  }
  
  public boolean buscar() {
    boolean ok = true;
    try {
      CallableStatement proc = this.bd.prepareCall(QUERY_EMPLEADO);
      proc.setString(1, this.apellido);
      proc.registerOutParameter(2, java.sql.Types.VARCHAR);
      proc.registerOutParameter(3, java.sql.Types.INTEGER);
      proc.registerOutParameter(4, java.sql.Types.INTEGER);
      
      proc.executeQuery();
      this.oficio = proc.getString(2);
      this.salario = proc.getInt(3);
      this.comision = proc.getInt(4);
    } catch (SQLException ex) {
      ok = false;
    }
    return ok;
  }
}
