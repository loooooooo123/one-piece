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
		//��ȡfile��Ϣ
		fileInfo();
		//��ȡ���˺���ļ�/Ŀ¼
		fileFilterName();
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
	
	//��ȡfile��Ϣ
	public static void fileInfo() {
		//����file����
		File file1 = new File("E:\\public_project\\java_project\\files\\test.txt");
		File file2 = new File("E:\\public_project\\java_project\\files\\haha");
		
		//��ȡfile·��
		System.out.println(file1.getPath());
		//��ȡfile����
		System.out.println(file1.getName());
		//��ȡfile����·��
		System.out.println(file1.getAbsolutePath());
		//��ȡfile�ֽڳ���
		System.out.println(file1.length());
		//��ȡfile���һ���޸ĵ�ʱ��
		System.out.println(file1.lastModified());
		
		//��ȡfile��ǰĿ¼�µ� �����С� �ļ�����Ŀ¼���ļ�����Ŀ¼����������һ������
		String[] filearr1 =  file2.list();
		System.out.println("��������������������������������������������������������");
		for(String a:filearr1) {
			System.out.println(a);
		}
		
		//��ȡfile��ǰĿ¼�µ� ��ָ���� ��꡽�β���ļ�������һ������
		String[] filearrNew1 =  file2.list();
		System.out.println("��������������������������������һ���õ��ļ����֡���������������������������");
		for(String a:filearrNew1) {
			//�ж��������.txt��β��ȡ��
			if(a.endsWith(".txt")) {
				System.out.println(a);
			}
		}
		
		File[] filearrNew2 =  file2.listFiles();
		System.out.println("�������������������������������������õ��ļ�·��+�ļ���+��ꡣ����ֳ��á���������������������������");
		for(File a:filearrNew2) {
			//�ж�������ļ�����������.txt��β��ȡ��
			if(a.isFile() && a.getName().endsWith(".txt")) {
				System.out.println(a);
			}
		}
		
		//��ȡfile��ǰĿ¼�µ������ļ�����Ŀ¼���ļ������Ŀ¼���󣩣�����һ��file����
		File[] filearr2 =  file2.listFiles();
		System.out.println("��������������������������������������������������������");
		for(File a:filearr2) {
			System.out.println(a);
		}
		System.out.println("��������������������������������������������������������");
		
		//���ش˳���·�����ķ����е�δ������ֽ���
		System.out.println(file1.getFreeSpace());
		//���ظ�Ŀ¼��·�����ַ��������˳���·�����������·����û��ָ����Ŀ¼��Ϊnull
		System.out.println(file1.getParent());
		//���ش˳���·�����ķ����Ĵ�С
		System.out.println(file1.getTotalSpace());
		//���ظ÷����ϵĿ��õ��ֽ���
		System.out.println(file1.getUsableSpace());
	}
	
	//��ȡ���˺���ļ�/Ŀ¼
	public static void fileFilterName() {
		File file1 = new File("E:\\public_project\\java_project\\files\\haha");
		String[] arr = file1.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir,String name) {
				//��ӡ��·��
				//System.out.println(dir);
				//��ӡ������
				//System.out.println(name);
				
				//��װ�ɶ��󣬺������Խ��й���
				File ff = new File(dir,name); 
				
				//�������ļ����Һ��Ϊ.txt���ļ�
				return ff.isFile() && ff.getName().endsWith(".txt");
			}
		});
		
		System.out.println("�������������������������������˺���ļ���Ŀ¼����������������������������");
		for(String a:arr) {
			System.out.println(a);
		}
		
	}
	
}
