import java.io.*;
import java.util.Scanner;

/**
 *@autor: Rafel Dalmau
  @date: 20/11/2024
 */
public class Exercici2 {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Introdueix la ruta del primer fitxer: ");
        String ruta1 = teclat.nextLine();

        System.out.println("Introdueix la ruta del segon fitxer: ");
        String ruta2 = teclat.nextLine();

        System.out.println("Introdueix la ruta de destí (només la carpeta): ");
        String desti = teclat.nextLine();

        combinaFitxers(ruta1, ruta2, desti);
    }

    public static void combinaFitxers(String ruta1, String ruta2, String desti) {
        File file1 = new File(ruta1);
        File file2 = new File(ruta2);
        File fileDesti = new File(desti, file1.getName().split("\\.")[0] + "_" + file2.getName().split("\\.")[0] + ".txt");

        if (fileDesti.exists()) {
            System.out.println("El fitxer ja existeix. Vols sobrescriure? (s/n)");
            Scanner teclat = new Scanner(System.in);
            String resposta = teclat.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                System.out.println("Operació cancel·lada.");
                return;
            }
        }

        try (FileWriter writer = new FileWriter(fileDesti, false)) {
            copiaContingut(file1, writer);
            copiaContingut(file2, writer);
            System.out.println("Fitxers combinats correctament a " + fileDesti.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void copiaContingut(File file, FileWriter writer) throws IOException {
        try (FileReader reader = new FileReader(file)) {
            StringBuilder currentLine = new StringBuilder();
            int character;

            while ((character = reader.read()) != -1) { 
                if (character == '\n' || character == '\r') { 
                    String line = currentLine.toString().trim();
                    if ("EOF".equals(line)) { 
                        break;
                    }
                    writer.write(line + System.lineSeparator());
                    currentLine.setLength(0); 
                } else {
                    currentLine.append((char) character); 
                }
            }

            
            if (currentLine.length() > 0) {
                String line = currentLine.toString().trim();
                if (!"EOF".equals(line)) {
                    writer.write(line);
                }
            }
        }
    }
}
