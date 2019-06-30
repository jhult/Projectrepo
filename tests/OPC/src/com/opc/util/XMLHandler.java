package com.opc.util;
/**
 * To be used for creating failed tests xml file.
 * 
 */
import java.io.File;		 
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;		 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
		 
		 
		public class XMLHandler { 
		 
		    public static void createXML(ArrayList<Object> testClassList) {	
		    	String XMLFileName = ".\\test-output\\safc-failed.xml";
		        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder dBuilder;
		        try {
		            dBuilder = dbFactory.newDocumentBuilder();
		            Document doc = dBuilder.newDocument();
		            //add elements to Document
		            Element suite = doc.createElement("suite");		
			        suite.setAttribute("name", "Failed suite");
			        suite.setAttribute("parallel", "none");
			        doc.appendChild(suite);
			        
			        Element test = doc.createElement("test");		
			        test.setAttribute("name", "Test(failed)");
			        suite.appendChild(test);
			        		            
					//append child element
			        test.appendChild(getlist(doc, test,  testClassList));
		 		 
		            //for output to file, console
		            TransformerFactory transformerFactory = TransformerFactory.newInstance();
		            Transformer transformer = transformerFactory.newTransformer();
		            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		            DOMSource source = new DOMSource(doc);
		 
		            //write to console or file
		            StreamResult console = new StreamResult(System.out);
		            StreamResult file = new StreamResult(new File(XMLFileName));
		 
		            //write data
		            // transformer.transform(source, console);
		            transformer.transform(source, file);
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }		 
		 
		    private static Node getlist(Document doc,  Element element, ArrayList<Object> failTestClassList ) {
		    	Element clasess = doc.createElement("classes");	
		    	element.appendChild(clasess);
		        
		        for (Object s: failTestClassList) {   
		          //  System.out.println(s); 
		            Element class1 = doc.createElement("class");	
			        class1.setAttribute("name", (String) s);
			        clasess.appendChild(class1);
			        }		        
	       
		        // create element
		        // clasess.appendChild(getNodeElements(doc, clasess, "class", "value"));
		 
		        return clasess;
		    }
		    
		   //utility method to create text node
		    private static Node getNodeElements(Document doc, Element element, String name, String value) {
		        Element node = doc.createElement(name);
		        node.appendChild(doc.createTextNode(value));
		        return node;
		    }
		 
		}