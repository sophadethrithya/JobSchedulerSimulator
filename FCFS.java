package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Class Record are made to keep track of Start Time & End Time of Each process/job
class Record {
    List<Integer> start= new ArrayList<Integer>();
    List<Integer> stop= new ArrayList<Integer>();
}
//This is First Come First Serve Class
public class FCFS {
    //This hashmap are created to store all the data from the file
     protected HashMap<String, Integer> data = new HashMap<>();

     //Once call this instructor in main() it will get all the data
    //from file and do the scheduling computation then display the result
    FCFS(String filepath) throws FileNotFoundException {
        try {
            this.data = getData(filepath);
            Record record = compute(this.data);
            displayResult(record);
        }
        catch (Exception e)
        {
            System.out.println("Error: " +e);
        }

    }

    //This getData() is maded to parse the data from the text file
    public HashMap<String,Integer> getData(String filepath) throws FileNotFoundException {
        HashMap<String,Integer>data = new HashMap<>();

        File file = new File(filepath);
        Scanner filedata = new Scanner(file);

        while(filedata.hasNextLine()){
            String data1 = filedata.nextLine().replaceAll("\\s","");

            int data2 = Integer.parseInt(filedata.nextLine().replaceAll("\\s",""));

            data.put(data1,data2);
        }
        return  data;
    }

    //This is where FCFS computation take places
    public Record compute(HashMap<String,Integer> data)
    {
        Record record = new Record();
        //Start time always start from 0
        record.start.add(0);

        //This algorithm is simple. The end time will be added between the current job burst time and start time
        //Start time always start off with end time of the previous one
        for (int i = 0; i < data.size();i++)
        {
            //find the current end time
            int temp = record.start.get(i)+data.get("Job"+String.valueOf(i+1));
            record.stop.add(temp);
            //Set the next end time to equal to current end time
            if (i < data.size()-1)
                record.start.add(temp);
        }

        return record;
    }

    //This is where result are displayed using this displayResult
    //To find Average Turn Around Time : take all the data in End time arraylist and divided by the size of the End time arraylist
    public void displayResult(Record record)
    {
        System.out.println("First Come First Serve: ");
        System.out.println("Schedule Table:");
        System.out.println("Job#\tStart Time\tEnd Time\tJob Completion");
        for(int i = 0; i< this.data.size(); i++)
        {
            System.out.println("Job"+String.valueOf(i+1)+"\t"+record.start.get(i)+"\t\t\t"+record.stop.get(i)+"\t\t\tJob"+String.valueOf(i+1)+" complete @"+record.stop.get(i));
        }
        float turnAroundTime = 0;
        for (int i: record.stop)
        {
            turnAroundTime+= i;
        }
        turnAroundTime /= record.stop.size();
        System.out.println("\nAverage Turn Around Time: "+ turnAroundTime);
        System.out.println();
    }

}
