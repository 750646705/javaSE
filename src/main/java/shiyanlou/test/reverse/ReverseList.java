package shiyanlou.test.reverse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

class ReverseList<T> extends ArrayList<T>{

    private static final long serialVersionUID = 1L;

    public ReverseList(Collection<T> c){ super(c);}

    /**
     * 实现反向迭代
     * @return
     */
    public Iterable<T> reversed(){

        return new Iterable<T>() {

            @Override
            public Iterator<T> iterator() {

                return new Iterator<T>() {
                    @Override
                    public void remove() {
                    }

                    @Override
                    public void forEachRemaining(Consumer<? super T> action) {
                    }

                    @Override
                    public boolean hasNext() {
                        return false;

                    }

                    @Override
                    public T next() {
                        return null;

                    }
                };

            }

        };
    }
}