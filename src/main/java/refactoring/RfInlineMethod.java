package refactoring;

/**
 * Motivation
 * 方法体和服方法名称表现的意思一样清晰时，去掉这个方法。调用方直接使用代码
 *
 *
 */
@SuppressWarnings("all")
public class RfInlineMethod {

    int moreThanFiveLateDeliveries;
    // before  //////////////////////////////////////////////////////////////////////////

    int getRating() {
        return (moreThanFiveLateDeliveries()) ? 2 : 1;
    }

    private boolean moreThanFiveLateDeliveries() {
        return moreThanFiveLateDeliveries > 5;
    }

    // after   ////////////////////////////////////////////////////////////////////////////////

    int getRating2() {
        return (moreThanFiveLateDeliveries > 5) ? 2 : 1;
    }
}
