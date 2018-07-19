package iodemo;
import java.io.*;

//io的file基础
public class IOBase1 {

	public static void main(String[] args) throws IOException {
		//获取file文件，直接全路径形式
		fileFn();
		//获取file文件，目录+文件名形式
		fileFn2();
		//创建文件，检测文件是否存在，如果不存在自动创建
		fileIsTrue();
		//创建目录，检测目录是否存在，如果不存在自动创建
		fileMdk();
		//创建目录，并检测文件的父目录是否存在，如果不存在自动创建
		fileNewMdk();
		//文件重命名
		fileResetName();
		//删除文件
		fileDel();
		//文件目录判断
		fileRex();
	}
	
	//获取file文件，直接全路径形式
	public static void fileFn() {
		File file1 = new File("E:\\public_project\\java_project\\files\\test.txt");
		
		//检测文件是否存在
		System.out.println(file1.exists());
	}
	
	//获取file文件，目录+文件名形式
	public static void fileFn2() {
		String fileUrl = "E:\\public_project\\java_project\\files";
		String fileName = "test.txt";
		File file1 = new File(fileUrl,fileName);
		
		//检测文件是否存在
		System.out.println(file1.exists());
	}
	
	//创建文件，检测文件是否存在，如果不存在自动创建
	public static void fileIsTrue() throws IOException {
		File file1 = new File("E:\\public_project\\java_project\\files\\testa.txt");
		//false表示文件存在
		System.out.println(file1.createNewFile());
	}
	
	//创建目录，检测目录是否存在，如果不存在自动创建
	public static void fileMdk() {
		File file1 = new File("E:\\public_project\\java_project\\files\\testa");
		//false表示目录存在
		System.out.println(file1.mkdir());
	}

	//创建目录，并检测文件的父目录是否存在，如果不存在自动创建
	public static void fileNewMdk() {
		File file1 = new File("E:\\public_project\\java_project\\files\\testb\\testbb");
		//false表示目录存在
		System.out.println(file1.mkdirs());
	}

	//文件重命名
	public static void fileResetName() {
		File file1 = new File("E:\\public_project\\java_project\\files\\testa.txt");
		File file2 = new File("E:\\public_project\\java_project\\files\\testa2.txt");
		//false表示目录存在
		String newname = "testNew2.txt";
		System.out.println(file1.renameTo(file2));
	}
	
	//删除文件或目录，注意删除后不走回收站，且被删目录必须时空的，如果有文件，那么必须先删除全部文件后才能删除目录
	public static void fileDel() {
		//删文件
		File file1 = new File("E:\\public_project\\java_project\\files\\testa2.txt");
		System.out.println(file1.delete());
		//删目录
		File file2 = new File("E:\\public_project\\java_project\\files\\testb\\testbb");
		System.out.println(file2.delete());
	}
	
	//文件目录判断
	public static void fileRex() {
		//删文件
		File file1 = new File("E:\\public_project\\java_project\\files\\test.txt");
		
		System.out.println("——————————————————————");
		
		//是否为目录
		System.out.println(file1.isDirectory());
		//是否为文件
		System.out.println(file1.isFile());
		//是否为存在
		System.out.println(file1.exists());
		//是否为可读
		System.out.println(file1.canRead());
		//是否为可写
		System.out.println(file1.canWrite());
		//是否为隐藏
		System.out.println(file1.isHidden());
	}
}
