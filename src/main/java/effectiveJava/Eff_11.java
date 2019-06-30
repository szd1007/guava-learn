package effectiveJava;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.util.Objects;

/**
 * 11. 覆盖equals时总要覆盖hashCode方法
 * <p>
 * hashMap  hashSet 会根据hashCode进行分桶， 所以要保证equals对象有相同的hashCode
 *
 * murmurhash 和md5相比性能高十几倍，同时比经典hash算法（乘31）产生的散列效果更好
 * @see HashingExplainedTest
 */
public class Eff_11 {


}

class EF_Phone extends Eff_10.PhoneNumber {
    private int hashCode;
    public EF_Phone(int areaCode, int prefix, int lineNum) {
        super(areaCode, prefix, lineNum);
    }

    /**
     *31是个奇素数，同时可以使用位移加减法来操作
     * */
    @EfLanguagePoints("典型的hashCode产生流程")
    public int hashCode1() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
    /**
     * 低性能版本,底层实现和方法1一样
     */
    public int hashCode2(){
        return Objects.hash(lineNum, prefix, areaCode);
    }

    /**
     * 缓存版本，延迟初始化，但是要确保对象是不可变的，这样计算一次之后就直接返回值
     */
    @EfLanguagePoints("不可变实例对象，懒加载 缓存  版本")
    public int hashCode3(){
        int result = hashCode;
        if (result == 0) {
            hashCode = hashCode2();
        }
        return result;
    }

    @EfLanguagePoints("google hash  版本， 直接产生md5密文，冲突极小  但是性能会差。 折衷 murmurhash")
    public int hashCode4() {
        HashCode hashCode = Hashing.md5().newHasher()
                .putShort(lineNum)
                .putShort(prefix)
                .putShort(areaCode).hash();
        return hashCode.hashCode();

    }
}