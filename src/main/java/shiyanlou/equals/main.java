package shiyanlou.equals;


import java.util.Date;

/**
 * @author XuqiangDuan
 * @Date 2018/8/21 13:55
 **/
public class main {

    public static void main(String[] args){

        /**
         * 基本数据类型 无equals方法，==比较内容/值 Object equals和==都是比较引用
         * equals比较内容/值 ==比较引用
         *
         * 备注：基本数据类型（8种） byte/short/int/long float/double boolean char
         */
        Object o1 = new Object();
        Object o2 = new Object();
        Boolean boo1e2 = o1.equals(o2);
        Boolean boo12 =  o1 == o2;
        //false false
        System.out.println("result: boo1e2-"+ boo1e2 +" boo12-"+ boo12);

        int i1 = 100;
        int i2 = 100;
        int i3 = 10000;
        int i4 = 10000;
        //true true
        System.out.println("result: one-"+(i1 == i2)+"| two-"+(i3 == i4));

        char c1 = 'a';
        char c2 = 'a';
        char c3 = '汉';
        char c4 = '汉';
        //true true
        System.out.println("result: one-"+(c1 == c2)+"| two-"+(c3 == c4));

//        String s1 = new String("111111");
//        String s2 = new String("111111");
//        String s3 = "111111";
//        String s4 = "111111";
//
//        boolean boo1e2 = s1.equals(s2);
//        boolean boo12 = s1 == s2;
//        boolean boo1e3 = s1.equals(s3);
//        boolean boo13 = s1 == s3;
//        boolean boo3e4 = s3.equals(s4);
//        boolean boo34 = s3 == s4;
//        //true false
//        System.out.println("result: boo1e2-"+ boo1e2 +" boo12-"+ boo12);
//        //true false
//        System.out.println("result: boo1e3-"+ boo1e3 +" boo13-"+ boo13);
//        //true true
//        System.out.println("result: boo3e4-"+ boo3e4 +" boo34-"+ boo34);

//        Object o1 = null;
//        Object o2 = new Object();
//        String s1 = "111111";
//        Value v1 = new Value(1, "111111");
//        Value v2 = new Value(1, "111111");
//        Value v3 = new Value(2, "111111");
//        Value v4 = new Value(1, "1111111");
//        //false
//        boolean boov1n = v1.equals(o1);
//        //false
//        boolean boov1o = v1.equals(o2);
//        //false
//        boolean boov1s = v1.equals(s1);
//        //true
//        boolean boov1e2 = v1.equals(v2);
//        //true
//        boolean boov12 = v1 == v2;
//        //false
//        boolean boov13 = v1.equals(v3);
//        //false
//        boolean boov14 = v1.equals(v4);
//        System.out.println("result: boov1n-"+boov1n);
//        System.out.println("result: boov1o-"+boov1o);
//        System.out.println("result: boov1s-"+boov1s);
//        System.out.println("result: boov1e2-"+boov1e2);
//        System.out.println("result: boov12-"+boov12);
//        System.out.println("result: boov13-"+boov13);
//        System.out.println("result: boov14-"+boov14);

//        Date d1 = new Date();
//        if(d1!=null && d1 != ' '){
//
//        }
    }


}
