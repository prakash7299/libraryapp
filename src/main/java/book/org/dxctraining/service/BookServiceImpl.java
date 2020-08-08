package book.org.dxctraining.service;

import java.util.List;



import book.org.dxctraining.dao.ILibraryDao;
import book.org.dxctraining.dao.LibraryDaoImpl;
import book.org.dxctraining.entities.Book;
import book.org.dxctraining.exceptions.InvalidArgumentException;


public class BookServiceImpl implements IBookService {
	private ILibraryDao dao = new LibraryDaoImpl();

	@Override
	public Book findById(String id) {
		checkId(id);
		Book book = dao.findById(id);
		return book;
	}



	@Override
	public List<Book> findAll() {
		List<Book>list=dao.findAll();
		return list;
	}

	
	
	public void checkId(String id) {
		int idno=Integer.parseInt(id);
		if (idno < 1) {
			throw new InvalidArgumentException("id cant be negative, id passed="+id);
		}
	}

	public void checkName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidArgumentException("name cant be null or empty");
		}
	}
	
	public void checkBook(Book book) {
		if(book==null) {
			throw new InvalidArgumentException("Author cant be null or empty");
				
		}
	}

	

	@Override
	public Book updateCost(String id,double newCost) {
		checkId(id);
		Book book = dao.updateCost(id, newCost);
	    return book;
	}

	@Override
	public void add(Book book) {
		checkBook(book);
		dao.add(book);
		
	}

	@Override
	public void remove(String id) {
	  checkId(id);	
	  dao.remove(id);		
	}

}
