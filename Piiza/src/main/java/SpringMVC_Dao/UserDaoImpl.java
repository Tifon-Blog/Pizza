package SpringMVC_Dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import SpringMVC_Model.Usuario;
import SpringMVC_Utils.CommonUtils;

@Component //Quedaste en el minuto 50, archivo User DAO
public class UserDaoImpl implements UsuarioDao{
	
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public void process(List<String> filesPath) throws JAXBException, IOException {
		// TODO Auto-generated method stub
		List<Usuario> list = new ArrayList<Usuario>();
		
		//Lee data
		for (String filePath : filesPath) {
			if(CommonUtils.getFileExtenson(filePath).equals("csv"))
			{
				//Leyendo archivo csv file
					list.addAll(CommonUtils.readCsv(filePath));				
			} else if (CommonUtils.getFileExtenson(filePath).equals("xml"))
			{
				//Leyendo archivo xml
					list.addAll(CommonUtils.readXml(filePath));
			}
		}
		
		//Importando data
		importData(list);
	}
	
	public void importData(List<Usuario> list){
		String sql = "INSERT INTO usuario(id, name) VALUES (:id, :name)";
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(list.toArray());
		
		namedParameterJdbcTemplate.batchUpdate(sql, batch);
	}
	
	
	
	
	
	
	
	
	

}
