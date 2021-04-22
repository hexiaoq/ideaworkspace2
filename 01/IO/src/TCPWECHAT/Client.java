package TCPWECHAT;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		System.out.println("客户端");
		System.out.println("请输入您的名字");
		BufferedReader bs=new BufferedReader(new InputStreamReader(System.in));
		String name;
		name=bs.readLine();
		Socket client=new Socket("localhost",8888);
		clientsend send=new clientsend(client,name);
		clientrecivier r=new clientrecivier(name,client);
		new Thread(send).start();
		new Thread(r).start();
	}
	static void close(DataInputStream is, Socket client) {
		tools.close(is,client);}
}
