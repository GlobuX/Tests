package ru.globux.test.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HardLinkTest {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.name"));

        Path file = Paths.get("C:/Temp/test.txt");
        Path simLink = Paths.get("C:/Temp/hardlink_test.txt");
        try {
            Files.createLink(simLink, file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
