package collections;

import com.google.common.collect.ImmutableSet;

import java.util.Set;


/**
 * Created by shangzhidong on 2017/1/10.
 * https://github.com/google/guava/wiki/ImmutableCollectionsExplained
 */
public class ImmutableCollectionTest {

    public static void main(String[] args) {

    }
    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow"
    );
    class Foo {
        final  ImmutableSet<Object> bars;
        Foo(Set<Object>bars){
            this.bars = ImmutableSet.copyOf(bars);//defensive copy!!!
        }
    }
}
