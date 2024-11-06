package ru.globux.testing.test1;

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

//Тест работы CharsetDecoder, SeekableByteChannel, ByteBuffer
public class CharsetDecoderTest2 {
    public static void main(String[] args) {
        Path file = Paths.get("C:/Temp").resolve("test.txt");
        try (SeekableByteChannel sbc = Files.newByteChannel(file)) {
            CharsetDecoder cd = Charset.defaultCharset().newDecoder();
            CoderResult coderResult;
            StringBuilder stringBuilder = new StringBuilder();
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            CharBuffer charBuffer = CharBuffer.allocate(10);
            while (sbc.read(byteBuffer) > 0) {
                // После чтения смещаем position на начало byteBuffer
                byteBuffer.flip();
                // Метод decode() смещает position ByteBuffer на количество правильно
                // распознанных байтов, position CharBuffer смещается на количество
                // символов полученных в результате работы метода
                coderResult = cd.decode(byteBuffer, charBuffer, false);
                // После заполнения CharBuffer смещаем position на начало для
                // потребления буфера в StringBuilder
                charBuffer.flip();
                // Метод compact перемещает ещё непрочитанные байты ByteBuffer в начало буфера,
                // position перемещается на следующий байт за перемещенными непрочитанными
                // байтами
                byteBuffer.compact();
                // При работе StringBuilder меняется внутреннее состояние CharBuffer,
                // position перемещается на количество прочитанный символов
                stringBuilder.append(charBuffer);
                // После чтения из CharBuffer, состояние его можно сбросить в начальное,
                // position перемещается в начало, limit в конец, mark сбрасывается
                charBuffer.clear();
            }
            System.out.println(stringBuilder);
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}

