package com.tkylin.lottery.controller;

import com.jfinal.core.Controller;
import com.tkylin.lottery.dto.PrizeDto;
import com.tkylin.lottery.dto.ResponseDto;
import com.tkylin.lottery.service.LotteryService;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2017/2/9 16:07
 */
public class AdminController extends Controller {
    public void check() {
        Long uniqueCode = getParaToLong("uniqueCode", 0L);
        ResponseDto resp = new ResponseDto();

        if (uniqueCode > 0) {
            PrizeDto prizeDto = LotteryService.checkExpiry(uniqueCode);
            resp.setStatus(200);
            resp.setPrize(prizeDto);
        } else {
            resp.setStatus(-100);
            resp.setDesc("参数错误!");
        }
        renderJson(resp);
    }

    public void expiry() {
        Long uniqueCode = getParaToLong("uniqueCode", 0L);
        LotteryService.expiry(uniqueCode);
        ResponseDto resp = new ResponseDto();
        resp.setStatus(200);
        renderJson(resp);
    }
}
