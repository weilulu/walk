package com.walk.start.search.service;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.FacetedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.walk.start.domain.ArticleInfo;
import com.walk.start.search.repository.WalkRepository;


@Service
public class WalkSearchService{
	
	@Autowired
	private WalkRepository walkRepository;
	
	public List<ArticleInfo> searchArticle(String keywords){
		
		/*walkRepository.search(QueryBuilders.matchQuery("title", keywords));
		FunctionScoreQueryBuilder queryBuilder = QueryBuilders.functionScoreQuery()
				.add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("title", keywords)),
						ScoreFunctionBuilders.weightFactorFunction(1000))
				.add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("summary", keywords)),
						ScoreFunctionBuilders.weightFactorFunction(1000));*/
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("content", keywords)).build();
		FacetedPage<ArticleInfo> page = walkRepository.search(searchQuery);
		int total = page.getTotalPages();
		return null;
	}
}
