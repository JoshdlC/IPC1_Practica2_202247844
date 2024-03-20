package org.example;

import Vistas.CarrosInterfaz;
import Vistas.CarrosRuteados;

import javax.swing.*;
import java.io.Serializable;

public class HiloCarros implements Runnable, Serializable {
    CarrosInterfaz carro;

    private static final Object lock = new Object();

    public HiloCarros(CarrosInterfaz carro) {
        this.carro = carro;
    }

    @Override
    public void run(){
        while(carro.getX() < CarrosRuteados.META_X){
            carro.avanzar();
            if (carro.getX() >= CarrosRuteados.META_X) {
                synchronized (lock){
                    if (CarrosRuteados.lblGanador.getText().isEmpty()) {
                        SwingUtilities.invokeLater(() -> CarrosRuteados.lblGanador.setText(carro.getNombre() + " ha ganado!"));
                    }
                }
            }
        }
        try {
            Thread.sleep(100);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
