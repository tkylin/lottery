package com.tkylin.lottery.constant;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2016/11/9 16:07
 */
public class LotteryConstant {
    public static interface Status {
        public static final int ENABLE = 1;
        public static final int DISABLED = 2;
    }

    public static interface PrizeType {
        public static final int HOUSE_CARD = 1;
        public static final int GOODS = 2;
        public static final int CASH = 3;
        public static final int NO_PRIZE = 4;
    }
}
