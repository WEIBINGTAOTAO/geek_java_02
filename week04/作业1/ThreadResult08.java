package java0.conc0303;

public class ThreadResult08 implements Runnable{

    private int returnValue;
    private Object lock;

    public ThreadResult08(Object lock){
        this.lock=lock;
    }

    @Override
    public void run() {
        synchronized(lock){
            returnValue=fibo(36);
            lock.notify();
        }
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

        final Object lock=new Object();

        long start=System.currentTimeMillis();
        ThreadResult08 threadResult08=new ThreadResult08(lock);
        Thread thread = new Thread(threadResult08);
        thread.start();


        try {
            synchronized(lock){
                lock.wait();

            }
            int result=threadResult08.getReturnValue();
            System.out.println("计算结果为："+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }


}
