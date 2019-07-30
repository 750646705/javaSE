package thread;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * {@link Executor}
 * {@link Executors}
 *
 * @author XuqiangDuan
 * @Date 2018/9/4 16:31
 * 线程池
 * @see Executor Executors
 **/
public class ThreadPoolDemo implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(String.format("i = %s", i + "----------" + Thread.currentThread().getName()));
            if (Thread.currentThread().getName().indexOf("2") > 0) {
                try {
                    Thread.sleep(10L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {


        // TODO 自动生成的方法存根
        ThreadPoolDemo t = new ThreadPoolDemo();
//        ExecutorService pool = Executors.newFixedThreadPool(6);

        /**
         * ThreadPoolExecutor类 构造方法
         *
         * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue);
         *
         * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory);
         *
         * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,RejectedExecutionHandler handler);
         *
         * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,RejectedExecutionHandler handler);
         *
         * int corePoolSize 核心线程数（最小线程数）
         * int maximumPoolSize 最大线程数
         * long keepAliveTime 空闲时间
         * TimeUnit unit 空闲时间单位
         * BlockingQueue<Runnable> workQueue 阻塞队列（缓存队列）可选ArrayBlockingQueue 数组、LinkedBlockingQueue 链表、SynchronousQueue
         * ThreadFactory threadFactory 线程工厂
         * RejectedExecutionHandler handler 拒绝策略
         *
         *
         *
         */
        int corePoolSize = 3;
        int maximumPoolSize = 5;
        long keepAliveTime = 1;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(1);
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };
        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        };
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);

        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i < 15; i++) {
            DemoRunnable demoRunnable = new DemoRunnable();
            poolExecutor.execute(demoRunnable);
            System.out.println("线程池中线程数目：" + poolExecutor.getPoolSize() + "，队列中等待执行的任务数目：" + poolExecutor.getQueue().size() + "，已执行玩别的任务数目：" + poolExecutor.getCompletedTaskCount());
        }
        poolExecutor.shutdown();


        HashMap<String, Object> map = new HashMap<>();


    }


}
