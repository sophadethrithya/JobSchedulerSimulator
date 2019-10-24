package com.company;

import java.awt.*;
import java.io.*;
import java.util.Random;

public class TrialCreator {
        Random rand = new Random();

        public static void main(String[] args) throws IOException {

                createTrialFile(5,10);
                createTrialFile(10,10);
                createTrialFile(15,10);

        }


        public static void createTrialFile(int jobSize,int numOfTrial) throws IOException {
                for (int j =0; j <numOfTrial;j++){
                        FileWriter file = new FileWriter("/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/trial/Job"+String.valueOf(jobSize)+"Trial"+String.valueOf(j+1)+".txt");
                        BufferedWriter out = new BufferedWriter(file);
                        for(int i = 0 ; i <jobSize; i++)
                        {

                                int jobLength = new Random().nextInt(20)+1;
                                out.write("Job"+String.valueOf(i+1)+'\n'+String.valueOf(jobLength)+'\n');

                        }
                        out.close();

                }



        }



    }
