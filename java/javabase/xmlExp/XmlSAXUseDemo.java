package xmlExp;

import java.io.*;
import javax.xml.parsers.*;

//ʹ���Զ����XmlSAXDemo������
public class XmlSAXUseDemo {

	public static void main(String args[]) throws Exception {
		// ����SAX��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// ʵ������������
		SAXParser parser = factory.newSAXParser();
		// ��ȡXML
		parser.parse("E:\\public_project\\java_project\\xml\\demo2.xml", new XmlSAXDemo());
	}

}
