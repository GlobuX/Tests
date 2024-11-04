package ru.globux.test.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SympleFileVisitorTest {
    public static void main(String[] args) {
        Path dir = Paths.get("C:/Temp");
        PrintFiles fileVisitor = new PrintFiles();
        try {
            Files.walkFileTree(dir, fileVisitor);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
