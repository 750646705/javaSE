package thread;

import lombok.Data;

/**
 * @author XuqiangDuan
 * @Date 2018/9/4 10:06
 *
 * 备注：创建多线程方法一
 * 1.新建子类 继承Thread类，并重写run方法；
 * 2.创建该子类的实例（即创建Tread对象）；
 * 3.start方法启动该线程对象。
 **/
@Data
public class DemoThread extends Thread {
    private int i;
    private String str;

    public DemoThread(String str) {
        super(str);
    }

    @Override
    public void run() {

        for (; i < 100; ++i) {
            System.out.println(String.format("i = %s", i + "----------" + Thread.currentThread().getName()));
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-----------" + i);
            try {
                Thread.sleep(10L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i == 20) {
                new DemoThread("windows1").start();
                new DemoThread("windows2").start();
            }
        }
    }

}
