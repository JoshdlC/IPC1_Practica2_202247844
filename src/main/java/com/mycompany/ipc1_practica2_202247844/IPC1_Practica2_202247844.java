package com.mycompany.ipc1_practica2_202247844;

import Vistas.CarrosInterfaz;
import Vistas.CarrosRuteados;
import javax.swing.SwingUtilities;

/**
 *
 * @author Josué dlaCruz
 */
public class IPC1_Practica2_202247844 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarrosRuteados::new);
    }
}
