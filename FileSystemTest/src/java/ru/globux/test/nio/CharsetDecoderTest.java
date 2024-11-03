package ru.globux.test.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CharsetDecoderTest {
    public static void main(String[] args) {
        Path file = Paths.get("C:/Temp/test.txt");
        ByteBuffer bb = ByteBuffer.allocate(100);
        CharBuffer cb = CharBuffer.allocate(70);
        CharsetDecoder cd = Charset.defaultCharset().newDecoder();
        StringBuilder sb = new StringBuilder();
        try (SeekableByteChannel sbc = Files.newByteChannel(file)) {
//        try (BufferedReader in = Files.newBufferedReader(file, Charset.defaultCharset())) {
//            String s;
//            while ((s = in.readLine()) != null) {
//                System.out.println(s);
//            }
//            in.lines().forEach(System.out::println);
            while (sbc.read(bb) > 0) {
                bb.flip();
                CoderResult cr = cd.decode(bb, cb, false);
                System.out.println("После чтения: " + bb.position());
                bb.compact();
                System.out.println("После compact: " + bb.position());
                System.out.println(cb.position());
                cb.flip();
                sb.append(cb);
                System.out.println("isError: " + cr.isError());
                System.out.println("isMalformed: " + cr.isMalformed());
                System.out.println("isOverflow: " + cr.isOverflow());
                System.out.println("isUnderflow: " + cr.isUnderflow());
                System.out.println("isUnmappable: " + cr.isUnmappable());
                cb.clear();
            }
            System.out.print(sb);
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}
