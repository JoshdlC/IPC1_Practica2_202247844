package Vistas;

/**
 *
 * @author Josué dlaCruz
 */

import com.mycompany.ipc1_practica2_202247844.HiloCarrera;
import javax.swing.*;
import java.awt.*;

public class CarrosRuteados extends JFrame {
    
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 400;
    private final int VEHICLE_WIDTH = 50;
    private final int VEHICLE_HEIGHT = 50;
    public static final int META_X = 700;

    public static JLabel lblGanador;

    public CarrosRuteados() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Prueba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(null);

        lblGanador = new JLabel();
        lblGanador.setBounds(WINDOW_WIDTH / 2, 50, 200, 30);
        add(lblGanador);

        CarrosInterfaz moto = new CarrosInterfaz("Moto", "CarroPremium.png", VEHICLE_WIDTH, VEHICLE_HEIGHT, 0, 50);
        CarrosInterfaz carro1 = new CarrosInterfaz("Estandar 1", "CarroPremium.png", VEHICLE_WIDTH, VEHICLE_HEIGHT, 0, 150);

        add(moto);
        add(carro1);

        Thread hiloCarro1 = new Thread(new HiloCarrera(moto));
        Thread hiloCarro2 = new Thread(new HiloCarrera(carro1));

        hiloCarro1.start();
        hiloCarro2.start();

        setVisible(true);
    }
    
}
