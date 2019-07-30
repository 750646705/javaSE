package singleton;

/**
 * 单例模式：设计模式之一，确保某个类只有一个实例对象。
 * 实现形式：懒汉式和饿汉式
 * 逼格备注：枚举式
 *
 * @author XuqiangDuan
 * @Date 2018/7/30 12:45
 **/
public class Singleton {
//    类内 / 同package / 子类 / 异package
//    public
//    protected
//    default（也成friendly，无修饰时默认）
//    private


    /**
     * 懒汉式
     */
    private static Singleton singleton = null;

    private Singleton() {
        slowdown();
        System.out.println("创建单类的一个实例");
    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    private void slowdown() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

