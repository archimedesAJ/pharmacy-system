package pharma;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to represent a prefix tree (trie) 
 * in which each each node stores a character
 * and can have as many children as possible. 
 */ 
  class Trie {
    private final TrieNode root;
 
    //Constructor to create an empty trie
    public Trie() {
        root = new TrieNode(' '); 
    }
   // A method to add a drug name to the trie
    public void addDrug(String drugName) {
        if (find(drugName) == true) 
            return;    
        TrieNode current = root; 
        TrieNode prev ;
        for (char character : drugName.toCharArray()) {
         prev = current;
            TrieNode child = current.getChild(character);
            if (child != null){
                current = child;
                child.parent = prev;
            } else {
                 current.children.add(new TrieNode(character));
                 current = current.getChild(character);
                 current.parent = prev;
            }
        }
        current.isEndOfWord = true;
    }
   
    //Delete drug name from the trie
    public boolean deleteDrug(String drugName){
      if (find(drugName) == false){
        return false;
      }
      
      TrieNode current = root;
      for (char ch : drugName.toCharArray()){ 
            TrieNode child = current.getChild(ch);
            if (child == null){
                current.children.remove(child);
                return true;
            } else{
              current = child;
              
            }
        }
        current.isEndOfWord = false;
        return true;
    }
    
    // Find drug name from the tie
    public boolean find(String drugName) {
        TrieNode current = root;      
        for (char ch : drugName.toCharArray()) {
            if (current.getChild(ch) == null)
                return false;
            else {
                current = current.getChild(ch);    
            }
        }      
        if (current.isEndOfWord != true) {       
            return true;
        }
        return false;
    }
    
    public List drugPrediction(String prefix) {     
       TrieNode leaf = root;
       for (int i = 0; i< prefix.length(); i++) {
        leaf = leaf.getChild(prefix.charAt(i));      
        if (leaf == null) 
         return new ArrayList();      
       }
       
       return leaf.getWords();
    }
    
  public class TrieNode{
    char element;
    LinkedList<TrieNode> children;
    TrieNode parent;
    boolean isEndOfWord;
  
  public TrieNode(char c){
    element = c;
    children = new LinkedList<>();
    isEndOfWord = false;
  }
  public TrieNode getChild(char c){
    if (children != null){
      for (TrieNode child : children)
        if (child.element ==c)
          return child;
    }
    return null;
  }
  
  protected List getWords() {
       List list = new ArrayList();      
       if (isEndOfWord) {
        list.add(toString());
       }
       
       if (children != null) {
        for (int k=0; k< children.size(); k++) {
           if (children.get(k) != null) {
              list.addAll(children.get(k).getWords());
           }
        }
       }       
       return list; 
    }

    @Override
  public String toString() {
  if (parent == null) {
       return "";
  } else {
       return parent.toString() + new String(new char[] {element});
  }
 }
}
    
 
//class AutocompleteWithTrie {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
     Scanner str = new Scanner(System.in);
     Trie trie = new Trie();
     trie = new Trie();
     trie.addDrug("abilify"); 
     trie.addDrug("acetaminophen"); 
     trie.addDrug("actos");     
     trie.addDrug("acyclovir"); 
     trie.addDrug("adderall");
     trie.addDrug("adderall XR");
     trie.addDrug("advair Diskus");
     trie.addDrug("aerosols");
     trie.addDrug("agaric");
     trie.addDrug("alpha-methyltryptamine");
     trie.addDrug("amani");
     trie.addDrug("amphetamine");
     trie.addDrug("amsterdam-gold");
     trie.addDrug("amt freebase");
     trie.addDrug("amyls");
     trie.addDrug("anabolic steroids");
     trie.addDrug("angel dust");
     trie.addDrug("annihilation");
     trie.addDrug("annihilation");
     trie.addDrug("annihilation");
     trie.addDrug("atropine"); 
     trie.addDrug("atenolol");
     trie.addDrug("ayahuasca");
     trie.addDrug("azithromycin");
     trie.addDrug("baccy");
     trie.addDrug("bacitracin"); 
     trie.addDrug("baclofen");  
     trie.addDrug("bactrim");     
     trie.addDrug("bactrim DS"); 
     trie.addDrug("bactroban");
     trie.addDrug("ballons Nitrous oxide");
     trie.addDrug("banshee dust");
     trie.addDrug("basaglar");
     trie.addDrug("base");
     trie.addDrug("bath salts");
     trie.addDrug("Beans ecstasy");
     trie.addDrug("belbuca");
     trie.addDrug("belsomra");
     trie.addDrug("benzo fury");
     trie.addDrug("benzodiazepines");
     trie.addDrug("benzofuran compounds");
     trie.addDrug("bhang");
     trie.addDrug("billy");
     trie.addDrug("blast");
     trie.addDrug("blotter");
     trie.addDrug("blow");
     trie.addDrug("blue blue");
     trie.addDrug("bolts extra");
     trie.addDrug("bom-25");
     trie.addDrug("bonsai supersleep");
     trie.addDrug("booze");
     trie.addDrug("brownnies");
     trie.addDrug("brilinta"); 
     trie.addDrug("bud cannabis");
     trie.addDrug("bumex");
     trie.addDrug("burst methylphenidate");
     trie.addDrug("codeine - caffeine"); 
     trie.addDrug("cabazitaxel (Jevtana)");     
     trie.addDrug("cabergoline (CO Cabergoline, Dostinex)"); 
     trie.addDrug("cabometyx (cabozantinib)");
     trie.addDrug("cabozantinib (Cabometyx)");
     trie.addDrug("caduet (amlodipine - atorvastatin)");
     trie.addDrug("caelyx (doxorubicin)");
     trie.addDrug("dabigatran (Pradaxa)"); 
     trie.addDrug("dabrafenib (Tafinlar)"); 
     trie.addDrug("dacarbazine (Dacarbazine for Injection BP)"); 
     trie.addDrug("dacarbazine for Injection BP (dacarbazine)"); 
     trie.addDrug("daclatasvir (Daklinza)");     
     trie.addDrug("daclizumab (Zinbryta)"); 
     trie.addDrug("dactinomycin (Cosmegen");
     trie.addDrug("daklinza (daclatasvir)");
     trie.addDrug("echinacea");
     trie.addDrug("ecotrin");
     trie.addDrug("effexor"); 
     trie.addDrug("effexor XR"); 
     trie.addDrug("effient"); 
     trie.addDrug("elavil"); 
     trie.addDrug("elidel");     
     trie.addDrug("eligard"); 
     trie.addDrug("famotidine");
     trie.addDrug("farxiga");
     trie.addDrug("febuxostat");
     trie.addDrug("femara");
     trie.addDrug("fenofibrate"); 
     trie.addDrug("fentanyl"); 
  }
 
  }
