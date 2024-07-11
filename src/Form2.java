import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Form2 {
    public JPanel menuDos;
    private JTextField enviotxt;
    private JButton enviarCedulaButton;
    private JTextArea textArea1;
    private JLabel labelAviso;
    private JButton regresarButton;

    String url = "jdbc:mysql://localhost:3306/vehiculosBD";
    String user = "root";
    String password = "123456";
    public Form2() {
        enviarCedulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String query="select * from vehiculos where placa= '"+ enviotxt.getText()+"'";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        textArea1.setText(" Placa: "+ resultSet.getString("placa")+"\n Marca: "+ resultSet.getString("marca")+"\n Modelo: "+resultSet.getString("modelo")+"\n Cilindraje: " + resultSet.getString("cilindraje")+"\n Tipo de Combustible : " + resultSet.getString("tipoCombustible")+"\n Color: " + resultSet.getString("color")+"\n Propietario: " + resultSet.getString("propietario"));
                    }
                }catch (SQLException e1){
                    System.out.println(e1);
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Vehículos 2024");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Form1().mainPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setSize(600, 400);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
    }
}
