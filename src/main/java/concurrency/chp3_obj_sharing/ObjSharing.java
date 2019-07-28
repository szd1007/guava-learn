package concurrency.chp3_obj_sharing;

/**
 * chp3 对象的共享
 */
public class ObjSharing {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(222));
    }
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        System.out.println(n);
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        return (n < 0) ? 1 : n;
    }}
