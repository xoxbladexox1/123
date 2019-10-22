
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.CustAssign;
import pe.com.synopsis.imgrabber.beans.domain.MensajePROBANDO;
import pe.com.synopsis.imgrabber.beans.domain.Officer;
import pe.com.synopsis.imgrabber.beans.request.NameRequestPROBANDO;
import pe.com.synopsis.imgrabber.beans.request.UpdateOfficerRequest;
import pe.com.synopsis.imgrabber.dao.OfficerDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAssignCustomer;
import pe.com.synopsis.imgrabber.dao.sp.SPDeleteOfficer;
import pe.com.synopsis.imgrabber.dao.sp.SPListAssignCustomer;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadOfficer;
import pe.com.synopsis.imgrabber.dao.sp.SPManagerOfficer;
import pe.com.synopsis.imgrabber.dao.sp.SPMostrarpornombrePROBANDO;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.support.Constants;
import pe.com.synopsis.imgrabber.support.MessageInventory;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class OfficerDAOImpl implements OfficerDAO
{
    private static final Logger logger = LoggerFactory.getLogger(OfficerDAOImpl.class);

    
    @Autowired
    SPMostrarpornombrePROBANDO spMostrarpornombrePROBANDO;
    
    @Autowired
    SPLoadOfficer spLoadOfficer;
    
    @Autowired
    SPManagerOfficer spManagerOfficer;
    
    @Autowired
    SPAssignCustomer spAssignCustomer;
    
    @Autowired
    SPDeleteOfficer spDeleteOfficer;
    
    @Autowired
    SPListAssignCustomer spListAssignCustomer;

    @Autowired
    MessageInventory messageInventory;

    @Override
    public List<Officer> loadOfficer(String userPhone, String userName)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPLoadOfficer.IN_NAME, userName)
                .addValue(SPLoadOfficer.IN_PHONE, userPhone);
        								//requiere de un simplejdc call el EXCECUTE
        Map<String, Object> result = spLoadOfficer.execute(in);

        											//este result tiene llaves que 
        										//se le envia el SPLoadOfficer y deuvelve algo
   															//este outcursosr es el que no se uaba en el 
        																	//procedimiento alamacenado
        List<Officer> officers = (List<Officer>) result.get(SPLoadOfficer.OUT_CURSOR);
        									// se le envia el SPLoadOfficer y devuelove algo
        
        String status = (String) result.get(SPLoadOfficer.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }

        return officers;
    }
    
    
    
    
    
    @Override
	public List<MensajePROBANDO> buscarconnombre(String namsetring) {
		
		SqlParameterSource sql = new MapSqlParameterSource().addValue(SPMostrarpornombrePROBANDO.INFINDNAME ,namsetring );
		Map<String, Object> map = spMostrarpornombrePROBANDO.execute(sql);
		List<MensajePROBANDO> lista = (List<MensajePROBANDO>) map.get(SPMostrarpornombrePROBANDO.OUT_CURSOR) ;
		return lista;
		
		// List<Officer> officers = (List<Officer>) result.get(SPLoadOfficer.OUT_CURSOR);
		// se le envia el SPLoadOfficer y devuelove algo
        
//String status = (String) result.get(SPLoadOfficer.OUT_STATUS);
		
		
	}
    
    
    
    
    
    @Override
    public void mgrOfficer(UpdateOfficerRequest request)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPManagerOfficer.IN_NAME, request.getName())
                .addValue(SPManagerOfficer.IN_APEPAT, request.getApePat())
                .addValue(SPManagerOfficer.IN_APEMAT, request.getApeMat())
                .addValue(SPManagerOfficer.IN_MOBILE, request.getMobile())
                .addValue(SPManagerOfficer.IN_PHONE, request.getPhone())
                .addValue(SPManagerOfficer.IN_EMAIL, request.getEmail())
                .addValue(SPManagerOfficer.IN_IDOFFICER, request.getIdOfficer());

        Map<String, Object> result = spManagerOfficer.execute(in);

        String status = (String) result.get(SPManagerOfficer.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }
    }

    @Override
    public List<CustAssign> listAssign(String idOfficer)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPListAssignCustomer.IN_OFFIID, idOfficer);

        Map<String, Object> result = spListAssignCustomer.execute(in);
        String status = (String) result.get(SPManagerOfficer.OUT_STATUS);
        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }
        List<CustAssign> list = (List<CustAssign>) result.get(SPListAssignCustomer.OUT_CURSOR);
        return list;
    }

    @Override
    public void updateAssign(String idCustomer, String idOfficer, String state)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPAssignCustomer.IN_CUSTID, idCustomer)
                .addValue(SPAssignCustomer.IN_OFFIID, idOfficer)
                .addValue(SPAssignCustomer.IN_CHATSTATE, state);

        Map<String, Object> result = spAssignCustomer.execute(in);

        String status = (String) result.get(SPManagerOfficer.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }
        
    }

    @Override
    public void deleteOfficer(String idOfficer)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPDeleteOfficer.IN_OFFIID, idOfficer);

        Map<String, Object> result = spDeleteOfficer.execute(in);

        String status = (String) result.get(SPManagerOfficer.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }
        
    }

	

	

}
