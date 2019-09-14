
public class Attempt implements Comparable<Attempt>{

	private String att;
	private String add;
	private int freq;
	private boolean show;

	public Attempt(String att, String add, int f){
		this.att = att;
		this.add = add;
		freq = f;
		show = true;		
	}

	public String toString(){
		return att + "   " + add;
	}

	
	public int compareTo(Attempt a){
		return add.compareTo(a.add);
	}
	
	public int getFreq(){
		return freq;
	}
	
	public void addFreq(){
		freq ++;
	}

	public boolean getShow(){
		return show;
	}
	
	public void changeShow(){
		show = false;
	}

	public String getAtt(){
		return att;
	}

	public String getAdd(){
		return add;
	}

}