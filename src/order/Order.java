package order;

import java.io.*;
import java.util.*;

public class Order {
	
	static String repository= "src/repository";
	public static void ascending() {
		
		File[] files = new File(repository).listFiles();
		Set<String> a = new TreeSet<>();
		for(File file : files) {
			if (!file.isFile()) {
				continue;
			}
			a.add(file.getName());
		}
		a.forEach(i->System.out.println(i));

	}
}
