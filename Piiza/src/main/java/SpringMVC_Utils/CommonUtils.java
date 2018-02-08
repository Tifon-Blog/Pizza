package SpringMVC_Utils;

import SpringMVC_Model.Usuario;
import SpringMVC_Model.Usuarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class CommonUtils {

	public static String getFileExtenson(String name) {
		if(name.lastIndexOf(".") != -1 && name.lastIndexOf(".") != 0) {
			return name.substring(name.lastIndexOf(".") +  1);
		} else {
			return "";
		}
	}
	
	public static List<Usuario> readCsv(String filePath) throws IOException{
		List<Usuario> list = new ArrayList<Usuario>();
		BufferedReader buff = null;
		String line="";
		String splitBy= ",";
	
	try {
		buff = new BufferedReader(new FileReader(filePath));
		while((line =buff.readLine()) !=null) {
			String[] data = line.split(splitBy);
			Usuario usuario = new Usuario();
			usuario.setId(Integer.valueOf(data[0]));
			usuario.setName(data[1]);
			list.add(usuario);
		}
			
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if(buff != null) {
			try {
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
		
		
		return list;
	}
	// leyendo xml
	public static List<Usuario> readXml(String filePath) throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(Usuario.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		Usuarios usuarios = (Usuarios) unmarshaller.unmarshal(new File (filePath));
		return usuarios.getUsuarios();
	}
}
