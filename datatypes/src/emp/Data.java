package emp;
class B{
	public int a=1000000003;
    long  c=1000000007999966667L;
    short d=13332;
   float m=22.222314f;
   double y=21.11111111111118;
   byte e=122;
   char z='a';
	public boolean b=true;
	void datatypes() {
	System.out.println("int:"+a);
	System.out.println("boolean:"+b);
	System.out.println("long :"+c);
	System.out.println("short :"+d);
	System.out.println("float :"+m);
	System.out.println("float :"+y);
	System.out.println("byte :"+e);
	System.out.println("character :"+z);
	}
}
public class Data {
    public static void main(String[]args) {
    	B obj=new B();
    	obj.datatypes();
    }
}
