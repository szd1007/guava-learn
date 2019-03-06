package refactoring;

/**
 * 两个类之间有双向关联，但是一方不再需要使用另一方的特性的时候。
 * 将其改成单向引用.
 * 双向引用会增加系统的耦合性，使代码变得复杂难以维护。尽量使用单向
 * {@link RfChangeUnidirectionalAssociaitionToBidirectional}
 *
 * Mechanics
 * 1. 检查所有读取持有要移出引用的成员变量的reader。确定到底能不能删除
 *     考虑没有引用的情况下能否确定另外的对象，如果可以使用{@link RfSubstituteAlgorithm}
 *  来满足client使用getMethod
 *     考虑将这个
 *
 *
 */
public class RfChangeBidirectionalAssociationToUnidirectional {
}
