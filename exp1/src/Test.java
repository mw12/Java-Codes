interface First
{
	final int i=100;
	void show();
}
 class Test implements First
{
 
	 int i=10;
	public void show()
	{ 
		
	}
	public static void main(String args[]){
	First t =  new Test();
	t.show();
	System.out.println(First.i);
}
}
