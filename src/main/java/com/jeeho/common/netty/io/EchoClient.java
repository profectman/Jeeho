package com.jeeho.common.netty.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    public static void main(String args[]){
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            clientSocket = new Socket("127.0.0.1",8080);
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("连接到服务器...");
            System.out.println("请输入消息【输入\"Quit\"】退出...");
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = null;
            while((inputLine = stdIn.readLine()) != null){
                out.write(inputLine);               //发送消息到服务器
                System.out.println(in.readLine());  //接收服务器的响应
                while(inputLine.equals("Quit")){
                    System.out.println("客户端连接关闭...");
                    stdIn.close();
                    in.close();
                    out.close();
                    clientSocket.close();
                }
                System.out.println("请输入消息[输入\"Quit\"]退出：");
            }
        }catch (Exception e){
            System.err.println("Don't know about host: PallaviÕs MacBook Pro.");
            System.exit(1);
        }
    }
}
