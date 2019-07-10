package effectiveJava;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 31. 利用有限通配符来提升API灵活性
 */

public class Eff_31 {
    @EfLanguagePoints("不要使用通配符作为返回参数类型")
    static <E> Set<E> union(Set<? extends E> set1, Set<? extends E> set2){
        Set<E> result = Sets.newHashSet(set1);
        result.addAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> integers = Sets.newHashSet();
        Set<Double> doubles = Sets.newHashSet();
        @EfLanguagePoints("Number 作为父类， union方法入参通配符指定了可以传递E的子类")
        Set<Number> numbers = union(integers,doubles);
        //error
        //Set<Double> d2 = union(integers,doubles);
    }
}
