package com.baidu.testMap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestMap {

	@Test
	public final void test() {
		String test = "ashdajiui";
		if(test.endsWith("ui")) {
			System.out.println(test.substring(0, test.indexOf("ui")));
		}
	}

}
