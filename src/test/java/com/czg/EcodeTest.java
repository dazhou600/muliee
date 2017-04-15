package com.czg;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class EcodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StandardPasswordEncoder spwe = new StandardPasswordEncoder("wztq") ;
		String digester = spwe.encode("123456") ;
		String str = "e7abdb3b6ba075bca92803fbd303b32bee93146f792d9f856ab4667e23a01f5534397da6e8874e60" ;
		System.out.println(digester);
		System.out.println(digester.length());
		System.out.println(digester.equals(str));
		System.out.println("***********************************");
		boolean flag = spwe.matches("123456", str);

		System.out.println("****************"+flag+"*******************");

	}

}
