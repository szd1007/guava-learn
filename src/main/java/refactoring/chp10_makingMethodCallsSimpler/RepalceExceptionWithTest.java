package refactoring.chp10_makingMethodCallsSimpler;

import com.sun.deploy.security.WrapResource;
import sun.misc.Resource;
import thecompletereferenc.EmptyArrayException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayDeque;

/**
 * 当存在一个条件可以通过程序判断的方式来处理的时候，不要用异常的方式来实现
 *
 *   exceptions should be used for exceptional behaviour-behaviour that is an unexpected error;
 *
 * double getValueForPeriod(int periodNumber) {
 *     try{
 *         return values[periodNumber];
 *     } catch(ArrayIndexOutOfBoundException e) {
 *         return 0;
 *     }
 * }
 * -------------------------------
 * double getValueForPeriod(int periodNumber) {
 *     if (periodNumber >= values.length) return 0;
 *     return values[periodNumber];
 * }
 */
public class RepalceExceptionWithTest {

    private ArrayDeque<Resource> available;
    private ArrayDeque<Resource> allocated;

    class Before {

        class ResourcePool {
            Resource  getResource(){
                sun.misc.Resource result;
                try {
                    result = available.pop();
                    allocated.push(result);
                } catch (Exception e) {
                    result = new WrapResource(null);
                    allocated.push(result);
                }
                return result;
            }
        }
    }
    class After {

        class ResourcePool {
            Resource  getResource(){
                sun.misc.Resource result;
                if (available.isEmpty()) {
                    result = new WrapResource(null);
                }else {
                    result = available.pop();
                }
                allocated.push(result);
                return result;
            }
        }
    }
}
