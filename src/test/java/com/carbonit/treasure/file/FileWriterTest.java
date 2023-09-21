package com.carbonit.treasure.file;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class FileWriterTest {

    @Test
    public void testEcrireFichier() throws IOException {
        String nomFichierSortie = "test_output.txt";
        String contenuAttendu = "Contenu de test à écrire dans le fichier.";

        FileWriter.writeFile(nomFichierSortie, contenuAttendu);

        try (BufferedReader br = new BufferedReader(new FileReader(nomFichierSortie))) {
            String ligneLue = br.readLine();
            assertEquals(contenuAttendu, ligneLue);
        }

        Files.deleteIfExists(java.nio.file.Paths.get(nomFichierSortie));
    }
}
