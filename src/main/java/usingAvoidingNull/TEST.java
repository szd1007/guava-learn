package usingAvoidingNull;

import java.util.Optional;

/**
 * Created by shangzhidong on 2017/1/3.
 */
public class TEST {
    public static void main(String args[]){
        Object a  =1;
        Optional<Object> possible = Optional.of(a);
        System.out.println(possible.isPresent());
    }
}
