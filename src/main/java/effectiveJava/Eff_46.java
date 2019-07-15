package effectiveJava;

import com.google.common.base.Charsets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * 46. 优先选择Stream中没有副作用的函数[]
 * stream是一种纯函数，不依赖任何 可变 的状态， 同时也  不更新 任何状态
 *
 * 放弃foreach 计算
 * toList, toSet, toMap , groupingBy, joining
 *
 */
public class Eff_46 {

    @EfLanguagePoints("错误使用，更新了中间状态。代码更加难懂")
    void wronUse1(String file){
        Map<String, Long> freq = new HashMap<>();
        try(Stream<String> words = Files.lines(Paths.get(file), Charsets.UTF_8)){
            words.forEach(word->freq.merge(word.toLowerCase(),1L,Long::sum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @EfLanguagePoints("正确方式")
    void rightUse1(String file){
        @EfLanguagePoints("用stream 终止操作获取对象")
        Map<String, Long> freq ;
        try(Stream<String> words = Files.lines(Paths.get(file), Charsets.UTF_8)){
            freq = words.collect(groupingBy(String::toLowerCase,counting()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
