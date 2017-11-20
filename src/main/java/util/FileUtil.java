package util;

import sun.nio.cs.ext.GBK;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shangzhidong on 2016/5/9.
 */
public class FileUtil {
    /**
     * 获取当前文件夹中的所有文件的路径
     * @param folder
     * @return
     */
    public static List<String> getFileList(String folder){
        List<String > fileList = new ArrayList<String>();
        File file = new File(folder);
        File files[] =file.listFiles();
        for(File tmp : files){
            if(tmp.isFile()){
                fileList.add(tmp.getAbsolutePath());
            }
        }
        return fileList;
    }

    /**
     * 读取文件内的内容 ，按行读取
     * @param filePath 文件路径
     * @return
     */
    public static List<String> readFileByLine(String filePath){
        List<String> content = new ArrayList<String>();
        BufferedReader br =null;
        try {
            // br = new BufferedReader(new FileReader(filePath)); 中文有乱码问题，需要InputStreamReader
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),
                StandardCharsets.UTF_8));
            String data;


            while ((data = br.readLine()) != null) {
                String row = data.trim();
                if(!"".equals(row)){
                    content.add(row);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  content;
    }

    /**
     * 读取文件内容
     * @param filePath
     * @return
     */
    public static String readContent (String filePath){
        BufferedReader br =null;
        String content="";
        try {
            br = new BufferedReader(new FileReader(filePath));
            String data;


            while ((data = br.readLine()) != null) {
                content+=data;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  content;
    }

    /**
     * 写文件内容
     *
     * @param fileName
     * @return
     */
    public static String writeContent(String fileName, String data) {
        BufferedWriter br = null;
        String content = "";
        try {
            br = new BufferedWriter(new FileWriter(fileName, false));
            br.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return content;
    }
    /**
     * 读取文件内容
     * @param in
     * @return
     */
    public static String readContent (InputStream in){
        BufferedReader br =null;
        String content="";
        try {
            br = new BufferedReader(new InputStreamReader(in));
            String data;


            while ((data = br.readLine()) != null) {
                content+=data;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  content;
    }
}
