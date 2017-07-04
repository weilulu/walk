package com.walk.start.search.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.walk.start.domain.ArticleInfo;

@Repository
public interface WalkRepository extends ElasticsearchRepository<ArticleInfo,Long>{

}
