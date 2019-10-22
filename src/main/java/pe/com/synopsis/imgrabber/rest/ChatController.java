
package pe.com.synopsis.imgrabber.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.synopsis.imgrabber.beans.dto.ContactDTO;
import pe.com.synopsis.imgrabber.beans.dto.MessageDTO;
import pe.com.synopsis.imgrabber.beans.dto.PageDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadContactRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadMessagesRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadPagesRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.service.ChatService;
import pe.com.synopsis.imgrabber.support.Constants;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/chat/v1")
@Api(value = "Chat Web Imgrabber")
public class ChatController
{

    @Autowired
    private ChatService chatService;
    
    

    @ApiOperation(value = "Permite al usuario consultar datos del chat")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/contacts")
    public ResponseEntity<Response<List<ContactDTO>>> loadContact(@Valid @RequestBody LoadContactRequest request)
    {
    	
        Response<List<ContactDTO>> response = chatService.loadContact(request);
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        {
            return new ResponseEntity<Response<List<ContactDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<ContactDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Permite al usuario consultar datos del chat")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/pages")
    
    
    public ResponseEntity<Response<List<PageDTO>>> loadPages(@Valid @RequestBody LoadPagesRequest request)
    {
        Response<List<PageDTO>> response = chatService.loadPages(request);
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        {
            return new ResponseEntity<Response<List<PageDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<PageDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Permite al usuario consultar datos del chat")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/messages")
    public ResponseEntity<Response<List<MessageDTO>>> loadMessages(@Valid @RequestBody LoadMessagesRequest request)
    {
        Response<List<MessageDTO>> response = chatService.loadMessages(request);
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        {
            return new ResponseEntity<Response<List<MessageDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<MessageDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}