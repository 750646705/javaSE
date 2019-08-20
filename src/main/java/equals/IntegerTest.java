package equals;

import java.lang.annotation.Inherited;

/**
 * == & equals 区别
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/13
 * @time 9:03
 */
public class IntegerTest {


    public static void main(String[] args) {

        Integer integerN = new Integer(10000);
        Integer integerD = 10000;
        int intD = 10000;
        System.out.println(integerN == integerD);
        System.out.println(integerN == intD);

        System.out.println(integerN.equals(integerD));
        System.out.println(integerN.equals(intD));

        Object object = new Integer(1);

    }
}
