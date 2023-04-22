package com.stdfcore.controller;

import com.alibaba.fastjson.JSONObject;
import com.stdf.Record;
import com.stdf.STDFContainer;
import com.stdf.STDFReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author 秀
 * @Description : TODO
 * @create 2023/3/23 10:20
 **/
@RestController
public class StdfTest {


    private static String bashPath=System.getProperty("user.dir");


    @GetMapping("/read")
    public STDFContainer  readAndDealFiles(){

        File file = new File(bashPath+"\\test.stdf");

        try {
            STDFReader stdfReader = new STDFReader(file);
            try {
                STDFContainer stdfContainer = new STDFContainer(stdfReader);
                Object jsonObject =JSONObject.toJSON(stdfContainer);

                return stdfContainer;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    return null;

    }


}
