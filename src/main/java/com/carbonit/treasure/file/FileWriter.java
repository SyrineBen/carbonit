package com.carbonit.treasure.file;

import java.io.BufferedWriter;
import java.io.IOException;


/**
 * This class handles file writing.
 */
public class FileWriter {

    /**
     * This method writes the results to an output file.
     *
     * @param fileName The name of the output file.
     * @param content  The content to write to the file.
     * @throws IOException if an I/O error occurs while writing to the file.
     */
    public static void writeFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
