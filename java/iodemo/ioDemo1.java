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
		File f  = new File("E:/public_project/java_project/files/test2.txt");  
        FileInputStream in = new FileInputStream(f);  
        // ָ����ȡ�ļ�ʱ��UTF-8�ĸ�ʽ��ȡ  
        BufferedReader br = new BufferedReader(new UnicodeReader(new FileInputStream(f), Charset.defaultCharset().name()));
          
        String line = br.readLine();  
        while(line != null)  
        {  
            System.out.println(line);  
            line = br.readLine();  
        }  
	}

}
