package com.tkylin.lottery.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: tangdq (tkylin@vip.qq.com) Date: 2015/11/16 11:41
 */
public class BaseController extends Controller {
    protected static final Gson GSON = new Gson();
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
}
