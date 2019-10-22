
package pe.com.synopsis.imgrabber.dao;

import pe.com.synopsis.imgrabber.beans.domain.ValidateUser;

public interface LoginDAO
{

    public ValidateUser login(String userName, String password);
}
