package com;

import com.stdf.Record;
import com.stdf.RecordData;
import com.stdf.STDFContainer;
import com.stdf.STDFReader;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author 秀
 * @Description : TODO
 * @create 2023/3/27 10:49
 **/
public class Test {

    private static String bashPath=System.getProperty("user.dir");

    public static void main(String[] args) {
        File file = new File(bashPath+"\\test.stdf");

        try {
            STDFReader stdfReader = new STDFReader(file);
            try {
                STDFContainer stdfContainer = new STDFContainer(stdfReader);

//                 for(Record r:stdfContainer){
//
//                     RecordData rt= r.getData();
//                     System.out.println(rt);
//
//                 }



            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
