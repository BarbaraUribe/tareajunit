package tareajunit;


import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

public class MainTest {
	
	static Logger logger = Logger.getLogger("Log");
	static FileHandler fh;
	
	@BeforeClass
	public static void log() {
		Date d = new Date(); 
		SimpleDateFormat d_formatter = new SimpleDateFormat("dd-M-yyyy hh mm ss");  
	    String date = d_formatter.format(d);
		
		try {
			fh = new FileHandler("src/" + "test-" + date + ".log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			logger.setUseParentHandlers(false);
			fh.setFormatter(formatter);
		} catch (SecurityException e) {  
	        logger.info("Error" + e);  
	    } catch (IOException e) {  
	        logger.info("Error" + e);
	    } 
	}
	
	@Test
	public void testOptionsVerificarInventario() throws IOException {
		//Given
		logger.info("-----testOptionsVerificarInventario-----");
		Receta[] recetas = new Receta[]{
				new Receta("Mocaccino", 700, 2, 1, 2, 1),
				new Receta("Capuccino", 600, 2, 1, 0, 1),
				new Receta("Latte", 	700, 4, 1, 0, 0),
				new Receta("Chocolate", 500, 0, 2, 2, 1)
		};
		logger.info("Se incluyeron las siguientes recetas: \n(\"Mocaccino\", 700, 2, 1, 2, 1), \n"
				+ "(\"Capuccino\", 600, 2, 1, 0, 1), \n"
				+ "(\"Latte\", 700, 4, 1, 0, 0), \n"
				+ "(\"Chocolate\", 500, 0, 2, 2, 1)");
		Inventario inventario = new Inventario(0, 0, 0, 0);
		logger.info("Se inicia con inventario vac�o");
		Cafetera cafetera = new Cafetera(inventario, recetas);
		String s = "a";
		
		//When
		String resultado = Main.options(s, cafetera);
		
		//Then
		Assert.assertEquals(resultado, "Ingrese una instrucci�n v�lida \nEsperando...");
		
		//Given
		
		s = "Verificar inventario";
		
		//When
		resultado = Main.options(s, cafetera);
		
		//Then
		Assert.assertEquals("Caf�: " + 0 + "\n" + "Leche: " + 0 + "\n" + "Chocolate: " + 0 + "\n" + "Az�car: " + 0 + "\nEsperando...", resultado);
		
		
		//Given
		inventario.add(100, 100, 100, 100);
		logger.info("Se intentaron agregar 100 unidades de caf�, 100 unidades de leche, 100 unidades de chocolate y 100 unidades de az�car al inventario");
		logger.info("El inventario qued� con "+ inventario.getCoffee() + " unidades de caf�, " + inventario.getMilk() + " unidades de leche, " + inventario.getChoc() + " unidades de chocolate y "
				+ inventario.getSugar() + " unidades de az�car");
		s = "Verificar inventario";
		
		//When
		resultado = Main.options(s, cafetera);
		
		//Then
		Assert.assertEquals(resultado, "Caf�: " + 10 + "\n" + "Leche: " + 80 + "\n" + "Chocolate: " + 10 + "\n" + "Az�car: " + 40 + "\nEsperando...");
		
	}
	
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testOptionsAgregarInventario() throws IOException {
		//Given
		logger.info("-----testOptionsAgregarInventario-----");
		Receta[] recetas = new Receta[]{
				new Receta("Mocaccino", 700, 2, 1, 2, 1),
				new Receta("Capuccino", 600, 2, 1, 0, 1),
				new Receta("Latte", 	700, 4, 1, 0, 0),
				new Receta("Chocolate", 500, 0, 2, 2, 1)
		};
		logger.info("Se incluyeron las siguientes recetas: \n(\"Mocaccino\", 700, 2, 1, 2, 1), \n"
				+ "(\"Capuccino\", 600, 2, 1, 0, 1), \n"
				+ "(\"Latte\", 700, 4, 1, 0, 0), \n"
				+ "(\"Chocolate\", 500, 0, 2, 2, 1)");
		Inventario inventario = new Inventario(0, 0, 0, 0);
		logger.info("Se inicia con inventario vac�o");
		Cafetera cafetera = new Cafetera(inventario, recetas);
		String s = "Agregar inventario";
				
		//When
		systemInMock.provideLines("10", "0.0", "60", "30", "a", "10");
		String resultado = Main.options(s, cafetera);
		
		//Then
		Assert.assertEquals("Esperando...", resultado);
		
	}
	
	@Test
	public void testOptionsComprarBebida() throws IOException {
		//Given
		logger.info("-----testOptionsComprarBebida-----");
		Receta[] recetas = new Receta[]{
				new Receta("Mocaccino", 700, 2, 1, 2, 1),
				new Receta("Capuccino", 600, 2, 1, 0, 1),
				new Receta("Latte", 	700, 4, 1, 0, 0),
				new Receta("Chocolate", 500, 0, 2, 2, 1)
		};
		logger.info("Se incluyeron las siguientes recetas: \n(\"Mocaccino\", 700, 2, 1, 2, 1), \n"
				+ "(\"Capuccino\", 600, 2, 1, 0, 1), \n"
				+ "(\"Latte\", 700, 4, 1, 0, 0), \n"
				+ "(\"Chocolate\", 500, 0, 2, 2, 1)");
		Inventario inventario = new Inventario(0, 0, 0, 0);
		logger.info("Se inicia con inventario vac�o");
		Cafetera cafetera = new Cafetera(inventario, recetas);
		String s = "Comprar bebida";
		//When
		systemInMock.provideLines("Capuccino vainilla", "1000");
		String resultado = Main.options(s, cafetera);
		
		//Then
		Assert.assertEquals("Seleccione una bebida v�lida \nEsperando...", resultado);
		
		//When
		systemInMock.provideLines("Capuccino", "600");
		resultado = Main.options(s, cafetera);
		
		//Then
		Assert.assertEquals("No tenemos suficientes ingredientes para preparar su bebida, por lo que le devolvemos su dinero: $" + "600" + "\nEsperando...", resultado);
		
		//When
		systemInMock.provideLines("Capuccino", "500");
		inventario.add(10, 10, 10, 10);
		logger.info("Se intentaron agregar 10 unidades de caf�, 10 unidades de leche, 10 unidades de chocolate y 10 unidades de az�car al inventario");
		logger.info("El inventario qued� con "+ inventario.getCoffee() + " unidades de caf�, " + inventario.getMilk() + " unidades de leche, " + inventario.getChoc() + " unidades de chocolate y "
				+ inventario.getSugar() + " unidades de az�car");
		resultado = Main.options(s, cafetera);
		
		//Then
		Assert.assertEquals("No pag� suficiente, por lo que le devolvemos su dinero: $" + "500" + "\nEsperando...", resultado);
		
		//When
		systemInMock.provideLines("Chocolate", "500");
		inventario.add(10, 10, 10, 10);
		logger.info("Se intentaron agregar 10 unidades de caf�, 10 unidades de leche, 10 unidades de chocolate y 10 unidades de az�car al inventario");
		logger.info("El inventario qued� con "+ inventario.getCoffee() + " unidades de caf�, " + inventario.getMilk() + " unidades de leche, " + inventario.getChoc() + " unidades de chocolate y "
				+ inventario.getSugar() + " unidades de az�car");
		resultado = Main.options(s, cafetera);
				
		//Then
		Assert.assertEquals("Su vuelto es: $" + "0" + "\nSu bebida " + "Chocolate" + " est� lista \nEsperando...", resultado);
		
	}
	
	
	@Test
	public void testTryParse() {
		//Given
		String s = "a";
		
		//When
		boolean resultado = Main.tryParse(s);
		
		//Then
		Assert.assertEquals(resultado, false);
		
		//Given
		s = "2.0";
		
		//When
		resultado = Main.tryParse(s);
		
		//Then
		Assert.assertEquals(resultado, false);
		
		//Given
		s = "-5";
				
		//When
		resultado = Main.tryParse(s);
				
		//Then
		Assert.assertEquals(resultado, false);
		
		//Given
		s = "10";
				
		//When
		resultado = Main.tryParse(s);
				
		//Then
		Assert.assertEquals(resultado, true);
		
	}

}