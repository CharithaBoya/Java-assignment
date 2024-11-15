import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        Locale usLocale = Locale.US;
        NumberFormat us = NumberFormat.getCurrencyInstance(usLocale);
        String usFormatted = us.format(payment);
        
        Locale indiaLocale = new Locale("en", "IN"); 
        NumberFormat india = NumberFormat.getCurrencyInstance(indiaLocale);
        String indiaFormatted = india.format(payment);
        
        Locale chinaLocale = Locale.CHINA;
        NumberFormat china = NumberFormat.getCurrencyInstance(chinaLocale);
        String chinaFormatted = china.format(payment);
        
        Locale franceLocale = Locale.FRANCE;
        NumberFormat france = NumberFormat.getCurrencyInstance(franceLocale);
        String franceFormatted = france.format(payment);
        
        System.out.println("US: " + usFormatted);
        System.out.println("India: " + indiaFormatted);
        System.out.println("China: " + chinaFormatted);
        System.out.println("France: " + franceFormatted);
    }
}
