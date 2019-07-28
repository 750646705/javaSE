package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * 误解：该方法并非标准的冒泡排序，自己一直错误认为（20190728发现）
 *
 * @author XUQIANG_DUAN
 * @date 2019/2/12
 * @time 9:39
 */
public class BubbleSort {

    /**
     * 冒泡排序方法
     *
     * @param ints
     * @param flag 正序 = 1; 倒序 = -1
     * @return
     */
    public static int[] sortMethod(int[] ints, int flag) {
        int[] result = ints;
        boolean boo = true;

//        System.out.println("数组长：" + result.length);
        for (int i = 0; i < result.length; i++) {

//            System.out.println("i = " + i + " | value = " + result[i]);
            for (int j = i + 1; j < result.length; j++) {
                switch (flag) {
                    /**
                     * 正序 = 1 前大于后即交换
                     * 倒序 = -1 前小于后即交换
                     */
                    case 1:
                        boo = result[i] > result[j];
                        break;
                    default:
                        boo = result[i] < result[j];
                        break;
                }

//                System.out.println("j = " + j + " | value = " + result[j]);
                if (boo) {
                    /**
                     * 位置互换
                     */
                    result[i] = result[i] + result[j];
                    result[j] = result[i] - result[j];
                    result[i] = result[i] - result[j];
                }
            }
            System.out.println("第" + i + "次排序***" + Arrays.toString(result));
        }
        return result;
    }


    public static void main(String arg[]) {

        int[] ints = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
//        int[] ints = {2, 3, 1};
        System.out.println("排序前###" + Arrays.toString(ints));
        System.out.println("正排后+++" + Arrays.toString(sortMethod(ints, 1)));
        System.out.println("倒排后---" + Arrays.toString(sortMethod(ints, -1)));

    }


}
