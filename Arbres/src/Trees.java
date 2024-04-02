import java.util.ArrayDeque;
import java.util.Deque;

public class Trees {

	// *******************************************************
	// Un premier exemple: le nombre de feuilles d'un arbre
	// *******************************************************
	public static int nbrLeaves(Tree t) {
		int r;
		if (t.isLeaf()) {
			r = 1;
		} else {
			r = 0;
			for (Tree child : t) {
				r += nbrLeaves(child);
			}
		}
		return r;
	}

	// *******************************************************
	// Un deuxi�me exemple: aplanir un arbre
	// *******************************************************
	public static Tree[] flattenLeaves(Tree t) {
		int nl = nbrLeaves(t);
		Tree[] r = new Tree[nl];
		flattenLeaves(t, r, 0);
		return r;
	}

	private static int flattenLeaves(Tree t, Tree[] a, int idx) {
		int r;
		if (t.isLeaf()) {
			a[idx] = t;
			r = 1;
		} else {
			r = 0;
			for (Tree child : t) {
				r += flattenLeaves(child, a, idx + r);
			}
		}
		return r;
	}

	// *******************************************************
	// Un troisi�me exemple:
	// tous les algorithmes ne sont pas r�cursifs
	// *******************************************************
	public static void pathV1(Tree t) {
		System.out.println(t.getValue());
		if (t.getParent() != null) {
			pathV1(t.getParent());
		}
	}

	public static void pathV2(Tree t) {
		while (t != null) {
			System.out.println(t.getValue());
			t = t.getParent();
		}
	}

	// *******************************************************
	// Exercices 1
	// *******************************************************

	// 1.1) TODO DONE
	public static int nbrNode(Tree t) {
		int nbrFeuille;

		if(t.isLeaf()){
			nbrFeuille=1;
		}else {
			nbrFeuille=0;
			for(Tree child : t.getChildren()){
				nbrFeuille += nbrNode(child);
			}
		}
		return nbrFeuille;
	}

	// 1.2) TODO DONE
	public static int min(Tree t) {
		int min = t.getValue();
		if(t.isLeaf()){
			return min;
		}else{
			for(Tree child : t.getChildren()){
				min = Math.min(min, min(child));
			}
		}
		return min;
	}

	// 1.3) TODO DONE
	public static int sum(Tree t) {
		int sum= t.getValue();
		if(!t.isLeaf()){
			for (Tree child : t.getChildren()){
				sum += sum(child);
			}
		}
		return sum;
	}

	// 1.4) TODO DONE
	public static boolean equals(Tree t1, Tree t2) {
		// verifie que les deux on la meme valeur
		if(t1.getValue() != t2.getValue()) return  false;

		// verifie qu'ils ont le meme nombre d'enfants
		if(t1.nbrChildren() != t2.nbrChildren()) return false;

		// verifie que tous les enfants sont identiques
		for(int i = 0; i < t1.nbrChildren(); i++){
			if(!equals(t1.getChildren()[i], t2.getChildren()[i])){
				return false;
			}
		}
		return true;
	}

	// 1.5) TODO DONE
	public static int depth(Tree n) {
		if (n.getParent() != null) {
			return 1 + depth(n.getParent());
		}
		return 0;
	}

	// 1.6) TODO DONE
	public static boolean sameOne(Tree n1, Tree n2) {
		// si n1 n'a pas de parent et n2 n'a pas de parent
		if(n1.getParent() != null) return sameOne(n1.getParent(), n2);
		if(n2.getParent() != null) return sameOne(n1, n2.getParent());
		return true;
	}

	// 1.7) TODO DONE
	public static void dfsPrint(Tree t) {
		System.out.print(t.getValue()+"-");
		for (Tree child : t) {
			dfsPrint(child);
		}
	}

	// 1.8) TODO DONE
	public static void bfsPrint(Tree t) {
		Deque<Tree> list = new ArrayDeque<>();
		list.push(t);
		bfsPrint(list);
	}

	public static void bfsPrint(Deque<Tree> list){
		if(!list.isEmpty()){
			Tree current = list.pop();
			System.out.print(current.getValue() + "-");

			for (Tree child: current.getChildren()){
				list.addLast(child);
			}

			bfsPrint(list);
		}
	}

	// *******************************************************
	// Exercices 2
	// *******************************************************

	// 2.1) TODO DONE
	static void printPathV1(Tree node) {
		if (node.getParent() != null) {
			printPathV1(node.getParent());
		}
		System.out.print("->"+node.getValue());
	}

	// 2.2) TODO DONE
	static void printPathV2(Tree node) {
		Deque<Tree> parentList = new ArrayDeque<>();
		// On parcourt tout les parents
		while (node.getParent() != null){
			parentList.addFirst(node);
			node = node.getParent();
		}
		// Add the root node to the list
		parentList.addFirst(node);
		//On affiche
		for (Tree prnt : parentList) System.out.print("->"+prnt.getValue());
	}

	// 2.3
	static void printPathV3(Tree t, int v) {
		if (t.getValue() == v) {
			printPathV1(t);
			return;
		}

		for (Tree c: t) {
			printPathV3(c, v);
		}
	}

	// *******************************************************
	// Exercices 3
	// *******************************************************

	// 3.1
	public static int[][] toArray(Tree t) {
		int[][] tab = new int[3][nbrNode(t)];

		return tab;
	}

	// 3.2
	public static Tree toTree(int[][] t) {
		return null;
	}

	// *******************************************************
	// Exercices 4
	// *******************************************************

	public static Tree lca(Tree n1, Tree n2) {
		return null;
	}
}