import java.util.ArrayList;

public class Threading  extends Thread
{
	//public static Semaphore a;
	int threadid;
	int rownumber, colnumber, index;
	public static ArrayList<ListServers> servers = null;
	String data;
	public static int resultantmatrix[][];
	
	public Threading(int rowno, int colno, String string, int index, int resultantmatrix[][],int threadid) 
	{
		data = string;
		rownumber = rowno;
		colnumber = colno;
		this.index = index;
		Threading.resultantmatrix = resultantmatrix;
		this.threadid = threadid;
		//System.out.println("data is  " + data);
	}
	private Client getNextBestServer()
	{
		Client curclient = servers.get(index).client;
		while(servers.get(index).isUpandRunning==false)
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
			System.out.println("in thread " + this.threadid + " permits are "+ servers.get(index).sema.availablePermits());
			try 
			{
				servers.get(index).sema.acquire();
			} 
			catch (InterruptedException e) 
			{
				System.out.println("was trying to acquire lock");
				e.printStackTrace();
			}
//			while(!servers.get(index).free)
//			{
//				try 
//				{
//					this.sleep(10);
//				} 
//				catch (InterruptedException e) 
//				{
//					e.printStackTrace();
//				}
//			}
//			servers.get(index).free = false;
			
			currentserver.senddata(data);
			String read = null;
			read = currentserver.read();
			servers.get(index).sema.release();
			//System.out.println("read is "+ read);
			
			int status = currentserver.checkreceivedstring(read);
			if(status == 0)//down
			{
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
