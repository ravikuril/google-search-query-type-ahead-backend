package com.telstra.restservice.service;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TrieOperations {
    private TrieNode root;
    

    public TrieOperations() {
        root = new TrieNode();
    }

    public void insert(String word) {
        Map<Character, TrieNode> children = root.getChildren();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            if(children.containsKey(c)) {
                node = children.get(c);
            } else { 
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();

            if(i == word.length() - 1) {
                node.setLeaf(true);
            }
        }
    }

    public boolean search(String word) {
        Map<Character, TrieNode> children = root.getChildren();
        if(children.isEmpty())System.err.println("NO children found in search");
        
        TrieNode node = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            } else { 
                node = null;
                break;
            }
        }

        if(node != null && node.isLeaf()) {
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<String> allchildrenfind(TrieNode node,Map<Character,TrieNode>children,ArrayList<String>result,String word,String baseword) 
    {
    	if(node!=null&&node.isLeaf()) 
    	{
    		String recommended_word=baseword;
    		recommended_word+=word;
    		System.err.println("word is :"+word);
    		result.add(recommended_word);
    		return result;
    	}
    	if(node==null||children.isEmpty()) {return result;}
    	
    	
    	if(node!=null) 
    	{
    		for (Map.Entry<Character,TrieNode> entry : children.entrySet())  
    		{	System.out.println("searching for :"+ entry.getKey());
    			node=children.get(entry.getKey());
    			allchildrenfind(node,children.get(entry.getKey()).getChildren(),result,word+entry.getKey(),baseword);
    		}
    	}
		return result;
    }

	public ArrayList<String> searchChildren(String word) throws NullPointerException {
        Map<Character, TrieNode> children = root.getChildren();
        if(children.isEmpty())System.err.println("NO children found");
        ArrayList<String> recommand_word=new ArrayList<String>();
        
        TrieNode node = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);System.err.println("children found:"+ c);
            if(children.containsKey(c)) {
            	
                node = children.get(c);
                children = node.getChildren();
            } else { 
                node = null;
                break;
            }
        }

        if(node != null && node.isLeaf()) {
        	ArrayList<String> result = null;
            return result;
        } 
        if(node!=null&&!node.isLeaf()) 
        {
        	
        	 ArrayList<String> result = new ArrayList<String>();
        	 String nullword="";
        	recommand_word=allchildrenfind(node,children,result,nullword,word);
        	
        }
        return recommand_word;
    }


}