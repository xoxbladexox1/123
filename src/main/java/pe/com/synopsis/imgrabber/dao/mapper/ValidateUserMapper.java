
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.ValidateUser;

public class ValidateUserMapper implements RowMapper<ValidateUser>
{
    // iduser, username, password, secret
    private static final String COLUMN_IDUSER = "USER_PK";
    private static final String COLUMN_USERNAME = "USERNAME";
    private static final String COLUMN_PASSWORD = "USERPASS";
    private static final String COLUMN_SECRET = "USERSECRET";

    @Override
    public ValidateUser mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        ValidateUser scan = new ValidateUser();
        scan.setIduser(rs.getString(COLUMN_IDUSER));
        scan.setUsername(rs.getString(COLUMN_USERNAME));
        scan.setPassword(rs.getString(COLUMN_PASSWORD));
        scan.setSecret(rs.getString(COLUMN_SECRET));
        return scan;
    }

}
