package com.telstra.restservice.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.telstra.restservice.service.TrieOperations;

@Configuration
public class DictonaryTrie {

	@Autowired
	TrieOperations trieoperations;

	@Bean
	public String DictoryTrieCreationBean() throws FileNotFoundException, IOException 
	{
		
		String path="src/main/resources/dictonary.txt";
		String line;
		try (
		    InputStream fis = new FileInputStream(path);
		    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		    BufferedReader br = new BufferedReader(isr);
			) 
			{
		    	while ((line = br.readLine()) != null) {
		    			trieoperations.insert(line);
		    		}
			}
		System.out.println("DICTONARY TRIE CREATED SUCCESSFLLY");
		return "exiting";
	}
	
	public ArrayList<String> recommandedwords(String s) throws IOException ,NullPointerException
	{
		if(!trieoperations.search(s))System.out.println("PREFIX: "+s);
		return trieoperations.searchChildren(s);
		
	}
	
}
