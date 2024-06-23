package xmlMethodSaving;


import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class UserAuthentication {

    private static final String XML_FILE_PATH = "users.xml";

    public static void UserLogin(String Email, String Password) {
        try {
            // Đọc tệp XML để lấy thông tin user
            Document document = readXMLFile(XML_FILE_PATH);

            // Kiểm tra thông tin đăng nhập
            boolean isAuthenticated = authenticateUser(document, Email, Password);

            // Hiển thị kết quả
            if (isAuthenticated) {
                System.out.println("Đăng nhập thành công!");
            } else {
                System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
            }
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

    private static boolean authenticateUser(Document document, String username, String password) {
        Element rootElement = document.getDocumentElement();
        NodeList usersList = rootElement.getElementsByTagName("user");
        
        for (int i = 0; i < usersList.getLength(); i++) {
            Node userNode = usersList.item(i);
            if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                Element userElement = (Element) userNode;
                String storedUsername = userElement.getElementsByTagName("email").item(0).getTextContent();
                String storedPassword = userElement.getElementsByTagName("password").item(0).getTextContent();

                if (storedUsername.equals(username) && storedPassword.equals(password)) {
                    return true; // Đăng nhập thành công nếu tên đăng nhập và mật khẩu khớp
                }
            }
        }

        return false; // Đăng nhập thất bại nếu không tìm thấy thông tin đăng nhập khớp
    }

}

