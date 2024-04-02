public class Main {
  public static void main(String[] args){
    Tree l1 = new Tree(1);
    Tree l3 = new Tree(3);
    Tree l5 = new Tree(5);
    Tree l7 = new Tree(7);
    
    Tree t2 = new Tree(2, new Tree[]{l1, l3});
    Tree t6 = new Tree(6, new Tree[]{l7});
    
    Tree t4 = new Tree(4, new Tree[]{t2, l5, t6});

    System.out.println(Trees.nbrLeaves(t4));
    
    
    Tree[] ls = Trees.flattenLeaves(t4);
    System.out.println("Les " + ls.length + " feuilles");
    int i = 0;
    while(i != ls.length) {
      System.out.println(ls[i].getValue());
      i++;
    }

    System.out.println("Path V1");    
    Trees.pathV1(l7);

    System.out.println("Path V2");    
    Trees.pathV2(l7);

    System.out.println("==========TEST==========");
    System.out.print("1.1) Nbr de noeud: ");
    if (Trees.nbrNode(t4) == 4) System.out.println("OK");
    else System.out.println("ko");

    System.out.print("1.2) Minimum: ");
    if (Trees.min(t4) == 1) System.out.println("OK");
    else System.out.println("ko");

    System.out.print("1.3) Somme: ");
    if (Trees.sum(t4) == 28) System.out.println("OK");
    else System.out.println("ko");

    System.out.print("1.4) Equals: ");
    if (Trees.equals(t4,t4)) System.out.println("OK");
    else System.out.println("ko");

    System.out.print("1.5) Depth: ");
    if (Trees.depth(t4) ==3) System.out.println("OK");
    else System.out.println("ko");

    System.out.print("1.6) sameOne: ");
    if (Trees.sameOne(t4, t4)) System.out.println("OK");
    else System.out.println("ko");

    System.out.print("1.7) dfsPrint: ");
    Trees.dfsPrint(t4);

    System.out.println();
    System.out.print("1.8) bfsPrint: ");
    Trees.bfsPrint(t4);

    System.out.println();
    System.out.print("2.1) printPathV1: ");
    Trees.printPathV1(l1);

    System.out.println();
    System.out.print("2.2) printPathV2: ");
    Trees.printPathV2(l1);

    System.out.println();
    System.out.print("2.3) printPathV3: ");
    Trees.printPathV3(t4,7);
  }
}
