import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        /** Para ejecutar .ja, ir a terminal y escribir java -jar <direccion del archivo jar, se encuentra en out-artifacts>**/

        HolaMudo holamundo = new HolaMudo();

        ObjectMapper objectMapper = new ObjectMapper();

        /**Deserializa el json y lo convierte a un objeto**/
        ArrayList<Bank> personajes = objectMapper.readValue(new File("src/main/java/characters.json"), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Bank.class));

        /**Utilizr getters para imprimir la informacion de cada personaje**/
        personajes.forEach(new Consumer<Bank>() {
            @Override
            public void accept(Bank bank) {
                System.out.println(bank.getNombre());
                System.out.println(bank.getAltura());
                System.out.println(bank.getAnno());
            }
        });

    }
}
