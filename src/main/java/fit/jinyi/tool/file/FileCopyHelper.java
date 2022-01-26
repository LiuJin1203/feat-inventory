package fit.jinyi.tool.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 文件复制辅助类
 * 用于测试文件IO
 *
 * @author liujin
 * @date 2022/1/4
 * @since JDK8
 */
public class FileCopyHelper {
    private static final Logger log = LoggerFactory.getLogger(FileCopyHelper.class);

    private FileCopyHelper() {
    }
    private static class SingleHolder{
        private static final FileCopyHelper instance = new FileCopyHelper();
    }
    public static FileCopyHelper getInstance(){
        return SingleHolder.instance;
    }

    /**
     * 单个大文件复制
     * fileChannel 复制文件
     * todo 单体文件大于2G之后复制文件不全，后续继续验证
     * @param source 源文件
     * @param target 目标文件
     */
    public void bigFileChannelCopy(File source, File target) {
        FileInputStream infile = null;
        FileOutputStream outfile = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            infile = new FileInputStream(source);
            outfile = new FileOutputStream(target);
            inChannel = infile.getChannel();//得到对应的文件通道
            outChannel = outfile.getChannel();//得到对应的文件通道
            inChannel.transferTo(0, inChannel.size(), outChannel);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            log.info("复制结束,开始释放资源链接.");
            try {
                infile.close();
                inChannel.close();
                outfile.close();
                outChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 单个大文件复制
     * ByteBuffer 复制文件
     * @param source
     * @param target
     */
    public void bigFileNioBufferCopy(File source, File target) {
        FileChannel in = null;
        FileChannel out = null;
        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        try {
            inStream = new FileInputStream(source);
            outStream = new FileOutputStream(target);
            in = inStream.getChannel();
            out = outStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            while (in.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            log.debug("复制结束,开始释放资源链接.");
            try {
                inStream.close();
                in.close();
                outStream.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 大文件复制
     * 字节流+缓冲区
     * @param source
     * @param target
     */
    public void bigFileBufferStreamCopy(File source, File target) {
        BufferedInputStream inStream = null;
        BufferedOutputStream outStream = null;
        try {
            inStream = new BufferedInputStream(new FileInputStream(source));
            outStream = new BufferedOutputStream(new FileOutputStream(target));

            int len = 0;
            byte[] bt = new byte[4096];
            while ((len=inStream.read(bt)) != -1) {
                outStream.write(bt,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            log.debug("复制结束,开始释放资源链接.");
            try {
                inStream.close();
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 复制源文件夹下所有文件到目标文件夹
     * 只复制文件，不嵌套复制
     * @param sourcePath
     * @param destPath
     * @return
     */
    public long copyAllFiles(String sourcePath,String destPath)  {
        //单个文件大小的上限,小于这个上限即复制，可以通过这个上限值来控制部分文件是否拷贝
        //测试便于测试大文件和小文件复制效率
        final int upper = Integer.MAX_VALUE;
        File srcFolder = new File(sourcePath);
        //如果源文件夹路径不存在返回
        if(!srcFolder.exists()){
            log.info("源文件路径不存在.");
            return 0;
        }
        if(!srcFolder.isDirectory()){
            log.info("源文件路径需要是文件夹.");
            return 0;
        }
        File destFolder = new File(destPath);
        if (!destFolder.exists()){
            log.info("目标文件路径不存在,新建文件夹.");
            destFolder.mkdir();
        }
        File[] files = srcFolder.listFiles();
        int nums = files.length;
        long size = 0;
        String fileName = "";
        for (int i = 0; i < nums; i++) {
            if(!files[i].isDirectory()){
                fileName = files[i].getName();
                size = files[i].length()/1024+1;
//                System.out.println("文件名称: ["+fileName+"],大小(KB): "+size);
                if(size<upper){
                    long start = System.currentTimeMillis();
                    bigFileBufferStreamCopy(files[i],new File(destFolder+File.separator+fileName));
                    long end = System.currentTimeMillis();
                    log.info("复制文件[{}],大小:{}KB,耗时:{}ms",fileName,size,(end-start));
                }
            }
        }
        return nums;
    }

    /**
     * 打印文件夹下所有文件
     * @param path
     */
    public void printAllFiles(String path){
        File srcFolder = new File(path);
        //如果源文件夹路径不存在返回
        if(!srcFolder.exists()){
            log.info("源文件路径不存在.");
            return;
        }
        if(!srcFolder.isDirectory()){
            log.info("源文件路径需要是文件夹.");
            return;
        }
        File[] files = srcFolder.listFiles();
        Stream.of(files).forEach(file->{
            //文件夹则忽略
            if(!file.isDirectory()){
                System.out.println("文件名称: ["+file.getName()+"],大小(KB): "+(file.length()/1024+1));
            }
        });
    }

    /**
     * 复制源文件夹下所有文件到目标文件夹
     * 多线程并行复制
     * @param sourcePath
     * @param destPath
     */
    public void copyFilesParallel(String sourcePath,String destPath) {
        File srcFolder = new File(sourcePath);
        //如果源文件夹路径不存在返回
        if(!srcFolder.exists()){
            log.info("源文件路径不存在.");
            return ;
        }
        if(!srcFolder.isDirectory()){
            log.info("源文件路径需要是文件夹.");
            return ;
        }
        File destFolder = new File(destPath);
        if (!destFolder.exists()){
            log.info("目标文件路径不存在,新建文件夹.");
            destFolder.mkdir();
        }
        //过滤出所有文件，不包括文件夹
        List<File> files = Arrays.stream(srcFolder.listFiles())
                .filter(file -> !file.isDirectory())
                .collect(Collectors.toList());
        int nums = files.size();
        CountDownLatch count = new CountDownLatch(nums);
        int cpuCores = Runtime.getRuntime().availableProcessors();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(cpuCores);
        files.stream().map(file ->
            fixedThreadPool.submit(new FileCopyTask(file,destFolder,count) )
        ).collect(Collectors.toList());
        try {
            //计数器5分钟过期失效
            count.await(5,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("目标文件并行复制成功.");
        fixedThreadPool.shutdown();
    }

    /**
     * 内部文件复制任务类
     */
    private class FileCopyTask implements Runnable{
        private File sourceFile;
        private File destFolder;
        private CountDownLatch count;

        public FileCopyTask(File sourceFile, File destFolder, CountDownLatch count) {
            this.sourceFile = sourceFile;
            this.destFolder = destFolder;
            this.count = count;
        }

        @Override
        public void run() {
            String fileName = sourceFile.getName();
            long size = sourceFile.length()/1024+1;
            long start = System.currentTimeMillis();
            bigFileBufferStreamCopy(sourceFile,new File(destFolder+File.separator+fileName));
            long end = System.currentTimeMillis();
            log.info("复制文件[{}],大小:{}KB,耗时:{}ms",fileName,size,(end-start));
            count.countDown();
        }
    }


}
