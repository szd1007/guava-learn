import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.hash.HashCode;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import sun.misc.Hashing;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
//import java.nio.charset.StandardCharsets;

/**
 * Created by shangzhidong on 2017/1/17.
 *https://github.com/google/guava/wiki/IOExplained
 */
public class IOExplainedTest {

    public static void main(String[] args) throws Exception {

        Resources.asCharSource(new URL("http://www.baidu.com"),Charsets.UTF_8).copyTo(Files.asCharSink(new File("d:/x.txt"), Charsets.UTF_8));

//        Resources.toByteArray(new URL("www.hao123.com"));
//
//        String downUrl = Resources.toString(new URL("http://www.baidu.com"), StandardCharsets.UTF_8);
//        System.out.println(downUrl.length());
//        System.out.println(downUrl.substring(0,100));
//        File file = new File("");
//        /**CharSource  ByteSource*/
//        //read lines
//        ImmutableList<String> lines = Files.asCharSource(file,StandardCharsets.UTF_8).readLines();
//
//        //wordcount
//        Multiset<String>words = HashMultiset.create(
//                Splitter.on(CharMatcher.whitespace())
//                .trimResults()
//                .omitEmptyStrings()
//                .split(Files.asCharSource(file, Charsets.UTF_8).read())
//        );
//
//        // md5 a file
//        HashCode hash = Files.asByteSource(file).hash(com.google.common.hash.Hashing.md5());
//
//        Resources.asCharSource(new URL(""),Charsets.UTF_8).copyTo(Files.asCharSink(file, Charsets.UTF_8));
//        Resources.asByteSource(new URL("")).copyTo(Files.asByteSink(file));
//
//
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//        Files.createParentDirs(new File("d:/xxd/xx/test"));
//
//        Files.readLines(new File("d:/lines.txt"),StandardCharsets.UTF_8);

        Files.fileTreeTraverser();

    }
}
