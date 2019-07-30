package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XuqiangDuan
 * @Date 2018/9/14 17:02
 * 备注 Java8新特性 Stream API
 **/
public class StreamDemo {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", "abc", "  ", "");
        System.out.println("原List 大小：" + stringList.size());
        for (int i = 0; i < stringList.size(); ++i) {
            System.out.println("原List 索引i - " + i + " | str - " + stringList.get(i));
        }
        List<String> filtered = stringList.parallelStream().filter(string -> string.isEmpty()).collect(Collectors.toList());
        System.out.println("变List 大小：" + filtered.size());
        for (int i = 0; i < filtered.size(); ++i) {
            System.out.println("变List 索引i - " + i + " | str - " + stringList.get(i));
        }


    }


}
