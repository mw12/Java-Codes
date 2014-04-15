import java.util.*;
 
public class ExtraordinarilyLarge {
    public String compare(String x, String y) {
        int xi = x.length() - 1;
        while (x.charAt(xi) == '!') {
            xi--;
        }
        
        int xnum = Integer.parseInt(x.substring(0, xi + 1));
        xi = x.length() - xi - 1;
        int yi = y.length() - 1;
        while (y.charAt(yi) == '!') {
            yi--;
        }
        int ynum = Integer.parseInt(y.substring(0, yi + 1));
        yi = y.length() - yi - 1;
        System.out.println("number of ! are " + xi);
        System.out.println("number of ! are " + yi);
        
        System.out.println("number of ! are " + xnum);
        while (xnum < 13 && xi > 0) 
        {
            int r = 1;
            for (int i = 0; i < xnum; i++) {
                r = r * (i + 1);
            }
            xnum = r;
            xi--;
        }
        System.out.println("number of ! are " + xnum);
        while (ynum < 13 && yi > 0) {
            int r = 1;
            for (int i = 0; i < ynum; i++) {
                r = r * (i + 1);
            }
            ynum = r;
            yi--;
        }
 
        if (xi < yi) {
            return "x<y";
        } else if (xi > yi) {
            return "x>y";
        } else {
            if (xnum < ynum) {
                return "x<y";
            } else if (xnum > ynum) {
                return "x>y";
            } else {
                return "x=y";
 
            }
        }

    }
    
    public static void main (String args[])
    {
    ExtraordinarilyLarge extraordinarilyLarge =  new ExtraordinarilyLarge();
    System.out.println(extraordinarilyLarge.compare("123!!!","456!"));
    } 
 
}