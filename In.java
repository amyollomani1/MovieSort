
import java.io.*;
import java.util.*;

// In is a helper class written for CIS-2168 Labs. Its purpose is to help read
// a text file. In this version, the file is stored locally (a followup version
// will also read data from URL connections)
// The main() method shows an example of using the In class.

public final class In {
   private Scanner scanner;

   // Constructor. Initializes an input stream from standard input.
   public In() {
      scanner = new Scanner(new BufferedInputStream(System.in));
   }

   // Constructor. Initializes an input stream from a local filename.
   public In(String name) {
      if (name == null) throw new IllegalArgumentException("please tell me which file to open. exiting for now...");
      // UNCOMMENT THE LINES BELOW AND FILL IN YOUR CODE:
      try {
         File file = new File(name);
         if (file.exists()) {
        	 
                 FileInputStream fis = new FileInputStream(file);
                 BufferedInputStream bis = new BufferedInputStream(fis);
                 scanner = new Scanner(bis);
         }
      } catch (IOException ioe) {
         throw new IllegalArgumentException("Could not open " + name, ioe);
      }
   }

   // Reads all lines from this input stream and returns them as
   // an array of strings.
   public String[] readAllLines() {
	   ArrayList<String> lines = new ArrayList<String>();
	   while (scanner.hasNextLine()) {
		   lines.add(scanner.nextLine());
	   }
	   return lines.toArray(new String[lines.size()]);
   }

   // Closes this input stream.
   public void close() {
      scanner.close();
   }

   // Returns true if input stream is empty
   public boolean isEmpty() {
      return !scanner.hasNext();
   }

   // Returns true if this input stream has a next line.
   public boolean hasNextLine() { return scanner.hasNextLine(); }

   // Reads and returns the next line in this input stream
   public String readLine() {
	   String line;
	      try {
	    	  line = scanner.nextLine();
	    	  
	      } catch (NoSuchElementException e) {line = null;}
	      
	      return line;
   }

   // main() tests the In data type
   public static void main(String[] args) {
      In in = new In("movieinfo.txt");
      while (!in.isEmpty()) {
         String text = in.readLine();
         System.out.println(text);
      }
   }
}