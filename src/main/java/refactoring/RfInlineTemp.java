package refactoring;

/**
 *  你有一个局部变量只被一个表达式赋值了一次，
 *  并且这个临时变量正在妨碍其他重构{@see RfExtractMethod }
 */
public class RfInlineTemp {

//    double basePrice = anOrder.basePrice();
//    return (basePrice>1000)
//
////////////////////////////////////////////////
//
//    return (anOrder.basePrice()>1000)
}
