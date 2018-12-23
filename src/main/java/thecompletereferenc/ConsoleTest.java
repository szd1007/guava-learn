package thecompletereferenc;

import org.junit.Test;

import java.io.Console;
import java.util.Objects;

public class ConsoleTest {

    public static void main(String[] args) {
        testPasswordInput();
    }
    @Test
    public static void testPasswordInput() {
        Console console = System.console();
        char[] passwd = null;
        if (Objects.isNull(console)) {
            System.out.println("console is null");
        } else if ((passwd = console.readPassword("[%s]", "Passwd:"))!= null) {
            System.out.println("get passwd: " + passwd);
            //do something else

            //finally fill empty string in passwd

        }

    }
}
