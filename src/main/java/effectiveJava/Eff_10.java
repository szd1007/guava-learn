package effectiveJava;

/**
 * 10. 覆盖equals时要遵守通用约定[对称性 传递性 一致性]
 *
 * google autoValue框架
 */
public class Eff_10 {
    public static  class PhoneNumber {
        protected final short areaCode, prefix, lineNum;

        public PhoneNumber(int areaCode, int prefix, int lineNum){
            this.areaCode = rangeCheck(areaCode, 999, "area code");
            this.prefix = rangeCheck(prefix, 999, "prefix");
            this.lineNum= rangeCheck(lineNum, 9999, "line num");
        }

        @Override
        @EfLanguagePoints("equals  建议写法,   instanceof   包含了null 判断")
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PhoneNumber)) {
                return false;
            }
            PhoneNumber p = (PhoneNumber)obj;
            return (p.lineNum == lineNum) && (p.prefix == prefix) && (p.areaCode == areaCode);
        }

        private short rangeCheck(int val, int max, String arg) {
            if (val > max || val < 0) {
                throw new IllegalArgumentException(arg + ": " +val);
            }
            return (short)val;
        }
    }
}
