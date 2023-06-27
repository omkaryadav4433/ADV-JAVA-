package pojos;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

public class Book extends BaseEntity {
	@Column(name="bname",length=30)
   private  String title;
	
	@Column(name="price")
   private double price;
   
   
	@ManyToOne
	@JoinColumn(name="author_id")
   private Author aouthor_id;


public Book() {
	super();
	// TODO Auto-generated constructor stub
}


public Book(String title, double price) {
	super();
	this.title = title;
	this.price = price;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


public Author getAouthor_id() {
	return aouthor_id;
}


public void setAouthor_id(Author aouthor_id) {
	this.aouthor_id = aouthor_id;
}


@Override
public String toString() {
	return "Book [title=" + title + ", price=" + price + ", aouthor_id=" + aouthor_id + "]";
}
   
}
