package shiyanlou.test.equals;

/**
 * @author XuqiangDuan
 * @Date 2018/8/21 13:45
 **/
public class Value{
    /**
     * 成员变量
     */
    private int i;
    private String s;

    /**
     * 有参构造方法
     * @param i
     * @param s
     */
    public Value(int i, String s) {
        this.i = i;
        this.s = s;
    }

    /**
     * 重写equals方法
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }else{
            if(o instanceof Value){
                Value value = (Value) o;
                if(value.getI() == this.getI() && value.getS().equals(this.getS())){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
