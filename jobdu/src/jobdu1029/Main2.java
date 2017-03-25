package jobdu1029;

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class Main2{   
       
    public static void main(String [] args) throws IOException{
//            Scanner in = new Scanner(new File("./bin/oj/in.txt"));
            Scanner in = new Scanner(System.in);
           

//            while(in.hasNext()){
                HashMap hm = new HashMap<String,String>();
                    String str = in.nextLine();
                    while(!str.equals("@END@")){       
                            String [] s = str.split("] ");
                            String key = s[0].substring(1);
                            String fun = s[1];
                            System.out.println(key + " " + fun);
                            hm.put(key, fun);
                            hm.put(fun,key);
                           
                            str = in.nextLine();
                           
                    }
                   
                    int n = in.nextInt();
                    //need to skip NULL after get Int
                    String temp = in.nextLine();
                    StringBuffer sb = new StringBuffer();
                    for(int i=0;i<n;i++){
                            temp = in.nextLine();
                            if(temp.charAt(0)=='[')
                                    temp = temp.substring(1,temp.length()-1);
                            if(hm.containsKey(temp)){
                                    sb.append(hm.get(temp)+"\n");
                            }else{
                                    sb.append("what?\n");
                            }
                    }
                    System.out.print(sb);
//            }
                           
    }//main
}//Main
