
package controllers;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.DocumentException;

public class PDFTest {
    public static void main()
    throws IOException, DocumentException {
        String HTMLpageUrl = "http://localhost:8080/Wnioski/skladanieWniosku.xhtml"; // URL strony renderowanej .
        String PDFdoc = "C:\\ConvertedFile.pdf"; //Wyjściowy plik PDF
        OutputStream os = new FileOutputStream(PDFdoc);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument("http://localhost:8080/Wnioski/skladanieWniosku.xhtml");
        renderer.layout();
        renderer.createPDF(os);
        os.close();
   }
} 