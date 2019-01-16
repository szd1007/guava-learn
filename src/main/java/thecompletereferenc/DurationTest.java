package thecompletereferenc;

import java.time.Duration;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-01-16 16:55
 */
public class DurationTest {

    /**
     * Duration 字符串类似数字有正负之分,默认正,负以’-‘开头,紧接着’P’,下面所有字母都不区分大小写:
     ‘D’ – 天
     ‘H’ – 小时
     ‘M’ – 分钟
     ‘S’ – 秒
     字符’T’是紧跟在时分秒之前的，每个单位都必须由数字开始,且时分秒顺序不能乱,比如:P2DT3M5S,P3D,PT3S
     PT3M2S 等于 -PT-3M-2S
     * @param args
     */
    public static void main(String[] args) {
        Duration duration = Duration.parse("PT3m2s");
        System.out.println(duration.toMillis());

        duration = Duration.parse("PT1.345S");
        System.out.println(duration.toMillis());
    }
}
