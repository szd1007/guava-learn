package thecompletereferenc;

//Improved Stack class that uses the length array member.
public class StackTest {
    static class Stack {
        private Integer stock[];
        private int tos;

        //allocate and initialize stack
        public Stack(int size){
            stock = new Integer[size];
            tos = -1;
        }

        void push(int item) {
            if (tos == stock.length -1) //use length member
                System.out.println("Stack is full");
            else
                stock[++tos] = item;
        }

         int pop() {
            if (tos < 0) {
                System.out.println("stack underflow.");
                return 0 ;
            }else {
                int element = stock[tos--];
                stock[tos+1]=null;//帮助gc
                return element;
            }
        }
    }
}
