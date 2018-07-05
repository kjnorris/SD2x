import java.util.Date;


public abstract class Document {

	private String title;
	private String author;
	private Date date;
	protected PublishingLocation publishingLocation = new PublishingLocation();

	public Document() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getDate() {
		return date;
	}

	public String getCity() {
		return publishingLocation.getCity();
	}

	public String getState() {
		return publishingLocation.getState();
	}

	public String getPostCode() {
		return publishingLocation.getPostCode();
	}

	public boolean sameAuthor(Document article) {
		return this.getAuthor().equals(article.getAuthor());
	}

	public int compareDates(Document article) {
		return this.getDate().compareTo(article.getDate());
	}

	public int compareWithGeneralDate(Date date) {
		return this.getDate().compareTo(date);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}