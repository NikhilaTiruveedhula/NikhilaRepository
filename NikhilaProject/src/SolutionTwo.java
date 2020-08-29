import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SolutionTwo {
	//2.1 Implementation
	/*Example output of the program
	Conisder the directory (C:\\Users\\NIKHILA.TIRUVEEDHULA\\Downloads) has below files :
    No. FileName  CreatedDate
	1. file1.txt  18/02/2020
	2. file2.txt  28/06/2020
	3. file3.txt  14/02/2020
	4. file4.txt  05/04/2020
	5. file5.txt  09/12/2020
	6. file6.txt  01/04/2020
	7. file7.txt  07/07/2020
	8. file8.txt  09/08/2020
	9. file9.txt  11/07/2020
   10. file10.txt 21/07/2020
   
    Output :
    	January - 0
    	Febrauary - 2
    	March - 0
    	April - 2
    	May - 0
    	June - 1
    	July - 3
    	August - 1
    	September - 0
    	October - 0
    	November - 0
    	December - 1*/
	   
	
	//2.2 Implementation
	public static void main(String[] argv){
		try {
	     File directoryPath = new File("C:\\Users\\NIKHILA.TIRUVEEDHULA\\Downloads");
	     File filesList[] = directoryPath.listFiles();
	     BasicFileAttributes attrs;
	     int count[]=new int[12];
	     for(File file :filesList){
	    	 attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
	    	 FileTime time = attrs.creationTime();
	    	 String pattern = "yyyy-MM-dd HH:mm:ss";
	    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	    	 String formatted = simpleDateFormat.format( new Date( time.toMillis() ) );
	    	 String formatsplit[]=formatted.split("-");
	    	 int month= Integer.valueOf(formatsplit[1]);
	    	 if(month!=0){
	    		 count[month-1]++;
	    	 }  
	     }
	     String monthnames[]={"January","Febrauary","March","April","May","June","July","August","September","October","November","December"};
    	 int i=0;
    	 for(String name : monthnames){
    		System.out.println(name + " - " +count[i]);
    		i++;
    	 }  
	} catch (IOException e) {
	    e.printStackTrace();
	}
}
}
