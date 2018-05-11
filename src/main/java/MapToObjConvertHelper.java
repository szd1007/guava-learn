import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;

/**
 * 将Map对象转换成具体对象
 * @author shangzhidong@zhuanzhuan.com
 */
public class MapToObjConvertHelper {

    /**
     * 缓存对象的SetMethod
     **/
    private static final Map<Class<?>,Map<String, Method>> cacheMethods = Maps.newConcurrentMap();
    /**
     * 缓存对象的属性类型
     **/
    private static final Map<Class<?>,Map<String, Class>> cacheTypes = Maps.newConcurrentMap();
    private static final Map<Class<?>, Map<String, Type>> cacheGenericTypes = Maps.newConcurrentMap();
    /**接收String作为构造函数的类型**/
    private static final HashSet<Class<?>> basicType = Sets.newHashSet();
    private static final Gson gson = new Gson();

    static {
        basicType.add(Byte.class);
        basicType.add(Short.class);
        basicType.add(Integer.class);
        basicType.add(Long.class);
        basicType.add(Float.class);
        basicType.add(Double.class);
        basicType.add(Boolean.class);
        basicType.add(Character.class);
    }

    public static <T> T parseObjFromMap(Map<String, String> reqMap, Class<T>ojbClass) throws Exception {
        Map<String, Method> setMethod = cacheMethods.computeIfAbsent(ojbClass, MapToObjConvertHelper::initSetMethod);
        Map<String, Class> fieldType = cacheTypes.get(ojbClass);
        Map<String, Type> genericType = cacheGenericTypes.get(ojbClass);
        T resultObj = ojbClass.newInstance();
        for (Map.Entry<String, Class> entry : fieldType.entrySet()) {
            String name = entry.getKey();
            Class type = entry.getValue();
            Method method = setMethod.get(name);
            String strVal = reqMap.get(name);
            if (!Strings.isNullOrEmpty(strVal)) {
                Object paraObj = null;
                if(type.equals(String.class)){
                    paraObj = reqMap.get(name);
                }else if (basicType.contains(type)) {
                    paraObj = type.getConstructor(String.class).newInstance(strVal.trim());
                }else {
                    //调用gson 解析对象
                    paraObj = new Gson().fromJson(strVal.trim(), genericType.get(name));

                }
                //调用set方法
                method.invoke(resultObj, paraObj);
            }

        }
        return resultObj;
    }


    private static Map<String, Method> initSetMethod(Class objClass){
        Map<String, Method> methodMap = Maps.newHashMap();
        Map<String, Class> typeMap = Maps.newHashMap();
        Map<String, Type> genericTypeMap = Maps.newHashMap();

        try {
            for (Class<?> clazz = objClass; clazz != Object.class; clazz = clazz.getSuperclass()) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    String setName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);

                    Method setMethod = clazz.getDeclaredMethod(setName, field.getType());
                    methodMap.put(name, setMethod);
                    typeMap.put(name, field.getType());
                    genericTypeMap.put(name, field.getGenericType());

                }
            }
            cacheTypes.putIfAbsent(objClass, typeMap);
            cacheGenericTypes.putIfAbsent(objClass, genericTypeMap);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return Maps.newHashMap();
        }
        return  methodMap;
    }


    public static void main(String[] args) throws Exception {
        Map<String, String> xx = Maps.newHashMap();
        xx.put("name", "张三");
        xx.put("age", "4");
        xx.put("type", "1");
        xx.put("numbers", "[1,2,4,5]");
        xx.put("intVal", "55");
        xx.put("pp", "8883");
//        Test test = parseObjFromMap(xx, Test.class);
//        System.out.println(test);
        TT2 tt2 = parseObjFromMap(xx, TT2.class);
        System.out.println(tt2);

    }
    public static class Test{
        protected String name ;
        protected Integer age;
        protected Integer type;
        protected List<Integer> numbers;
        protected int intVal;

        public int getIntVal() {
            return intVal;
        }

        public void setIntVal(int intVal) {
            this.intVal = intVal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void setNumbers(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override public String toString() {
            return "Test{" + "name='" + name + '\'' + ", age=" + age + ", type=" + type + ", numbers=" + numbers + ", intVal=" + intVal
                    + '}';
        }
    }

    public static class TT2 extends Test {
        Integer pp;

        public Integer getPp() {
            return pp;
        }

        public void setPp(Integer pp) {
            this.pp = pp;
        }

        @Override public String toString() {
            return "TT2{" + "name='" + name + '\'' + ", age=" + age + ", type=" + type + ", numbers=" + numbers + ", intVal=" + intVal
                    + ", pp=" + pp + '}';
        }
    }
}
