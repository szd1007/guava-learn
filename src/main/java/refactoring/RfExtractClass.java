package refactoring;

/**
 * 有一个类做了两个类应该做的事情
 *  当一些子集数据和一堆方法看起来聚集在一起的时候，需要进行拆分。
 *  另外的迹象是子集数据经常一起改变，或者相对其他部分没有依赖。
 *
 *  Mechanics
 *  1 确定如何分割责类的责任
 *  2 创建一个新类承担分割出来的类的责任
 *     如果旧类名称不能代表它的意思，那么要修改旧类的名称
 *  3 创建一个从旧类到新类的链接
 *     你可能需要一个双向的link，只有当你需要时才创建
 *  4 使用  {@link RfMoveField} 把你想移动的field处理掉
 *  5 使用 {@link RfMoveMethod} 把method从原来的类移出到新类中
 *      从低级别的方法开始
 *  6 审查和降低每个类中的接口
 *      如果已经有了双向link，看看能不能搞成单向的
 *  7  确定是否要暴露一个新类
 *      如果要这么做，看看是通过对象引用来做，还是使用一个常量类
 */
public class RfExtractClass {

    class Person{
        String name;
        String officeAreaCode;
        String offficeNumber;

        public String getName() {
            return name;
        }

        public String getTelephoneNumber() {
            return "(" + officeAreaCode + ") " + offficeNumber;
        }
        public String getOffficeNumber() {
            return offficeNumber;
        }

        public String getOfficeAreaCode() {
            return officeAreaCode;
        }

        public void setOffficeNumber(String offficeNumber) {
            this.offficeNumber = offficeNumber;
        }

        public void setOfficeAreaCode(String officeAreaCode) {
            this.officeAreaCode = officeAreaCode;
        }
    }
}

////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
class TelephoneNumber {
    String officeAreaCode;
    String offficeNumber;

    public String getTelephoneNumber() {
        return "(" + officeAreaCode + ") " + offficeNumber;
    }
    public String getOffficeNumber() {
        return offficeNumber;
    }

    public String getOfficeAreaCode() {
        return officeAreaCode;
    }

    public void setOffficeNumber(String offficeNumber) {
        this.offficeNumber = offficeNumber;
    }

    public void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }
}
class PersonNew {
    String name;
    TelephoneNumber telephoneNumber = new TelephoneNumber();
    public String getName() {
        return name;
    }

    /**
     * 代理方式调用telephoneNumber实体。这样子类不会对外暴露，
     * 可以只对内部暴露。对外进行隐藏
     *
     */
    public String getTelephoneNumber() {
        return telephoneNumber.getTelephoneNumber();
    }
    public String getOffficeNumber() {
        return telephoneNumber.getOffficeNumber();
    }

    public String getOfficeAreaCode() {
        return telephoneNumber.getOfficeAreaCode();
    }
}