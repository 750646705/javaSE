/**
 * @author XUQIANG_DUAN
 * @date 2019/4/16
 * @time 15:30
 */
public abstract class TestOne {
    public abstract void aVoid();

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");

        Integer int1 = 123;
        Integer int2 = new Integer(123);
        int int3 = 123;

        System.out.println("--- String ---");
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
        System.out.println(str3.equals(str4));
        System.out.println(str3 == str4);

        System.out.println("--- Integer ---");
        System.out.println(int1.equals(int2));
        System.out.println(int1 == int2);
        System.out.println(int1.equals(int3));
        System.out.println(int1 == int3);


    }
}
