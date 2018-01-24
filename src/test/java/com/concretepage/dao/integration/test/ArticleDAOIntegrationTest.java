package com.concretepage.dao.integration.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.concretepage.dao.IArticleDAO;
import com.concretepage.entity.Article;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class ArticleDAOIntegrationTest {
	
	static int articleId;

	@Autowired
	private IArticleDAO articleDAO;
	
	@Test
	public void test1AddArticle(){
		Article article = new Article();
		article.setTitle("Article title 1");
		article.setCategory("Article category 1");
		
		articleDAO.addArticle(article);
		
		assertTrue(article.getArticleId() > 0);
		articleId = article.getArticleId();
	}
	
	@Test
	public void test2GetArticleById(){
		Article article = articleDAO.getArticleById(articleId);
		
		assertEquals(articleId, article.getArticleId());
		assertEquals("Article title 1", article.getTitle());
		assertEquals("Article category 1", article.getCategory());
		
	}
	
	@Test
	public void test3ArticleExist(){
		assertTrue(articleDAO.articleExists("Article title 1", "Article category 1"));
	}
	
	@Test
	public void test4GetAllArticles() throws Exception{
		List<Article> articleList = articleDAO.getAllArticles();
		
		assertTrue(articleList.size() > 0);
	}
	
	@Test
	public void test5UpdateArticle(){
		Article article = articleDAO.getArticleById(articleId);
		article.setTitle("New article title");
		article.setCategory("New article category");
		
		articleDAO.updateArticle(article);
		
		Article articleUpdated = articleDAO.getArticleById(articleId);
		assertEquals(articleId, articleUpdated.getArticleId());
		assertEquals("New article title", articleUpdated.getTitle());
		assertEquals("New article category", articleUpdated.getCategory());
	}
	
	@Test
	public void test6DeleteArticle(){
		articleDAO.deleteArticle(articleId);
		assertNull(articleDAO.getArticleById(articleId));
	}
	
}
