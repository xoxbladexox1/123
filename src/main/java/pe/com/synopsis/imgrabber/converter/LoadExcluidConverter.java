package pe.com.synopsis.imgrabber.converter;





import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Excluid;
import pe.com.synopsis.imgrabber.beans.dto.ExcluidDTO;
@Component
public class LoadExcluidConverter implements Converter<List<Excluid>,List<ExcluidDTO>>{

	@Override
	public List<ExcluidDTO> convert(List<Excluid> source) {
		// TODO Auto-generated method stub
		
		return source.stream().map(ExcluidDTO::new).collect(Collectors.toList()) ;
		
		
	}

	

}
