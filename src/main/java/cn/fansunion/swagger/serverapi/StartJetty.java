package cn.fansunion.swagger.serverapi;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;
  
public class StartJetty {
    public static void main(String[] args) {
    	
    	
//        String filePath = System.getProperty("user.dir")  
//                + "/src/main/resources"; 
        String filePath = System.getProperty("user.dir")  
                + "/src/main/webapp"; 
        System.out.println("user.dir="+System.getProperty("user.dir"));  
  
        try {  
            Server server = new Server(8080);  
  
            WebAppContext context = new WebAppContext();  
            context.setContextPath("/server-api");  
            context.setDescriptor(filePath + "/web.xml"); // 指定web.xml配置文件  
            context.setResourceBase(filePath);// 指定webapp目录  
            context.setParentLoaderPriority(true);  
  
            server.setHandler(context);  
            server.start();  
            server.join();  
  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    } 
} 