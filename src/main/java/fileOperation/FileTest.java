package fileOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 文件读取
 *
 * @author XUQIANG_DUAN
 * @date 2019/2/13
 * @time 14:59
 */
public class FileTest {

    /**
     * 1.读取文件夹名称
     * 2.配成功位置迁移
     *
     * @param pathName
     */
    public static void doChange(String pathName, String fileName) throws Exception {

        //读取文件夹名称
        File file = new File(pathName);
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
//            if (fileList[i].isFile()) {
//                String fileName = fileList[i].getName();
//                System.out.println("文件：" + fileName);
//            }
            if (fileList[i].isDirectory()) {
                String dirName = fileList[i].getName();
                if (dirName.indexOf(fileName) >= 0) {
                    System.out.println("第" + i + "次相同：" + dirName);
                    //配成功位置迁移
                    //需要复制的目标文件或目标文件夹
                    String oPathName = pathName + "/" + dirName;
                    File oFile = new File(oPathName);
                    //复制到的位置
                    String topathname = "E:/项目需求文档/IBM项目整理/售药机图片集/基础数据/new";
                    File toFile = new File(topathname);
                    FileTest.copy(oFile, toFile);

                }
            }
        }
    }

    /**
     * 文件复制
     *
     * @param file
     * @param toFile
     * @throws Exception
     */
    public static void copy(File file, File toFile) throws Exception {
        byte[] b = new byte[1024];
        int a;
        FileInputStream fis;
        FileOutputStream fos;
        if (file.isDirectory()) {
            String filepath = file.getAbsolutePath();
            filepath = filepath.replaceAll("\\\\", "/");
            String toFilepath = toFile.getAbsolutePath();
            toFilepath = toFilepath.replaceAll("\\\\", "/");
            int lastIndexOf = filepath.lastIndexOf("/");
            toFilepath = toFilepath + filepath.substring(lastIndexOf, filepath.length());
            File copy = new File(toFilepath);
            //复制文件夹
            if (!copy.exists()) {
                copy.mkdir();
            }
            //遍历文件夹
            for (File f : file.listFiles()) {
                copy(f, copy);
            }
        } else {
            if (toFile.isDirectory()) {
                String filepath = file.getAbsolutePath();
                filepath = filepath.replaceAll("\\\\", "/");
                String toFilepath = toFile.getAbsolutePath();
                toFilepath = toFilepath.replaceAll("\\\\", "/");
                int lastIndexOf = filepath.lastIndexOf("/");
                toFilepath = toFilepath + filepath.substring(lastIndexOf, filepath.length());

                //写文件
                File newFile = new File(toFilepath);
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newFile);
                while ((a = fis.read(b)) != -1) {
                    fos.write(b, 0, a);
                }
            } else {
                //写文件
                fis = new FileInputStream(file);
                fos = new FileOutputStream(toFile);
                while ((a = fis.read(b)) != -1) {
                    fos.write(b, 0, a);
                }
            }
        }
    }

    /**
     * 操作方法
     *
     * @param args
     */
    public static void main(String[] args) {
        String pathExcelName = "C:/Users/xuqiang_duan/Desktop/非销售出库审批表 - 零号店一层自动售药机.xlsx";
        String pathFileName = "E:/项目需求文档/IBM项目整理/售药机图片集/基础数据/test";

        try {
            //读取Excel文件
            List<String> result = ExcelOperationByPoi.readExcel(pathExcelName);
            for (String filmName : result) {
                System.out.println(filmName);
                FileTest.doChange(pathFileName, filmName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
