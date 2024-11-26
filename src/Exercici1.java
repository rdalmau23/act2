import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 @author Rafel Dalmau
 @Date 6/11/2024
*/

public class Exercici1 {
    public static void main(String[] args) {
        // crea un escaner per llegir des del teclat
        Scanner teclat = new Scanner(System.in);

        // demana a l'usuari la ruta del fitxer
        System.out.println("Introdueix la ruta del fitxer: ");
        String path = teclat.nextLine();

        // demana a l'usuari el text que vol invertir
        System.out.println("Introdueix text ");
        String text = teclat.nextLine();

        // inverteix el text
        text = invertir(text);

        // escriu el text invertit al fitxer
        escriureFitxer(path, text);

        // llegeix i mostra el contingut del fitxer
        llegirFitxer(path);
    }

    // escriu el text donat a la ruta indicada
    public static void escriureFitxer(String path, String text) {
        try (PrintStream writer = new PrintStream(new File(path))) {
            writer.println(text);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    // llegeix i mostra el contingut del fitxer donat
    public static void llegirFitxer(String path) {
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            System.out.println(line);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    // inverteix les majuscules i minúscules del text donat
    public static String invertir(String text) {
        StringBuilder invertit = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                invertit.append(Character.toLowerCase(c));
            } else {
                invertit.append(Character.toUpperCase(c));
            }
        }
        return invertit.toString();
    }
}
