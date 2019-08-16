package reflex;

/**
 * ReflexTest
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/16
 * @time 11:23
 */
public class ReflexTest {

    public static void main(String[] args) {

        try {

            Class<?> rclass = Class.forName("reflex.ReflexDemo");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
