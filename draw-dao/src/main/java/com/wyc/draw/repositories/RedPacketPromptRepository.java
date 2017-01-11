package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.RedPacketPrompt;

public interface RedPacketPromptRepository extends CrudRepository<RedPacketPrompt, String>{

	List<RedPacketPrompt> findAllByRedPacketIdAndIsDelOrderByCreateAtAsc(String redPacketId,Integer isDel);

}
