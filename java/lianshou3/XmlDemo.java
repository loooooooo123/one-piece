package lianshou3;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * XML���÷�����
 * 
 * 1��Document�ӿڣ�
 * 
 * //��ȡxml�ĵ���ָ�����ƵĽڵ�
 * xml����.getElementByTagName("�ڵ�");        
 * 

 * //��xml�ĵ��д���һ��ָ�����ƵĽڵ㣬Ҳ��ͬʱ�׳�һ���쳣
 * xml����.createElement("�ڵ���");
 * 

 * //��xml�ĵ��д���һ��ָ���ı����ݵĽڵ�
 * xml����.createTextNode("�ı�����");
 * 

 * //��xml�ĵ���ĳ�ڵ��ϴ���һ��ָ�����Ƶ�����
 * xml����.createAttribute("������");

 * //��һ��xml�ڵ���󣬵��뵽��ǰxml�����У���������ֵΪtrueʱ�Եݹ������µ���
 * xml����.importNode(������xml�ڵ����,����ֵ);

 *  ע�⣺�����ӽڵ㣬Ϊfalseʱ�����뵱ǰ��ȡ���Ľڵ㡣

 * 2��Node�ӿڣ�
 * xml����.appendChild(�ڵ�����);
 * //���Ѵ����Ľڵ������xml��������Ҳ��ͬʱ�׳�һ���쳣

 * xml����.getChildNodes();
 * //ȡ�ñ��ڵ��µ�ȫ���ӽڵ�

 * xml����.getFirstChild();
 * //ȡ�ñ��ڵ��µĵ�һ���ӽڵ�

 * xml����.getLastChild();
 * //ȡ�ñ��ڵ��µ����һ���ӽڵ�

 * xml����.has ChildNodes();
 * //�ж��Ƿ�����ӽڵ�

 * xml����.has Attributes();
 * //�ж��Ƿ��������

 * xml����.getNodeValue();
 * //ȡ�ñ��ڵ�����ݣ�Ҳ��ͬʱ�׳�һ���쳣

 * 3��NodeList�ӿڣ�
 * xml����.getLength();
 * //ȡ�ñ��ڵ�ĸ���

 * xml����.item(�±�);
 * //ȡ�ñ��ڵ���ָ�������Ľڵ����
 * 
 */

//��ȡxml
public class XmlDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		// ��ȡһ��XML�ڵ�������
		oneXmlNode();
		
		// ��ȡ���XML�ڵ�������
		AllXmlNode();
		
	}

	// ��ȡһ��XML�ڵ�������
	public static void oneXmlNode() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// ȡ��DocumentBuilderFactory��Ķ���
		DocumentBuilder build = factory.newDocumentBuilder();
		// ȡ��DocumentBuilder��Ķ���
		Document doc = build.parse(new File("E:\\public_project\\java_project\\xml\\demo.xml"));
		// ����Document����·������ȡxml�ļ�
		NodeList nl = doc.getElementsByTagName("name");
		// ��get������ȡname���ƵĽڵ�
		System.out.println("������" + nl.item(0).getFirstChild().getNodeValue());
		// ����ڵ�
	}

	// ��ȡ���XML�ڵ�������
	public static void AllXmlNode() throws ParserConfigurationException, SAXException, IOException {
		// ȡ��DocumentBuilderFactory��Ķ���
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// ȡ��DocumentBuilder��Ķ���
		DocumentBuilder build = factory.newDocumentBuilder();

		// ����Document����·������ȡxml�ļ�
		Document doc = build.parse(new File("E:\\public_project\\java_project\\xml\\demo2.xml"));

		// �õ����е�linkman�ڵ�
		NodeList nl = doc.getElementsByTagName("linkman");

		// ȡ��ÿһ��Ԫ��
		for (int x = 0; x < nl.getLength(); x++) {
			Element e = (Element) nl.item(x);
			System.out.println("������" + e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
			System.out.println("���䣺" + e.getElementsByTagName("email").item(0).getFirstChild().getNodeValue());
		}
	}

}
