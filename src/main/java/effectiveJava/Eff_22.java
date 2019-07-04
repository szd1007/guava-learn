package effectiveJava;

import thecompletereferenc.datatype.intUtil;

public class Eff_22 {

}

/**
 *  静态类
 */
class PhysicalConstants {
    @EfLanguagePoints("常量类，构造器私有化 禁止实例化调用")
    private PhysicalConstants(){} //prevents instantiation

    /**
     * @see intUtil
     */
    @EfLanguagePoints("java7开始数字中允许添加下划线")
    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    public static final double BOLTZMANN_CONST  = 1.380_648_52e-23;
    public static final double ELECTRON_MASS    = 9.109_383_56e-31;
}

