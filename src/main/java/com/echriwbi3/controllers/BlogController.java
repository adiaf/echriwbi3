package com.echriwbi3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@CrossOrigin
	@GetMapping("/shownonmenucategories")
	public ResponseEntity<?> findShownOnMenuCategories() {

		return ResponseEntity.ok(blogService.findShownOnMenuCategories());
	}

	@CrossOrigin
	@GetMapping("/articlesenvedette")
	public ResponseEntity<?> findArticlesEnVedette() {
		return ResponseEntity.ok(blogService.findArticlesEnVedette());
	}

	@CrossOrigin
	@GetMapping("/recentposts")
	public ResponseEntity<?> findsRecentPosts(@RequestParam(name = "number") int number) {
		return ResponseEntity.ok(blogService.findRecentPosts(number));
	}

	@CrossOrigin
	@GetMapping("/featuredposts")
	public ResponseEntity<?> featuredPosts(@RequestParam(name = "number") int number) {
		return ResponseEntity.ok(blogService.findFeaturedPosts(number));
	}

	@CrossOrigin
	@GetMapping("/mostreadposts")
	public ResponseEntity<?> mostReadPosts(@RequestParam(name = "number") int number) {
		return ResponseEntity.ok(blogService.findMostReadPosts(number));
	}

	@CrossOrigin
	@GetMapping("/findpostbyid")
	public ResponseEntity<?> postById(@RequestParam(name = "id") String id) {
		return ResponseEntity.ok(blogService.findPostById(id).get());
	}

	@CrossOrigin
	@GetMapping("/allcategories")
	public ResponseEntity<?> allCategories() {
		return ResponseEntity.ok(blogService.findAllCategories());
	}

	@CrossOrigin
	@GetMapping("/alltags")
	public ResponseEntity<?> allTags() {
		return ResponseEntity.ok(blogService.findAllTags());
	}
}
