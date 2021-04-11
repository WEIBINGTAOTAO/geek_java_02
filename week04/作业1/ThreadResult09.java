package java0.conc0303;

public class ThreadResult09 implements Runnable{

    private int returnValue;

    @Override
    public void run() {

            returnValue=fibo(36);

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
        ThreadResult09 threadResult09=new ThreadResult09();
        Thread thread = new Thread(threadResult09);
        thread.start();

        try {
            synchronized(thread){
                thread.wait();
            }
            int result=threadResult09.getReturnValue();
            System.out.println("计算结果为："+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }
}
