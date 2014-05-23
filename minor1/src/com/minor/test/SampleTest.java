package com.minor.test;

import java.util.ArrayList;
import java.util.Collection;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import junit.framework.TestCase;

public class SampleTest extends TestCase{
	public SampleTest(String name){
		super(name);
	}
	public void testEmptyCollection(){
		Collection< Object> cc=new ArrayList<Object>();
		cc.add(4);
		assertTrue(cc.isEmpty());
	}
}
