package basics;

/**
 * This is a Bird Interface
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/14
 * @time 15:50
 */
public interface InfBird extends InfAnimal {


    /**
     * Brid Call
     *
     * @param str
     * @return
     */
    @Override
    String call(String str);

    /**
     * Bird Feather
     *
     * @return
     */
    String feather();


}
