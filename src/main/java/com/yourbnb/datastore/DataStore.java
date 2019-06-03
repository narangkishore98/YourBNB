package com.yourbnb.datastore;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class  DataStore
{
    static String fileName = "log.txt";
    public static void log(String message) throws IOException
    {
        File f = new File(fileName);
        if(!f.isFile())
        {
            f.createNewFile();
        }
        FileWriter fw = new FileWriter(f,true);
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

        fw.write(df.format(d)+" ---- "+message);
    }
    public static void changeLogPath(String newFileName)
    {
        fileName = newFileName;
    }


}
