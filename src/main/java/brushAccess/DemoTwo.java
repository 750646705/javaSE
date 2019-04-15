package brushAccess;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * @author XUQIANG_DUAN
 * @date 2019/3/4
 * @time 19:51
 */
public class DemoTwo {

    public static void main(String[] args){
        /**
         * 使用默认浏览器打开指定链接刷新
         * 备注：由于CSDN限制，该方法的时间间隔必须大于1分钟，访问才有效
         */
        try {
            Desktop desktop = Desktop.getDesktop();
            for(int i=0 ; i<200 ; ++i){
                //创建URI统一资源标识符
                //https://blog.csdn.net/qq_32730819/column/info/35193
                URI uri = new URI("https://blog.csdn.net/qq_32730819/article/details/88354877");
                //使用默认浏览器打开超链接
                desktop.browse(uri);
                System.err.println(i + "次运行时间为：" + System.currentTimeMillis());
                //等待30秒
                TimeUnit.MILLISECONDS.sleep(30000);
                //关闭浏览器
                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
                //等待30秒
                TimeUnit.MILLISECONDS.sleep(30000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
