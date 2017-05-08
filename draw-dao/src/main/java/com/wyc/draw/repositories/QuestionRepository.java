package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, String>{
	
	List<Question> findAllByPaperIdAndIsDel(String paperId, Integer isDel);
	
	@Query(nativeQuery=true,value="select count(*) from q_question q where q.paper_id =:paperId and q.is_del = :isDel and id not in :ids")
	Long countAllByPaperIdAndByIdNotInAndIsDel(@Param("paperId")String paperId,@Param("ids")List<String> ids , @Param("isDel")Integer isDel);

	@Query(value="from com.wyc.draw.domain.Question q where q.paperId =:paperId and q.isDel = :isDel and id not in :ids")
	List<Question> findAllByPaperIdAndByIdNotInAndIsDel(@Param("paperId")String paperId, @Param("ids")List<String> ids ,@Param("isDel")Integer isDel, Pageable pageable);
}
