public class InstanceOfTest {

    static class Father{

    }
    static class Son extends Father{

    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        Father sb = new Son();

        System.out.println(father instanceof Father);
        System.out.println(son instanceof Father);
        System.out.println(sb instanceof Father);

        System.out.println();
        System.out.println(father instanceof Son);
        System.out.println(son instanceof Son);
        System.out.println(sb instanceof Son);    }
}
