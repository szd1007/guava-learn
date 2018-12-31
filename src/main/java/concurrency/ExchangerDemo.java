package concurrency;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new UseString(exchanger)).start();
        new Thread(new MakeString(exchanger)).start();
    }
}


//A thread that constructs a string.
class MakeString implements Runnable {
    Exchanger<String> ex;
    String str;

    MakeString(Exchanger<String> stringExchanger) {
        ex = stringExchanger;
        str = "";
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            //Fill Buffer
            for (int j = 0; j < 5; j++) {
                str += ch++;
            }
            try {
                //Exchange a full buffer for an empty one.
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

//A Thread that uses a string.
class UseString implements Runnable {
    Exchanger<String> exchanger;
    String str;

    UseString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = exchanger.exchange("");
                System.out.println("Got: " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}