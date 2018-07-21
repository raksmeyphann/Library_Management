package library;

public class Book extends BookModel {

	private String ISBN;
	private double price;
	private String author;
	private int edition;
	
//	public Book(String id, String title, String publisher, 
//		String yearPublished,boolean status, String ISBN, 
//		double price, String author, int edition) {
//		
//		super(id, title, publisher, yearPublished,status);
//		this.ISBN = ISBN;
//		this.price = price;
//		this.author = author;
//		this.edition = edition;
//	}
	
	
	

	public String[] toStringData()
	{
	
		String data[] = { this.getId(),this.getTitle(),this.getPublisher(),this.getYearPublished(),this.ISBN, this.price + "" ,this.author, this.edition + "" };
		return data;
	}

	public Book(String id, String title, String publisher, String yearPublished, boolean status,String ISBN, 
			double price, String author, int edition) {
		super(id, title, publisher, yearPublished, status);
		this.ISBN = ISBN;
		this.price = price;
		this.author = author;
		this.edition = edition;
	
	}
}
