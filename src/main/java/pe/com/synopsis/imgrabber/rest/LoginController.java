
package pe.com.synopsis.imgrabber.rest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.request.LogoffRequest;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.service.LoginService;
import pe.com.synopsis.imgrabber.support.Constants;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth/v1")
@Api(value = "Login Web Imgrabber")
public class LoginController
{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "Permite al usuario logearse")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/login")
    public ResponseEntity<Response<LoginResponse>> login(@Valid @RequestBody LoginRequest login,
            HttpServletRequest request)
    {
        Response<LoginResponse> response = loginService.login(login);
        
        
        
        if (Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
        { 
            return new ResponseEntity<Response<LoginResponse>>(response, HttpStatus.OK);
        }
        else
        {  
            return new ResponseEntity<Response<LoginResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
      
    }

    @ApiOperation(value = "Permite al usuario cerrar sesi&oacute;n")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/logout")
    public ResponseEntity<Status> logout(@Valid @RequestBody LogoffRequest logoffReq, HttpServletRequest request)
    {
        return new ResponseEntity<Status>(loginService.logout(logoffReq), HttpStatus.OK);
    }

    public LoginService getLoginService()
    {
        return loginService;
    }

    public void setLoginService(LoginService loginService)
    {
        this.loginService = loginService;
    }
}