package com.wyc.common.wx.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyc.common.smart.service.AccessTokenSmartService;
import com.wyc.common.smart.service.BasicSupportService;
import com.wyc.common.util.Request;
import com.wyc.common.util.RequestFactory;
import com.wyc.common.util.Response;
import com.wyc.common.wx.domain.AccessTokenBean;
import com.wyc.common.wx.domain.Article;

@Service
public class SendMessageService {
    private String tokenKey = "sendMessage_"+UUID.randomUUID().toString();
    @Autowired
    private AccessTokenSmartService accessTokenSmartService;
    
    @Autowired
    private RequestFactory requestFactory;
    
    
    public Map<String, String> sendMessage(String content)throws Exception{
    	AccessTokenBean accessTokenBean = accessTokenSmartService.getFromDatabaseByKey(tokenKey);
        if(accessTokenBean==null){
            accessTokenBean = accessTokenSmartService.getFromWx();
            accessTokenSmartService.saveToDatabase(accessTokenBean, tokenKey);
        }
    	ObjectMapper objectMapper = new ObjectMapper();
        Request request = requestFactory.messageCustomRequest(accessTokenBean.getAccessToken());
        Response response = request.post(content);
        return objectMapper.readValue(response.read(), HashMap.class);
    }
    public Map<String, String> sendImgMessage(String toUser,List<Article> articles)throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("touser",toUser);
        map.put("msgtype", "news");
        Map<String, Object> news = new HashMap<String, Object>();
        news.put("articles", articles);
        map.put("news", news);
        return sendMessage(objectMapper.writeValueAsString(map));
    }
}
