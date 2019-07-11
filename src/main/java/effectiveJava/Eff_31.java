package effectiveJava;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * 31. 利用有限通配符来提升API灵活性
 */
@EfLanguagePoints("PESC  produce-extends, consumer-super ")
public class Eff_31 {
    @EfLanguagePoints("不要使用通配符作为返回参数类型")
    static <E> Set<E> union(Set<? extends E> set1, Set<? extends E> set2){
        Set<E> result = Sets.newHashSet(set1);
        result.addAll(set2);
        return result;
    }
    @EfLanguagePoints("如果类型参数只在方法声明中出现一次，就可以用通配符取代他")
    public void swap(List<?> list ,int i, int j){
        //直接转换会有问题，list类型是<?>，不能将null之外的任何值放到List<?>中
        //list.set(i, list.set(j, list.get(i)));
        swapHelper(list,i,j);
    }

    /**
     辅助方法，用来捕捉通配符类型
     */
    private <E>void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public <E>void swap2(List<E>list, int i, int j){}

    public static void main(String[] args) {
        Set<Integer> integers = Sets.newHashSet();
        Set<Double> doubles = Sets.newHashSet();
        @EfLanguagePoints("Number 作为父类， union方法入参通配符指定了可以传递E的子类")
        Set<Number> numbers = union(integers,doubles);
        //error
        //Set<Double> d2 = union(integers,doubles);
    }
}
