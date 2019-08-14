package basics;

/**
 * This is a Sparrow
 *
 * @author XUQIANG_DUAN
 * @date 2019/8/14
 * @time 15:54
 */
public class Sparrow extends LikeSparrow {

    @Override
    public String call(String str) {
        return "Sparrow Call —— " + str;
    }

    @Override
    public String color(String str) {
        return "Sparrow Color —— " + str;
    }

    @Override
    public String feather() {
        return null;
    }

    public static void main(String[] args) {

        InfAnimal infAnimal = new Sparrow();
        System.out.println(infAnimal.call("Hello World!"));
        LikeSparrow likeSparrow = new Sparrow();
        System.out.println(likeSparrow.color("RED"));

    }

}
