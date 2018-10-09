package plugins;

import lombok.Data;

/**
 * @author XuqiangDuan
 * @Date 2018/10/8 10:28
 * 备注:lombok lombok注解   <= 互换 =>   getter/setter (JAVA 代码);
 **/
@Data
public class LombokDemo {
    private int numbers;
    private String names;

    public LombokDemo() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof LombokDemo;
    }

}
