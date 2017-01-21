package com.wyc.draw.service.other;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.common.domain.PaySuccess;
import com.wyc.common.wx.domain.Article;
import com.wyc.common.wx.domain.WxContext;
import com.wyc.common.wx.service.SendMessageService;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.DrawUserService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.pay.service.PayService;

@Service
public class RedPacketRefundService {
	
	@Autowired
	private PayService payService;
	
	@Autowired
	private RedPacketService redPacketService;
	
	@Autowired
	private DrawUserService drawUserService;
	
	@Autowired
	private WxContext wxContext;
	
	@Autowired
	private SendMessageService sendMessageService;
	
	final static Logger logger = LoggerFactory.getLogger(RedPacketRefundService.class);
	@Transactional
	public RedPacket refund(RedPacket redPacket)throws Exception{
		
		if(redPacket.getIsPay()==1&&redPacket.getIsRefund()==0&&redPacket.getIsTimeout()==1&&redPacket.getIsReceive()==0){
			
			if(redPacket.getPayType()==1){
				String outTradeNo = redPacket.getOutTradeNo();
				PaySuccess paySuccess  = payService.refund(outTradeNo);
				
				if(paySuccess.getIsRefund()==1){
				
					redPacket.setIsRefund(1);
					
					redPacketService.update(redPacket);
				}
				
				List<Article> articles = new ArrayList<>();
				
				Article article = new Article();
				article.setDescription("你的红包["+redPacket.getQuestion()+"]退款已到账\n退还金额："+redPacket.getAmount()+"，请查收");
				article.setTitle("红包退款到账通知");
				articles.add(article);
				DrawUser drawUser = drawUserService.findOne(redPacket.getHandDrawUserId());
				sendMessageService.sendImgMessage(drawUser.getOpenid(), articles);
			}else if(redPacket.getPayType()==0){
				
				DrawUser drawUser = drawUserService.findOneWithLuck(redPacket.getHandDrawUserId());
				BigDecimal amountBalance = drawUser.getAmountBalance();
				if(amountBalance == null){
					amountBalance = new BigDecimal(0);
				}
				amountBalance.add(redPacket.getAmount());
				drawUser.setAmountBalance(amountBalance);
				drawUserService.update(drawUser);
				
				List<Article> articles = new ArrayList<>();
				
				Article article = new Article();
				article.setDescription("你的红包["+redPacket.getQuestion()+"]已退还到余额\n退还金额："+redPacket.getAmount()+"，请查收");
				article.setTitle("红包退款到账通知");
				article.setUrl(wxContext.getDomainName()+"/view/draw/personal_center/main");
				articles.add(article);
				sendMessageService.sendImgMessage(drawUser.getOpenid(), articles);
			}else{
				System.out.println("不在范围，注意：这是一个很严重的错误，肯定是代码哪里有遗漏的地方");
				
				logger.error("不在范围，注意：这是一个很严重的错误，肯定是代码哪里有遗漏的地方");
			}
		}else{
			System.out.println("不在范围，注意：这是一个很严重的错误，肯定是代码哪里有遗漏的地方");
			logger.error("不在范围，注意：这是一个很严重的错误，肯定是代码哪里有遗漏的地方");
		}
		return null;
	}
	
}
