import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicReferenceDemo {


    /**
     * aba 问题
     *  http://www.adamx.org:9999/pics/java/aba问题.jpg
     * @param args
     */
    public static void main(String[] args) {

        String str1 = "aaa";
        String str2 = "bbb";
        AtomicStampedReference<String> reference = new AtomicStampedReference<String>(str1,1);
        reference.compareAndSet(str1,str2,reference.getStamp(),reference.getStamp()+1);
        System.out.println("reference.getReference() = " + reference.getReference());

        boolean b = reference.attemptStamp(str2, reference.getStamp() + 1);
        System.out.println("b: "+b);
        System.out.println("reference.getStamp() = "+reference.getStamp());

        boolean c = reference.weakCompareAndSet(str2,"ccc",4, reference.getStamp()+1);
        System.out.println("reference.getReference() = "+reference.getReference());
        System.out.println("c = " + c);
    }

}
