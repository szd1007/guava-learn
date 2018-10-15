package thecompletereferenc;

public class CharUtil {
    public static void main(String[] args) {
        char x = 'X';
        System.out.println(x);
        System.out.println(++x);

        //8进制标识字符
        char a = '\141';
        char a1 = 141;
        //16进制标识字符
        char a2 ='\u0061';
        System.out.println(a);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println((int)(a));
        //字符串
        System.out.println("\141 \u0061");
        float xf = 111;
    }
}
