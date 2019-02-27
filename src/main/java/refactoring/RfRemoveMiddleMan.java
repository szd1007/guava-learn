package refactoring;

/**
 * 一个类做了太多简单代理的事情，直接让client调用代理类
 * 和{@link RfHideDelegate} 正好相反
 *
 * Mechanics
 * 1 直接在代理类上创建访问方法
 * 2 移除中间代理方法
 * Refactoring means you never have to see you're sorry-you just fix it.
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-02-27 13:19
 */
public class RfRemoveMiddleMan {

}
