package effectiveJava;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 9. try-with-resources 优先于try-finally[AutoClosable 接口]
 */
@SuppressWarnings("all")
public class Eff_9 {
    private static final int BUFFER_SIZE = 1024;

    @DonotDoThis
    @EfLanguagePoints("需要处理多个资源关闭时，代码及其丑陋。同时会导致异常覆盖（内部close方法会抛出异常）")
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
    @EfLanguagePoints("try语句中的多个资源都会关闭，并且很优雅")
    static void copy2(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }

    @EfLanguagePoints("优雅滴编程")
    static String firstLineOfFile(String path, String defaultVal){
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))){
            return br.readLine();
        }catch (IOException e){
            return defaultVal;
        }
    }

}
