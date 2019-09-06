package com.example.simple_maven_project;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    public Integer getFactorial(Integer n) {
		Integer f=1;
		for(int i=1;i<=n;i++) {
			f=f*i;
		}
		return f;
	}
}
