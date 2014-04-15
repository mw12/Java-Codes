import java.util.HashSet;
 
public class AstronomicalRecordsEasy {
 
  public int minimalPlanets(int[] A, int[] B) {
 
    int min = Integer.MAX_VALUE;
    for (int ai = 0; ai < A.length; ai++) {
      for (int bi = 0; bi < B.length; bi++) {
        HashSet<Integer> ints = new HashSet<Integer>();
        int amul=B[bi];
        int bmul=A[ai];
        for(int a:A){
          ints.add(a*amul);
        }
        for(int b:B){
          ints.add(b*bmul);
        }
        for (Integer integer : ints) 
        {
        	System.out.print(integer + " ");
		}	
        System.out.println();
        if(min>ints.size()){
        	System.out.println(ints.size());
          min=ints.size();
        }
      }
    }
    return min;
  }
 
	public static void main(String[] args) {
		AstronomicalRecordsEasy astronomicalRecordsEasy =  new AstronomicalRecordsEasy();
		int A[] = {1,2,3,4}; 
		int B[] = {6,7,8,9};
		astronomicalRecordsEasy.minimalPlanets(A, B);

	}

}
