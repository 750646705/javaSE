package collection.mapDemo;

/**
 * 位运算&模运算效率比较
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/6
 * @time 13:50
 */
public class BitVsModular {

    /**
     * 位运算
     *
     * @param h
     * @param length
     * @return
     */
    public static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    /**
     * 模运算
     * @param h
     * @param length
     * @return
     */
    public static int modFor(int h, int length) {
        return h % length;
    }

    public static void main(String[] args) {

        long start = System.nanoTime();
        for (int i = 0; i < 1000; ++i) {
//            System.out.println(i + " & 15 计算结果：" +
                    BitVsModular.indexFor(i, 16);
//            );
        }
        long end = System.nanoTime();
        System.out.println("###################  位运算 运行时间为："+(end-start)+"  #######################");

        long start1 = System.nanoTime();
        for (int i = 0; i < 1000; ++i) {
//            System.out.println(i + " & 15 计算结果：" +
                    BitVsModular.modFor(i, 16);
//            );
        }
        long end1 = System.nanoTime();
        System.out.println("*******************  模运算 运行时间为："+(end1-start1)+"  ***********************");
    }


}
