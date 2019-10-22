package pe.com.synopsis.imgrabber.support;

import pe.com.synopsis.imgrabber.beans.response.Status;

public class Constants {

	//DATE FORMATS
	public static final String SQL_DATE_FORMAT = "dd/MM/yyyy";
	//SCHEMAS
	public static final String SCAN_WEB_SCHEMA = "SCAN_WEB";
	
	//PACKAGES 
	public static final String PKG_WEB_MANAGER = "PKG_SCAN_WEB_MANAGER";
	
	//STATUS SUCCESSFULLY
	public static final String RESULT_OK = "0000";
	public static final String RESULT_FAIL = "9999";
	public static final String RESULT_FAIL_MSG = "Ocurri\u00F3 un error en el proceso.";
    public static final Status STATUS_FAIL= new Status(RESULT_FAIL, RESULT_FAIL_MSG);
	public static final Status STATUS_SUCCESSFULL= new Status(RESULT_OK, "El servicio se ha ejecutado de forma correcta.");
	
	//EXCEPTION CODE
	public static final String USER_NOT_EXIST_EXCEPTION_CODE = "1001";
	public static final String USER_INVALID_EXCEPTION_CODE = "1002";
	public static final String USER_BLOCK_EXCEPTION_CODE = "1003";
	public static final String USER_MUST_CHANGE_PWD_EXCEPTION_CODE = "1004";
	public static final String USER_PACINET_EXCEPTION_CODE = "1005";
	public static final String LOGOUT_EXCEPTION_CODE = "1006";
	public static final String USER_INACTIVE_EXCEPTION_CODE = "1007";
	public static final String USER_PACINET_STOP_CODE = "1008";
	public static final String USER_HAS_ALREADY_SESSION_CODE = "1009";
	public static final String UNSUPPORT_ENVIRONMENT_CODE = "1010";
	public static final String USER_PACINET_UPDATE_APP = "5555";
	
	public static final String PARAM_PCIP = "pCIP";
	public static final String PARAM_NOMBRES = "pNombres";
	public static final String PARAM_EMAIL = "pEmail";
	public static final String PARAM_APELLIDOS = "pApellidos";
	public static final String PARAM_CELULAR = "pCelular";
	public static final String PARAM_RESULTADO = "pResultado";
	
	public static final String PARAM_IDPERSON = "pIdPersona";
	public static final String PARAM_PASSWORD = "pContrasena";
	public static final String PARAM_PASSWORD_STATUS = "pContrasenaEstado";
	public static final String PARAM_GENERATION_TYPE = "pIdTipoGeneracion";
	
	public static final String PARAM_OPERATION_LIST_AGENCIES = "getListAgencies";
	public static final String PARAM_OPERATION_LIST_OPTIONS = "getListOptions";
	
	public static final String PARAM_GET_TYPE_CHANGE = "getTypeChange";
	
	public static final String PARAM_AGENCY_TYPE = "agencyType"; 
	
	public static final String PARAM_TYPE = "pTipo";
	public static final String PARAM_MESSAGE = "pMensage";
	
	public static final String PARAM_PEOPLE_CODE = "pCodigoPersona";
	public static final String PARAM_SAL_CURSOR = "salCursor";
	
	public static final int ACTIVE_USER_CODE = 2;
	public static final int INACTIVE_USER_CODE = 1;
	
	public static final String CACHE_USER_NAME = "users";
	public static final String SYSTEM_ENVIRONMENT_WEB = "W";
	public static final String SYSTEM_ENVIRONMENT_MOBILE = "M";
	
	public static final String KEY_ID =  "salt";
	
	public static final String PARAM_OPERATION_LIST_PARAMETERS = "getListParameters";
	public static final String PARAM_PARAMETER_TYPE = "parameterType";
	
}
