package java0.conc0303;

public class ThreadResult02 implements Runnable{

    private int returnValue=0;

    @Override
    public void run() {
        returnValue=fibo(36);
    }

    private  int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
    public  int getReturnValue(){
        return returnValue;
    }

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        ThreadResult02 threadResult02=new ThreadResult02();
        Thread thread = new Thread(threadResult02);
        thread.start();

        try {
            while(threadResult02.getReturnValue()==0){
                Thread.sleep(1);
            }
            int result=threadResult02.getReturnValue();
            System.out.println("计算结果为："+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }
}
