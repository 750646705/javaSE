package fileOperation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XUQIANG_DUAN
 * @date 2019/2/27
 * @time 15:58
 */
public class Demo {
    /**
     * 读操作 -- 结果为String/数组/集合
     *
     * @param pathName 　文件路径
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
        if (pathName.indexOf(".xlsx") >= 0) {
            xwb = new XSSFWorkbook(fs);
            sheet = xwb.getSheetAt(1);
        } else {
            hwb = new HSSFWorkbook(fs);
            sheet = hwb.getSheetAt(1);
        }
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        String first = "";
        String second = "";
        String third = "";
        for (int i = firstRowNum + 1; i <= lastRowNum; i++) {
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
                if (row.getCell(2) != null) {
                    row.getCell(2).setCellType(CellType.STRING);
                    third = row.getCell(2).getStringCellValue();
                }
            }
            System.out.println("第" + i + "行信息为：" + first + " | " + second + " | " + third);
            result.add(first + "-" + second + "-" + third);
        }
        return result;

    }

    public static void main(String[] args) {
        String pathName = "C:/Users/xuqiang_duan/Desktop/test/test.xlsx";
        try {
            List<String> datas = Demo.readExcel(pathName);
            /**
             * 计算处理
             * result = (A-B)/C
             */
            for (String data : datas) {

                String[] strs = data.split("-");
                if (Double.parseDouble(strs[2]) != 0) {
                    double result = (Double.parseDouble(strs[0]) - Double.parseDouble(strs[1])) / Double.parseDouble(strs[2]);
                    System.out.println("计算结果：" + result);
                } else {
                    System.out.println("数据表数据有误，除数等于零，无法计算请核对数据！");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
