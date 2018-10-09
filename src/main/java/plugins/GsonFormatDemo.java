package plugins;

import lombok.*;

import java.util.List;

/**
 * @author XuqiangDuan
 * @Date 2018/10/8 16:13
 * 备注：GsonFormat 根据JSON文本生成JAVA类;
 **/
@Data
public class GsonFormatDemo {

    /**
     * status : 1
     * errorMessage : success
     * errorCode : 0
     * cinemaList : [{"cinemaCode":"18888888","cinemaName":"888测试影院","cityNo":null,"hallCount":"12","status":null,"linkId":"888","provider":0}]
     */

    private int status;
    private String errorMessage;
    private String errorCode;
    private List<CinemaListBean> cinemaList;

    @Data
    public static class CinemaListBean {
        /**
         * cinemaCode : 18888888
         * cinemaName : 888测试影院
         * cityNo : null
         * hallCount : 12
         * status : null
         * linkId : 888
         * provider : 0
         */

        private String cinemaCode;
        private String cinemaName;
        private Object cityNo;
        private String hallCount;
        private Object status;
        private String linkId;
        private int provider;
    }
}
