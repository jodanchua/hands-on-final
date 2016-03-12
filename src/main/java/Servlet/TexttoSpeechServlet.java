/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package Servlet;
import Servlet.Upload;
 
import Bean.TexttoSpeechConnector;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;  
import javax.servlet.http.*;  
  


import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import java.awt.Component;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "TexttoSpeechServlet1", urlPatterns = {"/TexttoSpeechServlet"})

public class TexttoSpeechServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TexttoSpeechServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TexttoSpeechServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            TexttoSpeechConnector connector = new TexttoSpeechConnector();      
  			TextToSpeech service = new TextToSpeech();
  			service.setUsernameAndPassword(connector.getUsername(),connector.getPassword());
        
        		String text = request.getParameter("inputText");
        		String format = "audio/wav";

  				InputStream speech = service.synthesize(text, format);
            	
				/*
				OutputStream output = response.getOutputStream();

			    byte[] buf = new byte[2046];
				int len;
				while ((len = speech.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
                        
                response.setContentType("audio/wav"); 
				response.setHeader("Content-disposition","attachment;filename=output.wav");  
 
				
				
				//OutputStream os =output;   
                                
				//os.flush();  
				//os.close();  
            
        //processRequest(request, response);
		*/
		RequestDispatcher rd = request.getRequestDispatcher("/Upload");
		rd.forward(request,response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
