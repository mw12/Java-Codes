
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class server 
{
    ServerSocket serverSocket =  null;
    Socket socket = null;
    public int compute(String recieved)
    {
        StringTokenizer st = new StringTokenizer(recieved,"," );
        //System.out.println("received is "+ recieved);
        String row = st.nextToken();
        String col = st.nextToken();
        int sum = 0;
       
        StringTokenizer st1 = new StringTokenizer(row);
        StringTokenizer st2 = new StringTokenizer(col);
       
        while(st1.hasMoreTokens() && st2.hasMoreTokens())
        {
            sum+=Integer.parseInt(st1.nextToken()) * Integer.parseInt(st2.nextToken()) ;
        }
        return sum;
    }
    public server(int port) throws IOException
    {
        this.serverSocket = new ServerSocket(port);
        
    }
    public void cleanup() throws IOException
    {
        this.serverSocket.close();
        this.socket.close();
    }
    public static void main(String[] args) throws IOException
    {
        server server1 = new server(6767);
        try
        {
        	while(true)
        	{
        		server1.socket = server1.serverSocket.accept();
        		BufferedReader input = null;  
                try
                {
                   input = new BufferedReader(new InputStreamReader(server1.socket.getInputStream()));
                }
                catch (IOException e)
                {
                   System.out.println("problem in input stream in server");
                   e.printStackTrace();
                }
                //System.out.println("trying to receive data from client");
                String recieved = null;//input.readLine();
                //
                while((recieved = input.readLine())!=null)
                {
                	System.out.println("received is " + recieved);
                	if(recieved.equals("done"))
                	{
                		System.out.println("terminatig server as ");
                		return ;
                	}
                		
                    System.out.println("here after receivin from client");
                    StringBuffer send = new StringBuffer();
                    send.append(server1.compute(recieved));
                                      
                   System.out.println(send);
                    try
                    {
                        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(server1.socket.getOutputStream()));
                        out.write(send+"\n");
                        out.flush();
                    }
                    catch(Exception e)
                    {
                    	System.out.println("exception in sending data from server");
                        e.printStackTrace();
                    }
                }
        	}
            
        }
        finally
        {
            server1.cleanup();
        }
    }
}