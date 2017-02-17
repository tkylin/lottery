package com.tkylin.lottery.util;

import com.jfinal.kit.PropKit;
import com.lamfire.code.MD5;
import com.lamfire.utils.URLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tkylin on 2016/11/8.
 */
public class LotteryUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(LotteryUtil.class);
    public static SimpleDateFormat format = new SimpleDateFormat();
    public static final String LOTTERY_SERVER = "lottery.server";
    public static final String CHECK_DATE_RANGE = "check.date.range";
    public static final String CHECK_START_DATE = "check.start.date";
    public static final String CARD_TO_CHANGE = "card.to.change";
    public static final String DEFAULT_CHANGE = "default.change";
    public static final String OPEN_TYPE = "open.type";
    public static final String OPEN_BEGIN_DATE = "open.begin.date";
    public static final String OPEN_END_DATE = "open.end.date";
    public static final String OPEN_WEEK_DAY = "open.week.day";

    static {
        format.applyPattern("yyyy-MM-dd");
    }

    public static long getUnixTime(long timeMillis) {
        return timeMillis / 1000;
    }

    public static long addDay(long endTime, int dateRange) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(endTime);
        cal.add(Calendar.DAY_OF_MONTH, -dateRange);

        return cal.getTimeInMillis();
    }

    public static int countChange(int roomCardNum) {
        return Math.abs(roomCardNum / PropKit.getInt(CARD_TO_CHANGE, 5));
    }

    public static int modChange(int roomCardNum) {
        return Math.abs(roomCardNum % PropKit.getInt(CARD_TO_CHANGE, 5));
    }

    public static String checkLotteryNumber(long userId, long startTime, long endTime) {
        String server = PropKit.get(LOTTERY_SERVER);
        StringBuilder sb = new StringBuilder(server);
        sb.append("?action=GetCardInfo");
        sb.append("&UserId=").append(userId);
        sb.append("&starttime=").append(getUnixTime(startTime));
        sb.append("&endtime=").append(getUnixTime(endTime));

        return getUrlResult(sb.toString());
    }

    public static String addRoomCard(long userId, int roomCardNum) {
        String server = PropKit.get(LotteryUtil.LOTTERY_SERVER);
        StringBuilder sb = new StringBuilder(server);
        sb.append("?action=AddRoomCard");
        sb.append("&UserId=").append(userId);
        sb.append("&roomcard=").append(roomCardNum);
        sb.append("&timestamp=").append(getUnixTime(System.currentTimeMillis()));
        String sign = sign(sb.toString());
        sb.append("&sign=").append(sign);
        return getUrlResult(sb.toString());
    }

    public static String sign(String string) {
        String str = string.substring(string.indexOf("&") + 1);
        String sign = MD5.sign(str + "ad72b164bcde214c688049759b1ef2e5");
        return sign;
    }

    public static String getUrlResult(String url) {
        String result = "";
        try {
            LOGGER.debug("get url:{}", url);
            result = URLUtils.getContentAsString(url, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String formatDate(Date date) {
        return format.format(date);
    }

    public static Date parseDate(String date) {
        try {
            return format.parse(date);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "UserId=10001&roomcard=1&timestamp=1478577600ad72b164bcde214c688049759b1ef2e5";
        System.out.println(MD5.sign(str));
    }
}
