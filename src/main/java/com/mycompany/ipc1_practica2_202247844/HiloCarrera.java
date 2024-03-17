package com.mycompany.ipc1_practica2_202247844;

import Vistas.CarrosInterfaz;
import Vistas.CarrosRuteados;

/**
 *
 * @author Josué dlaCruz
 */
public class HiloCarrera implements Runnable{
    
    CarrosInterfaz carro;
    
    private static final Object lock = new Object();

    public HiloCarrera(CarrosInterfaz carro) {
        this.carro = carro;
    }
    
    @Override
    public void run(){
        while(carro.getX() < CarrosRuteados.META_X){
            carro.avanzar();
            
            if (carro.getX() >= CarrosRuteados.META_X) {
                synchronized (lock){
                    
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
