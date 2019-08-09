package annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * 元注解 —— 注解其他注解
 * ————————————————————————————————————————————————————————————————————————————
 * @Target —— 说明注解的修饰范围
 * 1.ElementType.CONSTRUCTOR:用于描述构造器
 * 2.ElementType.FIELD:用于描述域（类的成员变量）
 * 3.ElementType.LOCAL_VARIABLE:用于描述局部变量（方法内部变量）
 * 4.ElementType.METHOD:用于描述方法
 * 5.ElementType.PACKAGE:用于描述包
 * 6.ElementType.PARAMETER:用于描述参数
 * 7.ElementType.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 * ————————————————————————————————————————————————————————————————————————————
 * @Retention —— 说明注解的保留时间
 * 1.RetentionPoicy.SOURCE:在源文件中有效（即源文件保留）
 * 2.RetentionPoicy.CLASS:在class文件中有效（即class保留）
 * 3.RetentionPoicy.RUNTIME:在运行时有效（即运行时保留）
 * ————————————————————————————————————————————————————————————————————————————
 * @Documented —— 标记注解 文档化
 * ————————————————————————————————————————————————————————————————————————————
 * @Inherited —— 标记注解 可继承
 * ————————————————————————————————————————————————————————————————————————————
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/9
 * @time 16:14
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyTestAnnotation {

    public int num() default 0;
    public String des() default "String";

}

