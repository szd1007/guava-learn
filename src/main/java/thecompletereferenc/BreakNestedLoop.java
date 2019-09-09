package thecompletereferenc;

/**
 * @author szd1007@github.com
 * @date 2018-10-15 14:17
 */
public class BreakNestedLoop {

    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 3; i++) {
            System.out.println("pass " + i + ": ");
            for (int j = 0; j < 100; j++) {
                if (j == 10) {
                    break outer;    //exit both loops
                }
                System.out.print(j + " ");
            }
            System.out.println("This will not print");
        }
        System.out.println("Loops complete");
    }
}
