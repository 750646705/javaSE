package classLoading;

import java.security.SecureClassLoader;

/**
 * 类加载演示
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/19
 * @time 15:12
 */
public class ClassLoadingTest {

    public static void main(String[] args) {
        /**
         * 启动（Bootstrap）类加载器加载路径
         */
        System.out.println("Bootstrap: " + System.getProperty("sun.boot.class.path"));

        /**
         * 扩展（Extension）类加载器加载路径
         */
        System.out.println("Extension: " + System.getProperty("java.ext.dirs"));

        /**
         * 系统（System）类加载器加载路径
         */
        System.out.println("System: " + System.getProperty("java.class.path"));

        try {

            Class<?> classT = Class.forName("classLoading.ClassLoadingTest");
            System.out.println("classT :" + classT.getClassLoader());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("————————————————————————————————————————————————————————————");
        //系统类加载器
        System.out.println(ClassLoader.getSystemClassLoader());
        //扩展类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        //启动类加载器 —— 为null /*事实上，由于启动类加载器无法被Java程序直接引用，因此JVM默认直接使用 null 代表启动类加载器*/
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println("————————————————————————————————————————————————————————————");
        try {

            ClassLoader classLoader = new ClassLoader() {
            };
            System.out.println("测试类加载器" + classLoader.toString());
            Class<?> loadClass = classLoader.loadClass("java.lang.String");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
