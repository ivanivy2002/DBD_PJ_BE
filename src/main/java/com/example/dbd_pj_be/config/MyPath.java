package com.example.dbd_pj_be.config;

import lombok.extern.log4j.Log4j2;

import java.io.File;

/* 整合项目所使用的文件路径, 采用单例模式，请使用绝对路径初始化 */
@Log4j2
public class MyPath {
    private static final MyPath PATH = new MyPath();
    private String commodityAvatarPath;

    private MyPath() {
        // Violette - 本地开发路径
//        configurePathWithBaseDir("D:\\Desktop\\SE\\GansuiMall-BE\\src\\main\\resources\\images");
        // H2O2 - 本地开发路径
//          configurePathWithBaseDir("root\\gansuimall\\images");
          //Ivan
          configurePathWithBaseDir("E:\\Current\\00_Project\\SE\\DBD_PJ_BE\\src\\main\\resources\\images");

        // 其他小组成员 - 本地开发路径

        printAll();
    }

    // 路径配置（注意：文结尾不带分隔符）
    private void configurePathWithBaseDir(String baseDir) {
        this.commodityAvatarPath = baseDir + File.separator + "commodity";
    }

    private void printAll() {
        log.info("Path.printAll: ");
        log.info("commodityAvatarPath " + commodityAvatarPath);
    }

    // 检测文件夹是否存在
    public Boolean checkDir(String dirPath) {
        File file = new File(dirPath);
        return file.exists();
    }

    public static MyPath getInstance() {
        return PATH;
    }

    public String getCommodityAvatarPath() {
        return commodityAvatarPath;
    }
}
