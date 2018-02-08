package SpringMVC_Validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import SpringMVC_Model.FileUpload;
import SpringMVC_Utils.CommonUtils;

@Component
public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return FileUpload.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		FileUpload fileUpload = (FileUpload) target;
		
		CommonsMultipartFile[] multipartFiles = fileUpload.getFiles();
		
		for(CommonsMultipartFile multipartFile: multipartFiles) {
			
			//checkea el tamañao
			if(multipartFile.getSize() == 0) {
				errors.rejectValue("files", "required.file");
				break;
			}
			//checkea la extensión	
			
			String fileExtension = CommonUtils.getFileExtenson(multipartFile.getOriginalFilename().toLowerCase());
			if(fileExtension.equals("xml") && !fileExtension.equals("csv")) {
				errors.rejectValue("files", "file.extension.allowed");
				break;
			}
		}
		
	}

}
