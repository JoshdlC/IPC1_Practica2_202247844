package org.example;

import Vistas.CarrosInterfaz;
import Vistas.CarrosRuteados;
import Vistas.Prueba;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

//        SwingUtilities.invokeLater(() ->{
//            Prueba interfaz = new Prueba();
//            interfaz.setVisible(true);
//        });
        SwingUtilities.invokeLater(() -> {
            CarrosRuteados interfaz = new CarrosRuteados();
            interfaz.setVisible(true);

            interfaz.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    interfaz.serializarEstado();
                    System.exit(0);
                }
            });
        });
    }
}