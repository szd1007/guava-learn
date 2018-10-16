package thecompletereferenc;

public class ControlState {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    continue outer;
                }
                System.out.print(" " + (i * j));
            }
        }
        System.out.println();
    }
    public static void main2(String[] args) {
        int a, b;
        for(a=1,b=4; a<b; a++) {
            System.out.println(a+";"+b);
        }
        for(int x=1,y=3; x<y; x++) {
            System.out.println(x+y);
        }

        boolean isDone = true;
        for(; !isDone; ){
            System.out.println("xxx");
        }

        //infinite loop
        for(;;)
            System.out.println();
    }
}
