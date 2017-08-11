package com.walk.start.index.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walk.start.common.page.util.Page;
import com.walk.start.domain.ArticleInfo;
import com.walk.start.index.mapper.WalkIndexMapper;

@Service
public class WalkIndexService {

	@Autowired
	private WalkIndexMapper indexMapper;
	
	public Page<ArticleInfo> getArticleInfoList(int start){
		//PageRequest pr = new PageRequest(start,10);
		int offset = start;
		if(start > 0){
			offset = start * 8;
		}
		List<ArticleInfo> infoList = indexMapper.getArticleInfoList(offset);
		long totalCount = indexMapper.getAllarticleCount();
		Page<ArticleInfo> page = new Page<ArticleInfo>();
		if(infoList == null || infoList.size() <= 0){
			page.setItems(Collections.emptyList());
			return page;
		}
		page.setTotalItems(totalCount);
		page.setItems(infoList);
		page.setPageNo(start);
		return page;
	}
	
	/*public ArticleContent getAticleContent(int articleId){
		ArticleContent  content = indexMapper.getAticleContent(articleId);
		return content;
	}*/
}
