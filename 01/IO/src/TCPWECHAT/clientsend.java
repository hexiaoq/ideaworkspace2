package TCPWECHAT;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class clientsend implements Runnable {
	private BufferedReader bs;
	private Socket client;
	private DataOutputStream os;
	private String name;
	private static boolean isrunning=true;
	private String msg=null;
	public clientsend(Socket client,String name) {
		this.name=name;
		this.client=client;
		try {
			os=new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		send(name);
		bs=new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public void send(String msg) {
		if(msg==null)
		{try {
			msg=bs.readLine();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			os.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}} else
			try {
				os.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
		
	
static void close(DataOutputStream os, Socket client) {
	tools.close(os,client);
	isrunning=false;

}
@Override
public void run() {
	while(isrunning) {
	send(msg);}
	
}}
