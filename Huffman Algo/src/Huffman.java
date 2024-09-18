import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import org.w3c.dom.Node;

public class Huffman {

   static class Node  {
    private char ch;
    private int freq;
    private final Node left, right;

    public Node(char ch, int freq, Node left, Node right) {
      this.ch = ch;
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    public boolean isLeaf() {
      return left == null && right == null;
    }

  }

  //TODO: renvoie une map qui a comme clé les lettres de la chaine de
  // caractère donnée en paramètre et comme valeur la fréquence de ces lettres
  public static Map<Character, Integer> computeFreq(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (freq.containsKey(c)) {
        freq.put(c, freq.get(c) + 1);
      } else {
        freq.put(c, 1);
      }
    }
    return freq;
  }

  //TODO: renvoie l'arbre de Huffman obtenu � partir de la map des fr�quences des lettres
  public static Node buildTree(Map<Character, Integer> freq) {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));

    for (Entry<Character, Integer> entry : freq.entrySet()) {
      pq.add(new Node(entry.getKey(), entry.getValue(), null, null));
    }

    while (pq.size() > 1) {
      Node left = pq.poll();
      Node right = pq.poll();
      Node parent = new Node('\0', left.freq + right.freq, left, right);
      pq.add(parent);
    }

    return pq.poll();
  }

  //TODO: renvoie une map qui associe chaque lettre � son code (suite de 0 et de 1).
  // Ce code est obtenu en parcourant l'arbre de Huffman donn� en param�tre
  public static Map<Character, String> buildCode(Node root) {
    Map<Character, String> codeMap = new HashMap<>();
    buildCode(root, "", codeMap);
    return codeMap;
  }

  private static void buildCode(Node node, String s, Map<Character, String> codeMap) {
    // tant que le node n'est pas une feuille
    if (!node.isLeaf()) {
      // on ajoute un 0 pour le fils de gauche et un 1 pour le fils de droite
      buildCode(node.left, s + '0', codeMap);
      buildCode(node.right, s + '1', codeMap);
    } else {
      // on ajoute le code de la feuille dans la map
      codeMap.put(node.ch, s);
    }
  }


  //TODO: encode la chaine de caract�re prise en param�tre en une chaine de
  // bit (0 et 1) en utilisant la map des codes codeMap
  public static String compress(String s, Map<Character, String> codeMap) {
     String result="";

     // On parcourt la chaine de caract�re
     for(int i = 0; i < s.length(); i++) {
       char c = s.charAt(i);
        // On ajoute le code de chaque caractère dans le résultat
       if (codeMap.containsKey(c)){
         result+=codeMap.get(c);
       }

     }
    return result;
  }

  // Cette m�thode d�code une chaine de 0 et de 1 cod� � l'aide de l'algorithme de Huffman
  // En param�tre, en plus de la chaine � d�coder, est sp�cifi� la racine de l'arbre de
  // Huffman
  public static String expand(Node root, String t) {
    Node currentNode = root;
    StringBuilder expandedString = new StringBuilder();

    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);

      //Si le char est un 1 on va à droite sinon a gauche
      if(c == '1'){
        currentNode = currentNode.right;
      }else{
        currentNode = currentNode.left;
      }

      // Si on est sur une feuille
      if(currentNode.isLeaf()){
        // on traduit le binaire en texte
        expandedString.append(currentNode.ch);
        // On revient à la racine
        currentNode = root;
      }
    }

    return expandedString.toString();
  }


  public static void main(String[] args) {
    String s="Bonjour! Au revoir!";
    Map<Character, Integer> freq = computeFreq(s);
    Node root = buildTree(freq);
    Map<Character, String> code= buildCode(root);
    String compress = compress(s, code);
    System.out.println("Texte compressé: "+ compress);
    String texteOriginal = expand(root,compress);
    System.out.println("Texte Original: "+texteOriginal);}
}
