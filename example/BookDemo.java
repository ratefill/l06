package by.epam.l06.example;

public class BookDemo
{
	public static void main(String[] args)
	{
		Book mybook = new Book("Золушка", 2000, 19000);
		ProgrammerBook myprogrbook = new ProgrammerBook("Java", 2006, 46000, "hight");
	}
}

class Book
{
	private String title;
	private int yearPublished;
	private int price;

	public Book()
	{
	}

	public Book(String title, int yearPublished, int price)
	{
		this.title = title;
		this.yearPublished = yearPublished;
		this.price = price;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getYearPublished()
	{
		return yearPublished;
	}

	public void setYearPublished(int yearPublished)
	{
		this.yearPublished = yearPublished;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}
}

class ProgrammerBook extends Book
{
	private String level;

	public ProgrammerBook(String title, int yearPublished, int price, String level)
	{
		super(title, yearPublished, price);
		this.level = level;
	}

	public String getLevel()
	{
		return level;
	}
}
