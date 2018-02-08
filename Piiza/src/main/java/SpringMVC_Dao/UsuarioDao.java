package SpringMVC_Dao;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

public interface UsuarioDao {
	
	public void process(List<String> filesPath) throws JAXBException, IOException;
	
}
