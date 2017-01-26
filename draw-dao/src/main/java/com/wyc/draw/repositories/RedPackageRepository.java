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

	@Query(value="from com.wyc.draw.domain.RedPacket rp where rp.handDrawUserId=:drawUserId")
	Page<RedPacket> findAllByHandDrawUserId(@Param("drawUserId")String drawUserId,Pageable pageable);


	//我参与的红包
	@Query(value="from com.wyc.draw.domain.RedPacket rp where rp.id in (select rtm.redPacketId from com.wyc.draw.domain.RedPacketTakepartMember rtm where rtm.drawUserId = :drawUserId)")
	Page<RedPacket> findAllByHandDrawUserIdOfTakepart(@Param("drawUserId")String drawUserId,Pageable pageable);
	
	
	//所有与该用户相关的红包
	@Query(value="select * from d_red_packet rp where rp.id in (select rp1.id from d_red_packet rp1 where rp1.hand_draw_user_id=:drawUserId union all select rtm.red_packet_id from d_red_packet_takepart_member rtm where rtm.draw_user_id = :drawUserId) order by rp.hand_time desc limit :start,:limit",nativeQuery=true)
	List<RedPacket> findAllOfRelatedToDrawUserId(@Param("drawUserId")String drawUserId,@Param("start")int start,@Param("limit")int limit);


	Page<RedPacket> findAllByIsTimeout(int isTimeout, Pageable pageable);


	//查找可以退款的红包
	Page<RedPacket> findAllByIsReceiveAndIsTimeoutAndIsPayAndIsRefundAndIsRefundError(int isReceive, int isTimeout, int isPay,
			int isRefund,int isRefundError,Pageable pageable);

}
