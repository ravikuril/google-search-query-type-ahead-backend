package com.telstra.restservice.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.restservice.service.*;
import javassist.expr.NewArray;

@RestController
public class UserController {

	@Autowired
	DictonaryTrie dictonarytrie;
	
	@RequestMapping(value = "/text")
	public String index() {
	        return "index.html";
	    }
	
    @GetMapping(path = "/{prefix}")
    public ArrayList<String> SearchByUsernamefun(@PathVariable("prefix") String prefix) throws IOException 
    {
    	
    	return dictonarytrie.recommandedwords(prefix);
    }
    
    @PostMapping(consumes = "application/json")
    public void InsertUserDatafun(@RequestBody String s) 
    {
    	
    }
   
}
