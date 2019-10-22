
package pe.com.synopsis.imgrabber.support;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

public class Utilities
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(Utilities.class);

    public static String cifrarContrasena(String idPersona, String contrasena)
    {
        String contrasenaCifrada;

        if (idPersona != null)
        {
            contrasenaCifrada = DigestUtils.md5DigestAsHex((idPersona + contrasena).getBytes());
        }
        else
        {
            contrasenaCifrada = DigestUtils.md5DigestAsHex(contrasena.getBytes());
        }
        return contrasenaCifrada;
    }

    public static String formatDate(Date date, String format)
    {
        String df = null;
        if (date != null)
        {
            SimpleDateFormat sdfr = new SimpleDateFormat(format);
            df = sdfr.format(date);
        }
        return df;
    }
}
