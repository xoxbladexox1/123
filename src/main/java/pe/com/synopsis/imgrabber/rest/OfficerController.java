
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
import pe.com.synopsis.imgrabber.beans.dto.CustAssignDTO;
import pe.com.synopsis.imgrabber.beans.dto.MensajePROBANDODTO;
import pe.com.synopsis.imgrabber.beans.dto.OfficerDTO;
import pe.com.synopsis.imgrabber.beans.request.AssignCustomerRequest;
import pe.com.synopsis.imgrabber.beans.request.DelOfficerRequest;
import pe.com.synopsis.imgrabber.beans.request.ListAssignCustRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadOfficerRequest;
import pe.com.synopsis.imgrabber.beans.request.NameRequestPROBANDO;
import pe.com.synopsis.imgrabber.beans.request.UpdateOfficerRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.service.OfficerService;
import pe.com.synopsis.imgrabber.support.Constants;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/officer/v1")
@Api(value = "Funcionarios Web Imgrabber")
public class OfficerController
{

    @Autowired
    private OfficerService officerService;

    @ApiOperation(value = "Carga lista de funcionarios, se puede enviar null para no filtrar.")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/load")																	//telefono y username
    public ResponseEntity<Response<List<OfficerDTO>>> loadOfficer(@Valid @RequestBody LoadOfficerRequest request)
    {
    	
        Response<List<OfficerDTO>> response = officerService.loadOfficer(request);
        
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        {
            return new ResponseEntity<Response<List<OfficerDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<OfficerDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
    
    @ApiOperation(value = "Carga lista de funcionarios, se puede enviar null para no filtrar.")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/probar")	
    public ResponseEntity<Response<List<MensajePROBANDODTO>>> buscarconnombre (@Valid @RequestBody NameRequestPROBANDO request)
    {
    	Response<List<MensajePROBANDODTO>> response = officerService.buscarconnombre(request);
    	 if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
         {
             return new ResponseEntity<Response<List<MensajePROBANDODTO>>>(response, HttpStatus.OK);
         }
         else
         {
             return new ResponseEntity<Response<List<MensajePROBANDODTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
         }
    	
    	
    	
    	
    	
    }
    
    
    
    
    @ApiOperation(value = "Permite registrar un funcionario.")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/add")
    public ResponseEntity<Response<String>> registerOfficer(@Valid @RequestBody UpdateOfficerRequest request)
    {
        Response<String> response = officerService.registerOfficer(request);
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        {
        	return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Permite editar un funcionario.")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/edit")
    public ResponseEntity<Response<String>> updateOfficer(@Valid @RequestBody UpdateOfficerRequest request)
    {
        Response<String> response = officerService.updateOfficer(request);
        
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        {
            return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Permite asignar un cliente a un funcionario. Activo (A) | Inactivo (I). ")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/assign/customer")
    public ResponseEntity<Response<String>> assignCustomer(@Valid @RequestBody AssignCustomerRequest request)
    {
        Response<String> response = officerService.assignCustomer(request);
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        {
            return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Listar todos los clientes, mostrando el flag de asociado.")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/list/customer")
    public ResponseEntity<Response<List<CustAssignDTO>>> listCustomer(@Valid @RequestBody ListAssignCustRequest request)
    {
        Response<List<CustAssignDTO>> response = officerService.listAssignCustomer(request);
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        {
            return new ResponseEntity<Response<List<CustAssignDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<CustAssignDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Registra un nuevo cliente, enviando idOfficer se puede asociar a un funcionario.")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/delete")
    public ResponseEntity<Response<String>> deleteCustomer(@Valid @RequestBody DelOfficerRequest request)
    {
        Response<String> response = officerService.deleteOfficer(request);
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        {
            return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}