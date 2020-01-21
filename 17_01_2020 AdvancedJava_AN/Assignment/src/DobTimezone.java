import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class DobTimezone{
    
    public static void main(String[] args) throws ParseException
    {
	String MyDOB,ParentDOB;
	try{
	Scanner input = new Scanner(System.in);
	System.out.println("Enter Your DOB in the Format(YYYY-MM-DDTHH:MM:SS) :");
	MyDOB = input.next();
	System.out.println("Enter Your Parent DOB in the Format(YYYY-MM-DDTHH:MM:SS) :");
	ParentDOB = input.next();
	} Catch(Exception e) {
	System.out.println("Can not read input.");
	}	
	LocalDateTime MyDOBTime = LocalDateTime.parse(MyDOB);
	System.out.println("My DateTime: " + MyDOBTime);
	LocalDateTime ParentDOBTime=LocalDateTime.parse(ParentDOB);
	System.out.println("Parent DateTime: " + ParentDOBTime);
	ZonedDateTime Zone1=ZonedDateTime.parse(MyDOB);
	System.out.println(Zone1);
	ZonedDateTime Zone2=ZonedDateTime.parse(ParentDOB);
	System.out.println(Zone2);
	ChronoUnit CDays=ChronoUnit.DAYS;
	System.out.println(CDays.between(Zone2, Zone1));
    }
}
