
import View.View;

import java.awt.*;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        var vista = new View();
        vista.setLayout(new FlowLayout());
        vista.setSize(600, 400);
        vista.setVisible(true);
        vista.setResizable(false);
        vista.setTitle("Informes - Reto 5");
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null); //ubica la ventana en el centro de la pantalla 
    }
}
