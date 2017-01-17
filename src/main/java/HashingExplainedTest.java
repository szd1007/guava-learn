import com.google.common.base.Charsets;
import com.google.common.hash.*;
import com.google.common.math.IntMath;

import java.util.Objects;

/**
 * Created by shangzhidong on 2017/1/17.
 * https://github.com/google/guava/wiki/HashingExplained
 */
public class HashingExplainedTest {

    public static void main(String[] args) {

        int a=1;
        String b = "222";
        String c = "3333";

        System.out.println(Objects.hash(a,b,c));

        HashFunction hf = Hashing.md5();
        HashCode hashCode = hf.newHasher()
                .putInt(a)
                .putString(b, Charsets.UTF_8)
                .putString(c, Charsets.UTF_8)
                .hash();
        System.out.println(hashCode);

        System.out.println("$$$$$$$$$$$$$$$$$$$$$");


        Funnel<Person> personFunnel = new Funnel<Person>() {
            @Override
            public void funnel(Person from, PrimitiveSink into) {
                into.putInt(from.id)
                        .putString(from.name,Charsets.UTF_8);
            }
        };
        BloomFilter<Person> friends = BloomFilter.create(personFunnel, 500, 0.01);
        //friends.put()
        //later
        if (friends.mightContain(new Person(1, "222"))) {

        }

//        BloomFilter<String>ids = BloomFilter.create()

    }
    static class Person{
        final int id;
        final String name;
        public Person(int id,String name) {
            this.id = id;
            this.name = name;
            
        }
    }


}
