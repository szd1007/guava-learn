package basicUtilities;

import com.google.common.base.Optional;
import com.google.common.base.Strings;


/**
 * Created by shangzhidong on 2017/1/3.
 */
public class OptionalTest {
    public static void main(String args[]){
        Object a  =1;
//        Optional<Object> possible = Optional.of(a);
//        System.out.println(possible.isPresent());
        Integer aaa = null;
        Optional<Integer> p2 = Optional.fromNullable(aaa);
        System.out.println(p2.isPresent());
        System.out.println();


        String str =null;
        Strings.isNullOrEmpty(str);
        Strings.nullToEmpty(str);

        Integer x=13;
        Integer b=1;
        System.out.println("xxs:"+(x==b));

    }
}
