package com.rose.TestSuite;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.rose.TestSuite.Test_suite.TestClassTwo;

public class Per_Suite_Setup_and_Tear_Down extends TestCase
{
	public Per_Suite_Setup_and_Tear_Down(String method)
	{
		super(method);
	}

	public void testLongRunner()
	{
		assertEquals(2300, 50);
	}

	public void testShortTest()
	{
		assertEquals(140, 5);
	}

	public void testAnotherShortTest()
	{
		assertEquals(586, 10);
	}

	public static Test suite()
	{
		TestSuite suite = new TestSuite();
		suite.addTest(new Per_Suite_Setup_and_Tear_Down("testShortTest"));
		suite.addTest(new Per_Suite_Setup_and_Tear_Down("testAnotherShortTest"));
		TestSetup wrapper = new TestSetup(suite)
		{
			protected void setUp()
			{
				oneTimeSetUp();
			}

			protected void tearDown()
			{
				oneTimeTearDown();
			}
		};
		return wrapper;
	}

	public static void oneTimeSetUp()
	{
		System.out.println("oneTimeSetUp");
	}

	public static void oneTimeTearDown()
	{
		System.out.println("oneTimeTearDown");
	}
}
