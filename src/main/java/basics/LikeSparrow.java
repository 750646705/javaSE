package basics;

/**
 * This is a LikeSparrow
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/14
 * @time 16:15
 */
public abstract class LikeSparrow implements InfAnimal, InfBird {

    @Override
    public String call(String str) {
        return "LikeSparrow —— " + str;
    }

    /**
     * LikeSparrow Color
     *
     * @param str
     * @return
     */
    public abstract String color(String str);

}
