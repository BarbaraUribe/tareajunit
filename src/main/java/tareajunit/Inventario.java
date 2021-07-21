package tareajunit;

public class Inventario {
	
	private int coffee;
	private int milk;
	private int choc;
	private int sugar;
	
	public Inventario() {
		//TODO
	}

	public Inventario(int coffee, int milk, int choc, int sugar) {
		super();
		this.coffee = coffee;
		this.milk = milk;
		this.choc = choc;
		this.sugar = sugar;
	}
	
	public void add(int coffee, int milk, int choc, int sugar) {
		if (this.coffee + coffee > 10) {
			this.coffee = 10;
		} else {
			this.coffee += coffee;
		}
		if (this.milk + milk > 80) {
			this.milk = 80;
		} else {
			this.milk += milk;
		}
		if (this.choc + choc > 10) {
			this.choc = 10;
		} else {
			this.choc += choc;
		}
		if (this.sugar + sugar > 40) {
			this.sugar = 40;
		} else {
			this.sugar += sugar;
		}
	}
	
	public boolean check(int u_coffee, int u_milk, int u_choc, int u_sugar) {
		if(this.coffee < u_coffee || this.milk < u_milk || this.choc < u_choc || this.sugar < u_sugar) {
			return false;
		}
		return true;
	}

	public int getCoffee() {
		return coffee;
	}

	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getChoc() {
		return choc;
	}

	public void setChoc(int choc) {
		this.choc = choc;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}	

}