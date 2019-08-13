package keywordDetilals;

import equals.IntegerTest;
import lombok.Data;

import java.sql.SQLOutput;

/**
 * static 关键字详解
 * 《Java编程思想》P86页
 * “static方法就是没有this的方法；
 * 在static方法内部不能调用非静态方法，反过来是可以的；
 * 而且可以在没有创建任何对象的前提下，仅仅通过类本身来调用static方法；
 * 这实际上正是static方法的主要用途。”
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/13
 * @time 11:07
 */
public class StaticTest extends BaseStatic {

    /**
     * static块
     */
    static {
        System.out.println("B static StaticTest");
    }

    /**
     * static 成员变量
     */
    private static Student student = new Student("D StaticTest");

    /**
     * static 成员方法
     */
    private static void staticMethod() {
        System.out.println("static methond!");
    }

    /**
     * 成员方法
     */
    @Override
    public void getStudent() {

        /**
         * 局部变量
         */
        Student student = new Student("G getStudent");
        System.out.println("H " + student.toString());
    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("begin...main");
        StaticTest staticTest = new StaticTest();
        staticTest.getStudent();

    }
}

/**
 * 父类
 */
class BaseStatic {

    /**
     * 父类 static块
     */
    static {
        System.out.println("A static BaseStatic");
    }

    /**
     * 父类 成员变量
     */
    private Student student = new Student("E BaseStatic");

    /**
     * 父类构造方法
     */
    public BaseStatic() {
        System.out.println("F class BaseStatic()");
    }

    /**
     * 父类普通方法
     */
    public void getStudent() {
        System.out.println("Student.id = " + null);
    }

}

@Data
class Student {
    private static String id = "null";

    static {
        System.out.println("C static Student");
    }

    public Student(String id) {
        Student.id = id;
        System.out.println("class Student() " + id);
    }

    @Override
    public String toString() {
        return "id = " + this.id;
    }
}


/**
 * 小结：
 * 1、static 可修饰成员变量&成员方法，不可修饰局部变量&构造方法，也可以单独成static快；
 * 2.加载顺序 static块 OR static成员变量 ——> main方法（包含构造new） ——> 成员变量 ——> 构造方法 ...
 */






