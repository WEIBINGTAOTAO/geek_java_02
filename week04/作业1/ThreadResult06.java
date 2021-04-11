package java0.conc0303;

import java.util.concurrent.*;

public class ThreadResult06 {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return fibo(36);
            }

            private  int fibo(int a) {
                if ( a < 2)
                    return 1;
                return fibo(a-1) + fibo(a-2);
            }
        });
        executor.submit(task);


        try {
            int result=task.get();
            // 确保  拿到result 并输出
            System.out.println("异步计算结果为："+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }
}
