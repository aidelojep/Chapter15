

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

    public class ClassExercises {

        public static void readSurveyInput(){


            try(Formatter formatter =
                        new Formatter("src/com/chp15/out/numbers.txt");
                Scanner input = new Scanner(System.in);){

                System.out.println("Enter survey " +
                        "responses and press ENTER+CTRL+D to quit");

                while(input.hasNext()){

                    formatter.format("%d ",input.nextInt());
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }

        public static int[] processSurveyResponses()  {
            int[] frequency = new int[6];

            try(Scanner input = new Scanner(Paths.get("src/com/chp15/out/numbers.txt"));
                Formatter output = new Formatter("src/com/chp15/out/output.txt");){
                while(input.hasNextInt()){

                    int answer = input.nextInt();
                    try
                    {
                        ++frequency[answer];
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println(e); // invokes toString method
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return frequency;

        }

        public static void writeSurveyFrequency(int[] frequency){
            try(Formatter output = new Formatter("src/com/chp15/out/output.txt");){

                output.format("%s%10s%n", "Rating", "Frequency");
                for(int i = 1; i < frequency.length; i ++){

                    System.out.printf("%d%10d%n", i, frequency[i]);
                    output.format("%d%10d%n", i, frequency[i]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        public static void main(String[] args) {
            readSurveyInput();
            int[] frequency = processSurveyResponses();
            writeSurveyFrequency(frequency);
        }
    }



