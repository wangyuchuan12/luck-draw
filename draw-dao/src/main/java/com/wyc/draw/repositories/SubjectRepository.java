package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.Subject;

public interface SubjectRepository extends CrudRepository<Subject, String>{

	List<Subject> findAllByIsMainAndIsDisplayOrderBySeqAsc(int isMain, int isDisplay);

	List<Subject> findAllByParentIdOrderBySeqAsc(String parentId);

}
