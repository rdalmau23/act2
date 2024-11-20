import java.io.*;
import java.util.Scanner;

/**
  @author Rafel Dalmau
  @date 6/11/2024
 */

public class Exercici2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Introdueix la ruta del primer fitxer: ");
        String ruta1 = input.nextLine();

        System.out.println("Introdueix la ruta del segon fitxer: ");
        String ruta2 = input.nextLine();

        System.out.println("Introdueix la ruta de destí (només la carpeta): ");
        String desti = input.nextLine();

        combinaFitxers(ruta1, ruta2, desti);
    }

    public static void combinaFitxers(String ruta1, String ruta2, String desti) {
        File file1 = new File(ruta1);
        File file2 = new File(ruta2);
        File fileDesti = new File(desti, file1.getName().split("\\.")[0] + "_" + file2.getName().split("\\.")[0] + ".txt");

        if (fileDesti.exists()) {
            System.out.println("El fitxer de destí ja existeix. Vols sobreescriure'l? (sí/no)");
            Scanner input = new Scanner(System.in);
            String resposta = input.nextLine();
            if (!resposta.equalsIgnoreCase("sí")) {
                System.out.println("Operació cancel·lada.");
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileDesti, false))) {
            copiaContingut(file1, writer);
            copiaContingut(file2, writer);
            System.out.println("Fitxers combinats correctament a " + fileDesti.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void copiaContingut(File file, BufferedWriter writer) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
