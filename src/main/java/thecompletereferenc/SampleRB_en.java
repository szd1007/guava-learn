package thecompletereferenc;

import java.util.ListResourceBundle;

/**
 * resourceBundle 测试
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-17 21:04
 */
public class SampleRB_en extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "My Program";
        resources[1][0] = "StopText";
        resources[1][1] = "Stop";
        resources[2][0] = "StartText";
        resources[2][1] = "Start";

        return resources;
    }

}
