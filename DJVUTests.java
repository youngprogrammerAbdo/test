/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package djvutests;

import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.xml.xmp.XmpWriter;

  
  


/**
 *
 * @author YOUNG PROGRAMMER
 * this class to create and read pdf metadata
 */


public class DJVUTests {
    public static void XMLTOTEXT(){
    
    }
    /**
     * Read Pdf metadata
     * @param PdfBookName 
     */
    public static void ReadMetaDataPDF(String PdfBookName){
    try {
                    PdfReader reader=new PdfReader(PdfBookName);
                    
                    Map info=reader.getInfo();
                    for(Iterator i=info.keySet().iterator();i.hasNext();){
                    String key=(String) i.next();
                    String value=(String) info.get(key);
                    
                        System.out.println(""+value);
                        
                    }
                    if(reader.getMetadata()==null){
                        System.out.println("No XML Metadata");
                    }else{
                        System.out.println(""+new String(reader.getMetadata()));
                    }
                } catch (IOException ex) {
                    
                }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    ReadMetaDataPDF("C:\\DjVu++Task\\HelloWorldStampedMetadata.pdf");
    }
    
}
