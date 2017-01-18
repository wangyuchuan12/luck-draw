package com.wyc.common.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.common.domain.ApplyForm;

public interface ApplyFormRepository extends CrudRepository<ApplyForm, String>{

	List<ApplyForm> findAllByOpenidOrderByApplyTimeDesc(String openid);

	List<ApplyForm> findAllByTypeAndStatusOrderByApplyTimeDesc(int type, int status);

}
