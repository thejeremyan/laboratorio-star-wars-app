import javax.swing.*;
import java.awt.*;

public class Tabla {

    JFrame frame = new JFrame();
    JTable tabla;
    JScrollPane pane;

    public void start () {

        String[] columnas = {"Nombre", "Altura", "Nacimiento"};
        Object[][] datos = {
                {"Luke", 170, 19},
                {"Leia", 160, 19},
                {"Han", 175, 18}
        };

        tabla = new JTable(datos, columnas);
        pane = new JScrollPane(tabla);
        frame.add(pane, BorderLayout.CENTER);


        frame.setTitle("Star Wars");
        frame.setBounds(300, 300, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main (String args[]) {
        Tabla app = new Tabla();
        app.start();
    }
}