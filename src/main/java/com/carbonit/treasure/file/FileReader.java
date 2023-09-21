package com.carbonit.treasure.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles file reading.
 */
public class FileReader {

    /**
     * This method reads a file line by line and returns non-commented lines.
     *
     * @param fileName The name of the file to read.
     * @return A list of non-commented lines.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    public static List<String> readFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#")) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

