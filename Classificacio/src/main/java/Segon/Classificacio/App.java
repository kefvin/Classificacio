package Segon.Classificacio;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
    		File file = new File("src\\main\\resources\\lligaR-1.xml");
        
    		SAXParserFactory fabrica = SAXParserFactory.newInstance();
    		fabrica.setNamespaceAware(true);
        
			SAXParser parser = fabrica.newSAXParser();
			parser.parse(file, new Gestor());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
