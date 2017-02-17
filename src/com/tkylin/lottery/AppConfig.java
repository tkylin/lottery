package com.tkylin.lottery;


import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.render.ViewType;
import com.tkylin.lottery.controller.AdminController;
import com.tkylin.lottery.controller.LotteryController;
import com.tkylin.lottery.interceptor.GlobalActionInterceptor;

public class AppConfig extends JFinalConfig {

    /**
     * 配置常量
     */
    public void configConstant(Constants me) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("jfinal.properties");
        me.setDevMode(PropKit.getBoolean("devmode", false));
        me.setViewType(ViewType.JSP);
    }

    /**
     * 配置路由
     */
    public void configRoute(Routes me) {
        me.add("/", LotteryController.class);
        me.add("/admin", AdminController.class);
    }

    /**
     * 配置插件
     */
    public void configPlugin(Plugins me) {
    }

    /**
     * 配置全局拦截器
     */
    public void configInterceptor(Interceptors me) {
        // 全局拦截器,主要实现权限
        me.addGlobalActionInterceptor(new GlobalActionInterceptor());

        // 全局导出excel拦截器
        //me.addGlobalActionInterceptor(new ExportExcelInterceptor());
    }

    /**
     * 配置处理器
     */
    public void configHandler(Handlers me) {
        // es服务器
        //me.add(new EsHandler());
    }

    /**
     * 建议使用 JFinal 手册推荐的方式启动项目 运行此 main
     * 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
     */
    public static void main(String[] args) {
        JFinal.start("web", 89, "/", 5);
    }
}