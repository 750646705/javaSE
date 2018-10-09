package serializable;

import java.io.Serializable;

/**
 * @author XuqiangDuan
 * @Date 2018/9/14 9:27
 * 备注：
 * 类的实例序列化成功条件：1.该类实现Serializable接口；2.该类的所有属性必须是可序列化的（如果不可序列化必须加transient短暂的）
 * 检验类的实例是否可序列化，只需看该类是否实现Serializable接口
 * JAVA关键字transient 实现Serilizable接口序列化时，类属性添加该关键字不会实现序列化
 **/
public class SerializableDemo implements Serializable {
    private int id;
    private String name;
    private transient String address;

    public void mailCheck(){
        System.out.println("Mailing a check to "+ name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
