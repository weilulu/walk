package com.walk.start.search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.elasticsearch.search.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.walk.start.domain.ArticleInfo;
import com.walk.start.search.repository.WalkRepository;

@Service
public class WalkSearchService {

	@Autowired
	private WalkRepository walkRepository;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	public Page<ArticleInfo> searchArticle(String keywords) {
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.matchQuery("content", keywords))
				.withHighlightFields(
						new HighlightBuilder.Field("content").preTags("<em style='color:red'>").postTags("</em>"))
				.build();
		return elasticsearchTemplate.queryForPage(searchQuery, ArticleInfo.class, new SearchResultMapper() {

			@Override
			public <T> Page<T> mapResults(SearchResponse response, Class<T> clazz,
					org.springframework.data.domain.Pageable pageable) {
				List<ArticleInfo> articleList = new ArrayList<>();
				long total = response.getHits().getTotalHits();
					if (total <= 0) {
						return null;
					}
					for (SearchHit hit : response.getHits()) {
						ArticleInfo info = new ArticleInfo();
						Map<String, Object> source = hit.getSource();
						Map<String, HighlightField> highField = hit.getHighlightFields();
						if (highField.get("title") != null) {
							info.setTitle(highField.get("title").fragments()[0].toString());
						} else {
							info.setTitle(source.get("title").toString());
						}
						if(highField.get("content") != null){
							info.setContent(highField.get("content").fragments()[0].toString());
						}else{
							info.setContent(source.get("content").toString());
						}
						articleList.add(info);
					}
					return new PageImpl<T>((List<T>)articleList);}

			/*@Override
			public <T> FacetedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
				long total = response.getHits().getTotalHits();
				if (total <= 0) {
					return null;
				}
				for (SearchHit hit : response.getHits()) {
					ArticleInfo info = new ArticleInfo();
					Map<String, Object> source = hit.getSource();
					Map<String, HighlightField> highField = hit.getHighlightFields();
					if (highField.get("title") != null) {
						info.setTitle(highField.get("title").fragments()[0].toString());
					} else {
						info.setTitle(source.get("title").toString());
					}
					if(highField.get("content") != null){
						info.setContent(highField.get("content").fragments()[0].toString());
					}else{
						info.setContent(source.get("content").toString());
					}
				}
				return new FacetedPage<T>((List<T>)articleList);
			}*/

		});
		
	}

	/*public FacetedPage<ArticleInfo> searchArticleTest(String keywords) {

		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.matchQuery("content", keywords))
				
				.withHighlightFields(
						new HighlightBuilder.Field("content").preTags("<em style='color:red'>").postTags("</em>"))
				.build();
		FacetedPage<ArticleInfo> page = walkRepository.search(searchQuery);

		return page;
	}*/
}
