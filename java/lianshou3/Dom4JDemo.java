package lianshou3;

import java.io.* ;
import java.util.Iterator;

import org.dom4j.* ;
import org.dom4j.io.* ;

/*
 * ���ɫ�Ľ���XML�ĵ���DOM4J���
 * 
 * DOM4J�ṩ�Ľӿ���JDOM�ṩ����������ƣ��ӿ����£�
  ��1�� Attribute�ӿڣ�������XML�����ԡ�
  ��2�� Branch�ӿڣ�����XMLԪ��Element��Documentһ����������Ϊ��
  ��3�� CDATA�ӿڣ�������XML CDATA����
  ��4�� CharachterData�ӿڣ���ʶ�ӿڣ���ʶ�����ַ��Ľڵ㣬��CDATA��Comment��Text��
  ��5�� Comment�ӿڣ�������XML��ע�͡�
  ��6�� Document�ӿڣ�������XML�ĵ���
  ��7�� Element�ӿڣ�������XMLԪ�ء�
  ��8�� Text�ӿڣ�������XML�ı��ڵ㡣
 *
 * */
public class Dom4JDemo {

	public static void main(String[] args) throws DocumentException, IOException {

		// ��ȡXML
		readXml();

		// ����XML
		createXml();
		
	}

	// ��ȡXML
	public static void readXml() throws DocumentException {
		// ��ȡxml�ļ�
		File file = new File("E:\\public_project\\java_project\\xml\\demo3.xml");
		SAXReader reader = new SAXReader(); // ʵ����SAX������ȡ��
		Document doc = reader.read(file); // ��ȡXML�ļ�
		// ȡ�ø��ڵ㣬JDOM������ʱ����Ҫȡ�ø��ڵ�
		Element root = doc.getRootElement();
		// ����Ӧ�ø��ݸ��ڵ��ҵ�ȫ�����ӽڵ㣬linkman
		Iterator iter = root.elementIterator();
		while (iter.hasNext()) {
			Element linkman = (Element) iter.next();
			System.out.println("������" + linkman.elementText("name"));
			System.out.println("�ʼ���" + linkman.elementText("email"));
		}
	}

	// ����XML
	public static void createXml() throws DocumentException, IOException {
		// �����ĵ�
		Document doc = DocumentHelper.createDocument();
		// ����addresslist���ڵ�
		Element addresslist = doc.addElement("addresslist");
		// ����linkman�ӽڵ�
		Element linkman = addresslist.addElement("linkman");
		// ����name�ӽڵ�
		Element name = linkman.addElement("name");
		// ����email�ӽڵ�
		Element email = linkman.addElement("email");
		// ����name�ڵ������
		name.setText("�۹���");
		email.setText("wahaha@163.com "); // ����email�ڵ������
		// ���������ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		// �������ʱ�ı���
		format.setEncoding("GBK");
		// ����ļ�
		XMLWriter writer = new XMLWriter(new FileOutputStream(new File("E:\\public_project\\java_project\\xml\\demo6.xml")), format);
		writer.write(doc); // �������
		writer.close(); // �ر������
	}

}
