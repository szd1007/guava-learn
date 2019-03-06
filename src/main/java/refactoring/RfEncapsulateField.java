package refactoring;

/**  (封装成员变量)you should never make your data public!!!
 *
 *  有一个公共的成员变量
 *  把访问级别改成private并提供访问方法（accessors）,并且此时一般要使用{@link RfMoveMethod}将方法移到新的类中来
 *
 *
 * Mechanics
 * 1. 创建对应的 get、set方法
 * 2. 找出所有使用的地方，针对使用的地方用get方法，如果改变了值就用set方法替换
 *      如果field是一个对象，使用者调用了对象上的修改方法，这算是使用（get）。只有当重新给field赋值时才调用set
 *
 * 3. 此时需要更改field成private，同时看看能不能使用{@link RfMoveMethod}
 *
 *
 *
 *  public String name;
 *  \\\\\
 *  private String name;
 *  public String getName(){
 *      return name;
 *  }
 *  public void setName(String arg){
 *      name = arg;
 *  }
 *
 */
public class RfEncapsulateField {
}
