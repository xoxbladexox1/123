
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.Customer;

public class CustomerMapper implements RowMapper<Customer>
{
    // iduser, username, password, secret
    private static final String COLUMN_IDCUSTOMER = "IDCUSTOMER";
    private static final String COLUMN_NAME = "PERNAME";
    private static final String COLUMN_APEPAT = "PERAPEPAT";
    private static final String COLUMN_APEMAT = "PERAPEMAT";
    private static final String COLUMN_MOBILE = "PERMOBILE";
    private static final String COLUMN_PHONE = "PERPHONE";
    private static final String COLUMN_EMAIL = "PEREMAIL";
    private static final String COLUMN_LASTUPDATE = "LASTUPDATE";
    private static final String COLUMN_RESOFK = "RESO_FK";

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Customer customer = new Customer();
        customer.setIdCustomer(rs.getString(COLUMN_IDCUSTOMER));
        customer.setName(rs.getString(COLUMN_NAME));
        customer.setApePat(rs.getString(COLUMN_APEPAT));
        customer.setApeMat(rs.getString(COLUMN_APEMAT));
        customer.setMobile(rs.getString(COLUMN_MOBILE));
        customer.setPhone(rs.getString(COLUMN_PHONE));
        customer.setEmail(rs.getString(COLUMN_EMAIL));
        customer.setLastUpdate(rs.getString(COLUMN_LASTUPDATE));
        customer.setResourceId(rs.getString(COLUMN_RESOFK));
        return customer;
    }

}
