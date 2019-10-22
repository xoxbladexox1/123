package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.MensajePROBANDO;
import pe.com.synopsis.imgrabber.beans.request.NameRequestPROBANDO;

public class HelpMapper implements RowMapper<MensajePROBANDO>{
	private static final String COLUM_CHATNAME="CHATNAME";
	private static final String COLUM_CHATMOBILE="CHATMOBILE";
	
	@Override
	public MensajePROBANDO mapRow(ResultSet rs, int rowNum) throws SQLException {

		MensajePROBANDO nam = new MensajePROBANDO();
		nam.setChatnombre(rs.getString(COLUM_CHATNAME));
		nam.setChatmobile(rs.getString(COLUM_CHATMOBILE));

		
		return nam;
	}

}
