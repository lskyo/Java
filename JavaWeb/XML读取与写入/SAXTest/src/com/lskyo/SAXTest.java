package com.lskyo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class SAXTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createXML();
	}
	
	public static ArrayList<Book> parseXML(){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParserHandler handler = null;
		try {
			SAXParser parser = factory.newSAXParser();
			handler = new SAXParserHandler();
			parser.parse("bookstore.xml", handler);
			System.out.println("--------------------------------------------------------");
			System.out.println("bookList's size = " + handler.getBookList().size());
			for(Book b : handler.getBookList()){
				System.out.println(b);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return handler.getBookList();
		
	}
	
	
	public static void createXML(){
		ArrayList<Book> bookList = parseXML();
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		try {
			TransformerHandler handler = tff.newTransformerHandler();
			Transformer tf = handler.getTransformer();
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			File f = new File("newbooks.xml");
			if(!f.exists()){
				f.createNewFile();
			}
			Result result = new StreamResult(new FileOutputStream(f));
			handler.setResult(result);
			
			
			handler.startDocument();
			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", "bookstore", attr);
			for (Book book : bookList){
				attr.clear();
				attr.addAttribute("", "", "id", "", book.getId());
				handler.startElement("", "", "book", attr);
				attr.clear();
				if(book.getName() != null && !book.getName().trim().equals("")){
					handler.startElement("", "", "name", attr);
					handler.characters(book.getName().toCharArray(), 0, book.getName().length());
					handler.endElement("", "", "name");
				}
				if(book.getAuthor() != null && !book.getAuthor().trim().equals("")){
					handler.startElement("", "", "author", attr);
					handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
					handler.endElement("", "", "author");
				}
				if(book.getYear() != null && !book.getYear().trim().equals("")){
					handler.startElement("", "", "year", attr);
					handler.characters(book.getYear().toCharArray(), 0, book.getYear().length());
					handler.endElement("", "", "year");
				}
				if(book.getPrice() != null && !book.getPrice().trim().equals("")){
					handler.startElement("", "", "price", attr);
					handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
					handler.endElement("", "", "price");
				}
				if(book.getLanguage() != null && !book.getLanguage().trim().equals("")){
					handler.startElement("", "", "language", attr);
					handler.characters(book.getLanguage().toCharArray(), 0, book.getLanguage().length());
					handler.endElement("", "", "language");
				}
				handler.endElement("", "", "book");
			}
		
			handler.endElement("", "", "bookstore");
			handler.endDocument();
			
			
			
			
			
			
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
