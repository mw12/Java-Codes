import java.util.concurrent.Semaphore;
public class ListServers 
{
	Client client;
	boolean isUpandRunning;
	Semaphore sema;
	
	public ListServers(Client c, boolean status)
	{
		client = c;
		isUpandRunning = status;
		this.sema = new Semaphore(1,true);
	}
}
