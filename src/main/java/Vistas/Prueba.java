package Vistas;

import javax.swing.*;

public class Prueba extends JFrame  {
    public JPanel principalPane;

    public Prueba(){

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Prueba");
        frame.setContentPane(new Prueba().principalPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
