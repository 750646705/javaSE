package serializable;

import java.io.*;

/**
 * @author XuqiangDuan
 * @Date 2018/9/14 10:27
 **/
public class Main {


    public static void main(String[] args) {
        /**
         * 序列化对象
         */
        SerializableDemo serializableDemo = new SerializableDemo();
        serializableDemo.setId(123456);
        serializableDemo.setName("DuanXuqiang");
        serializableDemo.setAddress("北京·亦庄");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:/test/serializable.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(serializableDemo);
            outputStream.close();
            fileOutputStream.close();
            System.out.printf("Serialized data is saved in E:/test/serializable.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 反序列化对象
         */
        SerializableDemo serializableDemo1 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("E:/test/serializable.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            serializableDemo1 = (SerializableDemo) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            System.out.printf("serializableDemo.id:" + serializableDemo1.getId() + " | serializableDemo.name:" + serializableDemo1.getName() + " | serializableDemo.address:" + serializableDemo1.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
