package refactoring;

/**
 * 你有一个代表特殊含义的字面常量数。
 * 创建一个常量，根据含义来命名。 然后替换程序中的魔数
 * Motivation
 *  如果magicNumber是一个类型码，可以使用 {@link RfReplaceTypeCodeWithClass}
 *
 *
 *
 * double potentialEnergy(double mass, double height) {
 *     return mass * 9.81 * height;
 * }
 *
 * \\\
 * double potentialEnergy(double mass, double height){
 *     return mass * GRAVITATIONAL_CONSTANT * height;
 * }
 * static final double GRAVITATIONAL_CONSTANT = 9.81;
 *
 * @author szd1007@github.com
 * @date 2019-03-06 09:55
 */
public class RfPeplaceMagicNumberWithSymbolicConstant {

}
