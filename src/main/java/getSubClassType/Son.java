package getSubClassType;

public class Son extends Father {

    /**
     * 可用于将父类log对象关联到对应的子类中.不能是static的
     * @param args
     */
    public static void main(String[] args) {
        Son son = new Son();
        Class type = son.getSubClassType();
        System.out.println(type.getName());

        }

}
