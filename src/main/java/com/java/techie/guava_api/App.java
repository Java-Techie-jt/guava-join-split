package com.java.techie.guava_api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Spliterators;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Hello world!
 *
 */
public class App {
	// convert List to String

	public String convertList2String() {
		List<String> names = Lists.newArrayList("Ravi", "Bikash", "Basant");
		String name = Joiner.on(",").join(names);
		System.out.println(name);
		return String.join("*", names);
	}

	public String convertMap2String() {
		Map<String, Integer> map = Maps.newHashMap();
		map.put("abc", 10);
		map.put("pqr", 109);
		String result = Joiner.on(",").withKeyValueSeparator("=").join(map);
		return result;
	}

	public String ignoreNull() {
		List<String> names = Lists.newArrayList("Ravi", "Bikash", "Basant", null, null);
		String result = Joiner.on(",").skipNulls().join(names);
		return result;
	}

	public String replaceNull() {
		List<String> names = Lists.newArrayList("Ravi", "Bikash", "Basant", null, null);
		String result = Joiner.on(",").useForNull("No Name").join(names);
		return result;
	}

	public List<String> convertString2List() {
		String name = "Basant-santosh-Ravi";
		List<String> list = Splitter.on("-").trimResults().splitToList(name);
		return list;
	}

	public Map<String, String> convertString2Map() {
		String entry = "john=100,Bikash=800";
		Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(entry);
		return map;
	}

	public List<String> multiSplit() {
		String result = "apple.banana,,orange,,.";
		List<String> convertData = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(result);
		return convertData;
	}

	public Iterable<String> getFilterData() {
		List<String> names = Lists.newArrayList("Ravi", "Bikash", "Basant");
		Iterable<String> resullt = Iterables.filter(names, Predicates.containsPattern("t"));
		return resullt;

	}
	
	
	public Collection<String> getCustomeFilterData(){
		Predicate<String> predicate=new Predicate<String>() {

			public boolean apply(String arg0) {
				return arg0.startsWith("B");
			}
		};
		List<String> names = Lists.newArrayList("Ravi", "Bikash", "Basant");
		Collection<String> data=Collections2.filter(names, predicate);
		return data;
	}

	public static void main(String[] args) {
		App app = new App();
		// System.out.println(app.convertList2String());
		// System.out.println(app.convertMap2String());

		// System.out.println(app.ignoreNull());
		// System.out.println(app.replaceNull());
		// System.out.println(app.convertString2List());
		// System.out.println(app.convertString2Map());

		// System.out.println(app.multiSplit());

		//System.out.println(app.getFilterData());
		System.out.println(app.getCustomeFilterData());

	}
}
