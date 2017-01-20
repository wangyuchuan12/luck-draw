package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.view.MainRoom;

public interface MainRoomRepository extends CrudRepository<MainRoom, String>{

	List<MainRoom> findAllByPeriodIdAndIsDisplay(String periodId, Integer isDisplay);

}
