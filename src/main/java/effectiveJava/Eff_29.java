package effectiveJava;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Eff_29 {

    static class Stack<E> {
        private E stock[];
        private int tos;

        //allocate and initialize stack
        @EfLanguagePoints("确保转换合法")
        @SuppressWarnings("unchecked")
        public Stack(int size){
            stock = (E[]) new Object[size];
            tos = -1;
        }

        void push(E item) {
            if (tos == stock.length -1) //use length member
                System.out.println("Stack is full");
            else
                stock[++tos] = item;
        }

        E pop() {
            if (tos < 0) {
                 return null ;
            }else {
                E element = stock[tos--];
                stock[tos+1]=null;//帮助gc
                return element;
            }
        }
    }

    static class Stack2<E> {
        @EfLanguagePoints("用数组的原因是这样可以优化性能")
        private Object stock[];
        private int tos;

        //allocate and initialize stack
        public Stack2(int size){
            stock =  new Object[size];
            tos = -1;
        }

        void push(E item) {
            ensureCapacity();
            stock[++tos] = item;
        }

        private void ensureCapacity() {
            if (stock.length == tos+1) {
                stock = Arrays.copyOf(stock, 2 * tos + 1);
            }
        }

        public boolean isEmpty(){
            return tos<0;
        }
        E pop() {
            if (tos < 0) {
                throw new EmptyStackException() ;
            }else {
                @EfLanguagePoints("stock数组只在内部使用，存储的都是E的元素，这样强制转换也没有问题")
                @SuppressWarnings("unchecked")
                E element = (E)stock[tos--];
                stock[tos+1]=null;//帮助gc
                return element;
            }
        }
    }
}
