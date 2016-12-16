package io.fengfu.learning.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by fengfu.qu on 2014/12/19.
 */
public class CSVReader {
    public static void main(String[] args){
        String csvFile = "D:\\Projects\\data\\cabin.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] cols = line.split(cvsSplitBy);

                char[] chars = cols[2].toCharArray();
                for(char c : chars){
                    System.out.println(cols[0]  + "_" + c + "=" + cols[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
