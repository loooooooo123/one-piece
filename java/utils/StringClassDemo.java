package utils;

//�ַ���������
public class StringClassDemo {

	static String str1 = "Hello World";
	static String str2 = "Come on Baby";
	static String strNew1 = " chi ji ";

	public static void main(String[] args) {

		// �ж�2���ַ����Ƿ����
		str1.equals(str2);

		// �ַ���ת����
		for (char a : str1.toCharArray()) {
			System.out.println(a);
		}

		// ��ȡָ���±괦�ַ�
		System.out.println(str2.charAt(2));

		// ��str1ת��Ϊ��������
		byte b[] = str1.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]); // ѭ�����b[]��ÿ��Ԫ��
		}

		// �ٽ���������ת��Ϊ�ַ�����ת��5��
		String str3 = new String(b, 0, 5);
		System.out.println(str3);

		// ȡ���ַ�������
		System.out.println(str1.length());

		// ����ָ���ַ����±�ֵ����ǰ�����ҵ�һ�γ��ֵģ��±�ֵ��0��ʼ
		System.out.println(str1.indexOf('o'));

		// ����ָ���ַ����±�ֵ���Ӻ���ǰ�ҵ�һ�γ��ֵģ��±�ֵ��0��ʼ
		System.out.println(str1.lastIndexOf('o'));

		// ��ȡָ���±귶Χ�ڵ��ַ��������������±괦���ַ�
		System.out.println(str1.substring(1, 3));

		// ȥ����β�ո�
		System.out.println(strNew1.trim());

		// �ַ������Ϊ���飬�Կո���
		String strSp1[] = str2.split(" ");
		for (int i = 0; i < strSp1.length; i++) {
			System.out.println(strSp1[i]); // ѭ�������ֺ���ַ�������ÿ��Ԫ��
		}

		// �ַ���ת��Сд
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());

		// �ж��Ƿ���ָ���ַ���ͷ
		System.out.println(str1.startsWith("H") ? "����H��ͷ" : "����H��ͷ");
		System.out.println(str1.endsWith("a") ? "����a��β" : "����a��β");

		// �ж�2���ַ����Ƿ���ȣ������ִ�Сд
		System.out.println(str1.equalsIgnoreCase("hello world") ? "���" : "�����");

		// �滻�ַ�
		System.out.println(str2.replace('C', 'c'));

		// ���ַ�����β��׷���ַ����˷�����׷�Ӷ���һ��Ҫ��ʵ����ΪStringBuilder���ַ�������ſ���ʹ��
		StringBuilder bd1 = new StringBuilder("hello");
		System.out.println(bd1.append(" world"));

		// ���ַ���ָ���±괦׷���ַ����˷�����׷�Ӷ���һ��Ҫ��ʵ����ΪStringBuilder���ַ�������ſ���ʹ��
		StringBuilder newbd1 = new StringBuilder("haha");
		System.out.println(newbd1.insert(2, " a "));

		// ɾ��ָ���±귶Χ�ڵ��ַ����˷�����׷�Ӷ���һ��Ҫ��ʵ����ΪStringBuilder���ַ�������ſ���ʹ��
		StringBuilder bd2 = new StringBuilder(str1);
		System.out.println(bd2.delete(0, 3));
		
		// ʹ��split��ת�ַ��������������ַ�����
		System.out.println(split_str(str1));
		
		// ʹ��charAt��ת�ַ��������������ַ�����
		System.out.println(charAt_str(str2));
	}

	// ʹ��split��ת�ַ��������������ַ�����
	private static String split_str(String str) {
		String str2[] = str.split(""); // ��ȡ�ַ���
		String newStr = ""; // ��ʼ��һ���ַ�������
		int len = str2.length; // ��ȡ��ȡ����ַ�������
		for (int i = len - 1; i >= 0; i--) {
			newStr += str2[i]; // newStr�ַ�������ÿ��str2[i]��ֵ���
		}
		return newStr; // ��������newStr
	}

	// ʹ��charAt��ת�ַ��������������ַ�����
	private static String charAt_str(String str) {
		String newStr = ""; // ��ʼ��һ���ַ�������
		int len = str.length(); // ��ȡ��ȡ����ַ�������
		for (int i = len - 1; i >= 0; i--) {
			// newStr�ַ�������ÿ��charAt[i]��ֵ���
			newStr += str.charAt(i);
		}
		return newStr; // ��������newStr
	}

}
