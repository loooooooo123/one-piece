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
		
		//其他IO操作
		fileDemo1();
		
		readByBufferedInputStream();

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
		File f = new File("E:/public_project/java_project/files/test2.txt");
		FileInputStream in = new FileInputStream(f);
		// 指定读取文件时以UTF-8的格式读取
		BufferedReader br = new BufferedReader(
				new UnicodeReader(new FileInputStream(f), Charset.defaultCharset().name()));

		String line = br.readLine();
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}
	}

	//其他IO操作
	public static void fileDemo1() {
		// 检查文件是否存在
		File file = new File("E:/public_project/java_project/files/test.txt");
		boolean fileExists = file.exists();
		System.out.println("检查文件是否存在"+fileExists);
		
		// 创建文件目录,若父目录不存在则返回false
		File file2 = new File("E:/public_project/java_project/files/newproject");
		boolean dirCreated = file2.mkdir();
		System.out.println("创建文件目录"+dirCreated);
		
		// 创建文件目录,若父目录不存则连同父目录一起创建
		File file3 = new File("E:/public_project/java_project/files/subproject/newproject2");
		boolean dirCreated2 = file3.mkdirs();
		System.out.println("创建文件目录，父目录不存在自动创建"+dirCreated2);
		
		
		File file4 = new File("E:/public_project/java_project/files/test.txt");
		// 判断长度
		long length = file4.length();
		if(length<10) {
			System.out.println("文件内容小于10");
		}
		
		// 重命名文件
		File redfile1 = new File("E:/public_project/java_project/files/test3.txt");
		boolean isRenamed = redfile1.renameTo(new File("E:/public_project/java_project/files/test_new.txt"));
		
		// 删除文件
		File redfile2 = new File("E:/public_project/java_project/files/test4.txt");
		boolean isDeleted = redfile2.delete();
		
		// 是否是目录
		File file5 = new File("E:/public_project/java_project/files");
		boolean isDirectory = file5.isDirectory();
		
		// 列出文件名
		String[] fileNames = file5.list();
		for(String a:fileNames) {
			System.out.println(a);
		}
		
		
		// 列出目录
		File[] files = file5.listFiles();
		for(File b:files) {
			System.out.println(b);
		}
		
		
	}
	
	//使用缓冲流读取文件
	 public static void readByBufferedInputStream() throws IOException {
	        File file = new File( "E:/public_project/java_project/files/test.txt");
	         byte[] byteArray = new byte[( int) file.length()];
	         //可以在构造参数中传入buffer大小
	        InputStream is = new BufferedInputStream( new FileInputStream(file),2*1024);
	         int size = is.read( byteArray);
	        System. out.println( "大小:" + size + ";内容:" + new String(byteArray));
	         is.close();
	  }

}

/*
 * 输出如下：

aa,wahaha
检查文件是否存在true
创建文件目录false
创建文件目录，父目录不存在自动创建false
newproject
subproject
test.txt
test2.txt
test_new.txt
E:\public_project\java_project\files\newproject
E:\public_project\java_project\files\subproject
E:\public_project\java_project\files\test.txt
E:\public_project\java_project\files\test2.txt
E:\public_project\java_project\files\test_new.txt

 * 
 * */
