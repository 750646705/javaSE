package fileOperation;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import sun.reflect.generics.tree.VoidDescriptor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel读/写操作 -- JXl方法
 * 备注：JXl方法暂不支持.xlsx文件格式
 * @author XUQIANG_DUAN
 * @date 2019/2/25
 * @time 20:49
 */
public class ExcelOperationByJxl {

    /**
     * 读操作 -- 结果为String/数组/集合
     * @param pathName　文件路径
     * @return
     * @throws Exception
     */
    public static List<String> readExcel(String pathName) throws Exception {

        List<String> result = new ArrayList<String>();
        if(pathName.indexOf(".xlsx") < 0){
            File file = new File(pathName);
            FileInputStream fs = new FileInputStream(file.getAbsolutePath());
            Workbook wb = Workbook.getWorkbook(fs);
            Sheet sheet = wb.getSheet(0);
            int rows = sheet.getRows();
            for (int i=0 ; i<rows ; i++){
                Cell[] cells = sheet.getRow(i);
                String first = cells[0].getContents().trim();
                String second = cells[1].getContents().trim();
                System.out.println("第" + i + "行信息为：" + first + " | " + second);
                result.add(first+second);
            }
        }else {
            System.out.println("JXL方法暂不支持.xlsx文件格式，请先处理Excel文件");
        }
        return result;

    }

    /**
     * 读操作 -- 结果为封装的实体对象
     * @param pathName
     * @return
     * @throws Exception
     */
    public static List<Student> readExcelBak(String pathName) throws Exception {

        List<Student> result = new ArrayList<>();
        if(pathName.indexOf(".xlsx") < 0){
            File file = new File(pathName);
            FileInputStream fs = new FileInputStream(file.getAbsolutePath());
            Workbook wb = Workbook.getWorkbook(fs);
            Sheet sheet = wb.getSheet(0);
            int rows = sheet.getRows();
            for (int i=0 ; i<rows ; i++){
                Student student = new Student();
                Cell[] cells = sheet.getRow(i);
                if(cells[0] != null){
                    if(CellType.LABEL.equals(cells[0].getType())){
                        student.setName(cells[0].getContents().trim());
                    }else {
                        System.out.println("注意：（"+i+"行, "+0+"列）数据格式（LABEL）有误请核对 | "+cells[0].getType());
                    }
                }
                if (cells[1] != null) {
                    if (CellType.NUMBER.equals(cells[1].getType())) {
                        student.setId(Integer.parseInt(cells[1].getContents().trim()));
                    }else{
                        System.out.println("注意：（"+i+"行, "+1+"列）数据格式（NUMBER）有误请核对 | "+cells[1].getType());
                    }
                }
                System.out.println("第" + i + "行信息为：" + student.getName() + " | " + student.getId());
                result.add(student);
            }
        }else {
            System.out.println("JXL方法暂不支持.xlsx文件格式，请先处理Excel文件");
        }
        return result;

    }

    /**
     * 写操作 -- 参数为封装的实体对象
     * @param pathName
     * @throws Exception
     */
    public static boolean writeExcel(String pathName, List<Student> students) throws Exception{

        File file = new File(pathName);
        OutputStream outputStream = new FileOutputStream(file);
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputStream);
        WritableSheet writableSheet = writableWorkbook.createSheet("测试", 0);

        for(int i=0; i<students.size(); i++){
            Student student = students.get(i);
            //创建一个Label,第一个参数是x轴,第二个参数是y轴,第三个参数是内容,第四个参数可选,指定类型
            Label label1 = new Label(0, i, student.getId()+"");
            Label label2 = new Label(1, i, student.getName());
            //把label加入sheet对象中
            writableSheet.addCell(label1);
            writableSheet.addCell(label2);
        }
        boolean result = false;
        try {
            writableWorkbook.write();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writableWorkbook){
                writableWorkbook.close();
            }
            if(null != outputStream){
                outputStream.close();
            }
        }
        return result;
    }

    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        String path = "C:/Users/xuqiang_duan/Desktop/test/test.xls";
        String wPath = "C:/Users/xuqiang_duan/Desktop/test.xls";
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("强强");
        student.setId(10001);
        students.add(student);
        try {
//            ExcelOperationByJxl.readExcel(path);
//            ExcelOperationByJxl.readExcelBak(path);
            ExcelOperationByJxl.writeExcel(wPath, students);

        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long use = end - begin;
        System.out.println("结束测试--用时："+use+"毫秒");
    }
}
