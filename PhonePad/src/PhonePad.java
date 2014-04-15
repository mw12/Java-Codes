
public class PhonePad {

	
	public 	int fingerMovement(String phoneNumber)
	{
		int lastx = 1;
		int lasty = 1;
		int countmoves =0;
		for (int i = 0; i < phoneNumber.length(); i++) 
		{
			switch (phoneNumber.charAt(i))
			{
			case '0':
				 	countmoves += Math.abs(3-lastx) + Math.abs(1-lasty);
				 	lastx = 3;
				 	lasty = 1;
				 	break;
			case '*':
			 	countmoves += Math.abs(3-lastx) + Math.abs(0-lasty);
			 	lastx = 3;
			 	lasty = 0;
			 	break;
			case '#':
			 	countmoves += Math.abs(3-lastx) + Math.abs(2-lasty);
			 	lastx = 3;
			 	lasty = 2;
			 	break;
			case '1':
			 	countmoves += Math.abs(lastx) + Math.abs(lasty);
			 	lastx = 0;
			 	lasty = 0;
			 	break;
			case '2':
			 	countmoves += Math.abs(lastx) + Math.abs(1-lasty);
			 	lastx = 0;
			 	lasty = 1;
			 	break;
			case '3':
			 	countmoves += Math.abs(lastx) + Math.abs(2-lasty);
			 	lastx = 0;
			 	lasty = 2;
			 	break;
			case '4':
			 	countmoves += Math.abs(1-lastx) + Math.abs(lasty);
			 	lastx = 1;
			 	lasty = 0;
			 	break;
			case '5':
			 	countmoves += Math.abs(1-lastx) + Math.abs(1-lasty);
			 	lastx = 1;
			 	lasty = 1;
			 	break;
			case '6':
			 	countmoves += Math.abs(1-lastx) + Math.abs(2-lasty);
			 	lastx = 1;
			 	lasty = 2;
			 	break;
			case '7':
			 	countmoves += Math.abs(2-lastx) + Math.abs(lasty);
			 	lastx = 2;
			 	lasty = 0;
			 	break;
			case '8':
			 	countmoves += Math.abs(2-lastx) + Math.abs(1-lasty);
			 	lastx = 2;
			 	lasty = 1;
			 	break;
			case '9':
			 	countmoves += Math.abs(2-lastx) + Math.abs(2-lasty);
			 	lastx = 2;
			 	lasty = 2;
			 	break;	 	
			default:
				break;
			}
		}
		
		return countmoves;
		
	}
	public static void main(String[] args) {
		PhonePad pad = new PhonePad();
		System.out.println(pad.fingerMovement("8606574276"));

	}

}
