package pe.com.synopsis.imgrabber.converter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Officer;
import pe.com.synopsis.imgrabber.beans.dto.OfficerDTO;

@Component
public class LoadOfficerConverter implements Converter<List<Officer>, List<OfficerDTO>>
{

    @Override
    public List<OfficerDTO> convert(List<Officer> source)
    {
    	return source.stream().map(OfficerDTO::new).collect(Collectors.toList());
        //return source.stream().map(OfficerDTO::new).collect(Collectors.toList());
    }

}
