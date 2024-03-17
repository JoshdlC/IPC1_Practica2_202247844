package Vistas;

/**
 *
 * @author Josué dlaCruz
 */


import javax.swing.*;
import java.awt.*;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CarrosInterfaz extends JPanel {
    private String nombre;
    private ImageIcon imagen;
    private int carWidth, carHeight;
    private int positionX, positionY;

    public CarrosInterfaz(String nombre, String rutaImagen, int carWidth, int carHeight, int positionX, int positionY) {
        this.nombre = nombre;
        //this.imagen = new ImageIcon(getClass().getResource(rutaImagen)); // Cargando la imagen desde la ruta
        if (getClass().getResource(rutaImagen) != null) {
            this.imagen = new ImageIcon(getClass().getResource(rutaImagen));
        } else {
            System.err.println("La imagen en la ruta proporcionada no pudo ser encontrada: " + rutaImagen);
        }
        this.carWidth = carWidth;
        this.carHeight = carHeight;
        this.positionX = positionX;
        this.positionY = positionY;

        initComponents();
    }

    public void initComponents() {
        setPreferredSize(new Dimension(this.carWidth, this.carHeight));
        setBounds(this.positionX, this.positionY, this.carWidth, this.carHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //agarra la imagen
        g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
        //g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawString(this.nombre, 5, getHeight() / 2);
    }

    public void avanzar() {
        Random random = new Random();
        this.positionX += random.nextInt(10) + 1;

        setLocation(this.positionX, this.positionY);
    }

    public String getNombre() {
        return nombre;
    }
    
}
