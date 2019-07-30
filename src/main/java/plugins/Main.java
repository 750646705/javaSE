package plugins;

import plugins.GsonFormatDemo.CinemaListBean;

import java.util.ArrayList;

/**
 * @author XuqiangDuan
 * @Date 2018/10/8 10:32
 * 备注:GenerateAllSetter 调用对象的所有 set 方法并且赋予默认值;
 **/
public class Main {

    public static void main(String[] args) {
        LombokDemo lombokDemo = new LombokDemo();
        lombokDemo.setNumbers(0);
        lombokDemo.setNames("");

        GsonFormatDemo gsonFormatDemo = new GsonFormatDemo();
        gsonFormatDemo.setStatus(0);
        gsonFormatDemo.setErrorMessage("");
        gsonFormatDemo.setErrorCode("");
        gsonFormatDemo.setCinemaList(new ArrayList<CinemaListBean>());

        System.out.println("OK");

    }
}
