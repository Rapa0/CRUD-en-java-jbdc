package Java_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CAlumnos {
   private int codigo;
   private String nombreAlumno;
   private String apellidosAlumno;

   public int getCodigo() {
      return codigo;
   }

   public void setCodigo(int codigo) {
      this.codigo = codigo;
   }

   public String getNombreAlumno() {
      return nombreAlumno;
   }

   public void setNombreAlumno(String nombreAlumno) {
      this.nombreAlumno = nombreAlumno;
   }

   public String getApellidosAlumno() {
      return apellidosAlumno;
   }

   public void setApellidosAlumno(String apellidosAlumno) {
      this.apellidosAlumno = apellidosAlumno;
   }

   public void mostrarAlumnos(JTable tablaTotalAlumnos) {
      CConexion objetoConexion = new CConexion();
      DefaultTableModel modelo = new DefaultTableModel();

      modelo.addColumn("Id");
      modelo.addColumn("Nombres");
      modelo.addColumn("Apellidos");

      tablaTotalAlumnos.setModel(modelo);

      String sql = "SELECT * FROM Alumnos";

      try {
         Connection connection = objetoConexion.establecerConexion();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery();

         while (resultSet.next()) {
            String id = resultSet.getString(1);
            String nombres = resultSet.getString(2);
            String apellidos = resultSet.getString(3);

            modelo.addRow(new Object[] { id, nombres, apellidos });
         }

         tablaTotalAlumnos.setModel(modelo);

         resultSet.close();
         statement.close();
         connection.close();
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error: " + e.toString());
      }
   }

   public void guardarAlumno() {
      CConexion objetoConexion = new CConexion();
      String sql = "INSERT INTO Alumnos (id, nombres, apellidos) VALUES (?, ?, ?)";

      try {
         Connection connection = objetoConexion.establecerConexion();
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setInt(1, codigo);
         statement.setString(2, nombreAlumno);
         statement.setString(3, apellidosAlumno);

         int filasInsertadas = statement.executeUpdate();
         if (filasInsertadas > 0) {
            JOptionPane.showMessageDialog(null, "Alumno guardado correctamente");
         } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el alumno");
         }

         statement.close();
         connection.close();
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error al guardar el alumno: " + e.toString());
      }
   }

   public void modificarAlumno() {
      CConexion objetoConexion = new CConexion();
      String sql = "UPDATE Alumnos SET nombres = ?, apellidos = ? WHERE id = ?";

      try {
         Connection connection = objetoConexion.establecerConexion();
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setString(1, nombreAlumno);
         statement.setString(2, apellidosAlumno);
         statement.setInt(3, codigo);

         int filasActualizadas = statement.executeUpdate();
         if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
         } else {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el alumno");
         }

         statement.close();
         connection.close();
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error al modificar el alumno: " + e.toString());
      }
   }

   public void eliminarAlumno() {
      CConexion objetoConexion = new CConexion();
      String sql = "DELETE FROM Alumnos WHERE id = ?";

      try {
         Connection connection = objetoConexion.establecerConexion();
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setInt(1, codigo);

         int filasEliminadas = statement.executeUpdate();
         if (filasEliminadas > 0) {
            JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
         } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el alumno");
         }

         statement.close();
         connection.close();
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error al eliminar el alumno: " + e.toString());
      }
   }
}
