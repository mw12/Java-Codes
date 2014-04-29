import java.util.ArrayList;

public class Threading  extends Thread
{
	String data;
	int threadid;
	int rownumber, colnumber, index;
	
	public static ArrayList<ListServers> servers = null;
	public static int resultantmatrix[][];
	
	public Threading(int rowno, int colno, String string, int index,int threadid) 
	{
		data = string;
		rownumber = rowno;
		colnumber = colno;
		this.index = index;
		this.threadid = threadid;
	}
	private Client getNextBestServer()
	{
		Client curclient = servers.get(index).client;
		while(servers.get(index).isUpandRunning == false)//search for next sever that is upandRunning
		{
			index = (index+1) % servers.size();
			curclient = servers.get(index).client;
		}
		return curclient;
	}
	public void run() 
	{
		boolean done = false;
		while(!done)
		{
			Client currentserver = getNextBestServer();
			//System.out.println("in thread " + this.threadid + " permits are "+ servers.get(index).sema.availablePermits());
			try
			{
				if(servers.get(index).sema.tryAcquire())
				{
					System.out.println("lock acquired by thread " + this.threadid);
				}
				else
				{
					System.out.println("not acquired by "+ this.threadid);
					servers.get(index).sema.acquire();
				}
				
			} 
			catch (InterruptedException e) 
			{
				System.out.println("was trying to acquire lock");
				e.printStackTrace();
			}
			
				currentserver.senddata(data);
				String read = null;
				read = currentserver.read();
			servers.get(index).sema.release();
			//System.out.println("read is "+ read);
			
			int status = currentserver.checkreceivedstring(read);
			if(status == 0)//down
			{
				System.out.println("node down for thread "+ this.threadid);
				servers.get(index).isUpandRunning = false;
				//System.out.println("node down");
				
			}
			else
			{
				//System.out.println("node running " + currentserver.socket.getPort());
				int result = Integer.parseInt(read);
				resultantmatrix[rownumber][colnumber] = result;	
				done = true;
			}
		}
		System.out.println("thread "+ this.threadid + " completed");
		
		
	}
}
