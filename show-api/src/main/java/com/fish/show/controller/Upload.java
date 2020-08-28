package com.fish.show.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @Author: Fish
 * @Date: 2020-08-15 10:18
 */
@RestController
public class Upload {

    /**
     * 实现文件上传
     * @param fileUpload
     * @param request
     * @return
     */
    @RequestMapping( "/fileUpload" )
    public void fileUpload(@RequestParam("file") MultipartFile fileUpload, HttpServletRequest request){

        SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddhhmmss" );
        String fileName = sFormat.format(Calendar.getInstance().getTime())+ new Random().nextInt(1000);
        String originalFilename = fileUpload.getOriginalFilename();
        fileName += originalFilename.substring(originalFilename.lastIndexOf("." ));
        String dirName = request.getSession().getServletContext().getRealPath("/" )+"fileUpload" ;

        double originalFilesize = request.getContentLength();//获取源文件大小

        File file = new File(dirName);
        InputStream inputStream = null ;
        FileOutputStream outputStream = null ;
        if (!file.exists())
        {
            file.mkdir();
        }
        try
        {
            inputStream = fileUpload.getInputStream();
            if (!inputStream.equals(null)){
                try {
                    String table_type = request.getParameter("table_type" );
//                    DocManagement docManagement = new DocManagement();
//                    docManagement.setFilename(originalFilename);
//                    docManagement.setFileurl( "/fileUpload/" +fileName);
//                    docManagement.setFilesize(originalFilesize);
//                    docManagement.setTable_type(table_type);
//                    dManagementService .addDocFile(readCurrentOperator(),docManagement);//直接存入数据库表
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
            outputStream = new FileOutputStream(dirName+"/" +fileName);
            byte [] buffer = new byte[1024 * 1024];
            int len=0;
            while ((len=inputStream.read(buffer)) != -1)
            {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }
            outputStream.close();
            inputStream.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
