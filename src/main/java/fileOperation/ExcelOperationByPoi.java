package fileOperation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * Excel表格读/写 -- POI方法
 * @author XUQIANG_DUAN
 * @date 2019/2/25
 * @time 15:18
 */
public class ExcelOperationByPoi {
    /**
     * 读操作 -- 结果为String/数组/集合
     * @param pathName　文件路径
     * @return
     * @throws Exception
     */
    public static List<String> readExcel(String pathName) throws Exception {

        List<String> result = new ArrayList<String>();
        File file = new File(pathName);
        FileInputStream fs = new FileInputStream(file.getAbsolutePath());
        //2003.xls文件
        HSSFWorkbook hwb = null;
        //2007.xlsx文件
        XSSFWorkbook xwb = null;
        //表格（第一个 index=0）
        Sheet sheet = null;
        if(pathName.indexOf(".xlsx") >= 0){
            xwb = new XSSFWorkbook(fs);
            sheet = xwb.getSheetAt(0);
        }else{
            hwb = new HSSFWorkbook(fs);
            sheet = hwb.getSheetAt(0);
        }
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        String first = "";
        String second = "";
        for (int i = firstRowNum; i <= lastRowNum; i++) {
            //取得第i行 （第一行i=0是表头）
            Row row = sheet.getRow(i);
            if (row != null) {
                if (row.getCell(0) != null) {
                    row.getCell(0).setCellType(CellType.STRING);
                    first = row.getCell(0).getStringCellValue();
                }
                if (row.getCell(1) != null) {
                    row.getCell(1).setCellType(CellType.STRING);
                    second = row.getCell(1).getStringCellValue();
                }
            }
            System.out.println("第" + i + "行信息为：" + first + " | " + second);
            result.add(first+second);
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
        File file = new File(pathName);
        FileInputStream fs = new FileInputStream(file.getAbsolutePath());
        //2003.xls文件
        HSSFWorkbook hwb = null;
        //2007.xlsx文件
        XSSFWorkbook xwb = null;
        //表格（第一个 index=0）
        Sheet sheet = null;
        if(pathName.indexOf(".xlsx") >= 0){
            xwb = new XSSFWorkbook(fs);
            sheet = xwb.getSheetAt(0);
        }else{
            hwb = new HSSFWorkbook(fs);
            sheet = hwb.getSheetAt(0);
        }
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        for (int i = firstRowNum; i <= lastRowNum; i++) {
            Student student = new Student();
            //取得第i行 （第一行i=0是表头）
            Row row = sheet.getRow(i);
            if (row != null) {
                if (row.getCell(0) != null) {
                    if(CellType.STRING.equals(row.getCell(0).getCellType())) {
                        student.setName(row.getCell(0).getStringCellValue());
                    }else {
                        System.out.println("注意：（"+i+"行, "+0+"列）数据格式（STRING）有误请核对 | " +row.getCell(0).getCellType());
                    }
                }
                if (row.getCell(1) != null) {
                    if (CellType.NUMERIC.equals(row.getCell(1).getCellType())) {
                        student.setId((int)row.getCell(1).getNumericCellValue());
                    }else{
                        System.out.println("注意：（"+i+"行, "+1+"列）数据格式（NUMERIC）有误请核对 | " +row.getCell(1).getCellType());
                    }
                }
            }
            System.out.println("第" + i + "行信息为：" + student.getId() + " | " + student.getName());
            result.add(student);
        }
        return result;

    }

    /**
     * 写操作 -- 参数为封装的实体对象
     * @param pathName 文件路径
     * @param sheetName 表格名称
     * @param style .xls/.xlsx文件类别
     * @param titles 表头信息
     * @param datas 表格信息
     * @return
     */
    public static boolean writeExcel(
            String pathName, String sheetName, String style, List<String> titles, List<Student> datas
    ) throws Exception {
        Workbook workbook = null;
        if (".XLS".equals(style.toUpperCase())) {
            workbook = new HSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook();
        }
        // 生成一个表格
        Sheet sheet = workbook.createSheet(sheetName);
        Row row = sheet.createRow(0);
        /**
         * 创建表头信息
         */
        for (int i = 0; i < titles.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(titles.get(i));
        }
        /**
         * 创建表格信息
         */
        Iterator<Student> iterator = datas.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            index++;
            row = sheet.createRow(index);
            Student student = iterator.next();
            //实体对象属性个数
            int length = student.getClass().getDeclaredFields().length;
            System.out.println("Student类属性数量为："+length);
            for (int i = 0; i < length ; i++) {
                Cell cell = row.createCell(i);
                //依次对应实体对象的属性
                switch (i){
                    case 0 :
                        cell.setCellValue(student.getId());
                        break;
                    case 1 :
                        cell.setCellValue(student.getName());
                        break;
                    default:
                        System.out.println("【异常】Student类属性数量为："+length+" | i="+i);
                        break;
                }
            }
        }
        /**
         * 写入到文件中
         */
        boolean isCorrect = false;
        File file = new File(pathName);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            isCorrect = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                outputStream.close();
            }
            if(null != workbook){
                workbook.close();
            }
        }
        return isCorrect;
    }

    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        String path = "C:/Users/xuqiang_duan/Desktop/test/test.xlsx";
        String pathName = "C:/Users/xuqiang_duan/Desktop/test.xls";
        String sheetName = "测试";
        String style = ".xls";
        List<String> titles = new ArrayList<>();
        titles.add("学号");
        titles.add("姓名");
        List<Student> datas = new ArrayList<>();
        Student student = new Student();
        student.setName("强强");
        student.setId(10001);
        datas.add(student);
        try {
//            ExcelOperationByPoi.readExcel(path);
//            ExcelOperationByPoi.readExcelBak(path);
            Boolean boo = ExcelOperationByPoi.writeExcel(pathName, sheetName, style, titles, datas);
            System.out.println("写入结果："+boo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long use = end - begin;
        System.out.println("结束测试--用时："+use+"毫秒");

    }


}
