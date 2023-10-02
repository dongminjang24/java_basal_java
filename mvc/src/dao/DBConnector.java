package dao;

import java.io.*;

public class DBConnector {


    public static BufferedWriter getWriter(String path) throws IOException{
        return new BufferedWriter(new FileWriter(path));
    }

    public static BufferedWriter getAppend(String path) throws IOException{
        return new BufferedWriter(new FileWriter(path,true));
    }
    public static BufferedReader getReader(String path) throws IOException{
        return new BufferedReader(new FileReader(path));
    }
}
