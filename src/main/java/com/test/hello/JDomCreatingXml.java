package com.test.hello;

/**
 * @author NIsaev on 25.06.2020
 */

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JDomCreatingXml {
    public static void main(String[] args) {

        Document document = new Document();
        Element root = new Element("ROWSET");

        Element childRow = new Element("ROW");
        childRow.setAttribute(new Attribute("num", "1"));

        Element childMSG = new Element("MSG");
        childMSG.addContent(new Element("MSGNUM").setText("4"));
        childMSG.addContent(new Element("MSGDATE").setText("06/24/2020 0:0:0"));
        childMSG.addContent(new Element("PAGECOUNT").setText("1"));
        childMSG.addContent(new Element("MSGTYPE").setText("1"));
        childMSG.addContent(new Element("MSGNUM_REF").setText("1"));
        childMSG.addContent(new Element("MSGDATE_REF").setText("06/24/2020 0:0:0"));


        Element childOper = new Element("OPER");
        childOper.addContent(new Element("OPERDATE").setText("06/11/2020 15:30:00"));
        childOper.addContent(new Element("OPER_CODE").setText("1012"));
        childOper.addContent(new Element("OPER_CODES").setText("1012"));
        childOper.addContent(new Element("SUMCUR").setText("4564.00"));
        childOper.addContent(new Element("SUMTGT").setText("4564"));
        childOper.addContent(new Element("SHARE_QTY").setText("00"));
        childOper.addContent(new Element("SHARE_CAPITAL").setText("00"));
        childOper.addContent(new Element("REASON").setText("оплата услуг клиентом"));
        childOper.addContent(new Element("LIMIT_CODES").setText("10001"));
        childOper.addContent(new Element("SHADY_CODES").setText("40001"));
        childOper.addContent(new Element("STATUS_CODE").setText("1"));
        childOper.addContent(new Element("PRTCOUNT").setText("0"));

        Element childPerson = getElementFromFile("C:/Projects/hello-world/person.xml");
        childPerson.detach();

        Element childPRTLIST = new Element("PRTLIST").setText("");

        childRow.addContent(childMSG);
        childRow.addContent(childPerson);
        childRow.addContent(childOper);
        childRow.addContent(childPRTLIST);

        root.addContent(childRow);
        document.setContent(root);

       /*try {
            Format format = Format.getPrettyFormat();
            format.setEncoding("windows-1251");

            FileWriter writer = new FileWriter("C:/Projects/hello-world/userinfo.xml");
            XMLOutputter outputter = new XMLOutputter();

            // Set the XLMOutputter to pretty formatter. This formatter
            // use the TextMode.TRIM, which mean it will remove the
            // trailing white-spaces of both side (left and right)
            outputter.setFormat(format);

            // Write the document to a file and also display it on the
            // screen through System.out.
            outputter.output(document, writer);
            outputter.output(document, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        String str = outputString(document);
        try (PrintWriter out = new PrintWriter("C:/Projects/hello-world/userinfo.xml", "windows-1251")) {
            out.write(str);
        }catch (Exception t){
            t.printStackTrace();
        }

        System.out.println(str);
    }

    private static String outputString(Document document) {
        try {
            Format format = Format.getPrettyFormat();
            format.setEncoding("windows-1251");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(format);
            return outputter.outputString(document);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Element getElementFromFile(String filePath) {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(filePath);
            return document.getRootElement();
        } catch (Exception t) {
            t.printStackTrace();
        }
        return null;
    }
}
