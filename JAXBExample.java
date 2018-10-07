package com.producer.consumer;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {
	
	private static void marshaller(JAXBContent content, File xmlFile) throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(content.getClass());
		
		Marshaller marsh = context.createMarshaller();
		
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		
		marsh.marshal(content,xmlFile);

	}
	
	private static JAXBContent unMarshaller(File file) throws JAXBException {
		
		JAXBContext context  = JAXBContext.newInstance(JAXBContent.class);
			
		Unmarshaller unmarshall = context.createUnmarshaller();
		
		JAXBContent unmarshallContent = (JAXBContent) unmarshall.unmarshal(file);
		
		return unmarshallContent;
	}
	
	public static void main(String[] args) throws JAXBException {
		
		File xmlFile = new File("/home/gnanajeyam/std.xml");
		
		JAXBContent content = new JAXBContent();
			content.setName("Jeyam");
			content.setAge(25);
			content.setId("j22");
		
		marshaller(content, xmlFile);
		
		JAXBContent unMarshallContent = unMarshaller(xmlFile);
		
		System.out.println(unMarshallContent);
		
	}
	
}
