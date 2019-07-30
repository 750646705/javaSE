package algorithm.maxCommonDivisor;


/**
 * 求两个数的最大公约数
 * 更相减损法
 *
 * @author XUQIANG_DUAN
 * @date 2019/7/29
 * @time 10:24
 */
public class Subtraction {

    private static int subMethon(int a, int b) {

        int result = 1;
        /**
         * 大值&小值
         */
        int maxI = a > b ? a : b;
        int minI = a > b ? b : a;
        /**
         * 大值&小值都为偶数，先简约
         */
        while (maxI % 2 == 0 && minI % 2 == 0) {
            result *= 2;
            maxI /= 2;
            minI /= 2;
        }
        /**
         * 差值
         */
        int sub = maxI - minI;
//        System.out.println("差值为：" + sub + " | 大值为：" + maxI + " | 小值为：" + minI + " | 结果为：" + result);
        if (sub == 0) {
            result *= minI;
        } else if (sub == 1) {
            result *= 1;
        } else {
            result *= subMethon(minI, sub);
        }

        return result;
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
        System.out.println("(" + a + ", " + b + ") | result = " + subMethon(a, b));
//        long end = System.currentTimeMillis();
        long nend = System.nanoTime();
//        System.out.println("共耗时（单位：ms）：" + (end - start) + " | 结束点：" + end + " | 开始点：" + start);
        System.out.println("共耗时（单位：ns）：" + (nend - nstart) + " | 结束点：" + nend + " | 开始点：" + nstart);
    }

    public static void main(String[] args) {
        timeConsume(5, 55);
        timeConsume(66, 55);
        timeConsume(10000, 10001);
        timeConsume(10000, 10003);
        timeConsume(1350, 1266);
        timeConsume(1000000, 1000003);
    }
}
