package java0.conc0303;

import java.util.concurrent.CountDownLatch;

public class ThreadResult10 implements Runnable{

    private int returnValue;
    private CountDownLatch countNum;

    public ThreadResult10(CountDownLatch countNum){
        this.countNum=countNum;
    }


    @Override
    public void run() {

        returnValue=fibo(36);
        countNum.countDown();
    }

    private  int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
    public  int getReturnValue()  {
        return returnValue;
    }

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        CountDownLatch countDownLatch=new CountDownLatch(1);
        ThreadResult10 threadResult10=new ThreadResult10(countDownLatch);
        Thread thread = new Thread(threadResult10);
        thread.start();

        try {
            countDownLatch.await();
            int result=threadResult10.getReturnValue();
            System.out.println("计算结果为："+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }
}
