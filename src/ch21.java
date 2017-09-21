

import java.io.*;
import java.util.*;

public class ch21 {
    public static void main (String[] args) {
        String filePath = args[0];
        //String filePath = "C:\\test.txt";
        File file = new File(filePath);
        String test = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null){

                test = test + temp;

            }
        } catch (IOException e){

        }
        System.out.println(test);

        Map<String, Integer> set = new TreeMap<>();



        String[] testing = test.split("[ \n\t\r.,;:!?(){]");
        for (String x : testing){
            if (x.length()>0){
                if (!set.containsKey(x)){
                    set.put(x,1);
                }else {
                    int count = set.get(x);
                    count ++;
                    set.put(x,count);
                }
            }

        }
        Set<Map.Entry<String, Integer>> entrySet = set.entrySet();
        for (Map.Entry<String, Integer> entry: entrySet){
            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }

    }
}
