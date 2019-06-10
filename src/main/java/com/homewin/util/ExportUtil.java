package com.homewin.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

public class ExportUtil {
	 private  Configuration configuration;
	    private  String encoding;
	    
	    public ExportUtil(String encoding) {
	    	this.encoding= encoding;
	        configuration = new Configuration(Configuration.VERSION_2_3_22);
	        configuration.setDefaultEncoding(encoding);
	        configuration.setClassForTemplateLoading(this.getClass(), "/template1");
	    }
	    
	    public  Template getTemplate(String name) throws Exception {
	        return configuration.getTemplate(name);
	    }
	    
	    public  String getImageStr(InputStream is) throws IOException {
	        BASE64Encoder encoder = new BASE64Encoder();
	        byte[] data = new byte[is.available()];
	        is.read(data);
	        
	        is.close();
	        return encoder.encode(data);
	    }

	    
	    public  void   exportDoc(String doc, String name,Map<String, Object> dataMap) throws Exception {
	        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(doc), encoding));
	        getTemplate(name).process(dataMap, writer);
	        writer.flush();
	        writer.close();
	    }
	    
	
}
