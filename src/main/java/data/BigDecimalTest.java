package data;

import java.math.BigDecimal;

/**
 * @author XuqiangDuan
 * @Date 2018/7/26 13:02
 **/
public class BigDecimalTest {

    public static void main(String[] args){
        for(String arg : args){
            System.out.println("args:"+arg);
        }
        System.out.println("Hello World!");

        BigDecimal b = null;
        BigDecimal b1 = new BigDecimal("0.01");
        BigDecimal b2 = new BigDecimal(0.01);
        System.err.print("0.01: " +b+" | "+b1+" | "+b2);

    }
}
