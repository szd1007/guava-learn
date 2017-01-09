package basicUtilities;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;

import java.util.Objects;

/**
 * Created by shangzhidong on 2017/1/9.
 */
public class CommonObjectMethods {

    public static void main(String[] args) {

        System.out.println(Objects.equals("x", null));
        System.out.println(com.google.common.base.Objects.equal("x", "x"));

        Bean b1 = new Bean("a",1);
        Bean b2 = new Bean("a",1);

        /**根据一个对象的多个字段产生hash值*/
        System.out.println(Objects.hash(b1.a, b1.b));
        System.out.println(Objects.hash(b2.a,b2.b));
        System.out.println(com.google.common.base.Objects.hashCode(b1.a,b1.b));

        System.out.println(b1);

    }


    static class Bean implements Comparable<Bean>{
        public Bean(String a,int b){
            this.a = a;
            this.b = b;
        }
        private String a;
        private int b;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("a",a)
                    .add("b",b).toString();
        }

        public int compareTo(Bean o) {
            return ComparisonChain.start()
                    .compare(this.a,o.a)
                    .compare(this.b,o.b)
                    .result();
        }
    }
}
