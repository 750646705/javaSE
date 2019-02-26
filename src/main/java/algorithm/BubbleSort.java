package algorithm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Array;

/**
 * 冒泡排序算法
 *
 * @author XUQIANG_DUAN
 * @date 2019/2/12
 * @time 9:39
 */
public class BubbleSort {

    /**
     * 打印数组信息
      * @param state //状态：排序前/后
     * @param array
     */
    public static synchronized void print(String state, Integer[] array){
        System.out.print(state+"数组为：");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序方法
      * @param array
     * @return
     */
    public static synchronized Integer[] bubbleSort(Integer[] array) {
        BubbleSort.print("排序前", array);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                //前大于后，交换
                if(array[i] > array[j]){
                    array[i] = array[i] + array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
            }
        }
        BubbleSort.print("排序后", array);
        return array;
    }

    public static void main(String[] args) throws Exception {
        Integer[] array = {111,23,44,55,77,99,0,3,897};
        BubbleSort.bubbleSort(array);
    }

}
