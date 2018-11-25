package thecompletereferenc;

public class ClassTest {
}

class X {
    int a;
    float b;
}

class Y extends  X {
    double c;
}
class RTTI {
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        Class<?> cloObj;

        cloObj = x.getClass();  //get class reference
        System.out.println("x is object of type:" + cloObj.getName());
        cloObj = y.getClass();  //
        System.out.println("y is object of type:" + cloObj.getName());
        cloObj = cloObj.getSuperclass();
        System.out.println("y's superclass is " + cloObj.getName());

    }
}
