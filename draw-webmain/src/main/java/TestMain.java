import com.wyc.common.filter.manager.FilterEntryFactory;
import com.wyc.common.filter.manager.FilterEntryManager;
import com.wyc.common.filter.manager.FilterStep;
import com.wyc.draw.filter.controller.api.AnswerQuestionApiFilter;
import com.wyc.draw.filter.controller.api.SubmitScoreApiFilter;

public class TestMain {
	public static void main(String[]args)throws Exception{
		FilterEntryManager filterEntryManager = new FilterEntryManager();
		
		FilterEntryFactory filterEntryFactory = new FilterEntryFactory(filterEntryManager, AnswerQuestionApiFilter.class,null);
		
		FilterStep filterStep = filterEntryFactory.instance();

		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());
		
		System.out.println(filterEntryManager.posSeqOut().getFilter());

	
				
	}
}
