package keywordDetilals;

import lombok.Data;

/**
 * 静态成员变量VS普通成员变量
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/13
 * @time 15:48
 */
public class StaticVariables {

    public static void main(String[] args) {
        School schoolA = new School();
        School schoolB = new School();
        School schoolC = new School();

        schoolA.getBig();
        System.out.println(schoolA.toString());
        System.out.println(schoolB.toString());
        System.out.println(schoolC.toString());

        schoolB.getBig();
        System.out.println(schoolA.toString());
        System.out.println(schoolB.toString());
        System.out.println(schoolC.toString());

        schoolC.getBig();
        System.out.println(schoolA.toString());
        System.out.println(schoolB.toString());
        System.out.println(schoolC.toString());

    }

}

@Data
class School {

    //静态变量
    private static int sint = 0;
    //成员变量
    private int nint = 0;

    public void getBig() {
        sint++;
        nint++;
    }

    @Override
    public String toString() {
        return "sint = " + sint + "; nint = " + nint;
    }

}

/**
 * 小结：
 * 1.静态变量属于整个类所有，而不是某个对象所有，即被类的所有对象共享；
 * 2.成员变量属于具体某个对象私有，即不被类的所有对象共享。
 */
