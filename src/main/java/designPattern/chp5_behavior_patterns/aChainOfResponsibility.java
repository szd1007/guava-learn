package designPattern.chp5_behavior_patterns;

/**
 * 职责链
 * 3 适用性
 *    - 有多个对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定
 *    - 你想在不明确接收者的情况下， 向多个对象中的一个提交请求
 *    - 可处理一个请求的对象集合应该被动态指定
 * 5 参与者
 *    - Handler  定义一个处理请求的接口
 *            【可选】实现后继链
 *    - concreteHandler（printButton 和 printDialog）
 *       * 处理它所负责的请求
 *       * 可访问它的后继者
 *       * 可处理就处理，否则转发请求到后继者
 *    - Client
 *       * 向链上提交请求
 *  7 效果
 *    - 降低耦合度
 *    - 增强给对象指派职责的灵活性
 *    - 不保证被接受
 *    @see ChainOfResponsibility
 *
 *
 *  相关模式：
 *    常与composite一起使用，此时一个构建的父构件可作为它的后继
 *
 */
public class aChainOfResponsibility {
}
