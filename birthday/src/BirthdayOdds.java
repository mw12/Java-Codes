import java.util.*;
public class BirthdayOdds {

	private static Scanner scan;
	public int minPeople(int minOdds, int daysInYear)
	{
		int num = daysInYear;
		float percentsame = 0;
		float percentdiff=1;
		while( percentsame  < minOdds)
		{
			percentdiff*=(float)num/daysInYear;
			
			percentsame = 100 - percentdiff*100;
			System.out.println("the percentage here is " + percentsame);
			num--;
		}
		System.out.println("the percent is " + (daysInYear-num));
		return 0;
		
	}
	public static void main(String[] args) {
		
		BirthdayOdds birthdayOdds = new BirthdayOdds();
		 
		scan = new Scanner(System.in);
		int minOdds = scan.nextInt();
		int daysInYear = scan.nextInt();
		birthdayOdds.minPeople(minOdds, daysInYear);
		

	}

}
