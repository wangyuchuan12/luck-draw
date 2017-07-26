package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.QuestionAnswer;

public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, String>{

	List<QuestionAnswer> findAllByKeyIdAndPaperIdAndTypeAndIsDel(String keyId, String paperId, int type,Integer isDel);

	List<QuestionAnswer> findAllByKeyIdAndPaperIdAndIsDel(String keyId,String paperId,Integer isDel);

	List<QuestionAnswer> findAllByPaperIdAndKeyIdAndIsDel(String paperId,String keyId, int isDel);

	List<QuestionAnswer> findAllByPaperIdAndDrawUserIdAndIsDel(String paperId,String drawUserId,Integer isDel);

}
