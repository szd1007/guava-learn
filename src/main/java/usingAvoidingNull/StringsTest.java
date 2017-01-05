package usingAvoidingNull;

import com.google.common.base.Strings;


/**
 * Created by shangzhidong on 2017/1/4.
 */
public class StringsTest {
    public static void main(String args[]){



        String str =null;
        boolean flag = Strings.isNullOrEmpty(str);
        System.out.println(flag);
        String ret = Strings.nullToEmpty(str);
        System.out.println("%"+ret+"%"+null);
    }
}
