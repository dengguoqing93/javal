package io;

import java.io.File;

/**
 * 目录列表
 *
 * @author dengguoqing
 * @date 2019/6/23
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list = new String[0];
        if (args.length == 0) {
            list = path.list();
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
