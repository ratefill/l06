package by.epam.l06.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Сборник литературных произведений. Реализовать приложение, позволяющее
создавать сборники произведений (объект, представляющий собой сборник).
Составляющими сборника являются литературные произведения(стихи, проза и
т.д.) и форма сборника(журнал, книга и т.д.). Реализуйте возможность
определения, есть ли конкретное произведение в сборнике.
*/

public class HW01anthology
{
	public static void main(String[] args) throws ParseException
	{
		anthology a = new anthology();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");

		Science s = new Science("Инверсные токи", "Калобанов А.В.", sdf.parse("16.12.1975"), 4);		
		System.out.println("входит ли в сборник: "+ a.exist(s));// должен быть true		
		System.out.println("входит ли в сборник (hash): "+ a.existByHash(s));// должен быть true

		Biography b = new Biography("Пушкин А.С", "Дмитров А.Д.", sdf.parse("17.01.1928"), "старость");
		System.out.println("входит ли в сборник: "+ a.exist(b));// должен быть false
		System.out.println("входит ли в сборник (hash): "+ a.existByHash(b));// должен быть false
	}
};

class anthology
{
	private Paper[] an;

	public anthology()
	{
		super();
		this.an = new Paper[4];
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");

		try
		{
			an[0] = new Science("Инверсные токи", "Калобанов А.В.", sdf.parse("16.12.1975"), 4);
			an[1] = new Science("Термодинамика", "Гордан Д.Д.", sdf.parse("17.01.1968"), 1);
			an[2] = new Biography("Пушкин А.С", "Дмитров А.Д.", sdf.parse("17.01.1928"), "детство");
			an[3] = new Biography("Пушкин А.С", "Дмитров А.Д.", sdf.parse("17.07.1928"), "юношество");			
			

			

			System.out.println();
			System.out.println();
			
			System.out.println("первое произведение "+an[0].toString());
			
			if (an[0] instanceof Paper)
			{
				System.out.println("instanceof Paper");
				
			}
			if (an[0] instanceof Biography)
			{
				System.out.println("instanceof Biography");
			}
			if (an[0] instanceof Science)
			{
				System.out.println("instanceof Science");
			}
			
			System.out.println(an[0].getClass());
			
			System.out.println();
			
			// Science sc = (Science) an[0];
			// System.out.println(sc.toString());

		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		for (Paper p : an)
		{
			System.out.println(p.toString());
		}

	}

	public boolean exist(Paper p)
	{
		boolean result = false;
		for (Paper paper : an)
		{
			if (paper.equals(p))
			{
				result = true;
				break;
			}
		}
		return result;
	}

	public boolean existByHash(Paper p)
	{
		boolean result = false;
		for (Paper paper : an)
		{
			if (paper.hashCode() == p.hashCode())
			{
				result = true;
				break;
			}
		}
		return result;
	}
}

abstract class Paper
{
	private String name;
	private String author;

	private Date dateCreated;

	public Paper(String name, String author, Date dateCreated)
	{
		super();
		this.name = name;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString()
	{
		String result;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		result = getAuthor() + ", \"" + getName() + "\", " + sdf.format(getDateCreated());
		return result;

	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Date getDateCreated()
	{
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paper other = (Paper) obj;
		if (author == null)
		{
			if (other.author != null)
				return false;
		}
		else if (!author.equals(other.author))
			return false;
		if (dateCreated == null)
		{
			if (other.dateCreated != null)
				return false;
		}
		else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}
}

class Science extends Paper
{
	private int version;

	public Science(String name, String author, Date dateCreated, int version)
	{
		super(name, author, dateCreated);
		this.version = version;
	}

	public int getVersion()
	{
		return version;
	}

	public void setVersion(int version)
	{
		this.version = version;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Science other = (Science) obj;
		if (version != other.version)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Science [version=" + version + ", toString()=" + super.toString() + "]";
	}

}

class Biography extends Paper
{
	private String interval;

	public String getInterval()
	{
		return interval;
	}

	public void setInterval(String interval)
	{
		this.interval = interval;
	}

	public Biography(String name, String author, Date dateCreated, String interval)
	{
		super(name, author, dateCreated);
		this.interval = interval;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((interval == null) ? 0 : interval.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biography other = (Biography) obj;
		if (interval == null)
		{
			if (other.interval != null)
				return false;
		}
		else if (!interval.equals(other.interval))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "biography [interval=" + interval + ", " + super.toString() + "]";
	}

}
