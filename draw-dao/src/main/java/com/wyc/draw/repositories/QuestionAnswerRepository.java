package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.QuestionAnswer;

public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, String>{

	List<QuestionAnswer> findAllByKeyIdAndPaperIdAndType(String keyId, String paperId, int type);

	List<QuestionAnswer> findAllByKeyIdAndPaperId(String keyId,String paperId);

	List<QuestionAnswer> findAllByPaperIdAndKeyIdAndIsDel(String paperId,String keyId, int isDel);

	List<QuestionAnswer> findAllByPaperIdAndDrawUserId(String paperId,String drawUserId);

}
