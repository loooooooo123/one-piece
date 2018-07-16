package iodemo;

import java.io.*;
import java.nio.charset.Charset;

import utils.UnicodeReader;

//io����
public class ioDemo1 {

	public static void main(String[] args) throws IOException {

		// ��ȡ����̨��������
		// getConsoleInput();

		// �ļ�д��������ַ���ģʽ
		WriteByteFromFile();

		// �ļ���ȡ�������ַ���ģʽ
		readCharFromFile();
		
		//����IO����
		fileDemo1();
		
		readByBufferedInputStream();

	}

	// ��ȡ����̨��������
	public static void getConsoleInput() throws IOException {
		char c;
		// ʹ�� System.in ���� BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����ַ�, ���� 'q' ���˳���");
		// ��ȡ�ַ�
		do {
			c = (char) br.read();
			System.out.println(c);
		} while (c != 'q');
	}

	// �ļ�д��������ַ���ģʽ
	public static void WriteByteFromFile() throws IOException {
		String hello = new String("hello word! ����һ�����ĵ�");
		File file = new File("E:/public_project/java_project/files/test.txt");
		// ��Ϊ�����ַ�������ý�飬���Զ�Ӧ����Writer������Ϊý��������ļ��������õ�������FileWriter
		Writer os = new FileWriter(file);
		os.write(hello);
		os.close();
	}

	// �ļ���ȡ������ʹ�÷�װ�Ķ�ȡ�ַ���
	public static void readCharFromFile() throws IOException {
		File f = new File("E:/public_project/java_project/files/test2.txt");
		FileInputStream in = new FileInputStream(f);
		// ָ����ȡ�ļ�ʱ��UTF-8�ĸ�ʽ��ȡ
		BufferedReader br = new BufferedReader(
				new UnicodeReader(new FileInputStream(f), Charset.defaultCharset().name()));

		String line = br.readLine();
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}
	}

	//����IO����
	public static void fileDemo1() {
		// ����ļ��Ƿ����
		File file = new File("E:/public_project/java_project/files/test.txt");
		boolean fileExists = file.exists();
		System.out.println("����ļ��Ƿ����"+fileExists);
		
		// �����ļ�Ŀ¼,����Ŀ¼�������򷵻�false
		File file2 = new File("E:/public_project/java_project/files/newproject");
		boolean dirCreated = file2.mkdir();
		System.out.println("�����ļ�Ŀ¼"+dirCreated);
		
		// �����ļ�Ŀ¼,����Ŀ¼��������ͬ��Ŀ¼һ�𴴽�
		File file3 = new File("E:/public_project/java_project/files/subproject/newproject2");
		boolean dirCreated2 = file3.mkdirs();
		System.out.println("�����ļ�Ŀ¼����Ŀ¼�������Զ�����"+dirCreated2);
		
		
		File file4 = new File("E:/public_project/java_project/files/test.txt");
		// �жϳ���
		long length = file4.length();
		if(length<10) {
			System.out.println("�ļ�����С��10");
		}
		
		// �������ļ�
		File redfile1 = new File("E:/public_project/java_project/files/test3.txt");
		boolean isRenamed = redfile1.renameTo(new File("E:/public_project/java_project/files/test_new.txt"));
		
		// ɾ���ļ�
		File redfile2 = new File("E:/public_project/java_project/files/test4.txt");
		boolean isDeleted = redfile2.delete();
		
		// �Ƿ���Ŀ¼
		File file5 = new File("E:/public_project/java_project/files");
		boolean isDirectory = file5.isDirectory();
		
		// �г��ļ���
		String[] fileNames = file5.list();
		for(String a:fileNames) {
			System.out.println(a);
		}
		
		
		// �г�Ŀ¼
		File[] files = file5.listFiles();
		for(File b:files) {
			System.out.println(b);
		}
		
		
	}
	
	//ʹ�û�������ȡ�ļ�
	 public static void readByBufferedInputStream() throws IOException {
	        File file = new File( "E:/public_project/java_project/files/test.txt");
	         byte[] byteArray = new byte[( int) file.length()];
	         //�����ڹ�������д���buffer��С
	        InputStream is = new BufferedInputStream( new FileInputStream(file),2*1024);
	         int size = is.read( byteArray);
	        System. out.println( "��С:" + size + ";����:" + new String(byteArray));
	         is.close();
	  }

}

/*
 * ������£�

aa,wahaha
����ļ��Ƿ����true
�����ļ�Ŀ¼false
�����ļ�Ŀ¼����Ŀ¼�������Զ�����false
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
