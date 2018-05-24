package com.rone.personnel_management.test;

import com.rone.personnelManagement.util.MyStringUtil;
import org.junit.*;

import java.security.NoSuchAlgorithmException;

public class OtherTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws NoSuchAlgorithmException {
//		int i = 19;
//		double j = 10;
//		System.out.println(Math.ceil(i/10.0));
//		96e79218965eb72c92a549dd5a330112
//		96e79218965eb72c92a549dd5a330112
		
		String str = "111111";
		System.out.println(MyStringUtil.encryption(str));
	}

}
