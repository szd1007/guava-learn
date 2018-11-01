package thecompletereferenc;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-01 10:00
 */
public class AutoBox {

    public static void main(String[] args) {
        Integer iOb, iOb2;
        int i;
        iOb = 100;
        System.out.println("Original value of IOb: " + iOb);
        //表达式内 先自动拆箱（不管有没有原始类型）  最后自动装箱
        // 1,自动拆箱成int  2 执行增加操作 3 重新自动装箱
        ++iOb;
        System.out.println("iOb2 after expression: " + iOb);
        //同上
        iOb2 = iOb + (iOb / 3);
        System.out.println("iob2 after expression: " + iOb2);

        //未发生步骤3 自动装箱
        i = iOb + (iOb / 3);
        System.out.println("i after expression: " + i);

        //autobox
        Boolean b = true;

        //condition expression  auto Unbox
        if (b) {
            System.out.println("x");
        }
        //auto unbox
        while (b) {
            System.out.println("xx");
        }
    }
}
