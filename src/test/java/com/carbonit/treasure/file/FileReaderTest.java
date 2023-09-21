package com.carbonit.treasure.file;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {


    @Test
    public void testLireFichier() throws IOException {
        String nomFichierTest = "test_input.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichierTest))) {
            writer.write("Ligne 1\n");
            writer.write("Ligne 2\n");
            writer.write("# Commentaire\n");
            writer.write("Ligne 3\n");
        }
        List<String> lines = FileReader.readFile(nomFichierTest);

        assertEquals(3, lines.size());
        assertEquals("Ligne 1", lines.get(0));
        assertEquals("Ligne 2", lines.get(1));
        assertEquals("Ligne 3", lines.get(2));

        Files.deleteIfExists(java.nio.file.Paths.get(nomFichierTest));
    }
}
