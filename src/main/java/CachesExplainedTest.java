import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shangzhidong on 2017/1/13.
 * https://github.com/google/guava/wiki/CachesExplained
 *
 * Generally, the Guava caching utilities are applicable whenever:

 You are willing to spend some memory to improve speed.
 You expect that keys will sometimes get queried more than once.
 Your cache will not need to store more data than what would fit in RAM. (Guava caches are local to a single run of your application. They do not store data in files, or on outside servers. If this does not fit your needs, consider a tool like Memcached.)


 */
class Person{
    private long age;
    private String name;

    public Person(long age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class CachesExplainedTest {
    /**
     * java  引用
     *
     * 强引用，引用关系存在就不会回收
     * 弱引用，垃圾回收就会被回收
     * 软引用，内存空间不足，系统内存溢出时才会回收（介于强弱之间）

     */
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<Long,Person> cache = CacheBuilder.newBuilder()
                .weakKeys().softValues()
                .recordStats()
                .maximumSize(3).build(new CacheLoader<Long, Person>() {
                    @Override
                    public Person load(Long key) throws Exception {
                        return getPersonByAge(key);
                    }

            private Person getPersonByAge(Long key) {
                return new Person(key, key + "'s people "+System.currentTimeMillis());
            }
        });

        System.out.println(cache.get(1L));
        System.out.println(cache.get(2L));
        System.out.println(cache.get(1L));
        System.out.println(cache.get(3L));
        System.out.println(cache.get(4L));
        System.out.println(cache.get(2L));

        System.out.println(cache.stats());
    }
}
