package tareajunit;

public class Cafetera {
	
	private Inventario inventario;
	private Receta[] recetas;
	
	
	public Cafetera(Inventario inventario, Receta[] recetas) {
		super();
		this.inventario = inventario;
		this.recetas = recetas;
	}


	public Inventario getInventario() {
		return inventario;
	}


	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}


	public Receta[] getRecetas() {
		return recetas;
	}


	public void setRecetas(Receta[] recetas) {
		this.recetas = recetas;
	}
	
	public int buy(String nombre, int pago) {
		
		int costo = 0;
		boolean check = false;
		Receta receta = null;
		
		for (Receta r : this.recetas) {
			if(r.getName().equals(nombre)) {
				
				check = this.inventario.check(r.getU_coffee(), r.getU_milk(), r.getU_choc(), r.getU_sugar());
				if (!check) {
					return 3;
				}
				receta = r;
				costo = r.getPrice();
			}
		}
		
		if (costo == 0) {
			//Si no está la bebida
			return 1;
		} else if (pago < costo) {
			//Si no se pagó suficiente
			return 2;
		} else {
			this.inventario.setCoffee(this.inventario.getCoffee() - receta.getU_coffee());
			this.inventario.setMilk(this.inventario.getMilk() - receta.getU_milk());
			this.inventario.setChoc(this.inventario.getChoc() - receta.getU_choc());
			this.inventario.setSugar(this.inventario.getSugar() - receta.getU_sugar());
			//Se calcula el vuelto
			return pago - costo;
		}
		
	}

}