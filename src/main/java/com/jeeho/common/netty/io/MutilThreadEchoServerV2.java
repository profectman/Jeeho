package com.jeeho.common.netty.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutilThreadEchoServerV2 {
    private int port ;

    public MutilThreadEchoServerV2(int port){
        this.port = port;
    }

    public void startServer(){
        ServerSocket echoServer = null;
        int i =0;
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("服务端在【"+this.port+"】端口等待用户请求......");
        try {
            echoServer = new ServerSocket(this.port);
            while(true){  //循环监听客户端连接
                Socket clientRequest = echoServer.accept();
                executorService.execute(new ThreadedServerHandler(clientRequest,i++));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
