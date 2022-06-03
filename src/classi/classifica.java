package classi;

public class classifica implements Comparable<classifica>{
	int score;
	String name;
public classifica(int s, String n) {
	score = s;
	name = n;
}
public int score() {return score;}
public String name() {return name;}
public void setscore(int ss){score = ss;}

@Override
public int compareTo(classifica o) {
	if (o.score() >= this.score()) return 1;
	else return -1;
}

/* Test 
public static void main(String[] args) {
	classifica c1 = new classifica(5, "Piccola");
	classifica c2 = new classifica(7, "grande");
	ArrayList<classifica> cl = new ArrayList<classifica>();
	cl.add(c1);
	cl.add(c2);
	Collections.sort(cl);
	for(int i =0; i<2;i++)
		System.out.println(cl.get(i).name);

}*/
}
