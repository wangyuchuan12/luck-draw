package com.wyc.draw.repositories;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.DrawUser;

public interface DrawUserRepository extends CrudRepository<DrawUser, String>{

	DrawUser findByUserId(String userId);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query(value="from com.wyc.draw.domain.DrawUser du where du.userId=:userId")
	DrawUser findByUserIdWithLock(@Param("userId")String userId);

	@Modifying
	@Query(value="update com.wyc.draw.domain.DrawUser du set du.canTakeOutCount=:count")
	void initDrawUserCanTakeOutCount(@Param("count") int count);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query(value="from com.wyc.draw.domain.DrawUser du where du.id=:id")
	DrawUser findOneWithLuck(@Param("id")String id);

}
