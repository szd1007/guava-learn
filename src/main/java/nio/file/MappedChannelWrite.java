package nio.file;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite {
    public static void main(String[] args) {
        //Obtain a channel to a file within a try-with-resources block.
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("111.txt"),
                StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            //Now, map the file into a buffer.
            MappedByteBuffer mBuf = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
            //Read and display bytes from buffer.
            for (int i = 0; i < 10; i++) {
                System.out.println("put "+(byte)('B'+i));
                mBuf.put((byte) ('A' + i));
            }
            System.out.println();
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}
