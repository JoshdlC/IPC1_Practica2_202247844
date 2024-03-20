package Vistas;

import org.example.HiloCarros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CarrosRuteados extends JFrame{

    private Map<String, CarrosInterfaz> vehiculos;
    private Map<String, Point> posicionesGuardadas;

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 400;
    private final int VEHICLE_WIDTH = 50;
    private final int VEHICLE_HEIGHT = 50;
    public static final int META_X = 700;
    private JButton iniciarViaje1Btn;

    private ImageIcon imagenCarroPremium;

    public static JLabel lblGanador;

    public CarrosRuteados() {
        vehiculos = new HashMap<>();
        posicionesGuardadas = new HashMap<>();

        Map<String, CarrosInterfaz> estadoInicial = cargarEstado();
        System.out.println("Estado inicial: " +  estadoInicial);


        initComponents(estadoInicial);
    }

    public void initComponents(Map<String, CarrosInterfaz> estadoInicial) {
        setTitle("Prueba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(null);

        lblGanador = new JLabel();
        lblGanador.setBounds(WINDOW_WIDTH / 2, 50, 200, 30);
        add(lblGanador);

        iniciarViaje1Btn = new JButton("Iniciar viaje");
        iniciarViaje1Btn.setBounds(WINDOW_WIDTH/3 - 75, WINDOW_HEIGHT-100, 150, 30);
        iniciarViaje1Btn.setEnabled(true);

        iniciarViaje1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarViaje();
            }
        });

        add(iniciarViaje1Btn);



        CarrosInterfaz moto = new CarrosInterfaz("Moto", Color.BLUE, VEHICLE_WIDTH, VEHICLE_HEIGHT, 10, 75);
        CarrosInterfaz carro1 = new CarrosInterfaz("Estandar 1", Color.lightGray, VEHICLE_WIDTH, VEHICLE_HEIGHT, 10, 150);

        //add(moto);
        //add(carro1);
        //Thread hiloCarro1 = new Thread(new HiloCarros(moto));
        //Thread hiloCarro2 = new Thread(new HiloCarrera(carro1));

        if (estadoInicial.isEmpty()){
            vehiculos.put(moto.getNombre(), moto);
            vehiculos.put(carro1.getNombre(), carro1);

        } else {
            for (Map.Entry<String, CarrosInterfaz> entry : estadoInicial.entrySet()){
                String nombreCarro = entry.getKey();
                CarrosInterfaz carroDeserializado = estadoInicial.get(nombreCarro);
                CarrosInterfaz carro = new CarrosInterfaz(
                        nombreCarro, carroDeserializado.getColor(), VEHICLE_WIDTH, VEHICLE_HEIGHT, carroDeserializado.getPositionX(), carroDeserializado.getPositionY()
                );
                vehiculos.put(nombreCarro, carro);

            }
            iniciarViaje1Btn.setEnabled(true);
        }

        for (CarrosInterfaz carros : vehiculos.values()){
            add(carros);
        }


        setVisible(true);
    }

    private Map<String, CarrosInterfaz> cargarEstado(){
        Map<String, CarrosInterfaz> estado = new HashMap<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("estado.bin"))){
            System.out.println("El estado de los vehiculos");
            Map<String, CarrosInterfaz> estadoMap = (Map<String, CarrosInterfaz>) ois.readObject();
            System.out.println("El estado del Map es: " +estadoMap);
            estado = estadoMap;

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return estado;
    }

    public void serializarEstado(){
        //guardar las posiciones de los uber

        for (Map.Entry<String, CarrosInterfaz> entry : vehiculos.entrySet()) {
            String nombreCarro = entry.getKey();
            CarrosInterfaz carro = entry.getValue();
            Point posicion = new Point(carro.getPositionX(), carro.getPositionY());

            posicionesGuardadas.put(nombreCarro, posicion);
            System.out.println("Se esta serializando esta posicion: " + posicion);

        }

        //guardar estado de los uber

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("estado.bin"))){
            oos.writeObject(vehiculos);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void iniciarViaje(){
        for (CarrosInterfaz carro : vehiculos.values()){
            new Thread(new HiloCarros(carro)).start();

        }
        iniciarViaje1Btn.setEnabled(false);
    }
}
