package by.epam.l06.example;


public class CourseInspector
{
	public static void main(String[] args)
	{
		Course course1 = new BaseCourse();
		Course course2 = new OptionalCourse();
		System.out.println(course1.getInformation());
		System.out.println(course2.getInformation());
	}
}

abstract class Course
{
	public abstract String getInformation();
}

class BaseCourse extends Course
{
	public String getInformation()
	{
		return "Base course";
	}
}

class OptionalCourse extends Course
{
	public String getInformation()
	{
		return "Optional course";
	}
}

