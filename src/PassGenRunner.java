import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PassGenRunner {
	
	private static BufferedReader in;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		//TEST COMMENT
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("How long do you want your password to be? ");
		
		int passLength = Integer.parseInt(in.readLine());
		String password = "";
		
		ArrayList<Character> chars = new ArrayList<Character>();
		
		for(int i = 65; i < 122; i++)
		{
			if(i == 91)
				i = 97;
			//System.out.println(i + ": " + (char)i);
			chars.add((char)i);
		}
		
		for(int i = 0; i < passLength; i++)
		{
			clearConsole();
			int isNum = (int)(Math.random() * 2);
			if(isNum == 0)
				password += Integer.toString((int)(Math.random() * 10));
			else
				password += chars.get((int)(Math.random() * chars.size()));
			
			double percentDone = 100 * ((double)i/(double)passLength);
			
			System.out.println(percentDone + "% done");
		}
		
		System.out.println("Your password is: " + password);

	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        System.out.println(e);
	    }
	}

}
