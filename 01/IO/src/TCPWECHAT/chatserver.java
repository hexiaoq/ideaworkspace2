package TCPWECHAT;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class chatserver {
	static public CopyOnWriteArrayList<channel> all=new CopyOnWriteArrayList<channel>();
	public static void main(String[] args) throws Exception {
		System.out.println("群聊服务器");
		ServerSocket chat = new ServerSocket(8888);
		ExecutorService pool = new ThreadPoolExecutor(
				5, 6, 3,
				TimeUnit.SECONDS, new LinkedBlockingDeque<>(4), Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.DiscardOldestPolicy()
		);
		while (true) {
			Socket client = chat.accept();

	channel c=new channel(client);
       pool.execute(c);



		new Thread(c).start();
		all.add(c);
			System.out.println("一个客户端已连接");

		}
	}
static class channel implements Runnable{
private DataInputStream is;
private	DataOutputStream os;
private Socket client;
private static boolean isrunning=true;
private String name;

public channel (Socket client)
{this.client=client;


try {
	is=new DataInputStream(client.getInputStream());
	this.name=reciever();
} catch (IOException e) {
	e.printStackTrace();
}
try {
	os=new DataOutputStream(client.getOutputStream());
} catch (IOException e) {
	e.printStackTrace();
}

	
}
//������Ϣ
public String reciever()
{String msg=null;
try {
	msg=is.readUTF();
	System.out.println(msg);
} catch (IOException e) {
	e.printStackTrace();
}
return msg;


	
}
//������Ϣ
public void sent(String msg)
{
	try {
		os.writeUTF(msg);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public void sentothers(String msg)
{boolean isprivate=msg.startsWith("@");
	if(isprivate) {
		String name,info;
		int index=msg.indexOf(":");
		name=msg.substring(1, index);
		info=msg.substring(index+1);
		for(channel c:all)
		{
			if(c.name.equals(name))
				{try {
					c.os.writeUTF(this.name+":"+info);
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
			else break;
		}
}
	
else {
	try {for(channel c:all)
	{if(c==this)
		System.out.print("");
	else
		c.os.writeUTF(this.name+":"+msg);}
	} catch (IOException e) {
		e.printStackTrace();
	}
}}

public void run() {
	sent("欢迎您来到330329聊天室");
	sentothers(name+"来到了聊天室");
	while(isrunning) {
		
	String msg=reciever();
	sentothers(msg);}
	close(is,os,client);
	
}
static void close(DataInputStream is,DataOutputStream os,Socket client)
{
	tools.close(is,os,client);
	isrunning=false;
}

	
}

}
