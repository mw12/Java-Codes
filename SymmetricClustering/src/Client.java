import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class Client 
{
	BufferedReader instream = null;
	DataOutputStream outstream = null;
	Socket socket = null;
	public static boolean upservers(ArrayList<ListServers> servers)
	{
		int count = 0;
		for (ListServers listServers : servers) 
		{
			if(listServers.isUpandRunning)
			{
				count++;
			}
		}
		if(count >0)
			return true;
		else
			return false;
	}
	public static void terminateservers(ArrayList<ListServers> servers) throws IOException
	{
		for (ListServers server : servers) 
		{
			server.client.senddata("done");
		}
	}
	public int checkreceivedstring(String read)
	{
		if(read.trim().equals("null"))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	public void computeandput(int resultantmatrix[][],int rowno,int colno,String recieved)
    {
		
        StringTokenizer st = new StringTokenizer(recieved,"," );
        String row = st.nextToken();
        String col = st.nextToken();
        int sum = 0;
       
        StringTokenizer st1 = new StringTokenizer(row," " );
        StringTokenizer st2 = new StringTokenizer(col," " );
       
        while(st1.hasMoreTokens() && st2.hasMoreTokens())
        {
            sum+=Integer.parseInt(st1.nextToken()) * Integer.parseInt(st2.nextToken()) ;
        }
        resultantmatrix[rowno][colno] = sum;
        
    }
	public boolean initializeClient(String host,int port,ArrayList<ListServers> servers)
	{
		try 
		{
			if(InetAddress.getByName(host).isReachable(10))
			{
				socket= new Socket(host,port);
				instream =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
				outstream =  new DataOutputStream(socket.getOutputStream());
				if(!servers.contains(this))
					servers.add(new ListServers(this, true));
				return true;
			}
			else
			{
				System.out.println("host unreachabel");
				throw new Exception();
			}
		}
		catch(ConnectException e)
		{
			System.out.println("connection is being refused");
			return false;
		}
		catch (Exception e) 
		{
			System.out.println("cannot create socket");
			e.printStackTrace();
			if(!servers.contains(this))
				servers.add(new ListServers(this, false));
			return false;
		} 
	}
	public int senddata(String data) throws IOException
	{
		try 
		{
//			System.out.println("sending " + data + "to server");
//			PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
//			out.println(data);
			this.outstream.writeBytes(data);
			this.outstream.flush();
//			out.flush();
		} 
		catch (Exception e) 
		{
			System.out.println("not able to send data to server");
			this.socket.close();
			//e.printStackTrace();
			return 0;
		}
		return 1;
	}
	public String read() 
	{
		StringBuffer temp =  new StringBuffer();
		String st = null;
		try 
		{
			socket.setSoTimeout(5000);
//			System.out.println("next is instream read");
			st = instream.readLine();
//			System.out.println("instream read success");
			temp.append(st);
//			System.out.println("append done");
			return temp.toString();
		} 
		catch(SocketTimeoutException sockex)
		{
			System.out.println("socket timeout");
			return new String("null");
		}
		catch (IOException e) 
		{
		
//			System.out.println("not able to read from server");
			e.printStackTrace();
			return null;
		}
		
		
	}
	public void cleanup()
	{
		try 
		{
			socket.close();
			instream.close();
			outstream.close();
		} 
		catch (Exception e) 
		{
			return ;
		}
	}
	public static void readmatrix(int [][] matrix,int row,int column,Scanner in)
	{
//		System.out.println("Enter the elements of matrix");
		//Scanner in = new Scanner(System.in);
		for ( int c = 0 ; c < row ; c++ )
			for ( int d = 0 ; d < column ; d++ )
				matrix[c][d] = in.nextInt();
//		in.close();
	 
	}
	public void putresult(int[][] matrix,String str,int row,int column)
	{
		StringTokenizer stringTokenizer =  new StringTokenizer(str,",");
		int value  = Integer.parseInt(stringTokenizer.nextToken());
		matrix[row][column] = value;
	}
	public static String getrow(int matrix[][],int rowkey)
	{
    	StringBuffer row1 = new StringBuffer();
    	for ( int d = 0 ; d < matrix[0].length ; d++ )
    	{
			row1.append(matrix[rowkey][d]);
			if(d+1!=matrix[0].length)
				row1.append(' ');
	   
    	}
        return row1.toString();       	
	}
	public static String generatedatatosend(String row,int colno,int[][] transpose)
	{
			StringBuffer buffer =  new StringBuffer();
			buffer.append(row);//1 2
			buffer.append(',');
			String column = getrow(transpose, colno);
			buffer.append(column);//1 3
			buffer.append("\n");
			return buffer.toString();
	}
	public static void main(String[] args) throws IOException, InterruptedException
	{
		long starttime = System.nanoTime();
		ArrayList<ListServers> servers = new ArrayList<ListServers>();
				
		Scanner in = new Scanner(new File("/home/user/workspace2/SymmetricClustering/input/in"));

		int row1 = in.nextInt();
		int col1 = in.nextInt();
		int row2 = in.nextInt();
		int col2 = in.nextInt();
		
		int matrix1[][] = new int[row1][col1];
		in = new Scanner(new File("/home/user/workspace2/SymmetricClustering/input/matbig"));
		readmatrix(matrix1, row1, col1,in);
		
		int matrix2[][] = new int[row2][col2];
		in = new Scanner(new File("/home/user/workspace2/SymmetricClustering/input/matbig1"));
		readmatrix(matrix2, row2, col2,in);
		
		int transpose[][] = new int[col2][row2];
		int[][] resultantmatrix = new int[row1][col2];
		
      	for ( int c = 0 ; c < row2 ; c++ )
      	{
      		for ( int d = 0 ; d < col2 ; d++ )               
      			transpose[d][c] = matrix2[c][d];
      	}
      	Client first = new Client();
		first.initializeClient("10.1.6.55", 6767,servers);
		Client second = new Client();
		second.initializeClient("10.1.6.56", 6768,servers);
		Client third = new Client();
		third.initializeClient("10.1.6.57", 6769,servers);

		
		if(!upservers(servers))
		{
			System.out.println("no server is there for computation");
			return ;
		}

//		Scanner scan = new Scanner(System.in);
//		int go = scan.nextInt();
//		scan.close();
		
		Threading[] threads = new Threading[row1*col2];
		Threading.servers = servers;
		Threading.resultantmatrix = resultantmatrix;
		System.out.println("no of servers are " + servers.size());
		int threadno = 0;
        for ( int rowno = 0 ; rowno < row1 ; rowno++ )
      	{
        	String row = getrow(matrix1,rowno); //getting row of the first matrix
      		for ( int colno = 0 ; colno < col2 ; colno++ )               
  			{
      			String datatosend = generatedatatosend(row, colno, transpose);
      			int index = threadno % servers.size();
      			threads[threadno] = new Threading(rowno,colno,datatosend,index,threadno);
      			//System.out.println("now giving to server no  "+ index);
      			threads[threadno].start();
      			threadno++;
  			}
      	}
        for (int i = 0; i < threads.length; i++) 
        {
        	//System.out.println("waiting for thread " + threads[i].threadid + " to complete" );
        	try 
        	{
        		threads[i].join();
		} 
        	catch (Exception e) 
        	{
        		System.out.println("while joining the thread");
        		e.printStackTrace();
			}
		}
        
        terminateservers(servers);
        for (int i = 0; i < resultantmatrix.length; i++) 
        {
        	for (int j = 0; j < resultantmatrix[0].length; j++) 
        	{
        		System.out.print(resultantmatrix[i][j] +" ");
			}
        	System.out.println();
		}
        
        first.cleanup();
        second.cleanup();
        third.cleanup();
        in.close();
        long endtime = System.nanoTime();
        System.out.println("total execution time is " + (endtime	 - starttime)/1000000 );
	}
	
	
}


