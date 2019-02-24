package refactoring;

/**
 * 你有一个长方法，并且这个方法使用本地变量的方式不能应用extactMethod
 * 将这个方法抽离成一个新对象，然后所有的本地变量都会变成新对象的类成员变量，这个时候可以在新对象中应用extractMethod
 *
 * 这个方法并不是为了减少方法中参数的个数，而是为了将方法进行进一步解耦查分
 *
 * @see RfExtractMethod
 */
@SuppressWarnings("all")
public class RfReplaceMethodWithMethodObject {
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    int gamma(int inputVal, int quantity, int yearToDate) {
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantValue1) > 100)
            importantValue2 -= 20;
        int importantValue3 = importantValue2 * 7;
        //and so on
        return importantValue3 - 2 * importantValue1;
    }

    int delta() {
        return -1;
    }

    /////////   after   //////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    int gamma2(int inputVal, int quantity, int yearToDate) {
        return new Gamma(this, inputVal, quantity, yearToDate).compute();
    }
}


class Gamma {
    private final RfReplaceMethodWithMethodObject _account;
    private int inputVal;
    private int quantity;
    private int yearToDate;
    private int importantValue1;
    private int importantValue2;

    public Gamma(RfReplaceMethodWithMethodObject source, int inputVal, int quantity, int yearToDate) {
        _account = source;
        this.inputVal = inputVal;
        this.quantity = quantity;
        this.yearToDate = yearToDate;
    }

    int compute() {
        importantValue1 = (inputVal * quantity) + _account.delta();
        importantValue2 = (inputVal * yearToDate) + 100;
        importantThing();
        int importantValue3 = importantValue2 * 7;
        // and so on
        return importantValue3 - 2 * importantValue1;
    }

    private void importantThing() {
        if ((yearToDate = importantValue1) > 100) {
            importantValue2 -= 20;
        }
    }
}
