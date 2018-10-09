package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author XuqiangDuan
 * @Date 2018/9/4 19:46
 *
 * 备注：创建线程方法三
 * 1.新建类实现Callable接口，并重写接口call方法；
 * 2.创建该类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值；
 * 3.使用FutureTask对象作为Thread的target创建Thread对象，并start方法启动该线程对象；
 * 4.调用FutureTask对象的get方法来获得子线程执行结束的返回值。
 **/
public class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for( ; i<10 ; i++) {
            System.out.println(Thread.currentThread().getName()+" | "+i);
        }
        return i;
    }

    public static void main(String[] args){
        CallableDemo callable = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        for(int i = 0 ; i<10 ;++i){
            System.out.println(String.format("i = %s", i+"----------"+Thread.currentThread().getName()));
            if(i==2) {
                Thread thread = new Thread(futureTask,"有返回值的线程");
                thread.start();
//                thread.run();
            }
        }
        try{
            System.out.println(String.format("线程返回值 %s", futureTask.get()+" | "+Thread.currentThread().getName()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
