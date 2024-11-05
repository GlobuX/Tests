package ru.globux.testing.test1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RandomAccessFilesTest {
    public static void main(String[] args) {
        String s = "I was here!\n";
        byte[] data = s.getBytes();
        ByteBuffer str = ByteBuffer.wrap(data);
        ByteBuffer tmp = ByteBuffer.allocate(data.length);

        Path file = Paths.get("C:/Temp/test.txt");
        try (FileChannel fc = FileChannel.open(file, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            while(fc.read(tmp) != -1 && tmp.hasRemaining());

            fc.position(0);
            while(str.hasRemaining())
                fc.write(str);

            long length = fc.size();
            fc.position(length);

            // Метод flip() перемещает limit на позицию position, а position делает равным нулю (на начало)
            tmp.flip();
            while(tmp.hasRemaining())
                fc.write(tmp);

            // Метод rewind() перемещает position на позицию ноль (на начало), limit не изменяется
            str.rewind();
            while(str.hasRemaining())
                fc.write(str);
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}
