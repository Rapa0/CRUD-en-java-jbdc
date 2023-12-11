package Java_crud;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VIsta extends JFrame {

   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JTable tablaListaAlumnos;
   private Button guardarButton;
   private Button modificarButton;
   private Button eliminarButton;
   private TextField codigoAlumnoTextField;
   private TextField nombresAlumnosTextField;
   private TextField apellidosAlumnosTextField;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               VIsta frame = new VIsta();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public VIsta() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 588, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new BorderLayout(0, 0));

      Panel datosAlumnosPanel = new Panel();
      contentPane.add(datosAlumnosPanel, BorderLayout.NORTH);

      Label idLabel = new Label("ID");
      datosAlumnosPanel.add(idLabel);

      codigoAlumnoTextField = new TextField();
      datosAlumnosPanel.add(codigoAlumnoTextField);

      Label nombresLabel = new Label("Nombres:");
      datosAlumnosPanel.add(nombresLabel);

      nombresAlumnosTextField = new TextField();
      datosAlumnosPanel.add(nombresAlumnosTextField);

      Label apellidosLabel = new Label("Apellidos:");
      datosAlumnosPanel.add(apellidosLabel);

      apellidosAlumnosTextField = new TextField();
      datosAlumnosPanel.add(apellidosAlumnosTextField);

      guardarButton = new Button("Guardar");
      datosAlumnosPanel.add(guardarButton);

      modificarButton = new Button("Modificar");
      datosAlumnosPanel.add(modificarButton);

      eliminarButton = new Button("Eliminar");
      datosAlumnosPanel.add(eliminarButton);

      Panel listaAlumnosPanel = new Panel();
      contentPane.add(listaAlumnosPanel, BorderLayout.CENTER);

      tablaListaAlumnos = new JTable();
      listaAlumnosPanel.add(tablaListaAlumnos);

      CAlumnos objetoAlumno = new CAlumnos();

      // Evento para guardar un alumno
      guardarButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String codigoText = codigoAlumnoTextField.getText();
            if (!codigoText.isEmpty()) {
               objetoAlumno.setCodigo(Integer.parseInt(codigoText));
            }
            objetoAlumno.setNombreAlumno(nombresAlumnosTextField.getText());
            objetoAlumno.setApellidosAlumno(apellidosAlumnosTextField.getText());
            objetoAlumno.guardarAlumno();
            objetoAlumno.mostrarAlumnos(tablaListaAlumnos);
         }
      });

      // Evento para modificar un alumno
      modificarButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String codigoText = codigoAlumnoTextField.getText();
            if (!codigoText.isEmpty()) {
               objetoAlumno.setCodigo(Integer.parseInt(codigoText));
            }
            objetoAlumno.setNombreAlumno(nombresAlumnosTextField.getText());
            objetoAlumno.setApellidosAlumno(apellidosAlumnosTextField.getText());
            objetoAlumno.modificarAlumno();
            objetoAlumno.mostrarAlumnos(tablaListaAlumnos);
         }
      });

      // Evento para eliminar un alumno
      eliminarButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String codigoText = codigoAlumnoTextField.getText();
            if (!codigoText.isEmpty()) {
               objetoAlumno.setCodigo(Integer.parseInt(codigoText));
            }
            objetoAlumno.eliminarAlumno();
            objetoAlumno.mostrarAlumnos(tablaListaAlumnos);
         }
      });

      objetoAlumno.mostrarAlumnos(tablaListaAlumnos);
   }
}
