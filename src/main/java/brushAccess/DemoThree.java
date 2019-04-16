package brushAccess;

import java.awt.*;
import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * @author XUQIANG_DUAN
 * @date 2019/4/16
 * @time 11:00
 */
public class DemoThree {
    //博客链接集
    private static String[] urls = {
            //专栏链接
            "https://blog.csdn.net/qq_32730819/column/info/35193",
            //CDA数据分析师 - 备考指南
            "https://blog.csdn.net/qq_32730819/article/details/87855572",
            //CDA数据分析师 - 《从零进阶！数据分析的统计基础》思维结构简图
            "https://blog.csdn.net/qq_32730819/article/details/88427788",
            //SPSS学习入门 简介&安装
            "https://blog.csdn.net/qq_32730819/article/details/88354877",
            //CDA数据分析师 - 数据分析概述
            "https://blog.csdn.net/qq_32730819/article/details/88203282",
            //CDA数据分析师 - SQL数据库基础 查询&连接
            "https://blog.csdn.net/qq_32730819/article/details/88059747",
            //CDA数据分析师 - SQL数据库基础 数据类型&表操作语句
            "https://blog.csdn.net/qq_32730819/article/details/87949029",
            //技术概念：敏捷开发、持续集成、持续交付和DevOps的定义及关系梳理
            "https://blog.csdn.net/qq_32730819/article/details/87716858",
            //IDEA常用插件
            "https://blog.csdn.net/qq_32730819/article/details/87885061",
            //博客访问量自刷DEMO
            "https://blog.csdn.net/qq_32730819/article/details/89314725"
    };
    //浏览器集
    private static String[] browsers = {
            "iexplore.exe ",
            "chrome.exe ",
            "firefox.exe "
    };

    public static void main(String[] args){
        try {
            Desktop desktop = Desktop.getDesktop();
            for(int i=0 ; i<600 ; ++i){
                //随机选择博客 [0,9] & 浏览器打开[0,2]
                int url = i%10;
                int browser = i%3;
                //选定博客uri
                URI uri = new URI(urls[url]);
                //选定浏览器
                String bro = browsers[browser];
                System.err.println(i + "次运行 | 浏览器:"+bro+" | 博客链接:"+url+" | 时间:" + System.currentTimeMillis());
                //Runtime类在浏览器中打开指定链接
                Runtime.getRuntime().exec("cmd /c start "+bro+uri);
                //等待5秒
                TimeUnit.MILLISECONDS.sleep(5050);
                //关闭浏览器
                Runtime.getRuntime().exec("taskkill /F /IM "+bro);
                //等待5秒
                TimeUnit.MILLISECONDS.sleep(1010);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
