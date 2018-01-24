package com.concretepage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import com.concretepage.entity.Article;
import com.concretepage.service.IArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
@Api(value="Controlador de Artículo", description="Article controler con Swagger")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@ApiOperation(value = "Buscar artículo por ID",response = Article.class)
	@GetMapping(value="/article/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<Article> getArticleById(@PathVariable(value = "id") Integer id){
		Article article = articleService.getArticleById(id);
		Resource<Article> resource = new Resource<Article>(article);
		resource.add(linkTo(methodOn(ArticleController.class).getArticleById(id)).withSelfRel());
		return resource;
	}
	
	//http://localhost:8080/user/articles
	
	@ApiOperation(value = "Ver artículos")
	@GetMapping("articles")
	@ResponseBody
	public List<Resource<Article>> getAllArticles(){
		List<Article> list = articleService.getAllArticles();
		List<Resource<Article>> resources = new ArrayList<Resource<Article>>();
		for (Article article : list){
			resources.add(getArticleResource(article));
		}
		return resources;
	}
	
	private Resource<Article> getArticleResource(Article article) {
		Resource<Article> resource = new Resource<Article>(article);
		resource.add(linkTo(methodOn(ArticleController.class).getArticleById(article.getArticleId())).withSelfRel());
		return resource;
	}

	@ApiOperation(value = "Añadir artículos")
	@PostMapping("article")
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder){
		boolean flag = articleService.addArticle(article);
		if(flag == false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Actualizar un artículo")
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article){
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Borrar artículo")
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id){
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
