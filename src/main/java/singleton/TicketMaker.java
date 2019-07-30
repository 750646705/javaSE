package singleton;

/**
 * @author XuqiangDuan
 * @Date 2018/7/30 13:10
 **/
public class TicketMaker {

    private static int ticket = 1000;

    private static TicketMaker ticketMaker = new TicketMaker();
    private static TicketMaker ticketMakerOther = new TicketMaker();
    private static TicketMaker ticketMakerLast = new TicketMaker();

    private TicketMaker() {
        System.out.println("创建TicketMaker的一个实例");
    }

    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }

    public static TicketMaker getInstance(int id) {
        switch (id) {
            case 1:
                return ticketMaker;
            case 2:
                return ticketMakerOther;
            default:
                return ticketMakerLast;
        }

    }


}
