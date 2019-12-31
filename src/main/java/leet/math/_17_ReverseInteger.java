package leet.math;

/**
 * 交流  溢出返回啥
 */
public class _17_ReverseInteger {

    public static int reverseInteger(int x) {
        int ret=0;
        int m = Integer.MAX_VALUE/10;
        while (x != 0) {
            if (Math.abs(ret) > m || (Math.abs(ret) == m && x % 10 >= 8)) {
                return 0;
            }
            ret = ret*10 +x%10;
            x/=10;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(-14));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
