package concurrency;

import util.FileUtil;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * 缓存实现
 */
public class MemorizeCacheTest<T, R> implements Function<T, R> {
    private final ConcurrentHashMap<T, Future<R>> cache = new ConcurrentHashMap<>();
    /**
     * 计算逻辑独立出来
     */
    private final Function<T,R> fun;
    public MemorizeCacheTest(Function<T,R> fun){
        this.fun = fun;
    }
    @Override
    public R apply(T t) {
        while (true) {
            Future<R> value = cache.get(t);
            if (Objects.isNull(value)) {
                FutureTask<R> newValue = new FutureTask<>(() -> fun.apply(t));
                value = cache.putIfAbsent(t, newValue);
                if (value == null) {
                    value = newValue;
                    newValue.run();
                }
            }
            try {
                return value.get();
            } catch (InterruptedException e) {
                cache.remove(t, value);
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
