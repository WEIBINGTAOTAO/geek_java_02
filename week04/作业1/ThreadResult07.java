package java0.conc0303;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class ThreadResult07 {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier (){

            @Override
            public Integer get(){
                return fibo(36);
            };
            private  int fibo(int a) {
                if ( a < 2)
                    return 1;
                return fibo(a-1) + fibo(a-2);
            }

        });

        try {
            int result=future.get();
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
