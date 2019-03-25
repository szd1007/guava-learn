package refactoring.chp10_makingMethodCallsSimpler;

/**
 * 方法名称词不达意的时候，change name
 */
public class RfRenameMethod {

    class Before {

        public String getTelephoneNumber() {
            return "officeAreaCode" + "officeNumber";
        }

        public String getOfficeTelephoneNumber() {
            return "officeAreaCode" + "officeNumber";
        }
    }

    class After {

        @Deprecated
        /**
         * 如果方法对外暴露了接口，导致原有方法不能删除的时候。
         * 使用这种方式处理
         */
        public String getTelephoneNumber() {
            return getOfficeTelephoneNumber();
        }

        public String getOfficeTelephoneNumber() {
            return "officeAreaCode" + "officeNumber";
        }
    }


}
