
public class SoultionOneChildClass extends SolutionOneParentClass{
	SolutionOneParentClass b=new SolutionOneParentClass();
	public static void main(String args[]){
		
		SoultionOneChildClass a = new SoultionOneChildClass();
		SoultionOneChildClass c = new SoultionOneChildClass();
		if(a.b.c==c.b.a)
			System.out.println("both variables are equal");
		else
			System.out.println("variables are not equal");
	}
}
