
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.CustAssign;

public class CustAssignMapper implements RowMapper<CustAssign>
{
    // iduser, username, password, secret
    private static final String COLUMN_IDCUSTOMER = "IDCUSTOMER";
    private static final String COLUMN_NAME = "PERNAME";
    private static final String COLUMN_APEPAT = "PERAPEPAT";
    private static final String COLUMN_APEMAT = "PERAPEMAT";
    private static final String COLUMN_MOBILE = "PERMOBILE";
    private static final String COLUMN_PHONE = "PERPHONE";
    private static final String COLUMN_EMAIL = "PEREMAIL";
    private static final String COLUMN_ISCUSTOMER = "IS_CUSTOMER";

    @Override
    public CustAssign mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        CustAssign scan = new CustAssign();
        scan.setIdCustomer(rs.getString(COLUMN_IDCUSTOMER));
        scan.setName(rs.getString(COLUMN_NAME));
        scan.setApePat(rs.getString(COLUMN_APEPAT));
        scan.setApeMat(rs.getString(COLUMN_APEMAT));
        scan.setMobile(rs.getString(COLUMN_MOBILE));
        scan.setPhone(rs.getString(COLUMN_PHONE));
        scan.setEmail(rs.getString(COLUMN_EMAIL));
        scan.setState(rs.getString(COLUMN_ISCUSTOMER));
        return scan;
    }

}
