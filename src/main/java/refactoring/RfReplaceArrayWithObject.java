package refactoring;

/**
 * 你有一个数组用不同的元素代表不同意思的时候，将数组替换成对象。并且针对具体元素含义设置相应的对象属性。
 * (数组是用来方相似对象的地方）
 *
 *
 * String[] row = new String[3];
 * row[0] = "Liverpool";
 * row[1] = "15";
 * \\
 *  \\
 * Performance row = new Performance();
 * row.setName("Liverpool");
 * row.setWins("15");
 *
 * Mechanics
 * 1. 创建一个新的class来代表这个数组具体的含义
 * 2. 针对数组中的对象含义创建对应的类成员属性
 * 3. 替换array的使用到新的类
 *
 *
 * ps： 也可以采用直接使用类对象包裹原来array的方式。这样不用定义新的类成员，通过对应方法调用数组。
 *
 */
public class RfReplaceArrayWithObject {


}
