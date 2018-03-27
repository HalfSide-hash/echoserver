import java.io.*;
import java.net.*;

public class TCPClient
{
	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("127.0.0.1", 9840); //local host connection
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter w = new PrintWriter(s.getOutputStream(), true);
			BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
			String line;
			do
			{
				line = r.readLine();
				if ( line != null )
					System.out.println(line);
				line = con.readLine();
				w.println(line);
			}
			while ( !line.trim().equals("end") );
		}
		catch (Exception err)
		{
			System.err.println(err);
		}
	}
}