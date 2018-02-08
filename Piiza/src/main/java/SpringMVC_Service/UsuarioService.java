package SpringMVC_Service;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Service;


public interface UsuarioService {

	
	public void process(List<String> filePath) throws JAXBException, IOException;
}
