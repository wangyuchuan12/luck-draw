package com.wyc.common.filter;

import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wyc.common.domain.MyResource;
import com.wyc.common.service.MyResourceService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.smart.service.UploadToQNService;


public class AddResourceFilter extends Filter{

	@Autowired
	private MyResourceService myResourceService;
	
	@Autowired
	private UploadToQNService uploadToQNService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		MultipartHttpServletRequest httpServletRequest = (MultipartHttpServletRequest)filterManager.getHttpServletRequest();
		CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) httpServletRequest.getFile("file");
		MyResource myResource = new MyResource();
        String resourceId = UUID.randomUUID().toString();
        myResource.setId(resourceId);
        if(commonsMultipartFile!=null&&commonsMultipartFile.getOriginalFilename()!=null&&!commonsMultipartFile.getOriginalFilename().trim().equals("")){
            
            String fileName = commonsMultipartFile.getOriginalFilename();
            myResource.setSuffix(fileName.substring(fileName.lastIndexOf(".")+1));
            myResource.setName(fileName.substring(0,fileName.lastIndexOf(".")));
            
        }
        try {
            myResourceService.addToWebpath(myResource, commonsMultipartFile.getInputStream());
        } catch (Exception e) {

        }
        myResourceService.add(myResource);


        uploadToQNService.syncResource(myResource);
		return myResource;
	}

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

}
