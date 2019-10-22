package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.dto.UserDTO;
import pe.com.synopsis.imgrabber.dao.sp.SPValidateUser;

@Component
public class LoginConverter implements Converter<List<SPValidateUser>, List<UserDTO>>
{

    @Override
    public List<UserDTO> convert(List<SPValidateUser> source)
    {
        return source.stream().map(UserDTO::new).collect(Collectors.toList());
    }
    
}
