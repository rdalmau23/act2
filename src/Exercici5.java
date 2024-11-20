import java.io.*;
import java.util.Scanner;

/**
  @author Rafel Dalmau
  @date 20/11/2024
 */

public class Exercici5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Introdueix el nom del fitxer amb les notes: ");
        String nomFitxer = input.nextLine();

        generaHistograma(nomFitxer);
    }

    public static void generaHistograma(String nomFitxer) {
        File file = new File(nomFitxer);
        if (!file.exists()) {
            System.out.println("El fitxer no existeix.");
            return;
        }

        String histogramaNom = "Informe" + file.getName();

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(histogramaNom, false))) {

            writer.write("Informe de" + file.getName());
            writer.newLine();
            writer.write("------------");
            writer.newLine();

            int suspes = 0, aprovat = 0, notable = 0, excelent = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                for (String valor : line.split("\\s+")) {
                    if (valor.equals("-1")) break;
                    try {
                        double nota = Double.parseDouble(valor);
                        if (nota < 5) suspes++;
                        else if (nota < 6.5) aprovat++;
                        else if (nota < 9) notable++;
                        else if (nota <= 10) excelent++;
                    } catch (NumberFormatException e) {
                        System.out.println("Nota invalida: " + valor);
                    }
                }
            }

            writer.write("Suspes:" + "*".repeat(suspes));
            writer.newLine();
            writer.write("Aprovat:" + "*".repeat(aprovat));
            writer.newLine();
            writer.write("Notable:" + "*".repeat(notable));
            writer.newLine();
            writer.write("Excelent:" + "*".repeat(excelent));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
