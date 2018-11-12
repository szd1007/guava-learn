package thecompletereferenc;

public class Lambda {
    public static void main(String[] args) {
//        () -> 122.3;
//        () -> Math.random() * 100;
//        (n) -> (n % 2) == 0;
        //functional interface 的一个接口实现；一句话搞定一个类
        MyNumber myNumber = () -> 122.3;

    }
}

interface MyNumber {
    double getValue();
}