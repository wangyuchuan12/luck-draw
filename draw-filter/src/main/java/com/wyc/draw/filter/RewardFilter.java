package com.wyc.draw.filter;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.vo.RewardVo;


/**
 * 减去数值
 * @author root
 *
 */
public class RewardFilter extends Filter{

	@Autowired
	private AccountService accountService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		RewardVo rewardVo = (RewardVo)sessionManager.getObject(RewardVo.class);
		if(rewardVo!=null){
			DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
			Account account = accountService.fineOneSync(drawUser.getAccountId());
			Integer integral = account.getIntegral();
			Integer loveLife = account.getLoveLife();
			Long wisdomCount = account.getWisdomCount();
			
			BigDecimal amount = account.getAmountBalance();
			
			if(integral==null){
				integral = 0;
			}
			if(loveLife==null){
				loveLife = 0;
			}
			
			if(wisdomCount==null){
				wisdomCount = 0l;
			}
			
			if(amount==null){
				amount = new BigDecimal(0);
			}
			
			if(rewardVo.getAddAmount()!=null){
				amount.add(rewardVo.getAddAmount());
			}
			
			if(rewardVo.getSubAmount()!=null){
				amount.subtract(rewardVo.getSubAmount());
			}
			
			if(rewardVo.getAddLoveLifeNum()!=null){
				loveLife =  loveLife+rewardVo.getAddLoveLifeNum().intValue();
			}
			
			if(rewardVo.getSubLoveLifeNum()!=null){
				loveLife = loveLife - rewardVo.getSubLoveLifeNum().intValue();
			}
			
			if(rewardVo.getAddIntegralNum()!=null){
				integral= integral + rewardVo.getAddIntegralNum().intValue();
			}
			
			if(rewardVo.getAddWisdomNum()!=null){
				wisdomCount = wisdomCount+rewardVo.getAddWisdomNum();
			}
			
			if(rewardVo.getSubWisdomNum()!=null){
				wisdomCount = wisdomCount-rewardVo.getSubWisdomNum();
			}
			
			if(integral<0){
				integral = 0;
			}
			
			if(loveLife<0){
				loveLife = 0;
			}
			
			if(wisdomCount<0){
				wisdomCount = 0l;
			}
			
			if(amount.intValue()<0){
				amount = new BigDecimal(0);
			}
		
			account.setAmountBalance(amount);
			account.setIntegral(integral);
			account.setLoveLife(loveLife);
			account.setWisdomCount(wisdomCount);
			accountService.update(account);
			
			sessionManager.save(account);
			return account;
		}else{
			return null;
		}
		
		
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
