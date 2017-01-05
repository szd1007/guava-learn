package basicUtilities;

import com.google.common.base.Preconditions;

/**
 * Created by shangzhidong on 2017/1/5.
 */
public class TestPreconditions {


    public static void main(String[] args) {
        System.out.println();

        int a=-1;
//        Preconditions.checkArgument(a>0,"vlue must be no negative ",a);
//        Integer b=null;
//        Preconditions.checkNotNull(b);

//        Preconditions.checkState(,"");
//        Preconditions.checkElementIndex(1,1);
        Preconditions.checkElementIndex(-1,1);

    }
}
