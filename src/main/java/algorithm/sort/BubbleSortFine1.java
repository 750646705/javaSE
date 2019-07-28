package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法优化
 * 思路：在排序过程中，如某次循环无元素发生位置互换，则数列已有序
 *
 * @author XUQIANG_DUAN
 * @date 2019/7/28
 * @time 14:00
 */
public class BubbleSortFine1 {


    /**
     * 优化冒泡方法
     *
     * @param ints
     * @return
     */
    public static synchronized int[] bubbleSortMeth(int[] ints) {
        int[] result = ints;
        for (int i = 0; i < result.length - 1; i++) {
            /**
             * 数列已有序的标记，默认为true
             */
            boolean isSorted = true;
            for (int j = 0; j < result.length - i - 1; j++) {
                /**
                 * 前后元素互换
                 */
                if (result[j] < result[j + 1]) {
                    isSorted = false;
                    result[j] = result[j] + result[j + 1];
                    result[j + 1] = result[j] - result[j + 1];
                    result[j] = result[j] - result[j + 1];
                }
            }
            if (isSorted) {
                break;
            }
            System.out.println("第" + i + "次排序***" + Arrays.toString(result));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        int[] ints = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        System.out.println("排序前###" + Arrays.toString(ints));
        System.out.println("排序后+++" + Arrays.toString(bubbleSortMeth(ints)));

    }


}
