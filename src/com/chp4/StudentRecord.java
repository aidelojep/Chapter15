package com.chp4;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;

public class StudentRecord {

    public void saveRecords(){
        try(
            Formatter formatter = new Formatter("students_records.txt");
            Scanner myScanner = new Scanner(System.in)){
            System.out.println("Enter students records and ENTER + CNTRL + D to stop");
            formatter.format("%s %s %s %s %s%n", "Firstname","Lastname","Level","Year","Age");
            
            while (myScanner.hasNext()){
                String firstname = myScanner.next();
                String lastname = myScanner.next();
                int level = myScanner.nextInt();
                int yearOfBirth = myScanner.nextInt();
                
                formatter.format("%s %s %d %d %d%n", firstname, lastname,level, yearOfBirth,
                        LocalDate.now().getYear() - yearOfBirth);
            }
            
            
        } 
        catch(FileNotFoundException e){
            e.printStackTrace();
            
            
        }
        
    }

    public static void main(String[] args) {
        StudentRecord studentRecord = new StudentRecord();
        studentRecord.saveRecords();
    }

    
}

