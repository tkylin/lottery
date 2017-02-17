package com.tkylin.lottery.dataaccess.entity;

import java.util.Date;

public class User {
    public Long userId;

    public Integer roomCardNum;

    public Integer lotteryCount;

    public Integer count;

    public Date lastUpdateTime;

    public Date createTime;

    public Integer usableRoomCardNum;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRoomCardNum() {
        return roomCardNum;
    }

    public void setRoomCardNum(Integer roomCardNum) {
        this.roomCardNum = roomCardNum;
    }

    public Integer getLotteryCount() {
        return lotteryCount;
    }

    public void setLotteryCount(Integer lotteryCount) {
        this.lotteryCount = lotteryCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUsableRoomCardNum() {
        return usableRoomCardNum;
    }

    public void setUsableRoomCardNum(Integer usableRoomCardNum) {
        this.usableRoomCardNum = usableRoomCardNum;
    }
}