package ru.globux.test.nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

public class WorkWithDirectoriesTest {
    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<>() {
            @Override
            public boolean accept(Path p) {
                return Files.isDirectory(p) && p.getFileName().toString().matches("(?i)\\$recycle\\.bin");
            }
        };

        for(Path root: fileSystem.getRootDirectories()) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(root, filter)) {
                System.out.println("\t" + root);
//                for(Path entry: stream) {
//                    System.out.println(entry.getFileName());
//                }
                StreamSupport.stream(stream.spliterator(), false)
                             .forEach(p -> System.out.println(p.getFileName()));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
