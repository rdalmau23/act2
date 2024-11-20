import java.io.*;
import java.util.Scanner;

/**
  @author Rafel Dalmau
  @date 20/11/2024
 */

public class Exercici4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nomFitxer;

        while (true) {
            System.out.println("Introdueix el nom del fitxer: ");
            nomFitxer = input.nextLine();
            File file = new File(nomFitxer);

            if (!file.exists()) break;
            System.out.println("El fitxer ja existeix. Prova amb un altre nom.");
        }

        escriuFitxer(nomFitxer);
    }

    public static void escriuFitxer(String nomFitxer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFitxer, false))) {
            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.println("Escriu una línia (un punt per acabar): ");
                String linia = input.nextLine();

                if (linia.equals(".")) break;
                writer.write(linia);
                writer.newLine();
            }
            System.out.println("Fitxer desat correctament.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
