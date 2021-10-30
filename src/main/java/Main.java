import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {

    static int i = 0;

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        JTable tabla;
        JScrollPane pane;

        String[] columnas = {"Nombre", "Altura", "Nacimiento"};
        Object[][] datos = new Object[6][6];

        /** Para ejecutar .jar, ir a terminal y escribir java -jar <direccion del archivo jar, se encuentra en out-artifacts>**/

        HolaMudo holamundo = new HolaMudo();

        ObjectMapper objectMapper = new ObjectMapper();

        /**Deserializa el json y lo convierte a un objeto**/
        ArrayList<Bank> personajes = objectMapper.readValue(new File("src/main/java/characters.json"), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Bank.class));

        /**Utilizr getters para imprimir la informacion de cada personaje**/
        personajes.forEach(new Consumer<Bank>() {
            @Override
            public void accept(Bank bank) {
                String[] datosjson = {bank.getNombre(), bank.getAltura(), bank.getAnno()};
                datos[i] = datosjson;
                add1();
                /*
                System.out.println(bank.getNombre());
                System.out.println(bank.getAltura());
                System.out.println(bank.getAnno());
                */
            }
        });
        tabla = new JTable();

        tabla = new JTable(datos, columnas);
        pane = new JScrollPane(tabla);
        frame.add(pane, BorderLayout.CENTER);


        frame.setTitle("Star Wars");
        frame.setBounds(300, 300, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void add1() {
        i += 1;
    }
}
