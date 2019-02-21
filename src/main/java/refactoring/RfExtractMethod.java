package refactoring;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Motivation
 *  1 拆解长代码段方法
 *  2 当一段代码需要注释其作用时，代码拆分成新方法
 *
 *  if extracting improves clarity,do it , even if the name is longer than the code you have extracted.
 *
 *  Mechanics
 *  1 创建新方法，命名要说出方法要做什么，而不是如何做
 *  2 当需要返回多个结果到当前方法而无法应用此模式时
 *    先进行  @see RfSplitTemporaryVariable   @see RfReplaceTempWithQuery @see RfReplaceMethodWithMethodObject
 */
public class RfExtractMethod {
    // before  //////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param amount
     */
    void printOwing(double amount) {

        printBanner();

        //print details
        System.out.println("name:" + "shan");
        System.out.println("amount" + amount);


    }

    // after   ////////////////////////////////////////////////////////////////////////////////


    void printOwingA(double amount) {
        printBanner();
        printDetails(amount);
    }

    private void printDetails(double amount) {
        System.out.println("name:" + "shan");
        System.out.println("amount" + amount);
    }

    //////////////////////////////////////////////////////////////////////////////////

    private void printBanner() {
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////复杂示例//////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
@SuppressWarnings("all")
class RemDemo {
//////////////////////////////////////////////////////////////////////////////////
    void printOwing() {
        List<String> names = Lists.newArrayList("a", "ben", "d", "c");
        double charLens = 0;

        //print banner
        System.out.println("*****************");
        System.out.println("****print owing");
        System.out.println("*****************");

        //calculate len
        for (String name : names) {
            charLens += name.length();
        }

        //print details
        for (String name : names) {
            System.out.println("name: " + name);
            System.out.println("len:" + name.length());
        }
    }
//////////////////////////////////////////////////////////////////////////////////
    void printOwing2() {
        List<String> names = Lists.newArrayList("a", "ben", "d", "c");
        double charLens = 0;

        //print banner
        printBanner();

        //calculate len
        charLens = getLen(names);

        //print details
        printDetail(charLens);
    }

    private void printDetail(double charLens) {
        System.out.println("name: " + "joe");
        System.out.println("len:" + charLens);
    }

    private double getLen(List<String> names) {
        double charLens = 0;
        for (String name : names) {
            charLens += name.length();
        }
        return charLens;
    }

    private void printBanner() {
        System.out.println("*****************");
        System.out.println("****print owing");
        System.out.println("*****************");
    }
//////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////
    //目标  像读注释一样来读代码
    void printOwing3() {
        List<String> names = Lists.newArrayList("a", "ben", "d", "c");
        //print banner
        printBanner();
        //print details
        printDetail(getLen(names));
    }


//////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////
    //目标  像读注释一样来读代码
    void printOwing4() {

        //变量只被getLen使用，直接迁移到getLen方法就行
//        List<String> names = Lists.newArrayList("a", "ben", "d", "c");

        //print banner
        printBanner();
        //print details
        printDetail(getLen());
    }

    private double getLen() {
        List<String> names = Lists.newArrayList("a", "ben", "d", "c");
        double charLens = 0;
        for (String name : names) {
            charLens += name.length();
        }
        return charLens;
    }

    //////////////////////////////////////////////////////////////////////////////////

}
