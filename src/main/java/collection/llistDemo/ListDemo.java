package collection.llistDemo;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author XuqiangDuan
 * @Date 2018/9/14 11:50
 * 备注：List特点：有序、可重复、不唯一
 **/
public class ListDemo {

    public static void main(String[] args){
        ArrayList<String> stringArrayList = new ArrayList<String>(2);
        stringArrayList.add("AAA");
        stringArrayList.add("FFF");
        stringArrayList.add("AAA");
        stringArrayList.add("BBB");
        stringArrayList.add("BBB");
        stringArrayList.add("AAA");
        stringArrayList.add("CCC");
        stringArrayList.add("AAA");
        stringArrayList.add("DDD");
        stringArrayList.add("AAA");
        stringArrayList.add("EEE");
        stringArrayList.add("AAA");

        System.out.println("原List长度："+stringArrayList.size());
        for(int i=0 ; i< stringArrayList.size() ; ++i){
            System.out.println("索引 - "+ i +" | Str - " +stringArrayList.get(i));
        }
        /**
         * 删除 remove
         * 排序 sort
         * 去重 1.equals比较 2.通过HashSet 3.通过HashSet/Iterator 4.使用List.contains方法 5.JAVA8使用Stream去重
         *
         */
//        stringArrayList.remove(3);
//        stringArrayList.remove("AAA");
//        stringArrayList.sort(String::compareTo);

//        useEqualsRemove(stringArrayList);
//        useHashSetRemove(stringArrayList);
//        useHashSetAndIteratorRemove(stringArrayList);
//        useNewListAndContainsRemove(stringArrayList);
        useJAVA8Remove(stringArrayList);


        System.out.println("变List长度："+stringArrayList.size());
        for(int i=0 ; i< stringArrayList.size() ; ++i){
            System.out.println("索引 - "+ i +" | Str - " +stringArrayList.get(i));
        }

    }

    /**
     * 去重方法一：双重遍历equals比较
     * @param list
     */
    public static void useEqualsRemove(List list){
        for (int i=0 ; i< list.size() ; ++i){
            for(int j= i+1 ; j< list.size() ; ++j) {
                System.out.println("索引i - "+ i +" | 索引J - " + j);
                if(list.get(i).equals(list.get(j))){
                    System.out.println("索引 - "+ j +" | 重复str - " +list.get(j));
                    list.remove(j);
                }
            }
        }
    }

    /**
     * 去重方法二：通过HashSet 注：顺序可能发生变化
     * @param list
     */
    public static void useHashSetRemove(List list){
        HashSet<String> hashSet = new HashSet<>(list);
        list.clear();
        list.addAll(hashSet);
    }

    /**
     * 去重方法三：通过HashSet/Iterator
     * @param list
     */
    public static void useHashSetAndIteratorRemove(List list){
        List newList = new ArrayList();
        Set set = new HashSet();
        for (Iterator iter = list.iterator() ; iter.hasNext() ;) {
            Object element = iter.next();
            if (set.add(element)){
                newList.add(element);
            }
        }
        list.clear();
        list.addAll(newList);
    }

    /**
     * 去重方法四：使用List.contains方法
     * @param list
     */
    public static void useNewListAndContainsRemove(List list){
        List listTemp = new ArrayList();
        for(int i=0 ; i<list.size() ; i++){
            if(!listTemp.contains(list.get(i))){
                listTemp.add(list.get(i));
            }
        }
        list.clear();
        list.addAll(listTemp);
    }

    /**
     * JAVA8 使用Stream去重
     * 备注：Stream API
     * @param list
     */
    public static void useJAVA8Remove(List list){
        List listTemp = (List) list.stream().distinct().collect(Collectors.toList());
        list.clear();
        list.addAll(listTemp);
    }












}
