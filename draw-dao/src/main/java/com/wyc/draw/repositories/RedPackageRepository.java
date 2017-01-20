package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.RedPacket;

public interface RedPackageRepository extends CrudRepository<RedPacket, String>{

	Page<RedPacket> findAllByDrawRoomId(String roomId, Pageable pageable);

	
	@Query(value="from com.wyc.draw.domain.RedPacket rp where rp.id in (select mrp.redPacketId from com.wyc.draw.domain.view.MainRedPack mrp where mrp.periodId=:periodId and mrp.isDisplay=1)")
	List<RedPacket> findAllOfMainByPeriodId(@Param("periodId")String periodId);

}
