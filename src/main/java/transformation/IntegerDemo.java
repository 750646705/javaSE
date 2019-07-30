package transformation;

import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

/**
 * @author XuqiangDuan
 * @Date 2018/9/30 15:47
 **/
public class IntegerDemo {
    /**
     * Integer integer = ###
     * ###当赋值在范围[-128,127]的整数，不会创建新的Integer对象,而是从IntegerCache中获取已经创建好的Integer对象;
     * ###当大于这个范围的时候，直接new Integer来创建Integer对象。
     * <p>
     * 备注:Integer i1 = new Integer(10) 和Integer i2 = 10不同，前者会创建对象，存储在堆中，
     * 而后者因为在-128到127的范围内，不会创建新的对象，而是从IntegerCache中获取的。
     * 那么Integer ii2 = 128, 大于该范围的话才会直接通过new Integer（128）创建对象，进行装箱。
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer i1 = new Integer(10);
        Integer i2 = Integer.valueOf(10);
        Integer i3 = new Integer(10);
        Integer i4 = Integer.valueOf(10);
        /**
         * 结果 false false true
         */
        System.out.println("对象引用比较: " + (i1 == i2));
        System.out.println("对象引用比较: " + (i1 == i3));
        System.out.println("对象引用比较: " + (i2 == i4));

        System.out.println("---------------------------------------------------------------------");
        Integer ii1 = new Integer(128);
        Integer ii2 = Integer.valueOf(128);
        Integer ii3 = new Integer(128);
        Integer ii4 = Integer.valueOf(128);
        /**
         * 结果 false false false
         */
        System.out.println("对象引用比较: " + (ii1 == ii2));
        System.out.println("对象引用比较: " + (ii1 == ii3));
        System.out.println("对象引用比较: " + (ii2 == ii4));

    }


}
