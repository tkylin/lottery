package com.tkylin.lottery.dto;

import java.util.Date;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2017/2/9 16:12
 */
public class PrizeDto {
    private Long uniqueCode;
    private String name;
    private String icon;
    private Integer indexNo;
    private Integer type;
    private Integer rewardNum;
    private Date createTime;//抽奖时间
    private Integer status;//是否兑奖
    private Long uid;

    public Long getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(Long uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRewardNum() {
        return rewardNum;
    }

    public void setRewardNum(Integer rewardNum) {
        this.rewardNum = rewardNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
