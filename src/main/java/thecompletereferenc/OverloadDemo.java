package thecompletereferenc;

/**
 * in practice , you should only overload closely related operations
 */
public class OverloadDemo {
    void test() {
        System.out.println("no parameters");
    }

    //overload test for one integer parameter.
    void test(int a){
        System.out.println("a"+a);
    }
    //overload test for double parameter
    void test(double a){
        System.out.println("double "+a);
    }

    //overload test for two integer parameters
    void test(int a, int b){
        System.out.println(a + b);
    }

    //invalid  only change return type
//    int test(){
//
//    }

}
