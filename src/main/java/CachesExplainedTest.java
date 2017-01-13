/**
 * Created by shangzhidong on 2017/1/13.
 * https://github.com/google/guava/wiki/CachesExplained
 *
 * Generally, the Guava caching utilities are applicable whenever:

 You are willing to spend some memory to improve speed.
 You expect that keys will sometimes get queried more than once.
 Your cache will not need to store more data than what would fit in RAM. (Guava caches are local to a single run of your application. They do not store data in files, or on outside servers. If this does not fit your needs, consider a tool like Memcached.)


 */
public class CachesExplainedTest {

}
