package refactoring.chp10_makingMethodCallsSimpler;

/**
 * 一个成员变量只能在初始化的时候进行设置
 * 移除对应的set方法
 * 【fastjson 依赖 get set方法设置值，这个没法去掉】
 *
 * 如果set方法里有额外的逻辑。那就重命名这个set方法，表明其只用一次的含义（initId）
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-28 09:48
 */
public class RfRemoveSettingMethod {

}
