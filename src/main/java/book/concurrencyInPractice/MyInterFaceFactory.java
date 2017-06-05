package book.concurrencyInPractice;

/**
 * Created by shangzhidong on 2017/6/5.
 */
public class MyInterFaceFactory {


    public   MyInterFace getMyInterFace() {
        return new MyInterFaceImpl();
    }
    /**只对外暴露接口就可以，具体实现可以是个私有类。外部引用就是接口对象了*/
    private class MyInterFaceImpl implements MyInterFace {
        public void print() {
            System.out.println("MyInterFaceImpl say .");
        }
    }
}
