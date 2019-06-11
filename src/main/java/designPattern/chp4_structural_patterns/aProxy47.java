package designPattern.chp4_structural_patterns;

/**
 * 代理
 * 2 别名  surrogate
 *
 * 4 适用性
 *  在需要用比较通用和复杂度对象指针替代简单指针的时候，使用proxy模式。
 *    1）远程代理（remote proxy）为一个对象在不同的地址空间提供局部代表。
 *    2） 虚代理（Virtual proxy）根据需要创建开销很大的对象。比如使用imageproxy 代替真正的image。实现使用时的初始化
 *    3）保护代理 （Protection Proxy）控制原始对象访问，保护代理使用于对象应该有不同的访问权限的时候
 *    4）智能指引（smart reference）取代了简单的指针，在访问对象时添加一些附加操作。
 *        - 对指向的对象计数，无引用时自动释放
 *        - 第一次引用时，装入内存
 *        - 访问一个实际对象钱，检查是否已经锁定了它。确保其他对象不能改变它
 * 6 参与者
 * 。Proxy（Image Proxy）
 *   Subject(Graphic) 定义realsub和proxy的共用接口，
 *   realsubject （image） 定义proxy所代表的实体
 *
 *  8 效果
 *  在访问对象时引入了一定的间接性。根据代理类型，附加的间接性有多种用途
 *   1）remoteProxy可以隐藏一个对象存在于不同地址空间（进程、机器）的事实
 *   2）virtualProxy可以进行最优化，例如根据要求创建对象
 *   3）protection proxies和smart references都允许在访问一个对象时有一些附加的内务处理（housekeeping task）
 *
 *   隐藏copy-on-write的优化方式。实现拷贝代理：只有对大对象进行修改时才进行拷贝
 *
 */
public class aProxy47 {
}
