package thread;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * @author XuqiangDuan
 * @Date 2018/9/4 10:33
 * <p>
 * 备注：创建多线程方法二
 * 1.新建类实现Runnable接口，并重写接口run方法；
 * 2.创建该类的实例，并以此实例作为Thread的target来创建Tread对象。
 * 3.start方法启动该线程对象。
 **/
public class DemoRunnable implements Runnable {
    private int i;

    /**
     * 同步锁
     */
    private static final ReentrantLock lock = new ReentrantLock();

    public static void lockCode() {
        /**
         * 加锁
         */
        lock.lock();
        try {
            System.out.println("同步锁等待中……");
            Thread.sleep(100L);
        } catch (Exception e) {

        } finally {
            /**
             * 释放锁
             */
            lock.unlock();
        }
    }

    @Override
    public void run() {

        System.out.println("正在执行……");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕……");

        for (; i < 100; ++i) {
            System.out.println(String.format("i = %s", i + "----------" + Thread.currentThread().getName()));
        }

    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            DemoRunnable.lockCode();
            System.out.println(Thread.currentThread().getName() + "-----------" + i);
            if (i == 20) {
                DemoRunnable t = new DemoRunnable();
                new Thread(t, "Windows1").start();
                new Thread(t, "Windows2").start();
            }
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
