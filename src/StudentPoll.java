import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class StudentPoll {

    public static void readSurveyInput() {

        try (Formatter formatter = new Formatter("src/numbers.txt"); Scanner myScanner = new Scanner(System.in);) {
            System.out.println("Enter survey response" +
                    "responses and press ENTER+CTRL+D to quit");
            while (myScanner.hasNext()) {

                formatter.format("%d ", myScanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }


    public static int[] processSurveyResponses() {
        int [] frequency = new int[6];

        try(Scanner input = new Scanner(Paths.get("src/numbers.txt"));
            Formatter newFormat = new Formatter("src/numbers.txt");) {



             while(input.hasNext()){
                 int answer = input.nextInt();
                 try{

                     ++frequency[answer];
                 }
                 catch(ArrayIndexOutOfBoundsException e){
                     System.out.println(e);
                 }

             }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return frequency;
    }

    public static void main(String[] args) {
        readSurveyInput();
        int [] frequency = processSurveyResponses();
        writeSurveyFrequency(frequency);
    }

    public static void writeSurveyFrequency(int[] frequency) {

        try(Formatter output = new Formatter("src/numbers.txt");){
            output.format("%s%10s%n", "Rating", "Frequency");
            for(int i=1; i< frequency.length; i++){
                System.out.printf("%d%10d%n", i, frequency[i]);
            }
        }

        catch(IOException e){
          e.printStackTrace();
        }
    }
}
