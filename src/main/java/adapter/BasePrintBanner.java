package adapter;

/**
 * @author XuqiangDuan
 * @Date 2018/8/8 12:56
 **/
public class BasePrintBanner extends BasePrint {
    private Banner banner;

    public BasePrintBanner(String message) {
        this.banner = new Banner(message);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
