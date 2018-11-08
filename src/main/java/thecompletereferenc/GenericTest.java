package thecompletereferenc;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-08 13:29
 */
public class GenericTest implements Runnable{

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        GenTest<GenericTest> gg = new GenTest<>();
    }
}

/**
 *  泛型类型  继承一个类 和实现多个接口
 *  这个比直接使用父类和接口方式灵活，比较易懂
 * @param <T>
 */
class GenTest<T extends GenericTest & Runnable>{
    private T obj;


}
