package refactoring;

/**
 *  当对参数进行分配值时，  使用一个临时变量进行替代
 *
 *  可以改变参数属性（当参数是对象时），但是不能改变参数的引用。
 *  Motivation
 *
 *   void aMethod(Object foo) {
 *       foo.modifyInSomeWay();     //that's ok
 *       foo = anotherObjec;        // trouble and despair will follow you
 *   }
 *========================================================
 *
 *  int discount(int inputVal, int quantity, int yearToDate) {
 *      if (inputVal > 50) inputVal -= 2;
 *  }
 * ------------------------
 * int discount(int inputVal, int quantity, int yearToDate) {
 *     int result = inputVal;
 *     if(inputVal > 50)
 *         result -= 2;
 * }
 *
 *
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-02-22 18:12
 */
public class RfRemoveAssignmentsToParameters {

    int discout(int inputVal) {

        return inputVal;
    }
}
