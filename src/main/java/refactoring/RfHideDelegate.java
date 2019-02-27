package refactoring;

/**
 * 一个客户端调用一个对象的代理类的时候
 *  创建一个server对象去包装代理方法。
 *
 *  Mechanics
 *  1 为每一个代理方法在server上创建一个对应的代理方法
 *  2 修改原来直接掉用代理的代码到server上
 *  3 如果没有client需要访问代理， 移除这个server上的代理
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-02-27 09:40
 *
 */
public class RfHideDelegate {

    static class Person{
        Department department;

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        //////////////////////after
        //封装代理，移除了getDepartment 操作符
        public Person getManager() {
            return department.getManager();
        }
    }

    class Department {
        private String chargeCode;
        private Person manager;

        public Department(Person manager) {
            this.manager = manager;
        }

        public Person getManager() {
            return manager;
        }
    }

    public static void main(String[] args) {
        new Person().getDepartment().getManager();
///////after ////////////

        new Person().getManager();
    }
}
