package SpringMVC_Service;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC_Dao.UsuarioDao;
@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioDao usuarioDao;
	

	public void process(List<String> filePath) throws JAXBException, IOException {
		usuarioDao.process(filePath);
	}

}
