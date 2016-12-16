package io.fengfu.learning.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by fengfu.qu on 2015/6/3.
 */
public class FilesDemo {
    public static void main(String[] args){
        try {
            long start = new Date().getTime();
//            long count = Files.newBufferedReader(Paths.get("D:\\atpco\\data\\ATP.INTFARES.D150419.T2359")).lines().count();
            System.out.println("Cost time: " + (new Date().getTime()-start));
//            System.out.println("=========="+count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
