package com.tlamatini.datos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author n3to
 */
public class ConexionDB {
    Connection conexion=null;
    
    public Connection getConexion()
    {
        return conexion;
    }
/**
* M�todo utilizado para establecer la conexi�n con la base de datos
* @return estado regresa el estado de la conexi�n, true si se estableci� la conexi�n,
* falso en caso contrario
*/
    public boolean crearConexion(){
    try {
      Class.forName("com.mysql.jdbc.Driver");
      //primero poner la base de datos (dulceria_maoli), usuario de base(root), contrase�a (en mi caso no tengo solo se pone "").ALEJ
      conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulceria_maoli","root","");
      System.out.println("Conexion Establecida");
      JOptionPane.showMessageDialog(null, "Conexion Establecida");
      
      
    }catch (SQLException | ClassNotFoundException ex    ) {
      ex.printStackTrace();
      System.out.println("Error de Conexion");
      JOptionPane.showMessageDialog(null, "Error de Conexion" + ex);
      return false;
    }
    return true;
    }
/**
*
*M�todo utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
*@param sql Cadena que contiene la instrucci�n SQL a ejecutar
*@return estado regresa el estado de la ejecuci�n, true(�xito) o false(error)
*
*/
    public boolean ejecutarSQL(String sql){
    try {
      Statement sentencia = conexion.createStatement();
      sentencia.executeUpdate(sql);
    } catch (SQLException ex) {
      ex.printStackTrace();
    return false;
    }
 
    return true;
    }
/**
*
*M�todo utilizado para realizar la instrucci�n SELECT
*@param sql Cadena que contiene la instrucci�n SQL a ejecutar
*@return resultado regresa los registros generados por la consulta
*
*/
    public ResultSet ejecutarSQLSelect(String sql){
    ResultSet resultado;
    try {
      Statement sentencia = conexion.createStatement();
      resultado = sentencia.executeQuery(sql);
    } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Error de Conexion");
      JOptionPane.showMessageDialog(null, "Error de Conexion" + ex);
      return null;
    }
 
    return resultado;
    }
   
}
