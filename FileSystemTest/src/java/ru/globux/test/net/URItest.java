package ru.globux.test.net;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URItest {

    public static void main(String[] args) {

        try {
            URI uri = new URI("mailto:ivanov@mail.ru");
            URL url = uri.toURL();
            System.out.println(url.getProtocol());
            System.out.println(url.getPath());

            URL aURL = new URL("http://example.com:80/docs/books/tutorial"
                    + "/index.html?name=networking#DOWNLOADING");

            System.out.println("protocol = " + aURL.getProtocol());
            System.out.println("authority = " + aURL.getAuthority());
            System.out.println("host = " + aURL.getHost());
            System.out.println("port = " + aURL.getPort());
            System.out.println("path = " + aURL.getPath());
            System.out.println("query = " + aURL.getQuery());
            System.out.println("filename = " + aURL.getFile());
            System.out.println("ref = " + aURL.getRef());

        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
