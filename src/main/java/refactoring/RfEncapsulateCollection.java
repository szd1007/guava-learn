package refactoring;


import junit.framework.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 封装集合，集合当做返回值时要和普通对象区别对待一下
 * 当一个方法返回一个集合的时候，使其返回一个只读的view。 并且提供 add/remove 方法。不提供set方法
 * 这样不用让client过多干涉set所在类内部结构
 *
 *  Mechanics
 *  1. 为collection添加 add 和 remove方法
 *  2. 初始化这个collection为一个empty collection
 *  3. 找到所有setting方法的调用者，要么在set方法中使用add 或者remove方法 要么让调用方直接使用add、remove方法
 *
 *      set方法只在两种种情形可用，就是当前collection是空的，或者传递的参数是一个非空的集合的时候
 *      这时候可以{@link RfRenameMethod} 表明方法是初始化或者replace的用意
 *  4. 找出来所有使用get方法的地方，修改成使用add、remove方法
 *  5. 等完成了所有的替换之后，将get返回一个read-only 的view给调用者
 *  6. 找出所有调用get方法然后还要更改原始collection的code，使用{@link RfExtractMethod} {@link RfMoveMethod}
 *
 */
public class RfEncapsulateCollection {

    class Before {
        class Course{
            String name;
            boolean isAdvanced;

            public Course(String name, boolean isAdvanced) {
                this.name = name;
                this.isAdvanced = isAdvanced;
            }

        }

        class Person {
            Set<Course> courses;
            public Set<Course> getCourses() {
                return courses;
            }

            public void setCourses(Set<Course> arg) {
                courses = arg;
            }
        }

        void test11() {
            Person kent = new Person();
            Set<Course> s = new HashSet<>();
            s.add(new Course("Smalltalk Programming", false));
            s.add(new Course("Appreciating Single Malts", true));
            kent.setCourses(s);
            junit.framework.Assert.assertEquals(2, kent.getCourses().size());

            Course refact = new Course("Refactoring", true);
            kent.getCourses().add(refact);
            kent.getCourses().add(new Course("Brutal Sarcasm", false));
            junit.framework.Assert.assertEquals(4, kent.getCourses().size());
            kent.getCourses().remove(refact);
            junit.framework.Assert.assertEquals(3, kent.getCourses().size());
        }

        void testIterator() {
            Person person = new Person();
            int count = 0;
            count = person.getCourses().stream().filter(x -> x.isAdvanced).collect(Collectors.toList()).size();
        }


    }

    public static void main(String[] args) {
        System.out.println(Before.class.getSimpleName());
    }
    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    class After{
        class Course{
            String name;
            boolean isAdvanced;

            public Course(String name, boolean isAdvanced) {
                this.name = name;
                this.isAdvanced = isAdvanced;
            }

        }

        class Person {

            Set<Course> courses = new HashSet<>();

            /**
             * 1 添加集合的 add remove方法
             */
            public void addCourse(Course arg) {
                courses.add(arg);
            }

            public void removeCourse(Course arg) {
                courses.remove(arg);
            }

            public void initializeCourse(Set<Course> arg) {
                Assert.assertEquals(0, courses.size());
//                arg.forEach(this::addCourse);
                courses.addAll(arg);
            }
        }
    }



}
