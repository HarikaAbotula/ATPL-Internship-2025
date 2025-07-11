package com.aaslin.assignments;

public class ConvertPrimitiveToWrapper {

	public static void main(String[] args) {
		
		byte byteNum=20;
		Byte byteConversion=byteNum;
		System.out.println("Class name of byte to Byte : " + byteConversion.getClass());
		
		short shortNum = 128;
		Short shortConversion = shortNum;
		System.out.println("Class name of short to Short : " + shortConversion.getClass());
		
		char letter = 'H';
		Character character = letter ;
		System.out.println("Class name of char to Character : " + character.getClass());
		
		int number = 10;
		Integer integer = number;
		System.out.println("Class name of int to Integer : " + integer.getClass());
		
		long longNum = 120L;
		Long longConversion= longNum;
		System.out.println("Class name of long to Long : " + longConversion.getClass());
		
		float floatNum= 10;
		Float floatConversion = floatNum ;
		System.out.println("Class name of float to Float : " + floatConversion.getClass());
		
		double doubleNum = 120.00;
		Double doubleConversion = doubleNum ;
		System.out.println("Class name of double to Double : " + doubleConversion.getClass());
		
		boolean bool = true;
		Boolean boolConversion = bool;
		System.out.println("Class name of boolean to Boolean : " + boolConversion.getClass());
	}

}

