
import java.sql.CallableStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Departamento {
  private int codigo;
  private String nombre;
  private String localidad;
  
  private final String PROC_ALTA = "{? = call AltaDepartamento(?, ?, ?)}";
  
  public Departamento(int codigo, String nombre, String localidad) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.localidad = localidad;
  }
  
  public boolean alta() {
    try {
      CallableStatement proc = BaseDatos.obtenerConexion().prepareCall(PROC_ALTA);
      proc.registerOutParameter(1, java.sql.Types.INTEGER);
      proc.setInt(2, this.codigo);
      proc.setString(3, this.nombre);
      proc.setString(4, this.localidad);
      proc.executeUpdate();
      return (proc.getInt(1) == 1);
    } catch (SQLException ex) {
      return false;
    }
  }  
}
