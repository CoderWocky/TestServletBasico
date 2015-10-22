/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */

import java.sql.*;

public class BaseDatos {
  private static Connection conexion;
  private static final String BASE_DATOS = "jdbc:oracle:thin:@localhost:1521:XE";
  private static final String USUARIO = "system";
  private static final String PASSWORD = "javaoracle";
  
  public static Connection obtenerConexion() throws SQLException {
    if (conexion == null) {
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      conexion = DriverManager.getConnection(BASE_DATOS, USUARIO, PASSWORD);
    }
    return conexion;
  }
  
}
