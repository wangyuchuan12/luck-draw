package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.Subject;
import com.wyc.draw.service.SubjectService;
import com.wyc.draw.vo.SubjectListVo;
import com.wyc.draw.vo.SubjectVo;

public class GetSubjectCheckFilter extends Filter{

	@Autowired
	private SubjectService subjectService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String parentId = httpServletRequest.getParameter("parent_id");
		List<Subject> mainSubjects = null;
		if(CommonUtil.isEmpty(parentId)){
			mainSubjects = subjectService.findAllByIsMainAndIsDisplayOrderBySeqAsc(1,1);
		}else{
			mainSubjects = subjectService.findAllByParentIdOrderBySeqAsc(parentId);
		}
		
		List<SubjectVo> subjectVos = new ArrayList<>();
		for(Subject subject:mainSubjects){
			SubjectVo subjectVo = packetSubject(subject);
			filterChildren(subjectVo);
			
			subjectVos.add(subjectVo);
		}
		
		SubjectListVo subjectListVo = new SubjectListVo();
		
		subjectListVo.setMainSubjectVos(subjectVos);
		
		return subjectListVo;
		
	}
	
	public SubjectVo filterChildren(SubjectVo subjectVo){
		List<Subject> children = subjectService.findAllByParentIdOrderBySeqAsc(subjectVo.getId());
		
		if(children==null||children.size()==0){
			subjectVo.setIsLeaf(1);
		}else{
			subjectVo.setIsLeaf(0);
			
			List<SubjectVo> subjectVos = new ArrayList<>();
			
			for(Subject subject:children){
				SubjectVo childSubject = packetSubject(subject);
				filterChildren(childSubject);
				subjectVos.add(childSubject);
				
			}
			subjectVo.setChildren(subjectVos);
		}
		
		
		return subjectVo;
		
		
	}
	
	
	private SubjectVo packetSubject(Subject subject){
		SubjectVo subjectVo = new SubjectVo();
		
		subjectVo.setId(subject.getId());
		
		subjectVo.setColor(subject.getColor());
		subjectVo.setIsDisplay(subject.getIsDisplay());
		subjectVo.setIsMain(subject.getIsMain());
		subjectVo.setName(subject.getName());
		subjectVo.setParentId(subject.getParentId());
		
		return subjectVo;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
