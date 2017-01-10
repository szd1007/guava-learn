package basicUtilities;

import com.google.common.base.Throwables;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by shangzhidong on 2017/1/10.
 * https://github.com/google/guava/wiki/ThrowablesExplained
 */
public class ThrowablesTest {

    public static void main(String[] args) throws SQLException, IOException {

        try {
            System.out.println("tdd");
//            throw  new RuntimeException();
            throw  new NumberFormatException();



        }catch (Throwable t){
            Throwables.propagateIfPossible(t,NumberFormatException.class);
            Throwables.propagateIfPossible(t,IOException.class);
        }

    }
}
