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

        ClassLoader classLoader = null;
        SecureClassLoader secureClassLoader = null;


    }

}
