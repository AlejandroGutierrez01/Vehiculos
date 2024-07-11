import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;

public class Form1 {
    public JPanel mainPanel;
    private JTextField placatxt;
    private JTextField marcatxt;
    private JTextField modelotxt;
    private JTextField cilindrajetxt;
    private JTextField combustibletxt;
    private JTextField colortxt;
    private JTextField propietariotxt;
    private JButton enviarButton;
    private JButton borrarButton;
    private JButton buscarButton;
    String url = "jdbc:mysql://localhost:3306/vehiculosBD";
    String user = "root";
    String password = "123456";
    public Form1() {
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehiculos vehiculo1 = new Vehiculos(placatxt.getText(),marcatxt.getText(),modelotxt.getText(),parseDouble(cilindrajetxt.getText()),combustibletxt.getText(),colortxt.getText(),propietariotxt.getText());
                String sql = "INSERT INTO vehiculos (placa, marca, modelo, cilindraje, tipoCombustible, color, propietario) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try(Connection connection= DriverManager.getConnection(url,user,password)) {
                    System.out.println("Conexion exitosa");
                    PreparedStatement cadenaPreparada = connection.prepareStatement(sql);
                    cadenaPreparada = connection.prepareStatement(sql);
                    cadenaPreparada.setString(1, vehiculo1.getPlaca());
                    cadenaPreparada.setString(2, vehiculo1.getMarca());
                    cadenaPreparada.setString(3, vehiculo1.getModelo());
                    cadenaPreparada.setDouble(4, vehiculo1.getCilindraje());
                    cadenaPreparada.setString(5, vehiculo1.getTipoCombustible());
                    cadenaPreparada.setString(6, vehiculo1.getColor());
                    cadenaPreparada.setString(7, vehiculo1.getPropietario());
                    cadenaPreparada.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Vehiculo registrado correctamente");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al registrar vehiculo");
                }
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placatxt.setText("");
                marcatxt.setText("");
                modelotxt.setText("");
                cilindrajetxt.setText("");
                combustibletxt.setText("");
                colortxt.setText("");
                propietariotxt.setText("");
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Vehículos 2024");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Form2().menuDos);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setSize(600, 400);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(buscarButton)).dispose();
            }
        });
    }
}
