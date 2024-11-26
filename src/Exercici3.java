import java.io.*;
import java.util.Scanner;

/**
 @author rafel dalmau
 @date 20/11/2024
*/

public class Exercici3 {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);

        // demanem la ruta del fitxer a analitzar
        System.out.println("Introdueix la ruta del fitxer: ");
        String ruta = teclat.nextLine();

        // comptem les paraules en cada linia
        comptaParaules(ruta);
    }

    public static void comptaParaules(String ruta) {
        File file = new File(ruta);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int numLinia = 1;

            // llegim el fitxer linia per linia i comptem les paraules
            while ((line = reader.readLine()) != null) {
                if (line.equals("fi")) break;
                int paraules = line.split("\\s+").length;
                System.out.println("La linia " + numLinia + " te " + paraules + " paraules.");
                numLinia++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
