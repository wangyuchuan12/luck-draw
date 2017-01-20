package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.view.MainImg;

public interface MainImgRepository extends CrudRepository<MainImg, String>{

	List<MainImg> findAllByPeriodId(String periodId);

}
