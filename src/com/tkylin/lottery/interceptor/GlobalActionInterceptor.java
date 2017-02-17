package com.tkylin.lottery.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.tkylin.lottery.util.LotteryUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by tkyli on 2016/11/27.
 */
public class GlobalActionInterceptor implements Interceptor {
    private static final String NO_LOTTERY = "/index.html";
    private static final String LOTTERY = "/index.jsp";

    @Override
    public void intercept(Invocation inv) {

        int type = PropKit.getInt(LotteryUtil.OPEN_TYPE, 0);
        int week = PropKit.getInt(LotteryUtil.OPEN_WEEK_DAY, 0);

        String begin = PropKit.get(LotteryUtil.OPEN_BEGIN_DATE, "");
        String end = PropKit.get(LotteryUtil.OPEN_END_DATE, "");

        Controller ctr = inv.getController();

        String uri = ctr.getRequest().getRequestURI();
        if (!uri.contains("/admin/")) {
            //验证是否可以进行抽奖
            if (type == 1) {
                Calendar cal = Calendar.getInstance();
                if (week == 0 || cal.get(Calendar.DAY_OF_WEEK) != week) {
                    ctr.render(NO_LOTTERY);
                    return;
                }
            } else if (type == 2) {
                Date now = LotteryUtil.parseDate(LotteryUtil.formatDate(new Date()));//格式化日期
                Date beginDate = LotteryUtil.parseDate(begin);
                Date endDate = LotteryUtil.parseDate(end);
                if (now.before(beginDate) || now.after(endDate)) {
                    ctr.render(NO_LOTTERY);
                    return;
                }
            }
        }

        inv.invoke();
    }
}
