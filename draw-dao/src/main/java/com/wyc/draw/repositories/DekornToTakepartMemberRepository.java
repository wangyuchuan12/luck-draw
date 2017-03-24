package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.DekornToTakepartMember;

public interface DekornToTakepartMemberRepository extends CrudRepository<DekornToTakepartMember, String>{

	DekornToTakepartMember findOneByDekornIdAndDrawUserId(String dekornId, String drawUserId);

}
