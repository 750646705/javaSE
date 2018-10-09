package adapter;

/**
 * @author XuqiangDuan
 * @Date 2018/8/8 8:56
 **/
public class Banner {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Banner(String message) {
        this.message = message;
    }

    public void showWithParen(){
        System.err.println("######" + message);
    }

    public void showWithAster(){
        System.err.println("******" + message);

    }
}
