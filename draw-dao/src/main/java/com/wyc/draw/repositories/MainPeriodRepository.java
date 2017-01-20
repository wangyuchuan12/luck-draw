package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.view.MainPeriod;

public interface MainPeriodRepository extends CrudRepository<MainPeriod, String>{

	List<MainPeriod> findAllByIsDefault(int isDefault);

}
