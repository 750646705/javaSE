package iterator;

/**
 * @author XuqiangDuan
 * @Date 2018/8/1 9:18
 **/
public interface Iterator {

    /**
     * 判断是否存在下一个元素
     *
     * @return
     */
    public abstract boolean hasNext();

    /**
     * 获取下一个元素
     *
     * @return
     */
    public abstract Object next();


}
