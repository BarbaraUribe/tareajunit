package tareajunit;

import org.junit.Test;
import org.junit.Assert;

public class InventarioTest {
	
	@Test
	public void testAdd() {
		//Given
		Inventario inventario = new Inventario(0, 0, 0, 0);
		
		//When
		inventario.add(10, 20, 10, 40);

		//Then
		Assert.assertEquals(inventario.getCoffee(), 10);
		Assert.assertEquals(inventario.getMilk(), 20);
		Assert.assertEquals(inventario.getChoc(), 10);
		Assert.assertEquals(inventario.getSugar(), 40);
		
		//When
		inventario.add(100, 100, 100, 100);
		
		//Then
		Assert.assertEquals(inventario.getCoffee(), 10);
		Assert.assertEquals(inventario.getMilk(), 80);
		Assert.assertEquals(inventario.getChoc(), 10);
		Assert.assertEquals(inventario.getSugar(), 40);
		
		
	}
	
	@Test
	public void testCheck() {
		//Given
		Inventario inventario = new Inventario(0, 0, 0, 0);
		
		//When
		boolean resultado = inventario.check(2, 1, 2, 1);
		
		//Then
		Assert.assertEquals(resultado, false);
		
		//Given
		inventario.add(2, 1, 2, 1);
		
		//When
		resultado = inventario.check(2, 1, 2, 1);
		
		//Then
		Assert.assertEquals(resultado, true);
		
	}

}
