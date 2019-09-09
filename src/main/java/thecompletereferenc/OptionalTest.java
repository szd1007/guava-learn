package thecompletereferenc;

import com.google.common.base.Strings;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * @author szd1007@github.com
 * @date 2018-12-13 09:23
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println("empty present:" + empty.isPresent());

        Optional<Integer> opInt = Optional.of(1);

        System.out.println("filter 1==1:" + opInt.filter(x -> x == 1));
        System.out.println("filter 1!=1:" + opInt.filter(x -> x != 1));

        Optional<String> flatMapOp = opInt.flatMap((Integer x) -> Optional.of("str_" + x));
        System.out.println("flatMapOp" + flatMapOp);

        //function 只进行参数转换。 没有optional操作。
        Optional<String> mapOp = opInt.map((Integer x) -> "str" + x);
        System.out.println("mapOp" + mapOp);

        //ifPresent
        opInt.ifPresent(x -> System.out.println("ifPresent int exist" + x));
        //ifPresentOrElse jdk9

        //orElse
        System.out.println("orElse" + empty.orElse(" default value"));

        //orElseGet
        System.out.println("orElseGet" + empty.orElseGet(() -> {
            return "rpc call result";
        }));

        //orElseThrow
//        System.out.println("orElseThrow" + empty.orElseThrow(NoSuchElementException::new));

        //stream  add by jdk9

//        String a = null;
        String a = "";
        Optional.ofNullable(a).filter(x -> x.length() > 1).ifPresent(y -> System.out.println("a " + a));
        Optional.ofNullable(a).ifPresent(y -> System.out.println("a11 " + a));

    }

    @Test
    public void testOptInt() {
        OptionalInt opi = OptionalInt.of(1);
        System.out.println("primitive int " + opi.getAsInt());
        opi = OptionalInt.empty();
        System.out.println(opi.orElse(-1));
    }

    @Test
    public void testOverride() {
        Object obj = new MyObj();
        System.out.println(obj.toString());
    }

    static class MyObj {

        @Override
        public String toString() {
            System.out.println("myObj");
            return "myObj";
        }
    }
}
