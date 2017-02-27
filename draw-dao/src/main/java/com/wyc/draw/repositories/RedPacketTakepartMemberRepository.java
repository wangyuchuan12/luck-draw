package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.RedPacketTakepartMember;

public interface RedPacketTakepartMemberRepository extends CrudRepository<RedPacketTakepartMember, String>{

	@Query("select count(*) from com.wyc.draw.domain.RedPacketTakepartMember rtm where rtm.redPacketId = :redPacketId and rtm.drawUserId = :drawUserId")
	int countByRedPacketIdAndDrawUserId(@Param("redPacketId")String redPacketId, @Param("drawUserId")String drawUserId);

	Page<RedPacketTakepartMember> findAllByRedPacketId(String redpacketId, Pageable pageable);

	List<RedPacketTakepartMember> findByRedPacketIdAndDrawUserId(String redPacketId, String drawUserId);

	List<RedPacketTakepartMember> findAllByRedPacketIdAndIsComplete(String redPacketId, int isComplete);

	Page<RedPacketTakepartMember> findAllByRedPacketIdAndIsComplete(String redPacketId, int isComplete,
			Pageable pageable);

	RedPacketTakepartMember findByOutTradeNo(String outTradeNo);

	List<RedPacketTakepartMember> findAllByRedPacketIdAndIsBest(String redPacketId, int isBest);

	@Query(nativeQuery=true,value="SELECT num1.right_count+num2.time_count from "+
								   "(select count(*) right_count from d_red_packet_takepart_member member1 where "+
								   	"member1.red_packet_id=:redPacketId and member1.right_count>:rightCount) num1,"+
								   	"(select count(*) time_count from d_red_packet_takepart_member member2 where "+
								   	"member2.red_packet_id=:redPacketId and "+
								   	"member2.right_count=:rightCount and member2.time_long<=:timeLong+0.000001)num2")
	Long rowNumberByRedPacketId(@Param("rightCount")Long rightCount,@Param("timeLong")Float timeLong, @Param("redPacketId")String redPacketId);

	@Query(nativeQuery=true,value="select count(*) from d_red_packet_takepart_member member where member.red_packet_id=:redPacketId")
	Long countByRedPacketId(@Param("redPacketId")String redPacketId);

}
