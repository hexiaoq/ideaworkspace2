package TCPWECHAT;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class clientrecivier implements Runnable {
	private String name;
private Socket client;
private DataInputStream is;
private static boolean isrunning=true;
public clientrecivier(String name,Socket client) {
	this.name=name;
	this.client=client;
	try {
		is=new DataInputStream(client.getInputStream());
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}
public void recivier() {
	String msg=null;
	
	try {
		msg=is.readUTF();
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println(msg);
	
}

public void run() {while(isrunning) {recivier();}
	
	
}}


