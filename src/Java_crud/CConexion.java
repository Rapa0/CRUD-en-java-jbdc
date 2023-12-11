package Java_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CConexion {
   private static final String usuario = "postgres";
   private static final String contrasenia = "mariela1977";
   private static final String bd = "bdescuela";
   private static final String ip = "localhost";
   private static final String puerto = "5432";
   private static final String cadena = "jdbc:postgresql://" + ip + ":" + puerto + "/" + bd;

   public Connection establecerConexion() {
      Connection conectar = null;

      try {
         Class.forName("org.postgresql.Driver");
         conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
         JOptionPane.showMessageDialog(null, "Se conectó correctamente a la base de datos");
      } catch (ClassNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Error al cargar el controlador de la base de datos");
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error al establecer la conexión a la base de datos");
      }

      return conectar;
   }

   public static void main(String[] args) {
      CConexion conexion = new CConexion();
      Connection connection = conexion.establecerConexion();
      
      
   }
}