package nio.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite {
    public static void main(String[] args) {
        //Obtain a channel to a file within a try-with-resources block
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("test.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE)) {
            //Create a buffer
            ByteBuffer mBuf = ByteBuffer.allocate(26);
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
//            mBuf.rewind();
            mBuf.flip();

            fileChannel.write(mBuf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
