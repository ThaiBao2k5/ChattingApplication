package xmlMethodSaving;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class SaveUserSignUp {
	public static void UserSignUp(String Email,String Username,String Password) {
		try {
            // Đường dẫn tệp XML
            String XML_FILE_PATH = "users.xml";

            
            File newFile = new File(XML_FILE_PATH);
            if (!newFile.exists()) {
                
                newFile.createNewFile();
            }
  
            Document document = readXMLFile(XML_FILE_PATH);
            addNewUser(document, Username, Password,Email);   
            writeXMLFile(document, XML_FILE_PATH);

            System.out.println("User added and file saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    private static Document readXMLFile(String filePath) throws Exception {
        File inputFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(inputFile);
    }
    
    private static void addNewUser(Document document, String username, String password, String email) {
        Element rootElement = document.getDocumentElement();

     
        Element user = document.createElement("user");
        Element emailElement = document.createElement("email");
        emailElement.setTextContent(email);
        Element usernameElement = document.createElement("username");
        usernameElement.setTextContent(username);
        Element passwordElement = document.createElement("password");
        passwordElement.setTextContent(password);
   

        
        user.appendChild(emailElement);
        user.appendChild(usernameElement);
        user.appendChild(passwordElement);
        
       

       
        rootElement.appendChild(user);
    }

    private static void writeXMLFile(Document document, String filePath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
        transformer.transform(source, result);
    }
}

