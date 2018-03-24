package jdk8newFeature;

import com.google.common.collect.Maps;

import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMap();

        String v = map.computeIfAbsent("a", x -> x + x);//值不存在的默认初始化
        System.out.println(v);
        System.out.println(map);

    }

}
