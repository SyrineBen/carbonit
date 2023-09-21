package com.carbonit.treasure;

import com.carbonit.treasure.file.FileReader;
import com.carbonit.treasure.file.FileWriter;
import com.carbonit.treasure.map.Map;
import com.carbonit.treasure.map.MapService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    /**
     * This method reads data from an input file, simulates the movements of adventurers, and writes the results to an output file.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer le nom du fichier d'entrée : ");
        String inputFileName = scanner.nextLine();
        System.out.print("Veuillez entrer le nom du fichier de sortie : ");
        String outputFileName = scanner.nextLine();
        scanner.close();
        Map map = null;
        MapService mapService = new MapService();
        InputStream inputStream = App.class.getResourceAsStream("/" + inputFileName);
        OutputStream outputStream = null;
        try {

            outputStream = new FileOutputStream(outputFileName);

            // Lire les lignes du fichier d'entrée dans une liste
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
            map = mapService.initMap(lines);
        } catch (FileNotFoundException e) {
            System.err.println("Erreur : Le fichier d'entrée spécifié n'a pas été trouvé.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erreur : Une erreur s'est produite lors de la lecture du fichier d'entrée.");
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (map != null) {
            map.play();
            try {
                FileWriter.writeFile(outputFileName, map.toString());
                System.out.println("Résultats écrits dans le fichier : " +  outputFileName);
            } catch (IOException e) {
                System.err.println("Erreur : Une erreur s'est produite lors de l'écriture du fichier de sortie.");
                e.printStackTrace();
            }
        }
    }


}
