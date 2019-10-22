package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.Excluid;

public class ExcluidMapper implements RowMapper<Excluid>{
	
	private static final String COLUM_CELLPHONE="cellphone";
	private static final String COLUM_ALIAS="alias";
	@Override
	public Excluid mapRow(ResultSet rs, int rowNum) throws SQLException {
		Excluid ex = new Excluid();
		ex.setCellphone(rs.getString(COLUM_CELLPHONE));
		ex.setAlias(rs.getString(COLUM_ALIAS));
		
		
		return ex;
	}

}
