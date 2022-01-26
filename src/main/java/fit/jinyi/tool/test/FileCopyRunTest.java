package fit.jinyi.tool.test;

import fit.jinyi.tool.file.FileCopyHelper;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * 文件复制测试用例
 * @author liujin
 * @date 2022/1/4
 * @since JDK8
 */
public class FileCopyRunTest {
    @Test
    public void copyFile(){
//        String sourcePath = "D:\\software/Docker Desktop Installer.exe";
//        String destPath = "E:\\testCopy/Docker Desktop Installer_test.exe";
        String sourcePath = "D:\\software/cn_windows_10_multiple_editions_x64_dvd_6848463.iso";
        String destPath = "E:\\testCopy/cn_windows_10_multiple_editions_x64_dvd_6848463.iso";
        File srcFile = new File(sourcePath);
        File destFile = new File(destPath);
        FileCopyHelper fileCopyHelper = FileCopyHelper.getInstance();
        long start = System.currentTimeMillis();
//        fileCopyHelper.bigFileChannelCopy(srcFile,destFile);
        fileCopyHelper.bigFileNioBufferCopy(srcFile,destFile);
//        fileCopyHelper.bigFileBufferStreamCopy(srcFile,destFile);
        long end = System.currentTimeMillis();
        System.out.println("文件复制完成，耗时(ms): "+(end-start));
    }

    @Test
    public void printAllFiles(){
        String sourcePath = "D:\\software";
//        String sourcePath = "\\Apple iPhone\\Internal Storage\\DCIM\\103APPLE";
        FileCopyHelper.getInstance().printAllFiles(sourcePath);
    }

    @Test
    public void copyDirectory(){
//        String sourcePath = "D:\\software";
//        String destPath = "E:\\testCopy2";
        String sourcePath = "E:\\手机照片梳理\\100APPLE";
        String destPath = "E:\\testCopy2";
        long start = System.currentTimeMillis();
        FileCopyHelper.getInstance().copyAllFiles(sourcePath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("文件复制完成，耗时(ms): "+(end-start));
    }
    @Test
    public void copyPicture(){
        String sourcePath = "此电脑\\Apple iPhone\\Internal Storage\\DCIM\\103APPLE";
        String destPath = "E:\\手机照片梳理\\103APPLE";
        long start = System.currentTimeMillis();
        long nums = FileCopyHelper.getInstance().copyAllFiles(sourcePath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("文件复制完成，耗时(ms): "+(end-start));
        System.out.println("文件个数: "+nums);
    }
    @Test
    public void copyFilesParallel(){
        String sourcePath = "E:\\手机照片梳理\\100APPLE";
        String destPath = "E:\\testCopy";
        long start = System.currentTimeMillis();
        FileCopyHelper.getInstance().copyFilesParallel(sourcePath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("文件复制完成，耗时(ms): "+(end-start));
    }
    @Test
    public void test(){
        javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView();
        File file1 = fsv.getHomeDirectory();//读取桌面路径
        System.out.println(file1.getPath());
        fsv.getHomeDirectory().getPath(); // 返回 C:\Users\liu\Desktop
        //返回文件选择器的用户默认起始目录。
        String de = fsv.getDefaultDirectory().getPath() ; //这便是读取我的文档路径的方法
        System.out.println(de);
    }
}
