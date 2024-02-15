package Main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import entity.Book;
//import entity.Book;

import java.io.FileInputStream;

public class Bookapplication {
    public static void main(String[] args) {


        try {
            ObjectMapper mapper = new XmlMapper();

            FileInputStream inputStream = new FileInputStream("E:/Task1/src/main/java/Xml/Bookinfo.xml");

            TypeReference<Book> typeReference = new TypeReference<Book>() {
            };
            Book b = mapper.readValue(inputStream, typeReference);
            inputStream.close();



          b.Database();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

