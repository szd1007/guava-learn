package org.adamx.util.test.mockito;

import com.alibaba.fastjson.JSON;
import effectiveJava.EfLanguagePoints;
import org.junit.Test;
import org.mockito.InOrder;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by @author shangzhidong@meituan.com
 * 2020/7/16
 **/
public class MockTest {

    LinkedList mockedList = mock(LinkedList.class);

    @Test
    public void testMockList() {
        //mock creation
        List<String> mockedList = mock(List.class);

        //using mock object
        mockedList.add("two");
        mockedList.add("one");
        mockedList.clear();

        //verification
        //默认就是检查add元素次数，与顺序无关
        verify(mockedList).add("one");
        verify(mockedList).add("two");
        verify(mockedList).clear();
        //Once created, a mock will remember all interactions.
        // Then you can selectively verify whatever interactions you are interested in.
    }

    @Test
    public void test实体类() {
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing  mock特定类方法返回特定值
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(1));
        // 返回null
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
        System.out.println("----------------");
        when(mockedList.get(anyInt())).thenReturn("element");
        System.out.println(mockedList.get(999));
    }

    @Test
    public void testMock方法不限制参数() {
        //调用指定类的接口 返回mock对象
        MockMethod mock = mock(MockMethod.class);
        when(mock.mockTest(any())).thenReturn(new ReturnObj(3333));

        System.out.println(mock.mockTest(null).a);
    }

    @Test
    public void test指定调用次数() {
        LinkedList mockedList = mock(LinkedList.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //times(1) is the default. Therefore using times(1) explicitly can be omitted.
        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        verify(mockedList, times(1)).add("once");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }

    @Test
    public void test调用Void方法时触发异常() {
        doThrow(new RuntimeException()).when(mockedList).clear();

        mockedList.clear();
    }

    @Test
    public void test按顺序验证() {
        // A. Single mock whose methods must be invoked in a particular order
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(singleMock);

        //following will make sure that add is first called with "was added first, then with "was added second"
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. Multiple mocks that must be used in a particular order
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        InOrder inOrder2 = inOrder(firstMock, secondMock);

        //following will make sure that firstMock was called before secondMock
        inOrder2.verify(firstMock).add("was called first");
        inOrder2.verify(secondMock).add("was called second");

        // Oh, and A + B can be mixed together at will


//        verifyNoInteractions(firstMock,mockedList);
    }

    @Test
    public void test验证多余次数的调用() {
        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");
//        verify(mockedList).add("two");

        verifyNoMoreInteractions(mockedList);

    }

    @Test
    public void test使用Mock注解简化(){
//        @Mock private ArticleCalculator calculator;

    }

    @Test
    public void test连续调用返回不同值() {
        when(mockedList.add("one"))
                .thenThrow(new RuntimeException())
                .thenReturn(true);

        mockedList.add("ddd");
        try {
            mockedList.add("one");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(mockedList.add("one"));
        System.out.println(mockedList.add("one"));
    }
    @Test
    public void test连续调用返回不同值2222() {
        when(mockedList.add("one"))
               .thenReturn(true,false);

        System.out.println(mockedList.add("ddd"));

        System.out.println(mockedList.add("one"));
        System.out.println(mockedList.add("one"));
        System.out.println(mockedList.add("111111111111"));
        System.out.println(mockedList.add("one"));
    }



    static class MockMethod {
        public ReturnObj mockTest(InputParam inputParam) {
            return new ReturnObj(1);
        }

    }

    static class ReturnObj {
        int a;

        public ReturnObj(int i) {
            a = i;
        }
    }

    static class InputParam {
        int anInt;
    }


}
