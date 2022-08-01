package com.upskilled.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

import java.util.List;

import com.upskilled.task.model.Book;
import com.upskilled.task.repository.BookRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TaskApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testCreateBook() {
		Book book = new Book();

		book.setName("Buku Baru".trim());
		book.setPage(540L);
		book.setAuthor_id(1L);

		Book res = bookRepository.save(book);

		assertNotNull(res);
	}

	@Test
	public void testGetStudents() {
		List<Book> res = bookRepository.findAll();

		assertThat(res.size(), not(0));
	}

	@Test
	public void testUpdateBook() {
		Book book = bookRepository.findById(1L).orElseThrow();

		book.setName("Buku Cerita");

		Book res = bookRepository.save(book);

		assertEquals("Buku Cerita", res.getName().trim());
	}

	@Test
	public void testDeleteBook() {

		bookRepository.deleteById(1L);

		assertNull(bookRepository.findById(1L).isEmpty() ? null : new Book());
	}

}
