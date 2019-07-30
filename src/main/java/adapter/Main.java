package adapter;

/**
 * @author XuqiangDuan
 * @Date 2018/8/8 9:12
 **/
public class Main {

    public static void main(String[] agrs) {

        Banner banner = new Banner("JAVA");
        Print print = new PrintBanner("Hello World!");
        print.printWeak();
        print.printString();

        BasePrint basePrint = new BasePrintBanner("Base Hello World!");
        basePrint.printWeak();
        basePrint.printStrong();

    }

}
