package thread;

/**
 * @author XuqiangDuan
 * @Date 2018/9/4 20:54
 **/
public class ThreadTest {
    public static void main(String[] args){

//        DemoRunnable runnable = new DemoRunnable();
//        Thread thread = new Thread(runnable, "Hello");
        /**
         * 将该线程标记为守护线程或用户线程。
         */
//        thread.setDaemon(true);
//        thread.start();
//        thread.run();

        DemoThread demoThread = new DemoThread("Goodbye");
//        demoThread.setPriority(Thread.NORM_PRIORITY);
        demoThread.setDaemon(true);
        demoThread.start();
        Thread.yield();
//        demoThread.run();
        demoThread.interrupt();
        try{
            Thread.sleep(10L);
            System.out.println("线程:"+Thread.currentThread().getName()+"状态是否处于运行状态？   "+ demoThread.isAlive());
            demoThread.join(1L);
        }catch(Exception e) {
            System.err.println(String.format("异常信息:%s" + e));
        }
    }

}
