package thecompletereferenc;

import java.util.ListResourceBundle;

/**
 * resourceBundle 测试
 * @author szd1007@github.com
 * @date 2018-12-17 21:04
 */
public class SampleRB_zh_CN extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "我的程序";
        resources[1][0] = "StopText";
        resources[1][1] = "停止";
        resources[2][0] = "StartText";
        resources[2][1] = "开始";

        return resources;
    }

}
