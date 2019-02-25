package refactoring;

/**
 *   一个成员变量会比当前定义它的类被其他类使用的场景更多的时候，将成员变量抽出来。
 *   其他类的方法使用当前类变量比自己更多的时候，要考虑moving field。
 *   还有就是extract class时，先{@link RfMoveField} 再{@link RfMoveMethod}
 *
 *   Mechanics
 *   1 如果成员是public的，使用{@link RfEncapsulateField}
 *   2 在目标类创建成员变量和对应的get set方法
 *   3 确定如何从原来的类中引用目标类
 *      成员变量，或者方法， 没有创建个对象
 *   4 使用目标类的新方法替换现有的
 *      这个和{@link RfMoveMethod} 不一样，要使用目标方法，而不是代理转发
 *      but！！  如果当前类有很多使用目标类成员的时候，可以使用代理方法的形式，方便重构。即使后续更改也比较方便
 *      ，每次搞一小步
 *
 */
public class RfMoveField {


    private AccountType accountType;

    /**
     * @see AccountType#interestRate
     */
    private double interestRate;

    double interestForAmount_days(double amount, int days) {
        return interestRate * amount * days;
    }


    ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////

    /**
     *使用 accountType 中的interestRate
     */
    double interestForAmount_days2(double amount, int days) {
        return accountType.getInterestRate() * amount * days;
    }
}
