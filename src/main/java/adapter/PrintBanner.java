package adapter;

/**
 * @author XuqiangDuan
 * @Date 2018/8/8 9:08
 **/
public class PrintBanner extends Banner implements Print{

    public PrintBanner(String message) {
        super(message);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printString() {
        showWithAster();
    }
}
