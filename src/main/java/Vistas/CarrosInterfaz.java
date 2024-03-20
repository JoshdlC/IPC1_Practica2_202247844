package Vistas;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.io.Serializable;

public class CarrosInterfaz extends JPanel implements Serializable{

    private String nombre;
    private Color color;
    private int carWidth, carHeight;
    private int positionX, positionY;

    public CarrosInterfaz(String nombre, Color color, int carWidth, int carHeight, int positionX, int positionY) {
        this.nombre = nombre;
        this.color = color;
        //this.imagen = new ImageIcon(getClass().getResource(rutaImagen)); // Cargando la imagen desde la ruta
//        if (getClass().getClassLoader().getResource(rutaImagen) != null) {
//            this.imagen = new ImageIcon(getClass().getResource(rutaImagen));
//        } else {
//            System.err.println("La imagen en la ruta proporcionada no pudo ser encontrada: " + rutaImagen);
//        }
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
        //g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
        g.setColor(this.color);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawString(this.nombre, 5, getHeight() / 3);
    }


    public void avanzar() {
        Random random = new Random();
        this.positionX += random.nextInt(10) + 1;

        setLocation(this.positionX, this.positionY);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(int carWidth) {
        this.carWidth = carWidth;
    }

    public int getCarHeight() {
        return carHeight;
    }

    public void setCarHeight(int carHeight) {
        this.carHeight = carHeight;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
