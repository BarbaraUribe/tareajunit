package tareajunit;
import org.junit.Assert;
import org.junit.Test;

public class CafeteraTest {
	
	private Cafetera cafetera;
	private Inventario inventario = new Inventario(0, 0, 0, 0);
	private Receta recetas[] = new Receta[]{
			new Receta("Mocaccino", 700, 2, 1, 2, 1),
			new Receta("Capuccino", 600, 2, 1, 0, 1),
			new Receta("Latte", 700, 4, 1, 0, 0),
			new Receta("Chocolate", 500, 0, 2, 2, 1)
	};

	@Test
	public void testbuy() {
		
		//Given
		
		cafetera = new Cafetera(inventario, recetas);
		
		//When
		int result = cafetera.buy("Capuccino vainilla", 1000);
		
		//Then 
		
		Assert.assertEquals(result, 1); // 1: no existe la bebida
		
		//When
		
		result = cafetera.buy("Mocaccino", 1000); 
		
		//Then 
		
		Assert.assertEquals(result, 3); // 3: no hay suficientes ingredientes
		
		//Given
		
		inventario.add(10, 80, 10, 40);
		
		//When
		
		result = cafetera.buy("Mocaccino", 100); 
		
		//Then 
		
		Assert.assertEquals(result, 2); // 2: no se pagó suficiente
		
		//When
		
		result = cafetera.buy("Mocaccino", 1000); 
		
		//Then 
		
		Assert.assertEquals(result, 300); // vuelto
		
	}

}