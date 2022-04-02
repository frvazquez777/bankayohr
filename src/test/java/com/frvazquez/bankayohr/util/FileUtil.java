package com.frvazquez.bankayohr.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("resource")
public class FileUtil {

	public static String getData(File file) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader(file));
		String result = "";
		String linea;
		while ((linea = read.readLine()) != null)
			result += linea;

		return result;
	}

}
