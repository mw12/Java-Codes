
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTextTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
       
        //following docs are w/o repitition
        String d1[] = {"website", "application", "people", "information"};
        String d2[] = {"website", "people", "profile", "communities", "interests"};
        String d3[] = {"network", "service", "platform", "website","relations", "people"};
        String d4[] = {"communities","interest","commonality","Internet","people","network"};
        String d5[] = {"group","people","information","experience","purpose"};
        String d6[] = {"network","contacts","communities","people","interest","prospects","information","support"};
        String d7[] = { "network", "group", "computer", "devices","channels","communications","users","resources", "data"};
        String d8[] = {"computer", "network",  "server"};
        String d9[] = {"group", "computer", "cables", "signals","network","protocols"};
        String d10[] = {"group", "network", "data","computer"};
       
        String hd1[], hd2[], hd3[], hd4[], hd5[], hd6[], hd7[], hd8[], hd9[], hd10[];
        hd1 = new String[d1.length];
        hd2 = new String[d2.length];
        hd3 = new String[d3.length];
        hd4 = new String[d4.length];
        hd5 = new String[d5.length];
        hd6 = new String[d6.length];
        hd7 = new String[d7.length];
        hd8 = new String[d8.length];
        hd9 = new String[d9.length];
        hd10 = new String[d10.length];
      
        compute_hash(d1, hd1);
        compute_hash(d2, hd2);
        compute_hash(d3, hd3);
        compute_hash(d4, hd4);
        compute_hash(d5, hd5);
        compute_hash(d6, hd6);
        compute_hash(d7, hd7);
        compute_hash(d8, hd8);
        compute_hash(d9, hd9);
        compute_hash(d10, hd10);
       
        
        //System.out.println(hd1[2]);
        /*All the weights could have been placed into 1 vector - but since the method is being called multiple times, multiple arrays of weights*/
      
        double wt1[] = {0.131,0.25,0.055,0.131};
        double wt2[] = {0.105,0.044,0.2,0.105,0.105};
        double wt3[] = {0.039, 0.25, 0.125, 0.065, 0.125,0.028};
        double wt4[] = {0.075, 0.075, 0.143, 0.143, 0.032, 0.044};
        double wt5[] = {0.080, 0.044, 0.105, 0.2, 0.2};
        double wt6[] = {0.019, 0.125, 0.065 , 0.028, 0.065 , 0.125, 0.065, 0.125};
        double wt7[] = {0.014 ,0.036, 0.072 ,0.091,0.091, 0.091, 0.182, 0.091, 0.064};
        double wt8[] = {0.199,0.039,0.25};
        double wt9[] = {0.066, 0.066, 0.167, 0.167, 0.026, 0.167};
        double wt10[] = {0.057,0.066 ,0.100,0.114};
       
        double finger_d1[] = get_fingerprint(hd1, wt1); //do the same till finger_d10 and use d outputted values for clustering
        double finger_d2[] = get_fingerprint(hd2, wt2);
        double finger_d3[] = get_fingerprint(hd3, wt3);
        double finger_d4[] = get_fingerprint(hd4, wt4);
        double finger_d5[] = get_fingerprint(hd5, wt5);
        double finger_d6[] = get_fingerprint(hd6, wt6);
        double finger_d7[] = get_fingerprint(hd7, wt7);
        double finger_d8[] = get_fingerprint(hd8, wt8);
        double finger_d9[] = get_fingerprint(hd9, wt9);
        double finger_d10[] = get_fingerprint(hd10, wt10);
        
        for (int i = 0; i < finger_d1.length; i++) {
        	System.out.print((int)finger_d1[i]);	
		}
        
        
       
    }
 
    /*Computes hash values of all the features of the passed documents*/
    private static void compute_hash(String d[], String hd[]){
        String temp = "";
        for(int i=1;i<=10;i++){
            for(int j=0;j<d.length;j++){
                try{
                    temp = sha1(d[j]);
                }catch(Exception e){
                    e.printStackTrace();
                }
                temp = temp.substring(0, 16);//extracting only first 64 bits ie 16 hex numbers from hashed value
                hd[j] = temp;
            }
        }
    }
   
   
    /*Taken from site*/
    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
    }
   
    /*following method first converts hex to binary and then finds d fingerprint vector*/
    private static double[] get_fingerprint(String hash_values[], double weight_array[]){
       
        String hash_array[] = new String[hash_values.length];
        for(int i = 0;i<hash_values.length;i++)
        {
        	//System.out.println(hash_values[i]);
            hash_array[i] = convert_string(hash_values[i]); 
            //System.out.println(hash_array[i].length());
            //System.out.println("the binary of " + hash_values[i] +"  is  "+ hash_array[i]);
        }
       
        String temp;
        double vector[] = new double[64];//declaring 64bit fingerprint vector
       
        /*weight_array contains tf-idf weights of every feature in d doc, hashvalue denotes concatenated hashvalues of all the features in d doc*/
        for(int i=0;i<hash_array.length;i++){
           
            temp = hash_array[i]; //extracting hashvalue of ith feature of the passed value
           
            for(int j = 0;j<64;j++){
                if(temp.charAt(j)=='1')
                    vector[j] = vector[j] + weight_array[i]; 
                else
                    vector[j] = vector[j] - weight_array[i];
            }
   
        }
        //System.out.println(vector[1]);
        for (int i = 0; i < vector.length; i++) {
			
        	if (vector[i]>0) {
				vector[i]=1;
			}
        	else {
				vector[i]=0;
			}
		}
       
        return vector; //return the fingerprint vector
       
    }
   
    /*Converts hex hash value to binary*/
    private static String convert_string(String s){
        String whole_string = "";
        //System.out.println(s.length());
        for(int i=0;i<s.length();i++){
        	whole_string = whole_string + convert_char(s.charAt(i));
        	//System.out.println(whole_string + "converted " + s.charAt(i) + " to "+ convert_char(s.charAt(i)));
        }
        return whole_string;
    }
   
    /*Converts hex char to binary*/
    private static String convert_char(char c){
        String s;
        switch(c){
            case '0': s = "0000"; break;
            case '1': s = "0001"; break;
            case '2': s = "0010"; break;
            case '3': s = "0011"; break;
            case '4': s = "0100"; break;
            case '5': s = "0101"; break;
            case '6': s = "0110"; break;
            case '7': s = "0111"; break;
            case '8': s = "1000"; break;
            case '9': s = "1001"; break;
            case 'a': s = "1010"; break;
            case 'b': s = "1011"; break;
            case 'c': s = "1100"; break;
            case 'd': s = "1101"; break;
            case 'e': s = "1110"; break;
            case 'f': s = "1111"; break;
            default: s = "";
            }
        return s;
    }
}