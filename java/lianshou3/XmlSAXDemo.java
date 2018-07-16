package lianshou3;

//SAX���ν�����SAXֻ�ܶ�XML�������޸�XML
import org.xml.sax.*;
import org.xml.sax.helpers.*; //������Ӧ�İ�����

public class XmlSAXDemo extends DefaultHandler {
	// �ĵ���ʼ�¼�
	public void startDocument() throws SAXException {
		System.out.println("<?xml version=\"1.0\" encoding=\"GBK\">");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { // Ԫ�ؿ�ʼ�¼�
		System.out.print("<");
		System.out.print(qName);
		if (attributes != null) { // �������������
			for (int x = 0; x < attributes.getLength(); x++) {
				System.out.print(" " + attributes.getQName(x) + "=\"" + attributes.getValue(x) + "\"");
			}
		}
		System.out.print(">");
	}

	// Ԫ�ؽ����¼�
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("<");
		System.out.print(qName);
		System.out.print(">");
	}

	// Ԫ�������¼�
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch, start, length));
	}

	// �ĵ������¼�
	public void endDocument() throws SAXException {
		System.out.println("�ĵ�����������");
	}
}
