package test;
//union find question
//iterate all the entries, if the entry elements are not showed before add them with there own id 
//if the entry elements are showed before, do the union operation(find same root)
//union find usually need findRoot function


import java.util.*;
public class Solution721_account_merge_UnionFind {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    	
        HashMap<Integer, String> idToName = new HashMap<>();
        TreeMap<Integer, List<String>> ansMap = new TreeMap<>(); 
        List<List<String>> ans = new LinkedList<>();
       
        for(int i = 0; i < accounts.size(); i++){
        	idToName.put(i, accounts.get(i).get(0));
        }
        
        HashMap<Integer, Integer> idBelongTo = new HashMap<>();
        HashMap<String, Integer> emailBelongTo = new HashMap<>();
        
        for(int i = 0; i < accounts.size(); i++){
        	int parent = i;
        	List<String> account = accounts.get(i);
        	//union
        	List<Integer> sameRoot = new LinkedList<>();
        	for(int j = 1; j < account.size(); j++){
        		String s = account.get(j);
        		if(emailBelongTo.containsKey(s)){
        			sameRoot.add(emailBelongTo.get(s));
        		}
        	}
        	parent = union(idBelongTo, sameRoot);
        	if(parent == -1)parent = i;
        	
        	idBelongTo.put(i, parent);
        	for(String s: accounts.get(i)){
        		emailBelongTo.put(s, parent);
        	}
        	
        	
        	
        }
        
        HashSet<String> emailUsed = new HashSet<>();
        for(int id = 0; id < accounts.size(); id++){
        	List<String> account = accounts.get(id);
        	int root = getRoot(idBelongTo, id);
        	if(!ansMap.containsKey(root)){
        		LinkedList<String> entry = new LinkedList<>();
        		entry.add(idToName.get(root));
        		ansMap.put(root, entry);
        	}
        	for(int i = 1 ; i < account.size(); i++){
        		if(emailUsed.contains(account.get(i)))continue;
        		emailUsed.add(account.get(i));
        		ansMap.get(root).add(account.get(i));
        	}
        }
        
        for(int i: ansMap.keySet()){
        	ans.add(ansMap.get(i));
        }
        
        for(List<String> account: ans){
        	Collections.sort(account);
        }
        
        return ans;
    }
    
    public int getRoot(HashMap<Integer, Integer> idBelongTo, int id){
    	while(idBelongTo.get(id) != id){
    		id = idBelongTo.get(id);
    	}
    	return id;
    }
    
    public int union(HashMap<Integer, Integer> idBelongTo, List<Integer> sameRoot){
    	if(sameRoot.size() == 0)return -1;
    	if(sameRoot.size() == 1)return sameRoot.get(0);
    	
    	int newRoot = getRoot(idBelongTo, sameRoot.get(0));
    	for(int i = 1; i < sameRoot.size(); i++){
    		idBelongTo.put(getRoot(idBelongTo, sameRoot.get(i)), newRoot);
    	}
    	return newRoot;
    }
}
