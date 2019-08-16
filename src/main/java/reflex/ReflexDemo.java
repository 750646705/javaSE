package reflex;

import lombok.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Reflex Demo
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/15
 * @time 11:25
 */
@Data
public class ReflexDemo {

    public String id;

    /**
     * hello
     *
     * @param string
     * @return
     */
    public String hello(String string) {
        return "ReflexDemo hello -- " + string;
    }

    public String hello(String str, String string) {
        return "ReflexDemo hello -- " + str + " | " + string;
    }

    static {
        /**
         * Class.forName(String str)调用会触发该类的static块
         */
        System.out.println("ReflexDemo static ————————————————————————————————————————————————————");
    }

    public static void main(String[] args) {

        try {
            /**
             * Class 类 （package java.lang 包下）
             * 获取Class对象的方式
             * 1.通过Class静态方法forName()获取；
             * 2.类class方法；
             * 3.对象getClass()方法获取。
             * 以下以String为例
             */
            Class<? extends Object> aClass = Class.forName("java.lang.String");

            Class<? extends Object> bClsss = String.class;

            String string = new String("abcd");
            Class<? extends String> cClass = string.getClass();
            System.out.println("" + aClass + "\n" + bClsss.getName() + "\n" + cClass.getTypeName());

            Class<? extends Object> rClass = Class.forName("reflex.ReflexDemo");
            /**
             * Method 类 （package java.lang.reflect 包下）
             * 注意：getMethods() 获取包括父类的全部public修饰的方法 VS getDeclaredMethods() 仅获取该类声明全部的方法
             * 类普通方法
             */
            Method[] methods = rClass.getMethods();
            System.out.println("methods" + Arrays.toString(methods));

            /**
             * Field 类 （package java.lang.reflect 包下）
             * 同注意：getFields() VS getDeclaredFields()
             * 类成员属性
             */
            Field[] fields = rClass.getFields();
            System.out.println("fields : " + Arrays.toString(fields));

            /**
             * Constructor 类 （package java.lang.reflect 包下）
             * 类构造方法
             */
            Constructor<?>[] constructors = rClass.getDeclaredConstructors();
            System.out.println("constructors : " + Arrays.toString(constructors));


            /**
             * 反射创建对象
             * 1.Class.newInstance();
             * 2.Class ——> Constructor.newInstance()
             */
            ReflexDemo reflexDemoF = (ReflexDemo) rClass.newInstance();
            System.out.println(reflexDemoF.hello("First"));

            Constructor<?> cons = rClass.getConstructor(new Class[]{});
            ReflexDemo reflexDemoS = (ReflexDemo) cons.newInstance(new Object[]{});
            System.out.println(reflexDemoS.hello("Second"));


            /**
             * 反射调用方法
             */
            Object object = (ReflexDemo) rClass.newInstance();
            Method helloMethod = rClass.getMethod("hello", String.class);
            Object result = helloMethod.invoke(object, "JavaScript");
            System.out.println(result);
            //多参数方法调用
            Method helloMethodN = rClass.getMethod("hello", new Class[]{String.class, String.class});
            Object resultN = helloMethodN.invoke(object, new Object[]{"one", "two"});
            System.out.println(resultN);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}