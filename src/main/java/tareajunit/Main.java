package tareajunit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
	
	static Logger logger = Logger.getLogger("Log");
	static FileHandler fh;
	
	public static boolean tryParse(String s) {
		
		try {
			int i = Integer.parseInt(s);
			if(i < 0) {
				return false;
			}
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
		
	}
	
	public static String options(String comm, Cafetera cafetera) throws IOException {
		
		int coffee = 0;
		int milk = 0;
		int choc = 0;
		int sugar = 0;
		
		
		if (comm.equals("Agregar inventario")) {
			
			logger.info("Se ingresó la instrucción \""+ comm + "\"");
			
			BufferedReader r = new BufferedReader(
					new InputStreamReader(System.in));
			
			System.out.println("Ingrese las unidades que desea agregar al inventario: ");
			
			System.out.print("Café: ");
			
			try {
				String in = r.readLine();
				while(!tryParse(in)) {
					logger.info("Se ingresaron unidades de café no válidas \"" + in + "\"");
					System.out.print("Ingrese unidades válidas: ");
					in = r.readLine();
					coffee = Integer.parseInt(in);
				}
			} catch(IOException e) {
				logger.info("Ocurrió un error al ingresar unidades: " + e);
				System.out.println("Ocurrió un error al ingresar unidades: " + e);
			}
			
			try {
				System.out.print("Leche: ");
				String in1 = r.readLine();
				while(!tryParse(in1)) {
					logger.info("Se ingresaron unidades de leche no válidas \"" + in1 + "\"");
					System.out.print("Ingrese unidades válidas: ");
					in1 = r.readLine();
				}
				milk = Integer.parseInt(in1);
			} catch(IOException e) {
				logger.info("Ocurrió un error al ingresar unidades: " + e);
				System.out.println("Ocurrió un error al ingresar unidades: " + e);
			}
			
			try {
				
				System.out.print("Chocolate: ");
				String in2 = r.readLine();
				while(!tryParse(in2)) {
					logger.info("Se ingresaron unidades de chocolate no válidas \"" + in2 + "\"");
					System.out.print("Ingrese unidades válidas: ");
					in2 = r.readLine();
				}
				choc = Integer.parseInt(in2);
				
			} catch(IOException e) {
				logger.info("Ocurrió un error al ingresar unidades: " + e);
				System.out.println("Ocurrió un error al ingresar unidades: " + e);
			}
			
			try {
				System.out.print("Azúcar: ");
				String in3 = r.readLine();
				while(!tryParse(in3)) {
					logger.info("Se ingresaron unidades de azúcar no válidas \"" + in3 + "\"");
					System.out.print("Ingrese unidades válidas: ");
					in3 = r.readLine();
				}
				sugar = Integer.parseInt(in3);
				
			} catch(IOException e) {
				logger.info("Ocurrió un error al ingresar unidades: " + e);
				System.out.println("Ocurrió un error al ingresar unidades: " + e);
			}			

			Inventario inv = cafetera.getInventario();
			inv.add(coffee, milk, choc, sugar);
			logger.info("Se intentaron agregar "+ coffee + " unidades de café, " + milk + " unidades de leche, " + choc + " unidades de chocolate y "
					+ sugar + " unidades de azúcar al inventario");
			cafetera.setInventario(inv);
			logger.info("El inventario quedó con "+ inv.getCoffee() + " unidades de café, " + inv.getMilk() + " unidades de leche, " + inv.getChoc() + " unidades de chocolate y "
					+ inv.getSugar() + " unidades de azúcar");
			return "Esperando...";
			
		} else if (comm.equals("Verificar inventario")){
			

			logger.info("Se ingresó la instrucción "+ comm);
			
			Inventario inv = cafetera.getInventario();
			logger.info("Se verificó el inventario, este posee "+ inv.getCoffee() + " unidades de café, " + inv.getMilk() + " unidades de leche, " + inv.getChoc() + " unidades de chocolate y "
					+ inv.getSugar() + " unidades de azúcar");
			return "Café: " + inv.getCoffee() + "\n" + "Leche: " + inv.getMilk() + "\n" + "Chocolate: " + inv.getChoc() + "\n" + "Azúcar: " + inv.getSugar() + "\nEsperando...";
			
		} else if (comm.equals("Comprar bebida")) {

			logger.info("Se ingresó la instrucción "+ comm);
			
			System.out.println("Seleccione una de las bebidas:");
			System.out.println("Mocaccino, Capuccino, Latte o Chocolate");
			
			BufferedReader r = new BufferedReader(
					new InputStreamReader(System.in));
			
			try {
				String name = r.readLine();
				System.out.println("Ingrese monto de pago: ");
				int pago = Integer.parseInt(r.readLine());
				int vuelto = cafetera.buy(name, pago);
				if (vuelto == 1) {
					logger.info("La bebida seleccionada \""+ name + "\" no se encuentra dentro del repertorio de recetas");
					return "Seleccione una bebida válida \nEsperando...";
				} else if (vuelto == 2) {
					logger.info("La bebida seleccionada \""+ name + "\" cuesta más que el pago de $" + pago + ". Por lo que este dinero fue devuelto");
					return "No pagó suficiente, por lo que le devolvemos su dinero: $" + pago + "\nEsperando...";
				} else if (vuelto == 3) {
					logger.info("La cafetera no posee los suficientes ingredientes para fabricar la bebida \"" + name + "\". Por lo que se le devolvieron $" + pago + " al usuario");
					return "No tenemos suficientes ingredientes para preparar su bebida, por lo que le devolvemos su dinero: $" + pago + "\nEsperando...";
				} else {
					logger.info("La bebida \""+ name + "\" fue entregada, con un vuelto total de $" + pago);
					return "Su vuelto es: $" + vuelto + "\nSu bebida " + name + " está lista \nEsperando...";
				}
			} catch(IOException e) {
				logger.info("Ocurrió un error al comprar bebida: " + e);
				System.out.println("Ocurrió un error al comprar bebida: " + e);
			}
			
			
		} else {
			logger.info("Se ingresó la instrucción \"" + comm + "\", inválida");
			return "Ingrese una instrucción válida \nEsperando...";
		}
		return "";
	}

	public static void main(String[] args) throws IOException {
		
		Date d = new Date(); 
		SimpleDateFormat d_formatter = new SimpleDateFormat("dd-M-yyyy hh mm ss");  
	    String date = d_formatter.format(d);
		
		try {
			fh = new FileHandler("src/" + date + ".log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			logger.setUseParentHandlers(false);
			fh.setFormatter(formatter);
		} catch (SecurityException e) {  
	        logger.info("Error" + e);  
	    } catch (IOException e) {  
	        logger.info("Error" + e);
	    } 
		
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
		logger.info("Se inicia con inventario vacío");
		Cafetera cafetera = new Cafetera(inventario, recetas);
		System.out.println("Esperando...");
		
		while(true){
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				String comm = reader.readLine();
				System.out.println(options(comm, cafetera));
			} catch(IOException e) {
				logger.info("Ocurrió un error al ingresar instrucción: " + e);
				System.out.println("Ocurrió un error al ingresar instrucción: " + e);
			}
			
		}
		
	}

}