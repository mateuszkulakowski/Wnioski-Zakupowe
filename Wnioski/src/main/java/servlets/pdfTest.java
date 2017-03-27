 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;




import java.io.IOException;
import java.io.OutputStream;
import java.io.StringBufferInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author Patryk
 */
public class pdfTest extends HttpServlet {
    
 protected void pdfTest (){
     
 }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
//response.setHeader("Content-Disposition", "attachment;filename=\"" + "nazwa-pliku.pdf" + "\"");
StringBuffer buf = new StringBuffer();
buf.append("<?xml version='1.0' encoding='UTF-8' ?>");
buf.append("<html xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
"      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n" +
"      xmlns:c=\"http://xmlns.jcp.org/jsp/jstl/core\"\n" +
"      xmlns:f=\"http://xmlns.jcp.org/jsf/core\">");

buf.append("<h:body><div class=\"container body-content col-lg-10\">\n" +
"        \n" +
"        <br/><br/><br/><br/><br/>\n" +
"        <h:form id=\"wniosek_o_zakup\">\n" +
"            <input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\"/>\n" +
"            <h4 style=\"width: 100%;text-align: center;\">Wniosek o zakup</h4>\n" +
"            \n" +
"            <br/>\n" +
"            <br/>\n" +
"            \n" +
"            \n" +
"            <div id=\"Numer_rej_wniosku\">\n" +
"                Nr rej. wniosku<br/>\n" +
"                <h:inputText value=\"#{WniosekController.wniosek.nr_rej_wniosku}\"/>\n" +
"            </div>\n" +
"            \n" +
"            <br/><br/>\n" +
"            \n" +
"            \n" +
"            <div class=\"oddzielna_sekcja\">\n" +
"                <strong>1.1.</strong> Jednostka organizacyjna uczelni<br/>\n" +
"                <h:inputText  class=\"input_duzy\" value=\"#{WniosekController.wniosek.jednostka_org_uczelni}\"/><br/>\n" +
"                <strong>1.2.</strong> Wnioskodawca <h:inputText class=\"input_duzy\" value=\"#{WniosekController.wniosek.wnioskodawca}\"/> tel. <h:inputText value=\"#{WniosekController.wniosek.wnioskodawca_tel}\"/> <br/>\n" +
"                <strong>1.3.</strong> Osoba dokonująca opisu przedmiotu zamówienia / Przedstawiciel do komisji przetargowej:<br/>\n" +
"                <h:inputText class=\"input_duzy\" value=\"#{WniosekController.wniosek.os_dok_opisu_prz_zam}\"/>, tel. <h:inputText value=\"#{WniosekController.wniosek.os_dok_opisu_prz_zam_tel}\"/>, e-mail: <h:inputText value=\"#{WniosekController.wniosek.os_dok_opisu_prz_zam_e_mail}\"/>\n" +
"                \n" +
"            </div>\n" +
"            \n" +
"            <br/>\n" +
"            \n" +
"             \n" +
"            <div class=\"oddzielna_sekcja\">\n" +
"                <strong>2.Przedmiot zamówienia</strong>  <br/>\n" +
"                <h:inputTextarea class=\"input_max\" value=\"#{WniosekController.wniosek.przedmiot_zamowienia}\"/><br/>\n" +
"                - Określono na okres (tutaj jakiś data picker)<br/>\n" +
"                <p style=\"text-align: center;\">(Szczegółowy opis w załączniku do wniosku)</p>\n" +
"            </div>\n" +
"            \n" +
"            <br/>\n" +
"            \n" +
"            <div class=\"oddzielna_sekcja\">\n" +
"                <strong>3.1. Merytoryczne uzasadnienie celowości dokonania zakupu </strong> <br/>\n" +
"                <h:inputTextarea class=\"input_max\" value=\"#{WniosekController.wniosek.metoryczne_uzas_cel_dok_zakupu}\"/><br/>\n" +
"                <strong>3.2.</strong> Termin realizacji zamówienia: (tutaj jakiś data picker)\n" +
"            </div>\n" +
"            \n" +
"            <br/>\n" +
"            \n" +
"            <div class=\"oddzielna_sekcja\">\n" +
"                <strong>4.1. Szacunkowa wartość zamówienia (netto): </strong> <h:inputText value=\"#{WniosekController.wniosek.szacunkowa_wartosc_zam}\"/> zł <br/>\n" +
"                Ustalenia szacunkowej wartości zamówienia dokonano na podstawie: <h:inputText class=\"input_duzy\" value=\"#{WniosekController.wniosek.ustalenia_szac_wartosci}\"/><br/>\n" +
"                Osoba dokonująca ustalenia wartości szacunkowej zamówienia:  <h:inputText class=\"input_duzy\" value=\"#{WniosekController.wniosek.osoba_dok_ustalenia_szac_wart_zam}\"/><br/>\n" +
"                <strong>4.2. Kwota przeznaczona na sfinansowanie zamówienia (brutto): </strong> <h:inputText value=\"#{WniosekController.wniosek.kwota_przeznaczona_sfinans_zam}\"/> zł<br/>\n" +
"                <strong>4.3. Źródło finansowania </strong> <h:inputText class=\"input_duzy\" value=\"#{WniosekController.wniosek.zrodlo_sfinansowania}\"/>\n" +
"                <br/>\n" +
"                (podpis i data wnioskodawcy będzie uzupełniana przy kliknieciu ZŁÓŻ WNIOSEK)\n" +
"                \n" +
"            \n" +
"            </div>\n" +
"            <br/>\n" +
"            <h:commandButton action=\"#{WniosekController.Dodaj()}\" value=\"Wyślij do kierownika Działu nauki (zakupy finansowane ze środków naukowo-badawczych)\"/><br/>\n" +
"            <h:commandButton action=\"#{WniosekController.Dodaj()}\" value=\"Wyślij do kierownika BRPM (zakupy ze środków zagranicznych)\"/><br/>\n" +
"            <h:commandButton action=\"#{WniosekController.Dodaj()}\" value=\"Wyślij do kwestora (pozostałe wnioski)\"/>\n" +
"            \n" +
"            </h:form>\n" +
"<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>\n" +
"    </div>  </h:body>");
buf.append("</html>");

      try {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new StringBufferInputStream(Escaping.escapeHTML(buf.toString())));
        	        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(doc, null);
        renderer.layout();
        OutputStream os = response.getOutputStream();
        	        renderer.createPDF(os);
        os.close();
        } catch (Exception ex) {
        ex.printStackTrace();
        }
       
     
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request, response);
    }
       @Override
    public String getServletInfo() {
        return "This Servlet Generates PDF Using iText Library";
    }
     
    }
