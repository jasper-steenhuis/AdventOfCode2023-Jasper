import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


class DayOne{
    public static String[] wordsArray = {"one", "two", "three", "four", "five", "six", "seven", " eight", "nine", "ten"};
    public static void main(String[] args) {  
        try {
            File inputFile = new File("C:\\Users\\Gebruiker\\Documents\\projecten\\AdventOfCode2023-Jasper\\InputFiles\\dayOne");
            Scanner fileScanner = new Scanner(inputFile); 
            ArrayList<String> stringList = new ArrayList<String>();
        while (fileScanner.hasNextLine()) {
            String data = fileScanner.nextLine();
            stringList.add(data);
        }
        fileScanner.close();
        ArrayList<Integer> ints = new ArrayList<Integer>();
        int total =0;

        for(int i=0; i<stringList.size(); i++){
            String[] strs;
            strs = extractNumbersFromStrings(stringList.get(i));
            for(int x=0; x< strs.length; x++){
                    int first = strs[x].charAt(0) - '0';
                    int last = strs[x].charAt(strs[x].length()-1) - '0';
                    String firstStr = String.valueOf(first);
                    String lastStr = String.valueOf(last);
                    String finalStr = firstStr + lastStr;
                    int toAdd = Integer.parseInt(finalStr);
                    total += toAdd;
                    System.out.println(finalStr);
    
            }
            //System.out.println("TOTAL: " + total);
        }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
        
    }  
    public static String[] extractNumbersFromStrings(String str){
            Pattern pattern = Pattern.compile("(?:one|two|three|four|five|six|seven|eight|nine|ten)"); 

           return str.replaceAll("[^0-9]","").split("\\D+");        
    }



    



            


} 