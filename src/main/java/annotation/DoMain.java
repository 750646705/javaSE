package annotation;

import java.lang.reflect.Field;

/**
 * 测试方法类
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/9
 * @time 16:26
 */
public class DoMain {

    public static void main(String[] args) {

        try {

            Student student = new Student();
            Class stuClass = student.getClass();
            Field field = stuClass.getDeclaredField("name");
            MyTestAnnotation myTestAnnotation = field.getAnnotation(MyTestAnnotation.class);
            System.out.println("注解：" + myTestAnnotation);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
        }

    }


}

