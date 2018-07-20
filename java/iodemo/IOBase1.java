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
		//获取file信息
		fileInfo();
		//获取过滤后的文件/目录
		fileFilterName();
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
	
	//获取file信息
	public static void fileInfo() {
		//创建file对象
		File file1 = new File("E:\\public_project\\java_project\\files\\test.txt");
		File file2 = new File("E:\\public_project\\java_project\\files\\haha");
		
		//获取file路径
		System.out.println(file1.getPath());
		//获取file名字
		System.out.println(file1.getName());
		//获取file绝对路径
		System.out.println(file1.getAbsolutePath());
		//获取file字节长度
		System.out.println(file1.length());
		//获取file最后一次修改的时间
		System.out.println(file1.lastModified());
		
		//获取file当前目录下的 “所有” 文件和子目录（文件名和目录名），返回一个数组
		String[] filearr1 =  file2.list();
		System.out.println("————————————————————————————");
		for(String a:filearr1) {
			System.out.println(a);
		}
		
		//获取file当前目录下的 “指定” 后辍结尾的文件，返回一个数组
		String[] filearrNew1 =  file2.list();
		System.out.println("——————————————方法一，拿到文件名字——————————————");
		for(String a:filearrNew1) {
			//判断如果是以.txt结尾，取出
			if(a.endsWith(".txt")) {
				System.out.println(a);
			}
		}
		
		File[] filearrNew2 =  file2.listFiles();
		System.out.println("——————————————方法二，拿到文件路径+文件名+后辍，这种常用——————————————");
		for(File a:filearrNew2) {
			//判断如果是文件，并且是以.txt结尾，取出
			if(a.isFile() && a.getName().endsWith(".txt")) {
				System.out.println(a);
			}
		}
		
		//获取file当前目录下的所有文件和子目录（文件对象和目录对象），返回一个file数组
		File[] filearr2 =  file2.listFiles();
		System.out.println("————————————————————————————");
		for(File a:filearr2) {
			System.out.println(a);
		}
		System.out.println("————————————————————————————");
		
		//返回此抽象路径名的分区中的未分配的字节数
		System.out.println(file1.getFreeSpace());
		//返回父目录的路径名字符串命名此抽象路径名，或如果路径名没有指定父目录则为null
		System.out.println(file1.getParent());
		//返回此抽象路径名的分区的大小
		System.out.println(file1.getTotalSpace());
		//返回该分区上的可用的字节数
		System.out.println(file1.getUsableSpace());
	}
	
	//获取过滤后的文件/目录
	public static void fileFilterName() {
		File file1 = new File("E:\\public_project\\java_project\\files\\haha");
		String[] arr = file1.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir,String name) {
				//打印出路径
				//System.out.println(dir);
				//打印出名称
				//System.out.println(name);
				
				//封装成对象，后续可以进行过滤
				File ff = new File(dir,name); 
				
				//返回是文件，且后辍为.txt的文件
				return ff.isFile() && ff.getName().endsWith(".txt");
			}
		});
		
		System.out.println("——————————————过滤后的文件及目录——————————————");
		for(String a:arr) {
			System.out.println(a);
		}
		
	}
	
}
