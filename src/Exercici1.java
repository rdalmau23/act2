import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 @author Rafel Dalmau
 @Date 6/11/2024
*/

public class Exercici1 {
    public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                System.out.println("Introdueix la ruta del fitxer: ");
                String path = input.nextLine();
                System.out.println("Introdueix text ");
                String text = input.nextLine();

                text=invertir(text);
               
                escriureFitxer(path, text);
                llegirFitxer(path);
    
    }

    public static void escriureFitxer (String path, String text){
        try (PrintStream writer = new PrintStream(new File(path))) {
            writer.println(text);
            writer.close();
        }
        catch (Exception e) {
        System.out.println("Error" + e.getMessage());
        }
    }

    public static void llegirFitxer (String path) {
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
                String line = scanner.nextLine();
                System.out.println(line);
            
        }
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            }
    }

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
    