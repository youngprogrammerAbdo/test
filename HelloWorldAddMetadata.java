import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.xml.xmp.XmpWriter;

public class HelloWorldAddMetadata {

  public static void main(String[] args) throws Exception {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("C:\\DjVu++Task\\123.pdf"));
    document.open();
    document.add(new Paragraph("Hello World"));
    document.close();

    PdfReader reader = new PdfReader("C:\\DjVu++Task\\123.pdf");
    System.out.println("Tampered? " + reader.isTampered());
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
        "C:\\DjVu++Task\\HelloWorldStampedMetadata.pdf"));
    System.out.println("Tampered? " + reader.isTampered());
    HashMap<String, String> info = reader.getInfo();
    info.put("Subject", "Hello World");
    info.put("Author", "your name");
    info.put("Keywords", "iText pdf");
    info.put("Title", "Hello World stamped");
    info.put("Creator", "your name");
    info.put("Highlight","Highlight");
    stamper.setMoreInfo(info);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    XmpWriter xmp = new XmpWriter(baos, info);
    xmp.close();
    stamper.setXmpMetadata(baos.toByteArray());
    stamper.close();
  }

}
