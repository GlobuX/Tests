package ru.globux.test.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileAttributeViewTest {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        for (OpenOption o: StandardOpenOption.values()) {
            System.out.println(o);
        }

        Set<OpenOption> options = new HashSet<OpenOption>();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.APPEND);

        Path f = Paths.get("D:/Downloads/Games");
        DosFileAttributeView attrView = Files.getFileAttributeView(f, DosFileAttributeView.class);
        try {
            DosFileAttributes attrs = attrView.readAttributes();
            System.out.println("isArchive: " + attrs.isArchive());
            System.out.println("isSystem: " + attrs.isSystem());
            System.out.println("isHidden: " + attrs.isHidden());
            System.out.println("isOther: " + attrs.isOther());
            System.out.println("isReadOnly: " + attrs.isReadOnly());
            System.out.println("isDirectory: " + attrs.isDirectory());
            System.out.println("isRegularFile: " + attrs.isRegularFile());
            System.out.println("isSymbolicLink: " + attrs.isSymbolicLink());
            System.out.println("size: " + attrs.size());
            System.out.println("creationTime: " + attrs.creationTime());
            System.out.println("lastModifiedTime: " + attrs.lastModifiedTime());
            System.out.println("lastAccessTime: " + attrs.lastAccessTime());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        AclFileAttributeView ownerVeiw = Files.getFileAttributeView(f, AclFileAttributeView.class);
        try {
            for (AclEntry acl: ownerVeiw.getAcl()) {
                System.out.println(acl);
                System.out.println("ACL principal name: " + acl.principal().getName());
                System.out.println("ACL type: " + acl.type());
                System.out.println("ACL flags: " + Arrays.toString(acl.flags().toArray()));
                System.out.println("ACL permissions: " + Arrays.toString(acl.permissions().toArray()));

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}