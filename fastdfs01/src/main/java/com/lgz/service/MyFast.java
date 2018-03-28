package com.lgz.service;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;
import java.net.URL;

/**
 * Thanks for Everything.
 */
public class MyFast {

    public void upload(){
    //E:\idea\javafour\fastdfs01\src\main\resources\client.conf
    //		String path = this.getClass().getResource("/").getPath();
        try {
            //加载配置文件
            ClientGlobal.init("E:\\idea\\javafour\\fastdfs01\\src\\main\\resources\\client.conf");
            //创建监听的客户端对象
            TrackerClient trackerClient = new TrackerClient();
            //得到监听的服务端对象
            TrackerServer trackerServer = trackerClient.getConnection();

            //定义一个存储的服务器对象
            StorageServer storageServer = null;

            //获得存储的客户端对象
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            //使用存户的客户端对象上传具体的图片
            String[] pngs = storageClient.upload_file("D:\\截图工具\\FSLogo.png", "png", null);
            for (String png : pngs) {
                System.out.println(png);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyFast myFast = new MyFast();
        myFast.upload();
    }
}
