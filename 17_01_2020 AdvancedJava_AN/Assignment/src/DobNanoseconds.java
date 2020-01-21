import java.util.Scanner;
 import java.util.concurrent.TimeUnit;
 import java.text.ParseException;
 import java.text.SimpleDateFormat;  
 import java.util.Date;  
 public class DobNanoseconds {
 	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
 	    long diffInMillies = date2.getTime() - date1.getTime();
 	    return timeUnit.convert(diffInMillies,TimeUnit.NANOSECONDS);
 	}
 
 	public static void main(String[] args) {
 		String myDOB="";
 		String parentDOB="";
 		Date dateMyDOB = null;
 		Date dateParentDOB = null;
 		
 		try {
 		@SuppressWarnings("resource")
 		Scanner s = new Scanner(System.in);
 		System.out.println("Enter your DOB :");
 		myDOB = s.nextLine();
 		System.out.println("Enter your Parent DOB :");
 		parentDOB = s.nextLine();
 		} catch(Exception e) {
 			System.out.println("Can't initiate Scanner.");
 		}
 		try {
 			dateMyDOB = new SimpleDateFormat("dd/MM/yyyy").parse(myDOB);
 			dateParentDOB = new SimpleDateFormat("dd/MM/yyyy").parse(parentDOB);;
 		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} 
 		System.out.println(getDateDiff(dateParentDOB, dateMyDOB, TimeUnit.NANOSECONDS));
 	}
 }