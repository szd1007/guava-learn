package refactoring;

/**
 * （观察者模式）
 * 你有一块领域数据（domain data）只在GUI控制中可用， 并且domain方法 需要访问这些数据
 *
 * 复制这些数据到domain Obj中， 设置一个观察者去同步这两块数据。
 *
 *  Motivation
 *
 *  Mechanics
 *  1. 使用presentation class 成为domain class 的一个observer
 *
 *  2. 在guiClass 上针对 domain Data 使用 {@link RfSelfEncapsulateField}
 *
 *  3. 添加一个在eventHandler上的setting 方法，用它来更新
 *
 *  4. 在domain class中定义数据和 accessor方法
 *
 *  5. 将accessor指定去写domain field
 *
 *  6. 修改observer的 update方法，使其将domain field的data拷贝到GUI control中
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-04 09:47
 */
public class RfDuplicateObservedData {

}
