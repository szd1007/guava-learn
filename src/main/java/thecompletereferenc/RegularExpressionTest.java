package thecompletereferenc;

public class RegularExpressionTest {

    public static void main(String[] args) {
        String a = "111323423323211223242";

        System.out.println(a.replace("1", "A"));
        System.out.println("replace All: 正则表达式替换");
        System.out.println(a.replaceAll("[0-9]","A"));

    }
}
