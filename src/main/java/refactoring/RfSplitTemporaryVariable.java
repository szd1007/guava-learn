package refactoring;

/**
 * 你有一个临时变量被多次赋值，但是这个变量不是在循环中使用也不是用来收集数据的话。要对其进行分离
 *
 * Motivation
 * 一个变量如果赋值多次并且有了多个意义， 那么会使代码变得难以阅读
 *
 *
 *
 * **************************************
 * double temp = 2 * (height + width);
 * sout(temp);
 * temp = height * width;
 * sout(temp);
 *
 * ************************************
 * final double perimeter = 2 * (height + width);
 * sout(temp);
 * final double area = height *　width;
 * sout(area)
 * ************************************
 *
 * @author szd1007@github.com
 * @date 2019-02-22 15:01
 */
@SuppressWarnings("all")
public class RfSplitTemporaryVariable {

    private double primaryForce;
    private double secondaryForce;

    private double mass;
    private int delay;
///////////////////////////////////////////////////////////////////////////////////////////////
    double getDistanceTravelled(int time) {
        double result;
        ///
        double acc = primaryForce / mass;
        ///
        int primaryTime = Math.min(time, delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - delay;

        if (secondaryTime > 0) {
            double primaryVel = acc * delay;
            ///
            acc = (primaryForce + secondaryForce) / mass;
            ///
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    double getDistanceTravelled2(int time) {
        double result;
        ///
        final double primaryAcc = primaryForce / mass;
        ///
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - delay;

        if (secondaryTime > 0) {
            double primaryVel = primaryAcc * delay;
            ////
            final double secondaryAcc = (primaryForce + secondaryForce) / mass;
            ////
            result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
        }
        return result;
    }
}
