package ru.globux.test.net;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class URItest {

    public static void main(String[] args) {

        try {
            URI uri = new URI("mailto:ivanov@mail.ru");
            System.out.println(uri.toURL().toString());

        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
