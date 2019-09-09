package org.adamx.util.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedJunitTest {
    private int in;
    private int out;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
            {1,2},
            {2,3},
            {0,0}
        });
    }

    public ParameterizedJunitTest(int input , int expect){
        this.in = input;
        this.out = expect;
    }

    @Test
    public void normalTest(){
        assertEquals(in+1, out)

        ;

    }

}
