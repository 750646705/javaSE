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
            //CDA数据分析师 - 数据分析概述
            "https://blog.csdn.net/qq_32730819/article/details/88203282",
            //CDA数据分析师 - SQL数据库基础 查询&连接
            "https://blog.csdn.net/qq_32730819/article/details/88059747",
            //CDA数据分析师 - SQL数据库基础 数据类型&表操作语句
            "https://blog.csdn.net/qq_32730819/article/details/87949029",
            //IBM SPSS Statistics从零进阶 操作&运用
            "https://blog.csdn.net/qq_32730819/article/details/88365358",
            //SPSS学习入门 简介&安装
            "https://blog.csdn.net/qq_32730819/article/details/88354877",
            //SPSS中常用的几种t检验实例操作
            "https://blog.csdn.net/qq_32730819/article/details/88648814",
            //MySQL数据库安装操作指南（包括Windows&Linux系统安装详细步骤）
            "https://blog.csdn.net/qq_32730819/article/details/89279714",
            //MySQL导入CSV/TXT等数据源中数据操作流程及注意事项
            "https://blog.csdn.net/qq_32730819/article/details/88073041",
            //Redis概述 - Redis 安装步骤 & 基本操作
            "https://blog.csdn.net/qq_32730819/article/details/87924466",
            //Redis全局命令&数据结构详解
            "https://blog.csdn.net/qq_32730819/article/details/89480293",
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
    //浏览器集
    private static String[] browsers = {
            "iexplore.exe ",
            "chrome.exe "
            /**
             * TODO: 问题未解决
             * 1. QQBrowser & SogouExplorer.exe 运行显示如下
             * start QQBrowser.exe https://www.baidu.com
             * 系统找不到文件 QQBrowser.exe。
             * start SogouExplorer.exe https://www.baidu.com
             * 系统找不到文件 SogouExplorer.exe。
             * 2.microsoftedge.exe 无法跳转到指定链接
             * 3.firefox.exe 不稳定，多次打开并关闭显示Firefox启动时意外关闭
            */
    };

    public static void main(String[] args){
        try {
            Desktop desktop = Desktop.getDesktop();
            for(int i=0 ; i<60000 ; ++i){
                //随机选择博客 [0,26] & 浏览器打开[0,1]
                int url = i%27;
                int browser = i%2;
                //选定博客uri
                URI uri = new URI(urls[url]);
                //选定浏览器
                String bro = browsers[browser];
                System.err.println(i + "次运行 | 浏览器:"+bro+" | 博客链接:"+url+" | 时间:" + System.currentTimeMillis());
                //Runtime类在浏览器中打开指定链接
                Runtime.getRuntime().exec("cmd /c start "+bro+uri);
                //等待5秒
                TimeUnit.MILLISECONDS.sleep(2800);
                //关闭浏览器
                Runtime.getRuntime().exec("taskkill /F /IM "+bro);
                //等待1秒
                TimeUnit.MILLISECONDS.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
