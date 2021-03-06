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
//        System.out.println("余数为：" + remainder);
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

    /**
     * 运行时间&结果记录
     * currentTimeMillis 为毫秒时间戳
     * nanoTime 为纳秒时间戳
     * 1 秒 = 10^3 毫秒
     * 1 秒 = 10^9 纳秒
     *
     * @param a
     * @param b
     */
    private static void timeConsume(int a, int b) {

//        long start = System.currentTimeMillis();
        long nstart = System.nanoTime();
        System.out.println("(" + a + ", " + b + ") | result = " + euclidMethod(a, b));
//        long end = System.currentTimeMillis();
        long nend = System.nanoTime();
//        System.out.println("共耗时（单位：ms）：" + (end - start) + " | 结束点：" + end + " | 开始点：" + start);
        System.out.println("共耗时（单位：ns）：" + (nend - nstart) + " | 结束点：" + nend + " | 开始点：" + nstart);

    }

    public static void main(String[] args) {

        timeConsume(55, 55);
        timeConsume(66, 55);
        timeConsume(10000, 10001);
        timeConsume(10000, 10003);
        timeConsume(1350, 1266);
        timeConsume(1000000, 1000003);

    }
}
