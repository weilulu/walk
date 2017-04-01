package com.walk.start.index.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walk.article.entity.ArticleInfo;
import com.walk.common.page.util.Page;
import com.walk.start.index.mapper.WalkIndexMapper;

@Service
public class WalkIndexService {

	@Autowired
	private WalkIndexMapper indexMapper;
	
	public Page<ArticleInfo> getArticleInfoList(){
		List<ArticleInfo> infoList = indexMapper.getArticleInfoList();
		if(infoList == null || infoList.size() <= 0){
			return null;
		}
		Page<ArticleInfo> page = new Page<ArticleInfo>();
		page.setItems(infoList);
		return page;
	}
	
	/*public ArticleContent getAticleContent(int articleId){
		ArticleContent  content = indexMapper.getAticleContent(articleId);
		return content;
	}*/
}
