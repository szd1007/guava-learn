import com.google.common.base.Joiner;

import java.util.Arrays;

/**
 * Created by zm on 17/1/15.
 */
public class StringTest {

    public static void main(String[] args) {
//        Joiner joiner = Joiner.on(":").skipNulls();
        Joiner joiner = Joiner.on(":").useForNull("nullDefault");//null默认值

        String str2 = joiner.join("a", "b", null, "d");
        System.out.println(str2);

        System.out.println(Joiner.on("xx").skipNulls().join(Arrays.asList(1,2,3)));
        System.out.println("*****");
        String [] sp = ",a,,b,".split(",");
        for(String s:sp){
            System.out.println("#"+s+"#");
        }
    }
}
