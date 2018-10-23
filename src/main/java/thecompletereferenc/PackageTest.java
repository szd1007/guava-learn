package thecompletereferenc;

/**
 * 包访问权限
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-10-22 19:06
 */
public class PackageTest {

    public static void main(String[] args) {
        CharUtil charUtil = new CharUtil();
        //protect 同一个包内package  子类，非子类也可以访问  。不同包的子类
        //protect  包级别 加 不同包的子类权限
        //default 包级别访问权
        charUtil.CharUtilVal = 0;
    }

}
