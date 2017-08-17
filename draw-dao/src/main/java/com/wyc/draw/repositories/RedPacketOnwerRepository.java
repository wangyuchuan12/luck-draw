package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.RedPacketOwner;

public interface RedPacketOnwerRepository extends CrudRepository<RedPacketOwner, String>{

	public List<RedPacketOwner> findAll();

	public List<RedPacketOwner> findAllByDrawUserIdAndIsDel(String drawUserId, int isDel);

	public RedPacketOwner findOneByDrawUserIdAndRedPacketId(String drawUserId, String redPacketId);

	public List<RedPacketOwner> findAllByDrawUserIdAndIsMyselfAndIsDel(String drawUserId, Integer isMyself, int isDel);

	@Query(value="select rpo.redPacketId from com.wyc.draw.domain.RedPacketOwner rpo where rpo.drawUserId=:drawUserId and rpo.isDel=0")
	public List<String> redPacketIdsByDrawUserId(@Param("drawUserId")String drawUserId);
}
