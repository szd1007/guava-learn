package thecompletereferenc.datatype;

public class Bit {
    public static void main(String[] args) {
        int x = 0b00101010;
        System.out.println(x);
        System.out.println(~x);
        System.out.println(~x+1);
        int a = 0b0011;
        System.out.println(~a);
        System.out.println(~a & 0x0f);
        int b = 1;
        System.out.println(b<<30);
        System.out.println(b<<31);
        System.out.println(b<<32);

        //unsigned shift
        int nx = -4;
        System.out.println(nx>>1);
        System.out.println(nx>>>1);

        int d, e, f;
        d = e = f = 1;


    }
}
