package com.jeeho.common.netty.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadEchoServer {

    private int port ;

    public SingleThreadEchoServer(int port){
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
                handleRequest(clientRequest,i++);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleRequest(Socket clientRequest, int i) {
        PrintStream ps = null;
        BufferedReader br = null;

        try {
            ps = new PrintStream(clientRequest.getOutputStream());  //服务端回复数据字节流
            br = new BufferedReader(new InputStreamReader(clientRequest.getInputStream()));  //从socket中获取流数据
            String inputLine = null;
            while((inputLine = br.readLine()) != null){
                if(inputLine.equals("Quit")){
                    System.out.println("关闭服务器与【"+i+"】的连接...");
                    ps.close();
                    br.close();
                    clientRequest.close();
                }else{
                    System.out.println("客户端【"+i+"】的输入：" + inputLine);
                    ps.println("来自服务端的响应：" + inputLine);
                }
            }
        } catch (IOException e) {
            System.out.println("System closed...");
        }
    }

}
