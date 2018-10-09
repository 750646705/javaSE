package singleton;

/**
 * @author XuqiangDuan
 * @Date 2018/7/26 12:39
 **/
public class TestMain extends Thread{


    public static void main(String[] args) {
        long beg = System.currentTimeMillis();

        /**
         * Singleton 测试
         */
//        Singleton first = Singleton.getInstance();
//        Singleton second  = Singleton.getInstance();
////        Singleton singleton = new Singleton();
//        if(first == second){
//            System.out.println("相同");
//        }else{
//            System.err.println("不同");
//        }

        /**
         * TicketMaker 测试
         */
//        for(int i = 0 ; i < 10 ; ++i){

//            int ticket = TicketMaker.getInstance().getNextTicketNumber();
//            System.out.println("ticket: "+ticket);

//            int ticket1 = TicketMaker.getInstance(1).getNextTicketNumber();
//            System.out.println("ticket1: "+ticket1);
//
//            int ticket2 = TicketMaker.getInstance(2).getNextTicketNumber();
//            System.out.println("ticket2: "+ticket2);
//
//            int ticket3 = TicketMaker.getInstance(3).getNextTicketNumber();
//            System.out.println("ticket3: "+ticket3);
//
//        }
//        多线程测试
//        new TestMain("AAA").start();
//        new TestMain("BBB").start();
//        new TestMain("CCC").start();
//
//
//        long end = System.currentTimeMillis();
//        System.out.println("耗时（单位/毫秒）："+(end-beg));

        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        System.out.println("枚举式实现单例模式："+singletonEnum.equals(singletonEnum1));

    }

    @Override
    public void run(){
        Singleton obj = Singleton.getInstance();
        System.out.println(getName()+": obj = "+obj);
    }

    public TestMain(String name){
        super(name);
    }


}
