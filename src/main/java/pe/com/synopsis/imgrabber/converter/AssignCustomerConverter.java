package pe.com.synopsis.imgrabber.converter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.CustAssign;
import pe.com.synopsis.imgrabber.beans.dto.CustAssignDTO;

@Component
public class AssignCustomerConverter implements Converter<List<CustAssign>, List<CustAssignDTO>>
{

    @Override
    public List<CustAssignDTO> convert(List<CustAssign> source)
    {
        return source.stream().map(CustAssignDTO::new).collect(Collectors.toList());
    }

}
