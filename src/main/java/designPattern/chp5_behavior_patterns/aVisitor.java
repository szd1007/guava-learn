package designPattern.chp5_behavior_patterns;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author szd1007@github.com
 * @date 2019-06-13 11:27
 */
public class aVisitor {


    public static void main(String[] args) {
        List<Element> elements = Lists.newArrayList(new ElementA(), new ElementB());
        elements.forEach(x -> x.accept(new Visitor()));

        //解决如下代码
        for (Element element : elements) {
            if (element instanceof ElementA) {
                ((ElementA)element).a();
            } else if (element instanceof ElementB) {
                ((ElementB)element).b();
            }
        }
    }
}

class Visitor{

    /**
     * 每个visit方法负责访问异构对象的差异化方法
     */
    void visit(ElementA elementA) {

        System.out.println("visitor element A ");
        elementA.a();
    }

    void visit(ElementB elementB) {
        System.out.println("visitor element B");
        elementB.b();
    }
}
interface Element{

   void accept(Visitor visitor);
}
class ElementA implements Element{

    public void a() {
        System.out.println("method a in ElementA");
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ElementB implements Element{


    public void b() {
        System.out.println("method b in ElementB");
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
