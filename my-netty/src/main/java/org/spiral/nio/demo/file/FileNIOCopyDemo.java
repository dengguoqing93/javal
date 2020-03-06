package org.spiral.nio.demo.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel完成文件复制
 *
 * @author dengguoqing
 * @date 2019/11/17
 */
public class FileNIOCopyDemo {

    private static final Logger log = LoggerFactory.getLogger(FileNIOCopyDemo.class);

    public static void main(String[] args) {
        nioCopyResourceFile();

    }

    /**
     * 复制两个资源目录下的文件
     */
    private static void nioCopyResourceFile() {
        String srcPath = "/Users/dengguoqing/IdeaProjects/javal/my-netty/src/main/resources/test.txt";
        log.info("srcPath:{}", srcPath);

        String destPath = "/Users/dengguoqing/IdeaProjects/javal/my-netty/src/main/resources/test1.txt";
        log.info("destPath:{}", destPath);

        nioCopyFile(srcPath, destPath);


    }

    /**
     * nio方式复制文件
     *
     * @param srcPath  源文件路径
     * @param destPath 目标文件路径
     * @return void
     * @author dengguoqing
     * @date 2019/11/17
     * @since 1.0
     */
    private static void nioCopyFile(String srcPath, String destPath) {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        try {
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            long startTime = System.currentTimeMillis();
            try (FileInputStream fis = new FileInputStream(srcFile);
                 FileOutputStream fos = new FileOutputStream(destFile);
                 FileChannel inChannel = fis.getChannel();
                 FileChannel outChannel = fos.getChannel()) {
                int length = -1;
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while ((length = inChannel.read(buffer)) != -1) {
                    buffer.flip();
                    int outLength = 0;
                    while ((outLength = outChannel.write(buffer)) != 0) {
                        System.out.println("写入的字节数： " + outLength);
                    }
                    buffer.clear();
                }
                outChannel.force(true);
            }
            long endTime = System.currentTimeMillis();
            log.info("base复制毫秒数:{}", endTime - startTime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
