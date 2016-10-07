package org.vamsi.restful.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
//import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.vamsi.restful.messenger.model.Message;
import org.vamsi.restful.messenger.resources.beans.MessageFilterBeans;
import org.vamsi.restful.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	
	MessageService service = new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBeans filterBean){
		if(filterBean.getYear()>0)
			return service.getMessagesForYear(filterBean.getYear());
		if(filterBean.getStart()>=0 && filterBean.getSize()>0)
			return service.getMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		return service.getAllMessages();
	}
	

	@POST
	public Message addMessage(Message message){
		
		return service.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") int messageId, Message message){
		
		message.setId(messageId);
		return service.updateMessage(message);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") int messageId){
		return service.getMessage(messageId);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") int messageId){
		service.removeMessage(messageId);
	}
}
