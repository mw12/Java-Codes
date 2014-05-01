import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Threading  extends Thread
{
	String data;
	int threadid;
	int rownumber, colnumber, index;
	public static int forrand = 0;
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
		
		index = (index+1) % servers.size();
		//forrand++;
		return servers.get(index).client;
			
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
				//servers.get(index).sema.acquire();
				if(servers.get(index).sema.tryAcquire())
				{
//					System.out.println("lock acquired by thread " + this.threadid);
				}
				else
				{
//					System.out.println("not acquired by "+ this.threadid);
					if(servers.get(index).sema.tryAcquire(500,TimeUnit.MILLISECONDS))
					{
//						System.out.println("lock acquired by thread " + this.threadid);
					}
					else
					{	
//						System.out.println("timeout occured for thread " + this.threadid);
						continue;
					}
				}
				
			} 
			catch (InterruptedException e) 
			{
//				System.out.println("was trying to acquire lock");
				e.printStackTrace();
			}
			
				try {
//					System.out.println("Trying to send data now "+ this.threadid);
					currentserver.senddata(data);
//					System.out.println("data sent "+ this.threadid);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String read = null;
//				System.out.println("Trying to read data now "+ this.threadid);
				read = currentserver.read();
//				System.out.println("read done "+ this.threadid);
				
			servers.get(index).sema.release();
//			System.out.println("released lock now "+ this.threadid);
			//System.out.println("read is "+ read);
			
			int status = currentserver.checkreceivedstring(read);
			if(status == 0)//down
			{
				System.out.println("node down for thread "+ this.threadid);
				servers.get(index).isUpandRunning = false;
				//servers.get(index).client.cleanup();
				//System.out.println("node down");
				
			}
			else
			{
				//System.out.println("node running " + currentserver.socket.getPort());
				int result = Integer.parseInt(read);
				resultantmatrix[rownumber][colnumber] = result;	
				System.out.println("thread running "+ this.threadid  );
				done = true;
			}
		}
		System.out.println("thread "+ this.threadid + " completed");
		
		
	}
}
