package brushAccess;
import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * 线程A使用chrome浏览器依次打开指定链接
 * @author XUQIANG_DUAN
 * @date 2019/4/17
 * @time 11:00
 */
public class DemoFour extends Thread{

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
            "https://blog.csdn.net/qq_32730819/article/details/89480293"
    };

    @Override
    public void run(){
        try {
            for(int i=0 ; i<60000 ; ++i){
                //随机选择博客 [0,12]
                int url = i%13;
                //选定博客uri
                URI uri = new URI(urls[url]);
                System.err.println(i + "次运行 | 浏览器:chrome.exe | 博客链接:"+url+" | 时间:" + System.currentTimeMillis());
                //Runtime类在浏览器中打开指定链接
                Runtime.getRuntime().exec("cmd /c start chrome.exe "+uri);
                //等待5秒
                TimeUnit.MILLISECONDS.sleep(4800);
                //关闭浏览器
                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
                //等待1秒
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建线程，开始执行
     * @param args
     */
    public static void main(String[] args){
        new DemoFour().start();
        new DemoFourBak().start();
    }

}
