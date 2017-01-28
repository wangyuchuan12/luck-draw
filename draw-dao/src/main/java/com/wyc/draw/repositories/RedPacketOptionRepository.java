package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.wyc.draw.domain.RedPacketOption;

public interface RedPacketOptionRepository extends CrudRepository<RedPacketOption, String>{

	List<RedPacketOption> findAllByRedPacketIdAndIsDelOrderBySeqAsc(String redPacketId,int isDel);

}
