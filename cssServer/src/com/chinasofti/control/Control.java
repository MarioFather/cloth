package com.chinasofti.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.chinasofti.CssService.CssService;
import com.chinasofti.CssService.impl.CssServiceImpl;

public class Control {
	private ServerSocket server;
	public static final int port=6666;
	private ExecutorService es;
	private CssService service;
	public Control(){
		try {
			System.out.print("服务器正在开启中");
			this.server=new ServerSocket(port);
			for (int i = 0; i < 5; i++) {
				System.out.print(".");
				Thread.sleep(500);
			}
			System.out.println();
			System.out.println("服务器已经开启!");
			es=Executors.newCachedThreadPool();
			this.service=new CssServiceImpl();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void start(){
		while(true){
			try {
				Socket client= this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"已连接");
				ControlThread ct=new ControlThread(client,service);
				es.submit(ct);
				int activeCount=((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前在线活跃用户:"+activeCount);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
