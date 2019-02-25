package refactoring;


/**
 * chp7  moving features between  objects
 *
 * Mechaanics
 * 1 检验类中被方法使用的所有特性，考虑哪一些特性是要被移出的
 *   （如果一个特性被多个方法使用，那么要考虑移出所有关联的方法）
 * 2 检查子类和父类中你要移动方法的定义
 * （如果存在，那么你可能不能移出这个方法，除非目标类中也有这个继承关系）
 * 3. 在目标类中 声明这个方法
 *  （你可能使用另外一个名字，用来更好的符合目标类）
 * 4. 拷贝代码
 *   如果移动的代码需使用原来类中的逻辑，那么将source类作为对象引用传递到target中
 * 5. 确定如何在source中引用target对象
 *    使用成员变量、或者方法 来获取，（没有的话就创建个方法，其次是在source创建成员变量存储target引用）
 * 6. source方法代理使用target
 * 7 确定是否要移出source中的代理方法，或者是保留当做代理使用
 *   如果有多个对象引用，建议保留source方法做代理使用
 */
public class RfMoveMethod {

    private AccountType type;
    private int daysOverDrawn;

    double overdraftCharge(){
        if (type.isPremium()) {
            double result = 10;
            if ( daysOverDrawn > 7)
                result += (daysOverDrawn - 7) * 0.85;
            return result;
        } else {
            return daysOverDrawn * 1.75;
        }
    }

    double bankCharge() {
        double result = 4.5;
        if (daysOverDrawn > 0) {
            result += overdraftCharge();
        }
        return  result;
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////

    double overdraftCharge2() {
        return type.overdraftCharge(daysOverDrawn);
    }
}
