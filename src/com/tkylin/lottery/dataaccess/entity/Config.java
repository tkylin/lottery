package com.tkylin.lottery.dataaccess.entity;

public class Config {
    public Integer id;

    public Integer cardToChange;

    public Integer range;

    public String lotteryServer;

    public Integer defaultChange;

    public String defItem1;

    public String defItem2;

    public String defItem3;

    public Integer defItem4;

    public Integer defItem5;

    public Integer defItem6;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardToChange() {
        return cardToChange;
    }

    public void setCardToChange(Integer cardToChange) {
        this.cardToChange = cardToChange;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public String getLotteryServer() {
        return lotteryServer;
    }

    public void setLotteryServer(String lotteryServer) {
        this.lotteryServer = lotteryServer == null ? null : lotteryServer.trim();
    }

    public Integer getDefaultChange() {
        return defaultChange;
    }

    public void setDefaultChange(Integer defaultChange) {
        this.defaultChange = defaultChange;
    }

    public String getDefItem1() {
        return defItem1;
    }

    public void setDefItem1(String defItem1) {
        this.defItem1 = defItem1 == null ? null : defItem1.trim();
    }

    public String getDefItem2() {
        return defItem2;
    }

    public void setDefItem2(String defItem2) {
        this.defItem2 = defItem2 == null ? null : defItem2.trim();
    }

    public String getDefItem3() {
        return defItem3;
    }

    public void setDefItem3(String defItem3) {
        this.defItem3 = defItem3 == null ? null : defItem3.trim();
    }

    public Integer getDefItem4() {
        return defItem4;
    }

    public void setDefItem4(Integer defItem4) {
        this.defItem4 = defItem4;
    }

    public Integer getDefItem5() {
        return defItem5;
    }

    public void setDefItem5(Integer defItem5) {
        this.defItem5 = defItem5;
    }

    public Integer getDefItem6() {
        return defItem6;
    }

    public void setDefItem6(Integer defItem6) {
        this.defItem6 = defItem6;
    }
}