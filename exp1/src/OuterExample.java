class OuterExample
{
	static  int  x = 100;
	void methodInOuter()
	{
		for(int  j=0;j<5;j++){
		class InnerExample
		{
		void methodInInner()
		{
		System.out.println(x+1);}
		}
		InnerExample i = new InnerExample();
		i.methodInInner();
		}
	}


public static  void main(String a[])
{
	OuterExample  oe = new OuterExample();
	oe.methodInOuter();
} 
}
