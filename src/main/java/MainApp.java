import book.concurrencyInPractice.MyInterFace;
import book.concurrencyInPractice.MyInterFaceFactory;

/**
 * Created by shangzhidong on 2017/6/5.
 */
public class MainApp {


    public static void main(String[] args) {
        MyInterFace myInterFace = new MyInterFaceFactory().getMyInterFace();
        myInterFace.print();
    }
}
