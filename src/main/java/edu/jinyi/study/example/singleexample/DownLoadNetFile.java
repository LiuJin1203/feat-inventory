package edu.jinyi.study.example.singleexample;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 下载网络文件
 * @author liujin
 * @date 2022/1/14
 * @since JDK8
 */
public class DownLoadNetFile {
    public static void main(String[] args) throws IOException {
        String url0 = "https://github.com/rebeyond/Behinder/releases/download/Behinder_v3.0_Beta_11_for_tools/Behinder_v3.0_Beta_11.t00ls.zip";
        String url = "https://t7.baidu.com/it/u=1819248061,230866778&fm=193&f=GIF";
        String target = "E:\\downtest/Behinder_v3.0_Beta_11.t00ls.zip.zp";
        downLoadFile(url0,target);
//        closeFile();
    }

    private static void downLoadFile(String urlPath,String target)  {
        try{
            URL url = new URL(urlPath);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            int code = 0;
            code = urlConnection.getResponseCode();
            if (code==200){
                System.out.println("开始下载...");
                InputStream input = urlConnection.getInputStream();
                BufferedInputStream inStream = new BufferedInputStream(input);
                File outFile =  new File(target);
                FileOutputStream fileOutputStream = new FileOutputStream(outFile);
                BufferedOutputStream outStream = new BufferedOutputStream(fileOutputStream);
                int len = 0;
                byte[] bt = new byte[4096];
                while ((len=inStream.read(bt)) != -1) {
                    outStream.write(bt,0,len);
                    outStream.flush();
                    System.out.println("下载中...");
                }
                outStream.close();
                fileOutputStream.close();
                inStream.close();
                input.close();
                System.out.println("下载成功");
            }
        }catch (IOException e){
            System.out.println("下载失败");

            e.printStackTrace();
        }

    }

    private static void closeFile() throws IOException {
        String target = "E:\\downtest/Behinder_v3.0_Beta_11.t00ls.zip";
        File outFile =  new File(target);
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        fileOutputStream.close();
    }


}
