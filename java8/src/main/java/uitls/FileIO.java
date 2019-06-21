package uitls;

import java.io.*;

/**
 * Java重新实现的一些文件I-O原语
 *
 * @author dengguoqing
 * @date 2019/6/19
 */
public class FileIO {

    /**
     * 块大小
     */
    private static final int BLOCK_SIZE = 16384;

    private FileIO() {
    }

    /**
     * 将文件从一个文件复制到另一个
     *
     * @param inName  被复制文件文件名
     * @param outName 复制文件文件名
     */
    public static void copyFile(String inName, String outName) {
        try (BufferedInputStream is = new BufferedInputStream(
                new FileInputStream(inName));
             BufferedOutputStream os = new BufferedOutputStream(
                     new FileOutputStream(outName))) {
            copyFile(is, os, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从打开的inputStream流复制文件到打开的outputStream
     *
     * @param is    inputStream流
     * @param os    outputStream流
     * @param close 关闭文件
     * @return void
     * @author dengguoqing
     * @date 2019/6/19
     * @since 1.0
     */
    public static void copyFile(BufferedInputStream is, BufferedOutputStream os,
                                boolean close) throws IOException {
        byte[] b = new byte[BLOCK_SIZE];
        int i;
        while ((i = is.read(b)) != -1) {
            os.write(b, 0, i);
        }
        is.close();
        if (close) {
            os.close();
        }
    }


}
