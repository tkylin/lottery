package com.tkylin.lottery.dto;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2016/11/9 11:51
 */
public class ResponseDto {
    private int status;
    private int code;
    private String desc;
    private int lotteryCount;
    private PrizeDto prize;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLotteryCount() {
        return lotteryCount;
    }

    public void setLotteryCount(int lotteryCount) {
        this.lotteryCount = lotteryCount;
    }

    public PrizeDto getPrize() {
        return prize;
    }

    public void setPrize(PrizeDto prize) {
        this.prize = prize;
    }
}
