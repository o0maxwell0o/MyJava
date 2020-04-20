package com.maxwell.test;

import java.io.File;
import java.io.IOException;

public class InputOutput {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        // BufferedReader Input
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input");
        String c;
        do {
            c = br.readLine();
            System.out.println(c);
        } while (!c.equals("end"));
        System.out.println("exit");
         */
        // InputStream,OutputStream
        /*
        InputStream is = new FileInputStream("D:\\IdeaProjects\\MyJava\\testdata\\readtest.txt");
        //File file = new File("D:\\IdeaProjects\\MyJava\\testdata\\readtest.txt");
        //InputStream in = new FileInputStream(file);
        OutputStream os = new FileOutputStream("D:\\IdeaProjects\\MyJava\\testdata\\readtest.txt");
        //File file = new File("D:\\IdeaProjects\\MyJava\\testdata\\readtest.txt");
        //OutputStream out = new FileOutputStream(file);
         */
        // 先写入到文件然后读取
        /*
        byte bWrite[] = {11, 21, 3, 40, 5};
        OutputStream os = new FileOutputStream("test.txt");
        for (int x = 0; x < bWrite.length; x++) {
            os.write(bWrite[x]); // writes the bytes
        }
        os.close();

        InputStream is = new FileInputStream("D:\\IdeaProjects\\MyJava\\testdata\\readtest.txt");
        int size = is.available();

        for (int i = 0; i < size; i++) {
            System.out.print((char) is.read());
        }
        is.close();
         */
        // 创建文件夹
        /*
        File d = new File("D:\\IdeaProjects\\MyJava\\testdir\\1");
        System.out.println(d.mkdir());
          */
        // 读取文件夹下的目录
        File d = new File("D:\\IdeaProjects\\MyJava");
        if (d.isDirectory()) {
            System.out.println("目录" + "\\MyJava");
            String s[] = d.list();
            for (String dir : s) {
                File f = new File("D:\\IdeaProjects\\MyJava" + "\\" + dir);
                if (f.isDirectory()) {
                    System.out.println(dir + " 是文件夹");
                } else {
                    System.out.println(dir + " 是文件");
                }
            }
        }

    }


}

