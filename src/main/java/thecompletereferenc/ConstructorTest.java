package thecompletereferenc;

public class ConstructorTest {

    public static class Parent{
        int a = -1;
        public Parent(){
            System.out.println("con 1");
            a = 0;
        }
        public Parent(int b){
            System.out.println("con2");
            a = b;
        }

    }
    public static class Child extends Parent{
        public Child(int c){
            //super(c);
            System.out.println("con childe");
        }
    }

    public static void main(String[] args) {
        new Child(100);
    }
}

