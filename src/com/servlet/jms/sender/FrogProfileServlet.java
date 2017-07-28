package com.servlet.jms.sender;

import java.io.IOException;
import java.util.Properties;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.jms.sender.vo.FrogProfileVO;

/**
 * Servlet implementation class FrogProfileServlet
 * JSJSJS
 * (@#*#*&#*&#&#&#&#&#&
 */
public class FrogProfileServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String color=request.getParameter("color");
		String price=request.getParameter("price");
		String email=request.getParameter("email");
		FrogProfileVO frogProfileVO=new FrogProfileVO();
		frogProfileVO.setColor(color);
		frogProfileVO.setEmail(email);
		frogProfileVO.setName(name);
		frogProfileVO.setPrice(Integer.parseInt(price));
		///Here we have to write code to send data to mom
		//#####################################################################
		
		//below is URL for JNDI
		final String PROVIDER_URL = "jnp://localhost:1099";
		final String JNP_INTERFACES = "org.jboss.naming:org.jnp.interfaces";
		final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
		//Create an instance of properties
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
		prop.put(Context.PROVIDER_URL, PROVIDER_URL);
		try {
			//Initializing the JNDI so that we can access the resources like queue, connection factory etc	from remote server
			Context context=new InitialContext(prop);
			//fetching factory to connect with queue
			//ConnectionFactory is already define inside the MOM 
			//ConnectionFactory - this is JNDI name for QueueConnectionFactory which is define inside the MOM
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			// connected with the queue.
			QueueConnection queueConnection = factory.createQueueConnection();
			// open the connection
			 QueueSession queueSession = queueConnection.createQueueSession(false,QueueSession.AUTO_ACKNOWLEDGE);
			//we have to do jndi lookup for Queue 
				// create the Queue to send message to Queue
			 Queue queue = (Queue) context.lookup("queue/srimathi");
			//here session ->>>Topic = >>>>Sender
			QueueSender queueSender = queueSession.createSender(queue);

			//Setting our data into ObjectMessage to send to the MOM
			ObjectMessage objectMessage=queueSession.createObjectMessage();
			objectMessage.setObject(frogProfileVO);
			queueSender.send(objectMessage);
			System.out.println("frogProfileVO  = "+frogProfileVO);
		
		}catch(Exception exe){
			exe.printStackTrace();
		}
		
		
		
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("uploadProfile.jsp");
		dispatcher.forward(request, response);
		//############################
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
