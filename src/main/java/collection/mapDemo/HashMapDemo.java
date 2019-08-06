package collection.mapDemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XuqiangDuan
 * @Date 2018/9/14 16:45
 **/
public class HashMapDemo {

    /**
     * @deprecated 该标记为已弃用
     * HashMap 常用方法
     */
    public static void mapMethod() {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);
        hashMap.put("d", 4);
        hashMap.put("e", 5);

        //size
        System.out.println("size: " + hashMap.size());
        //values
        System.out.println("values: " + hashMap.values());
        //keys
        System.out.println("keys: " + hashMap.keySet());

        //entry
        System.out.println("entrySet : " + hashMap.entrySet());
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key：" + entry.getKey() + " - value：" + entry.getValue());
        }

        /*
         * putAll
         * 合并时，key相同value更新
         */
        HashMap<String, Integer> hashMapN = new HashMap<>();
        hashMapN.put("e", 55);
        hashMapN.put("f", 66);
        hashMapN.put("g", 77);
        hashMapN.put("h", 88);
        hashMapN.put("i", 99);
        hashMapN.putAll(hashMap);
        System.out.println("N合并后 size: " + hashMapN.size());
        System.out.println("N合并后 values: " + hashMapN.values());

        //JDK8-lambda表达式
        hashMapN.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });

        //remove
        hashMap.remove("a");
        System.out.println("remove后的size : " + hashMap.size());
        //clear
        hashMap.clear();
        System.out.println("clear后的size : " + hashMap.size());

    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {

        //HashMap方法
        HashMapDemo.mapMethod();

    }

}
