package book.concurrencyInPractice;

/**
 * Created by shangzhidong on 2017/7/27.
 */
public class A {

    public void test() {
        System.out.println(this.getClass().getName());
        System.out.println(getSubClassName());

    }

    private String getSubClassName() {
        String fullName = this.getClass().getName();
        return fullName.substring(fullName.lastIndexOf(".")+1, fullName.length());
    }
}
