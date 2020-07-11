package com.echriwbi3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.echriwbi3.service.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogService blogService;

	@GetMapping("/shownonmenucategories")
	public ResponseEntity<?> findShownOnMenuCategories() {
		return ResponseEntity.ok(blogService.findShownOnMenuCategories());
	}

	@GetMapping("/articlesenvedette")
	public ResponseEntity<?> findArticlesEnVedette() {
		return ResponseEntity.ok(blogService.findArticlesEnVedette());
	}

	@GetMapping("/recentposts")
	public ResponseEntity<?> findsRecentPosts(@RequestParam(name = "number") int number) {
		return ResponseEntity.ok(blogService.findRecentPosts(number));
	}

	@GetMapping("/featuredposts")
	public ResponseEntity<?> featuredPosts(@RequestParam(name = "number") int number) {
		return ResponseEntity.ok(blogService.findFeaturedPosts(number));
	}

	@GetMapping("/mostreadposts")
	public ResponseEntity<?> mostReadPosts(@RequestParam(name = "number") int number) {
		return ResponseEntity.ok(blogService.findMostReadPosts(number));
	}

	@GetMapping("/findpostbyid")
	public ResponseEntity<?> postById(@RequestParam(name = "id") String id) {
		return ResponseEntity.ok(blogService.findPostById(id).get());
	}

	@GetMapping("/gettagbyid")
	public ResponseEntity<?> tagById(@RequestParam(name = "id") String id) {
		return ResponseEntity.ok(blogService.findTagById(id).get());
	}

	@GetMapping("/allcategories")
	public ResponseEntity<?> allCategories() {
		return ResponseEntity.ok(blogService.findAllCategories());
	}

	@GetMapping("/alltags")
	public ResponseEntity<?> allTags() {
		return ResponseEntity.ok(blogService.findAllTags());
	}

	@GetMapping("/getcategorybyid")
	public ResponseEntity<?> categoryById(@RequestParam(name = "id") String id) {
		return ResponseEntity.ok(blogService.getCategoryById(id).get());
	}

	@GetMapping("/getcategorylastpostbycategoryid")
	public ResponseEntity<?> tagLastPostByt$TagId(@RequestParam(name = "id") String id) {
		return ResponseEntity.ok(blogService.getCategoryLastPostByCategoryId(id));
	}

	@GetMapping("/gettaglastpostbytagid")
	public ResponseEntity<?> categoryLastPostByCategoryId(@RequestParam(name = "id") String id) {
		return ResponseEntity.ok(blogService.getTagLastPostBytTagId(id));
	}

	@GetMapping("/getblogcategoryposts")
	public ResponseEntity<?> categoryPosts(@RequestParam(name = "id") String id,
			@RequestParam(name = "mainpostid") String mainPostId, @RequestParam(name = "start") int start,
			@RequestParam(name = "size") int size) {
		return ResponseEntity.ok(blogService.getBlogCategoryPosts(id, start, size, mainPostId));
	}

	@GetMapping("/getblogtagposts")
	public ResponseEntity<?> tagPosts(@RequestParam(name = "id") String id,
			@RequestParam(name = "mainpostid") String mainPostId, @RequestParam(name = "start") int start,
			@RequestParam(name = "size") int size) {
		return ResponseEntity.ok(blogService.getBlogTagPosts(id, start, size, mainPostId));
	}
}
