package annotation;

import lombok.Data;

/**
 * Student实体类
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/9
 * @time 16:14
 */

@Data
public class Student {

    @MyTestAnnotation(num = 1, des = "编号")
    private Long id;

    @MyTestAnnotation(num = 2, des = "姓名")
    private String name;

}
