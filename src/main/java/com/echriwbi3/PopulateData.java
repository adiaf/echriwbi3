package com.echriwbi3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.echriwbi3.model.accessManagement.ERole;
import com.echriwbi3.model.accessManagement.Role;
import com.echriwbi3.model.accessManagement.User;
import com.echriwbi3.model.blog.Article;
import com.echriwbi3.model.blog.Author;
import com.echriwbi3.model.blog.Tag;
import com.echriwbi3.repository.BlogArticleRepository;
import com.echriwbi3.repository.UserRepository;

@Component
public class PopulateData implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogArticleRepository blogArticleRepository;

	@Override
	public void run(String... args) throws Exception {

		// if (blogArticleRepository.count() == 0) {
		Article a = new Article();

		a.setTitle("It is a long established fact that a reader will");
		a.setContent(
				"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		a.setAuthor(new Author("Abderahmane DIAF", "a.diaf@outlook.fr"));
		a.setTags(Arrays.asList(new Tag("Hampden"), new Tag("Bonorum"), new Tag("Malorum")));

		blogArticleRepository.deleteAll();
		blogArticleRepository.save(a);
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