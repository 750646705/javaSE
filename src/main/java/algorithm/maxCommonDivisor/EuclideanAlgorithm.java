package algorithm.maxCommonDivisor;

/**
 * 求两个数的最大公约数
 * 欧几里得算法（又称辗转相除法）
 *
 * @author XUQIANG_DUAN
 * @date 2019/7/29
 * @time 9:21
 */
public class EuclideanAlgorithm {

    /**
     * 辗转相除法
     *
     * @param a
     * @param b
     * @return 最大公约数
     */
    private static int euclidMethod(int a, int b) {
        /**
         * 大值&小值
         */
        int maxI = a > b ? a : b;
        int minI = a > b ? b : a;
        /**
         * 余数
         */
        int remainder = maxI % minI;
        System.out.println("余数为：" + remainder);
        /**
         * 余数为零，小值为最大公约数
         * 余数为一，一为最大公约数
         * 大值&小值的最大公约数与小值与余数的最大公约数相同
         */
        if (remainder == 0) {
            return minI;
        } else if (remainder == 1) {
            return remainder;
        } else {
            return euclidMethod(minI, remainder);
        }
    }

    public static void main(String[] args) {

        System.out.println("(5, 55) | result = " + euclidMethod(5, 55));
        System.out.println("(66, 55) | result = " + euclidMethod(66, 55));
        System.out.println("(10000, 10001) | result = " + euclidMethod(10000, 10001));
        System.out.println("(10000, 10005) | result = " + euclidMethod(10000, 10005));
        System.out.println("(1350, 1266) | result = " + euclidMethod(1350, 1266));

    }
}
