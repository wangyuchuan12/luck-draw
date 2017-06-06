package com.wyc.draw.service.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.common.domain.Account;
import com.wyc.common.service.AccountService;

@Service
public class AccountHandleService {
	
	@Autowired
	private AccountService accountService;
	public void subBean(Account account,Long beanNum){
		
		Long beanCount = account.getWisdomCount();
		if(beanCount==null){
			beanCount = 0l;
		}
		
		if(beanCount<beanNum){
			account.setWisdomCount(0l);
		}else{
			account.setWisdomCount(beanCount-beanNum);
		}
		accountService.update(account);
	}
	
	public void addBean(Account account,Long beanNum){
		Long beanCount = account.getWisdomCount();
		if(beanCount==null){
			beanCount = 0l;
		}
		
		Long beanLimit = account.getWisdomLimit();
		
		if(beanCount+beanNum<beanLimit){
			account.setWisdomCount(beanCount+beanNum);
		}else{
			account.setWisdomCount(beanLimit);
		}
		
		accountService.update(account);
	}
	
	public void subLove(Account account,Integer loveNum){
		Integer loveCount = account.getLoveLife();
		
		if(loveCount==null){
			loveCount = 0;
		}
		
		if(loveCount<loveNum){
			account.setLoveLife(0);
		}else{
			account.setLoveLife(loveCount-loveNum);
		}
		accountService.update(account);
	}
	
	public void addLove(Account account,Integer loveNum){
		Integer loveCount = account.getLoveLife();
		
		if(loveCount==null){
			loveCount = 0;
		}
		
		Integer loveLimit = account.getLoveLifeLimit();
		
		if(loveCount+loveNum<loveLimit){
			account.setLoveLife(loveCount+loveNum);
		}else{
			account.setLoveLife(loveLimit);
		}
		
		accountService.update(account);
	}
}
