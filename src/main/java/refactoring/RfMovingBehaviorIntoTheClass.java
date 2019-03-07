package refactoring;

/**
 *  我调用了一个方法，然后用getter方法之后去操作一个对象。
 *  如果这段代码只使用来get来的对象数据，最好是要把这个方法移到get的对象类中
 *
 *
 *
 *
 *  kent.getCourses().size()
 *  \\\\\
 *  kent.numberOfCourse()
 *
 *  class Person{
 *      public int numberOfCourses(){
 *          return courses.size();
 *      }
 *  }
 */
public class RfMovingBehaviorIntoTheClass {
}
