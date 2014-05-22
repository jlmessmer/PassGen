import java.util.ArrayList;


public class PassGenWorker implements Runnable {
	
	private static int passLength;
	private static String password = "";
	private static ArrayList<String> sections;
	
	  public static void main (String[] args) throws InterruptedException  
	  {
		  long start = System.currentTimeMillis();
		  sections = new ArrayList<String>();
		  passLength = 26812 / (Runtime.getRuntime().availableProcessors() + 1);
		  
		  //System.out.println(passLength);
		    
		  for(int i = 0; i < Runtime.getRuntime().availableProcessors() + 1; i++)
		  {
			  //System.out.println(i);
			  PassGenWorker worker = new PassGenWorker();	    
			  Thread thread = new Thread(worker);  
			  thread.start();  
		  }
		  
		  while(sections.size() < Runtime.getRuntime().availableProcessors() + 1)
		  {
			  Thread.sleep(1);
		  }
		  
		  for(String s : sections)
			  password += s;
		  
		  System.out.println(password);
		  
		  long end = System.currentTimeMillis();
		  
		  System.out.println("It took " + (end - start) + " milliseconds to generate your password");

	  }  
	    
	  @Override  
	  public void run()   
	  {  
		  //System.out.println("This is currently running on the new thread, " + "the id is: " + Thread.currentThread().getId());
		  
		  String s = generatePass(passLength);
		  
		  //System.out.println(s);
		  sections.add(s);
		  //password += s;
		  //System.out.println(password);
	  }
	  
	  public String generatePass(int length)
	  {
		  String pass = "";
		  
		  int passLength = length;
		
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
			  int isNum = (int)(Math.random() * 2);
			  if(isNum == 0)
				  pass += Integer.toString((int)(Math.random() * 10));
			  else
				  pass += chars.get((int)(Math.random() * chars.size()));
		  }
		  
		  return pass;
	  }
}
