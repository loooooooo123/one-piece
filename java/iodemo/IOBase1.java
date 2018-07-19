package iodemo;
import java.io.*;

//io��file����
public class IOBase1 {

	public static void main(String[] args) throws IOException {
		//��ȡfile�ļ���ֱ��ȫ·����ʽ
		fileFn();
		//��ȡfile�ļ���Ŀ¼+�ļ�����ʽ
		fileFn2();
		//�����ļ�������ļ��Ƿ���ڣ�����������Զ�����
		fileIsTrue();
		//����Ŀ¼�����Ŀ¼�Ƿ���ڣ�����������Զ�����
		fileMdk();
		//����Ŀ¼��������ļ��ĸ�Ŀ¼�Ƿ���ڣ�����������Զ�����
		fileNewMdk();
		//�ļ�������
		fileResetName();
		//ɾ���ļ�
		fileDel();
		//�ļ�Ŀ¼�ж�
		fileRex();
	}
	
	//��ȡfile�ļ���ֱ��ȫ·����ʽ
	public static void fileFn() {
		File file1 = new File("E:\\public_project\\java_project\\files\\test.txt");
		
		//����ļ��Ƿ����
		System.out.println(file1.exists());
	}
	
	//��ȡfile�ļ���Ŀ¼+�ļ�����ʽ
	public static void fileFn2() {
		String fileUrl = "E:\\public_project\\java_project\\files";
		String fileName = "test.txt";
		File file1 = new File(fileUrl,fileName);
		
		//����ļ��Ƿ����
		System.out.println(file1.exists());
	}
	
	//�����ļ�������ļ��Ƿ���ڣ�����������Զ�����
	public static void fileIsTrue() throws IOException {
		File file1 = new File("E:\\public_project\\java_project\\files\\testa.txt");
		//false��ʾ�ļ�����
		System.out.println(file1.createNewFile());
	}
	
	//����Ŀ¼�����Ŀ¼�Ƿ���ڣ�����������Զ�����
	public static void fileMdk() {
		File file1 = new File("E:\\public_project\\java_project\\files\\testa");
		//false��ʾĿ¼����
		System.out.println(file1.mkdir());
	}

	//����Ŀ¼��������ļ��ĸ�Ŀ¼�Ƿ���ڣ�����������Զ�����
	public static void fileNewMdk() {
		File file1 = new File("E:\\public_project\\java_project\\files\\testb\\testbb");
		//false��ʾĿ¼����
		System.out.println(file1.mkdirs());
	}

	//�ļ�������
	public static void fileResetName() {
		File file1 = new File("E:\\public_project\\java_project\\files\\testa.txt");
		File file2 = new File("E:\\public_project\\java_project\\files\\testa2.txt");
		//false��ʾĿ¼����
		String newname = "testNew2.txt";
		System.out.println(file1.renameTo(file2));
	}
	
	//ɾ���ļ���Ŀ¼��ע��ɾ�����߻���վ���ұ�ɾĿ¼����ʱ�յģ�������ļ�����ô������ɾ��ȫ���ļ������ɾ��Ŀ¼
	public static void fileDel() {
		//ɾ�ļ�
		File file1 = new File("E:\\public_project\\java_project\\files\\testa2.txt");
		System.out.println(file1.delete());
		//ɾĿ¼
		File file2 = new File("E:\\public_project\\java_project\\files\\testb\\testbb");
		System.out.println(file2.delete());
	}
	
	//�ļ�Ŀ¼�ж�
	public static void fileRex() {
		//ɾ�ļ�
		File file1 = new File("E:\\public_project\\java_project\\files\\test.txt");
		
		System.out.println("��������������������������������������������");
		
		//�Ƿ�ΪĿ¼
		System.out.println(file1.isDirectory());
		//�Ƿ�Ϊ�ļ�
		System.out.println(file1.isFile());
		//�Ƿ�Ϊ����
		System.out.println(file1.exists());
		//�Ƿ�Ϊ�ɶ�
		System.out.println(file1.canRead());
		//�Ƿ�Ϊ��д
		System.out.println(file1.canWrite());
		//�Ƿ�Ϊ����
		System.out.println(file1.isHidden());
	}
}
