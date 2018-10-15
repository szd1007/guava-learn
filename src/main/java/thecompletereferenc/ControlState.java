package thecompletereferenc;

public class ControlState {
    public static void main(String[] args) {
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
