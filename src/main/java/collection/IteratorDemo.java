package collection;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author XuqiangDuan
 * @Date 2018/10/10 9:44
 **/
public class IteratorDemo implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
    
    public static void main(String[] args){
        IteratorDemo iteratorDemo = new IteratorDemo();
        System.out.println("结果: "+iteratorDemo.hasNext());
    }
}
