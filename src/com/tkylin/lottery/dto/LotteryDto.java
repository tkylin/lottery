package com.tkylin.lottery.dto;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2016/11/9 10:39
 */
public class LotteryDto {
    private int ret;
    private String desc;
    private Data data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        private int roomcard;
        private String result;

        public int getRoomcard() {
            return roomcard;
        }

        public void setRoomcard(int roomcard) {
            this.roomcard = roomcard;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
