package getSubClassType;

public class Father {

    public Father() {
        print();
    }
    void print(){
        System.out.println("this is father print");
    }
    public Class getSubClassType() {
        return getClass();
    }
}
