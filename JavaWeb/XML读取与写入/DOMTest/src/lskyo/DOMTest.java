package lskyo;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOMTest test = new DOMTest();
//		test.xmlParser();
		test.createXML();
	}
	
	
	public static DocumentBuilder getDocumentBuilder(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;
	}
	
	
	/**
	 * ����XML
	 */
	
	public static void addElement(Document document, Element rootNode, String name, String value){
		Element node = document.createElement(name);
		node.setTextContent(value);
		rootNode.appendChild(node);
	}
	
	public void createXML(){
		DocumentBuilder db = getDocumentBuilder();
		Document document = db.newDocument();
		document.setXmlStandalone(true);
		Element bookstore = document.createElement("bookstore");
		document.appendChild(bookstore);
		Element book = null;
		
		
		book = document.createElement("book");
		book.setAttribute("id", "1");
		addElement(document, book, "name", "С����");
		addElement(document, book, "author", "��������");
		addElement(document, book, "year", "1998");
		addElement(document, book, "price", "55");
		bookstore.appendChild(book);
		
		
		book = document.createElement("book");
		book.setAttribute("id", "2");
		addElement(document, book, "name", "��������������");
		addElement(document, book, "author", "������");
		addElement(document, book, "year", "2015");
		addElement(document, book, "price", "86");
		addElement(document, book, "language", "Chinese");
		bookstore.appendChild(book);
		
		
		
		
		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document), new StreamResult(new File("books1.xml")));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ����XML
	 */
	public void xmlParser(){
		try {
			Document document = getDocumentBuilder().parse("bookstore.xml");
			NodeList bookList = document.getElementsByTagName("book");
			System.out.println("һ����" + bookList.getLength() + "���顣");
			for(int i = 0; i < bookList.getLength(); i++){
				System.out.println("--------------------------��"+(i+1)+"����-----------------------");
				Node book = bookList.item(i);
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("��" + (i + 1) + "������" + attrs.getLength() + "������:");
				for(int j = 0; j < attrs.getLength(); j++){
					Node attr = attrs.item(j);
					System.out.print(attr.getNodeName());
					System.out.println(":" + attr.getNodeValue());
				}
				NodeList childNode = book.getChildNodes();
				System.out.println("��" + (i + 1) + "������" + childNode.getLength() + "���ӽڵ㣺");
				for(int k = 0; k < childNode.getLength(); k++){
					if(childNode.item(k).getNodeType() == Node.ELEMENT_NODE){
						System.out.print(childNode.item(k).getNodeName());
						System.out.println(":" + childNode.item(k).getFirstChild().getNodeValue());
					}
				}
			}
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
