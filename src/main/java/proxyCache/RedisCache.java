package proxyCache;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.*;
import java.util.*;

/**
 * scf rpc 方法调用redis缓存层
 * @author shanzhidong@zhuanzhuan.com 2018-3-27 17:07:37
 *
 */
public class RedisCache<T> implements InvocationHandler{

    private static final String keyPreFix = "zz_trade_scf_cache_";
    /**缓存过期时间*/
    private Long expiresTime;
    /**方法列表*/
    private Set<String> methods = new HashSet<>();
    /**是否是白名单方式,默认是通过白名单来决定缓存哪些方法.。否的话所有方法都会走缓存逻辑*/
    private final boolean useWhiteList;
    private final T obj;
    private final Map<String, KeyGen> keyGen = Maps.newConcurrentMap();
    private final Gson gson = new Gson();
    private RedisCache(Long expiresTime, Set<String> methods, boolean useWhiteList, T proxy, Map<String,KeyGen> keyGenMap) {
        this.expiresTime = expiresTime;
        this.methods = methods;
        this.useWhiteList = useWhiteList;
        this.obj = proxy;
        if (Optional.ofNullable(keyGenMap).isPresent()) {
            this.keyGen.putAll(keyGenMap);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();

        if (!useWhiteList || methods.contains(name)) {
            String redisKey = getRedisKey(method, args);
            System.out.println( "method use cache:" + name + " key/" + redisKey);
            if (!Strings.isNullOrEmpty(redisKey)) {
                System.out.println("generate redisKey error,get result direct:"+ obj.getClass().getName()+ "->"+ name);
//                return method.invoke(obj, args);
            }
            String resultStr = getResultCache(redisKey);
            //命中缓存，解析并返回
            if (!Strings.isNullOrEmpty(resultStr)) {
                System.out.println( "redis cache hit: key/"+ redisKey);
                return gson.fromJson(resultStr, method.getReturnType());
            }

            //缓存miss,写缓存并返回
//            Object result = method.invoke(obj, args);
            //String gsonStr = gson.toJson(result);
            String gsonStr = "{\"adam好9\":{\"name\":\"adam好9\",\"male\":false,\"age\":9,\"bookList\":[]},\"adam好8\":{\"name\":\"adam好8\",\"male\":true,\"age\":8,\"bookList\":[]},\"adam好7\":{\"name\":\"adam好7\",\"male\":false,\"age\":7,\"bookList\":[{\"name\":\"test9\",\"code\":81,\"desc\":\"adam好7\\u0027s book\"}]},\"adam好6\":{\"name\":\"adam好6\",\"male\":true,\"age\":6,\"bookList\":[{\"name\":\"test8\",\"code\":64,\"desc\":\"adam好6\\u0027s book\"},{\"name\":\"test9\",\"code\":81,\"desc\":\"adam好6\\u0027s book\"}]},\"adam好5\":{\"name\":\"adam好5\",\"male\":false,\"age\":5,\"bookList\":[{\"name\":\"test7\",\"code\":49,\"desc\":\"adam好5\\u0027s book\"},{\"name\":\"test8\",\"code\":64,\"desc\":\"adam好5\\u0027s book\"},{\"name\":\"test9\",\"code\":81,\"desc\":\"adam好5\\u0027s book\"}]},\"adam好4\":{\"name\":\"adam好4\",\"male\":true,\"age\":4,\"bookList\":[{\"name\":\"test6\",\"code\":36,\"desc\":\"adam好4\\u0027s book\"},{\"name\":\"test7\",\"code\":49,\"desc\":\"adam好4\\u0027s book\"},{\"name\":\"test8\",\"code\":64,\"desc\":\"adam好4\\u0027s book\"},{\"name\":\"test9\",\"code\":81,\"desc\":\"adam好4\\u0027s book\"}]},\"adam好3\":{\"name\":\"adam好3\",\"male\":false,\"age\":3,\"bookList\":[{\"name\":\"test5\",\"code\":25,\"desc\":\"adam好3\\u0027s book\"},{\"name\":\"test6\",\"code\":36,\"desc\":\"adam好3\\u0027s book\"},{\"name\":\"test7\",\"code\":49,\"desc\":\"adam好3\\u0027s book\"},{\"name\":\"test8\",\"code\":64,\"desc\":\"adam好3\\u0027s book\"},{\"name\":\"test9\",\"code\":81,\"desc\":\"adam好3\\u0027s book\"}]},\"adam好2\":{\"name\":\"adam好2\",\"male\":true,\"age\":2,\"bookList\":[{\"name\":\"test4\",\"code\":16,\"desc\":\"adam好2\\u0027s book\"},{\"name\":\"test5\",\"code\":25,\"desc\":\"adam好2\\u0027s book\"},{\"name\":\"test6\",\"code\":36,\"desc\":\"adam好2\\u0027s book\"},{\"name\":\"test7\",\"code\":49,\"desc\":\"adam好2\\u0027s book\"},{\"name\":\"test8\",\"code\":64,\"desc\":\"adam好2\\u0027s book\"},{\"name\":\"test9\",\"code\":81,\"desc\":\"adam好2\\u0027s book\"}]},\"adam好1\":{\"name\":\"adam好1\",\"male\":false,\"age\":1,\"bookList\":[{\"name\":\"test3\",\"code\":9,\"desc\":\"adam好1\\u0027s book\"},{\"name\":\"test4\",\"code\":16,\"desc\":\"adam好1\\u0027s book\"},{\"name\":\"test5\",\"code\":25,\"desc\":\"adam好1\\u0027s book\"},{\"name\":\"test6\",\"code\":36,\"desc\":\"adam好1\\u0027s book\"},{\"name\":\"test7\",\"code\":49,\"desc\":\"adam好1\\u0027s book\"},{\"name\":\"test8\",\"code\":64,\"desc\":\"adam好1\\u0027s book\"},{\"name\":\"test9\",\"code\":81,\"desc\":\"adam好1\\u0027s book\"}]},\"adam好0\":{\"name\":\"adam好0\",\"male\":true,\"age\":0,\"bookList\":[{\"name\":\"test2\",\"code\":4,\"desc\":\"adam好0\\u0027s book\"},{\"name\":\"test3\",\"code\":9,\"desc\":\"adam好0\\u0027s book\"},{\"name\":\"test4\",\"code\":16,\"desc\":\"adam好0\\u0027s book\"},{\"name\":\"test5\",\"code\":25,\"desc\":\"adam好0\\u0027s book\"},{\"name\":\"test6\",\"code\":36,\"desc\":\"adam好0\\u0027s book\"},{\"name\":\"test7\",\"code\":49,\"desc\":\"adam好0\\u0027s book\"},{\"name\":\"test8\",\"code\":64,\"desc\":\"adam好0\\u0027s book\"},{\"name\":\"test9\",\"code\":81,\"desc\":\"adam好0\\u0027s book\"}]}}";
            System.out.println( "redis cache miss: key/"+ redisKey);
            Type type = method.getGenericReturnType();
            System.out.println("parseType:" + type);
//            writeCache(redisKey, gson.toJson(result));
            return gson.fromJson(gsonStr, type);
        } else {
            //不走缓存的逻辑
            System.out.println( "method call direct:" + name);
            return method.invoke(obj, args);
        }
    }
    private static class ListParameterizedType implements ParameterizedType {
        private Type type;
        private ListParameterizedType(Type type) {
            this.type = type;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[] {type};
        }

        @Override
        public Type getRawType() {
            return ArrayList.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }

        // implement equals method too! (as per javadoc)
    }

    private void writeCache(String redisKey, String s) {
        System.out.println("writeCache:"+redisKey+":"+s);
    }

    private String getResultCache(String redisKey) {
        System.out.println("getResultCache:" + redisKey);
        return null;
    }


    /**
     * 生成key的方式, 默认取参数列表的第一个参数的toString方法
     * @param method the method invoke
     * @param args 参数列表
     * @return 具体的key
     */
    private String getRedisKey(Method method, Object[] args) {
        String name = method.getName();
        String className = obj.getClass().getName();
        String id;
        String key = keyPreFix + className + "_" + name + "_";
        if (keyGen.containsKey(name)) {
            KeyGen tmp = keyGen.get(name);
            id = tmp.getKey(args[tmp.getIdx()]);
            System.out.println( "getRedisKey:" + key + id + " argLoc:" + tmp.getIdx());
        }else {
            //使用第一个参数的toString来处理
            id = args[0].toString();
            System.out.println( "getRedisKey:" + key + id);
        }
        if (Strings.isNullOrEmpty(id)) {
            return "";
        }

        return keyPreFix + className + name + id;
    }

    /**
     * 获取代理类实体
     */
    @SuppressWarnings("unchecked")
    private T get() {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                                          obj.getClass().getInterfaces(),this);
    }
    public static class Factory {

        public static <T> T getCacheWithinTenMin(Set<String> methods, T proxy, Map<String, KeyGen> keyGen) {
            return new RedisCache<>(1000 * 60 * 10L, methods, true, proxy, keyGen).get();
        }

        //        public static <T> T getCacheWithinTenMin(T proxy, Map<String, KeyGen> keyGen) {
        //            return new RedisCache<>(1000 * 60 * 10L, null, false, proxy, keyGen).get();
        //        }

    }

    /**
     * 自定义的key取值方式，默认的话取参数列表的第一个参数来解析。
     * 具体的接口实现可以通过override #getIdx()该方法更改返回参数值
     * @param <T>
     */
    @FunctionalInterface
    public interface KeyGen<T> {

        /**
         * 定义具体的参数解析
         * @param arg 具体的参数对象
         * @return 本次参数的唯一key
         */
        String getKey(T arg);

        /**
         * 默认id取值，　接口可以继承修改
         */
        default int getIdx() {
            return 0;
        }

    }



}
