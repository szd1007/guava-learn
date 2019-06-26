package effectiveJava;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 7. 消除过期的对象引用[特别是对象自己管理内存的时候]
 */
@EfLanguagePoints("内存泄露来源 1 自己管理内存 2 缓存   3 监听器和其他问题")
public class Eff_7 {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Eff_7() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    @EfLanguagePoints("数组中存储无效的引用导致对象不会被回收，置null帮助垃圾回收")
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        @EfLanguagePoints("如果不用数组用list，这个问题就不会存在了")
        int i;
        //return elements[--size];
        Object object= elements[--size];
        elements[size]=null;
        return object;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
