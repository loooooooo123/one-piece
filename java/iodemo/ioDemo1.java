package iodemo;

import java.io.*;
import java.nio.charset.Charset;

import utils.UnicodeReader;

//io操作
public class ioDemo1 {

	public static void main(String[] args) throws IOException {

		// 获取控制台输入内容
		// getConsoleInput();

		// 文件写入操作，字符流模式
		WriteByteFromFile();
		
		// 文件读取操作，字符流模式
		readCharFromFile();

	}

	// 获取控制台输入内容
	public static void getConsoleInput() throws IOException {
		char c;
		// 使用 System.in 创建 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入字符, 按下 'q' 键退出。");
		// 读取字符
		do {
			c = (char) br.read();
			System.out.println(c);
		} while (c != 'q');
	}

	// 文件写入操作，字符流模式
	public static void WriteByteFromFile() throws IOException {
		String hello = new String("hello word! 这是一个新文档");
		File file = new File("E:/public_project/java_project/files/test.txt");
		// 因为是用字符流来读媒介，所以对应的是Writer，又因为媒介对象是文件，所以用到子类是FileWriter
		Writer os = new FileWriter(file);
		os.write(hello);
		os.close();
	}

	// 文件读取操作，使用封装的读取字符类
	public static void readCharFromFile() throws IOException {
		File f  = new File("E:/public_project/java_project/files/test2.txt");  
        FileInputStream in = new FileInputStream(f);  
        // 指定读取文件时以UTF-8的格式读取  
        BufferedReader br = new BufferedReader(new UnicodeReader(new FileInputStream(f), Charset.defaultCharset().name()));
          
        String line = br.readLine();  
        while(line != null)  
        {  
            System.out.println(line);  
            line = br.readLine();  
        }  
	}

}
