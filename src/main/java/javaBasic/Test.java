package javaBasic;

import java.util.concurrent.ThreadPoolExecutor;

public class Test{
    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,)
    }
}

class Mythread implements Runnable{
    int sum;
    @Override
    public void run() {
        synchronized (this){
            sum = 0;
            for(int i = 0 ; i<10 ;i++){
                sum += i;
                System.out.println(sum);
            }
            System.out.println("mythread run over");
            this.notify();
        }
    }
}