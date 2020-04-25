package com.jeeho.common.netty.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MutilThreadEchoServerV1 {

    private int port ;

    public MutilThreadEchoServerV1(int port){
        this.port = port;
    }

    public void startServer(){
        ServerSocket echoServer = null;
        int i =0;
        System.out.println("服务端在【"+this.port+"】端口等待用户请求......");
        try {
            echoServer = new ServerSocket(this.port);
            while(true){  //循环监听客户端连接
                Socket clientRequest = echoServer.accept();
                new Thread(new ThreadedServerHandler(clientRequest,i++)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
