package brushAccess;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * 线程B使用iexplore浏览器依次打开指定链接
 * @author XUQIANG_DUAN
 * @date 2019/4/17
 * @time 14:46
 */
public class DemoFourBak extends Thread{

    //博客链接集
    public String[] urls = {
            //Linux常用快捷键、技巧&通配符
            "https://blog.csdn.net/qq_32730819/article/details/89161867",
            //Linux VI VIM 文书编辑器
            "https://blog.csdn.net/qq_32730819/article/details/89105361",
            //Linux 版本介绍及安装
            "https://blog.csdn.net/qq_32730819/article/details/89004753",
            //Java虚拟机知识框架图
            "https://blog.csdn.net/qq_32730819/article/details/88725604",
            //log4j.properties 配置文件
            "https://blog.csdn.net/qq_32730819/article/details/88133806",
            //IDEA常用插件
            "https://blog.csdn.net/qq_32730819/article/details/87885061",
            //博客访问量自刷DEMO
            "https://blog.csdn.net/qq_32730819/article/details/89314725",
            //Java操作Excel表格
            "https://blog.csdn.net/qq_32730819/article/details/87365101",
            //Java基础——System.out.print与System.err.print区别
            "https://blog.csdn.net/qq_32730819/article/details/87075464",
            //技术概念：敏捷开发、持续集成、持续交付和DevOps的定义及关系梳理
            "https://blog.csdn.net/qq_32730819/article/details/87716858",
            //技术概念：算法帝国
            "https://blog.csdn.net/qq_32730819/article/details/87795453",
            //强强乐谈：为您推荐几部优秀的影视作品
            "https://blog.csdn.net/qq_32730819/article/details/87885283",
            //Python基础
            "https://blog.csdn.net/qq_32730819/article/details/80683882"
    };

    @Override
    public void run() {
        try {
            for(int i=0 ; i<60000 ; ++i){
                //随机选择博客 [0,12]
                int url = i%13;
                //选定博客uri
                URI uri = new URI(urls[url]);
                System.err.println(i + "次运行 | 浏览器:iexplore.exe | 博客链接:"+url+" | 时间:" + System.currentTimeMillis());
                //Runtime类在浏览器中打开指定链接
                Runtime.getRuntime().exec("cmd /c start iexplore.exe "+uri);
                //等待5秒
                TimeUnit.MILLISECONDS.sleep(4500);
                //关闭浏览器
                Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
                //等待1秒
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
