package library;


import javax.persistence.*;


@Entity
@Table(name="tblbook")
public class BookEntity {
	
	@Id
	@Column(name = "id")  
	private String id;
	
	@Column(name = "title")  
	private String title;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "yearPublished")
	private String yearPublished;
	
	@Column(name = "status")
	private int status;
	
	@Column(name="Isbn")
	private String ISBN;
	
	@Column(name="price")
	private double price;
	
	@Column(name="author")
	private String author;
	
	@Column(name="edition")
	private int edition;

	public BookEntity(String id, String title, String publisher, String yearPublished, int status, String iSBN,
			double price, String author, int edition) {
	
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
		this.status = status;
		ISBN = iSBN;
		this.price = price;
		this.author = author;
		this.edition = edition;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}

	
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", title=" + title + ", publisher=" + publisher + ", yearPublished="
				+ yearPublished + ", status=" + status + ", ISBN=" + ISBN + ", price=" + price + ", author=" + author
				+ ", edition=" + edition + "]";
	}
	
	
	
	
	
	
	
	
}
