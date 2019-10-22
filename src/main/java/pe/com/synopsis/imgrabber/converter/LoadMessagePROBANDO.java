package pe.com.synopsis.imgrabber.converter;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.MensajePROBANDO;
import pe.com.synopsis.imgrabber.beans.dto.MensajePROBANDODTO;



@Component
public class LoadMessagePROBANDO implements Converter<List<MensajePROBANDO>, List<MensajePROBANDODTO>>{

	@Override
	public List<MensajePROBANDODTO> convert(List<MensajePROBANDO> source) {
		return source.stream().map(MensajePROBANDODTO::new).collect(Collectors.toList());
	
	}

	
}
