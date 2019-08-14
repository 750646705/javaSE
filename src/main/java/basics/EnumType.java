package basics;

import java.util.Arrays;

/**
 * This is  a Enum!
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/14
 * @time 16:39
 */
public enum EnumType {

    /**
     * 注意：
     * 1.枚举值一般是大写的字母，多个值之间以逗号分隔；
     * 2.添加枚举值注释说明。
     */
    CLASS, INTERFACE, ENUM, ABSTRACTCLASS, ANNOTATION

}

/**
 * 测试类
 */
class Test {

    public static void main(String[] args) {

        //枚举类常用方法
        EnumType enumType = EnumType.CLASS;

        System.out.println("Enum.valueof : " + EnumType.valueOf("CLASS"));
        System.out.println("Enum.values : " + Arrays.toString(EnumType.values()));
        Class<?> eclass = enumType.getDeclaringClass();
        System.out.println("Class.getEnumConstants : " + Arrays.toString(eclass.getEnumConstants()));
        System.out.println("Class.isEnum" + eclass.isEnum());

    }

}