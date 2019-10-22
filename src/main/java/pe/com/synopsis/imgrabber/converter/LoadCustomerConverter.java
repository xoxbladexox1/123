package pe.com.synopsis.imgrabber.converter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Customer;
import pe.com.synopsis.imgrabber.beans.dto.CustomerDTO;

@Component
public class LoadCustomerConverter implements Converter<List<Customer>, List<CustomerDTO>>
{

    @Override
    public List<CustomerDTO> convert(List<Customer> source)
    {
        return source.stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

}
