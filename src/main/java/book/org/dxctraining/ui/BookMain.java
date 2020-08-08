package book.org.dxctraining.ui;

import java.util.List;

import author.org.dxctraining.entities.Author;
import author.org.dxctraining.service.AuthorServiceImpl;
import author.org.dxctraining.service.IAuthorService;
import book.org.dxctraining.entities.Book;
import book.org.dxctraining.exceptions.*;
import book.org.dxctraining.service.BookServiceImpl;
import book.org.dxctraining.service.IBookService;

public class BookMain {
	private IBookService service = new BookServiceImpl();
	private IAuthorService service2=new AuthorServiceImpl();
	public static void main(String args[]) {
		BookMain obj2=new BookMain();
		obj2.runapp();
	
	}
	private void runapp() {
		try {
		Author author1=new Author("prakash");
		service2.add(author1);
		Author author2=new Author("Lokesh");
		service2.add(author2);
		Author author3=new Author("karthk");
		service2.add(author3);
		Author author4=new Author("arul");
		service2.add(author4);
		Book book1=new Book("java",600,author1);
		service.add(book1);
		Book book2=new Book("python",700,author2);
		service.add(book2);
		Book book3=new Book("python",700,author3);
		service.add(book3);
		Book book4=new Book("C++",200,author4);
		service.add(book4);
		Book fetched=service.findById("2");
		service.updateCost("1", 800);
		service.remove("3");
		display(fetched);
		displayAll();
		}catch(InvalidArgumentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		catch(BookNotFoundException e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		}
		
		catch(Exception e) {
		 e.printStackTrace();
		 System.out.println("some thing went wrong");
		}
	}
	public void displayAll() {
		List<Book> list = service.findAll();
		for (Book book : list) {
			display(book);
		}
	}
	public void display(Book book) {
		Author author = book.getAuthor();
		System.out.println("Id : " + book.getId() + " Name : " + book.getName()+" Cost : "+book.getCost()+" Authorid =" + author.getId() + " AuthorName : " + author.getName());
	}
}
