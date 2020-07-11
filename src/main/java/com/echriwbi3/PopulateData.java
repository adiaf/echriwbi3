package com.echriwbi3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.echriwbi3.model.accessManagement.ERole;
import com.echriwbi3.model.accessManagement.Role;
import com.echriwbi3.model.accessManagement.User;
import com.echriwbi3.model.blog.Article;
import com.echriwbi3.model.blog.Author;
import com.echriwbi3.model.blog.Category;
import com.echriwbi3.model.blog.Tag;
import com.echriwbi3.repository.BlogArticleRepository;
import com.echriwbi3.repository.BlogCategoryRepository;
import com.echriwbi3.repository.BlogTagRepository;
import com.echriwbi3.repository.UserRepository;

@Component
public class PopulateData implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogArticleRepository blogArticleRepository;

	@Autowired
	private BlogCategoryRepository blogCategoryRepository;

	@Autowired
	private BlogTagRepository blogTagRepository;

	@Override
	public void run(String... args) throws Exception {

		// if (blogArticleRepository.count() == 0) {

		List<Tag> tags = Arrays.asList(new Tag("Tag1", null, "tag1"), new Tag("Tag2", null, "tag2"),
				new Tag("Tag3", null, "tag3"), new Tag("Tag4", null, "tag4"));

		List<Tag> tags2 = Arrays.asList(new Tag("Tag5", null, "tag5"), new Tag("Tag6", null, "tag6"));

		List<Category> cats = Arrays.asList(
				new Category("Commerce électronique", "commerce-electronique", null, true, true, 0),
				new Category("E-Paiement", "e-paiement", null, true, true, 1),
				new Category("Législations", "legislations", "green", true, true, 2),
				new Category("Banques", "banques", "orange", true, true, 3),
				new Category("Algérie Poste", "algerie-poste", "purple", true, true, 4),
				new Category("International", "international", "blue", true, true, 5));

		Article a = new Article();
		a.setTitle("It is a long established fact that a reader will");
		a.setSlug("chrome-extension-protects-against-javascript-based-cpu-side-channel-attacks");
		a.setContent(
				"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		a.setAuthor(new Author("Abderahmane DIAF", "a.diaf@outlook.fr"));
		a.setCategory(cats.get(3));
		a.setTags(tags);
		a.setEnabled(true);
		a.setEnVedette(true);
		a.setRead(3);

		Article b = new Article();
		b.setTitle("Of passages of Lorem Ipsum available");
		b.setSlug("chrome-extension-protects-against-javascript-based-cpu-side-channel-attacks");
		b.setContent(
				"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		b.setAuthor(new Author("Abderahmane DIAF", "a.diaf@outlook.fr"));
		b.setCategory(cats.get(3));
		b.setTags(tags);
		b.setEnabled(true);
		b.setEnVedette(true);
		b.setFeatured(true);
		b.setRead(20);

		Article c = new Article();
		c.setTitle("The Extremes of Good and Evi");
		c.setSlug("chrome-extension-protects-against-javascript-based-cpu-side-channel-attacks");
		c.setContent(
				"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		c.setAuthor(new Author("Abderahmane DIAF", "a.diaf@outlook.fr"));
		c.setCategory(cats.get(3));
		c.setTags(tags);
		c.setEnabled(true);
		c.setEnVedette(false);
		c.setFeatured(false);
		c.setRead(20);

		Article d = new Article();
		d.setTitle("Tend to repeat predefined chunks");
		d.setSlug("chrome-extension-protects-against-javascript-based-cpu-side-channel-attacks");
		d.setContent(
				"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		d.setAuthor(new Author("Abderahmane DIAF", "a.diaf@outlook.fr"));
		d.setCategory(cats.get(3));
		d.setTags(tags);
		d.setEnabled(true);
		d.setEnVedette(false);
		d.setFeatured(false);
		d.setRead(20);

		Article e = new Article();
		e.setTitle("There are many variations of passages ");
		e.setSlug("chrome-extension-protects-against-javascript-based-cpu-side-channel-attacks");
		e.setContent(
				"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		e.setAuthor(new Author("Abderahmane DIAF", "a.diaf@outlook.fr"));
		e.setCategory(cats.get(3));
		e.setTags(tags);
		e.setEnabled(true);
		e.setEnVedette(false);
		e.setFeatured(false);
		e.setRead(20);

		Article f = new Article();
		f.setTitle("The standard chunk of Lorem Ipsum");
		f.setSlug("chrome-extension-protects-against-javascript-based-cpu-side-channel-attacks");
		f.setContent(
				"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		f.setAuthor(new Author("Abderahmane DIAF", "a.diaf@outlook.fr"));
		f.setCategory(cats.get(3));
		f.setTags(tags);
		f.setEnabled(true);
		f.setEnVedette(false);
		f.setFeatured(false);
		f.setRead(20);

		Article g = new Article();
		g.setTitle("Packages and web page editors ");
		g.setSlug("chrome-extension-protects-against-javascript-based-cpu-side-channel-attacks");
		g.setContent(
				"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		g.setAuthor(new Author("Abderahmane DIAF", "a.diaf@outlook.fr"));
		g.setCategory(cats.get(3));
		g.setTags(tags);
		g.setEnabled(true);
		g.setEnVedette(false);
		g.setFeatured(false);
		g.setRead(20);

		Article h = new Article();
		h.setTitle("Where can I get some?");
		h.setSlug("chrome-extension-protects-against-javascript-based-cpu-side-channel-attacks");
		h.setContent(
				"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		h.setAuthor(new Author("Abderahmane DIAF", "a.diaf@outlook.fr"));
		h.setCategory(cats.get(3));
		h.setTags(tags);
		h.setEnabled(true);
		h.setEnVedette(false);
		h.setFeatured(false);
		h.setRead(20);

		blogArticleRepository.deleteAll();
		blogCategoryRepository.deleteAll();
		blogTagRepository.deleteAll();

		blogTagRepository.saveAll(tags);
		blogTagRepository.saveAll(tags2);

		blogCategoryRepository.saveAll(cats);

		blogArticleRepository.saveAll(Arrays.asList(a, b, c, d, e, f, g, h));
		// }

		if (!userRepository.existsByUsername("adf")) {
			userRepository.deleteAll();
			Set<Role> roles = new HashSet<>();
			roles.add(new Role(ERole.ROLE_ADMIN));
			roles.add(new Role(ERole.ROLE_USER));

			User user = new User("adf", "Abderahmane", "DIAF", "a.diaf@icloud.com",
					"$2a$10$8Zs9WYLX77m5T.EIthx4CupwaCJ1DNX0IRDdhPJmIgdT/XJZjvrum", roles);
			userRepository.save(user);
		}

	}
}