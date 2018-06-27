package com.manas.test.Messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.manas.test.Messenger.model.Message;
import com.manas.test.Messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService=new MessageService();
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getIt(@QueryParam("year") int year,
    		@QueryParam("start") int start,
    		@QueryParam("size") int size) {
    	if(year>0){
    		return messageService.getMessagesForYear(year);	 
    	}
    	if(start>=0 && size>=0){
    		return messageService.getMessagesPaginated(start, size);
    	}
    	else
    		return messageService.getAllMessages();
    }
    
    @GET
    @Path("/{messageID}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessage(@PathParam("messageID") long messageID){		
		return messageService.getMessage(messageID);
	}
    
    @GET
    @Path("/man")
    @Produces(MediaType.APPLICATION_XML)
    public String getString() {
        return "man";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Message postMessage(Message message) {
    	return messageService.addMessage(message);
    }
    
    @PUT
    @Path("/{messageID}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Message updateMessage(@PathParam("messageID") long messageID,Message message) {
    	message.setId(messageID);
    	return messageService.updateMessage(message);
    }
}
