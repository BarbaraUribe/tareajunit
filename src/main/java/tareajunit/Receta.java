package tareajunit;

public class Receta {
	
	private String name;
	private int price;
	private int u_coffee;
	private int u_milk;
	private int u_choc;
	private int u_sugar;
	
	public Receta(String name, int price, int u_coffee, int u_milk, int u_choc, int u_sugar) {
		super();
		this.name = name;
		this.price = price;
		this.u_coffee = u_coffee;
		this.u_milk = u_milk;
		this.u_choc = u_choc;
		this.u_sugar = u_sugar;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getU_coffee() {
		return u_coffee;
	}

	public void setU_coffee(int u_coffee) {
		this.u_coffee = u_coffee;
	}

	public int getU_milk() {
		return u_milk;
	}

	public void setU_milk(int u_milk) {
		this.u_milk = u_milk;
	}

	public int getU_choc() {
		return u_choc;
	}

	public void setU_choc(int u_choc) {
		this.u_choc = u_choc;
	}

	public int getU_sugar() {
		return u_sugar;
	}

	public void setU_sugar(int u_sugar) {
		this.u_sugar = u_sugar;
	}

}
