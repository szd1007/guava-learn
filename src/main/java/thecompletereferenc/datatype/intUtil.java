package thecompletereferenc.datatype;

public class intUtil {
    public static void main(String[] args) {
        //int 掩码形式
        int binary = 0b1010;
        int x = 15;
        System.out.println("binary 10:::" + binary);
        System.out.println(x&binary);

        int big = 123__456_7;
        System.out.println(big);

        long longNum = 222__333_44L;

        int ip = 0b1000_1111_00;
        System.out.println(ip);
        double dx = 10.0;
        double dx3 = 10d;

        float fp = 0x10p2f;
        System.out.println(fp);
        float xe = 1.0e2f;
        System.out.println(xe+1);

        int [] aA = new int[10];
        System.out.println(aA);
        for (int i : aA) {
            System.out.println("array i" + i);
        }
    }
}
