package SpringMVC_Model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Usuario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
