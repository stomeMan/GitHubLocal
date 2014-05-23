/**
 * 
 */
package com.hp.it.wstax.spider.util;

import java.io.IOException;
import java.io.StringWriter;

import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date 2014-1-15
 * @revision
 */
public class GlobalUtils {

    
    public static String formatXML(Element element){
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");
            StringWriter writer = new StringWriter();
            // format output stream
            XMLWriter xmlWriter = new XMLWriter(writer, format);
            // write document to outputstream.
            xmlWriter.write(element);
            xmlWriter.close();
            
            return writer.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }
}
