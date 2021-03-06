package Nicholas;

import java.util.Comparator;

public class problem3 {
	
	/*
	 * Nicholas Poole
	 * 
	 * Assignment:
	 * 		Write a program that has 4 classes, Rectangle, AreaComparator, PerimeterComparator, Main/Driver class. The Rectangle class 
	 * 		should contain the height/width of the rectangle and all standard class methods (getters/setters/constructor/tostring/etc). 
	 * 		Also include getArea and getPerimeter methods. The comparator classes should contain correctly written comparators for 
	 * 		Rectangle objects (page 25 has an example for comparing Strings). In the Main/Driver class, include the findMax method 
	 * 		provided (do not edit this method) and create an array of at least 5 rectangles. Use the findMax and each comparator class 
	 * 		object to determine which rectangle is the largest and print it out. Examples to test with: 
	 * 		H:1, W:100(large perimeter) H:25, W:20(large area)
	 *
	 * Grading:
	 * 		- Working Comparator classes (1pt)
	 * 		- Array of Rectangle objects, min 5 (1pt)
	 * 		- Did not modify findMax, and Main/Driver class shows this method working with each comparator class (1pt)
	 * 		- Complete Rectangle Class (1pt)
	 * 
	 */
  
  	public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp)
	{
		int maxIndex = 0;

		for(int i = 1; i < arr.length; i++)
		{
			if(cmp.compare(arr[i], arr[maxIndex]) > 0)
			{
				maxIndex = i;
			}
		}

		return arr[maxIndex];
	}
	
	public static void main(String[] args) {

    Rectangle[] r = new Rectangle[]{new Rectangle(737,273), new Rectangle(942,16), new Rectangle(7,3703), new Rectangle(126,638), new Rectangle(163,139)};
    System.out.println("Largest Perimeter: "+findMax(r, new PerimeterComparator())+"\nLargest Area: "+findMax(r, new AreaComparator()));
	}

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//rectangle class
class Rectangle{
  //width and height
  private int width, height;
  //constructor
  public Rectangle(int width, int height){
    this.width = width;
    this.height = height;
  }
  //getters and setters
  public int getArea(){
    return width * height;
  }
  public int getPerimeter(){
    return (2 * width) + (2 * height);
  }
  public int getWidth(){
    return width;
  }
  public int getHeight(){
    return height;
  }
  public void setWidth(int width){
    this.width = width;
  }
  public void setHeight(int height){
    this.height = height;
  }
  //to string (what gets returned if we just call the class)
	public String toString(){
    return "Rectangle width: "+getWidth()+", height: "+getHeight()+", area: "+getArea()+", perimeter: "+getPerimeter();
  }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//area comparator
class AreaComparator implements Comparator<Rectangle>{

	public int compare(Rectangle arg0, Rectangle arg1){
    if(arg0.getArea() > arg1.getArea()) 
      return 1; 
    return 0;
  }

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//perimeter comparator
class PerimeterComparator implements Comparator<Rectangle>{

	public int compare(Rectangle arg0, Rectangle arg1){
    if(arg0.getPerimeter() > arg1.getPerimeter()) 
      return 1;
    return 0;
  }

}