# Tarea jUnit - Pruebas de Software

### Bárbara Uribe Cataldo - 201673074-5 - barbara.uribe@sansano.usm.cl

## Instalación

Para poder utilizar este programa se debe instalar [Eclipse](https://www.eclipse.org/downloads/), donde instalaremos el framework de trabajo de Java.
Este proyecto utiliza Maven y jUnit.

Se debe realizar click derecho en el proyecto, luego de esto seleccionaremos Maven, donde tendremos que seleccionar la opci+on Update Project, esto abrirá una ventana en la que tendremos que presionar el botón Ok.

## Ejecución

Para poder ejecutar este programa, dentro de Eclipse, podemos realizar la combinación de teclas Ctrl + F11 o presionar Run en la pestaña con el mismo nombre para que este se ejecute.

Por otro lado, para ejecutar las pruebas de este programa podemos realizar la combinación de teclas Ctrl + R.

## Uso

Luego de ejecutar nuestro programa se nos indicará que este está esperando por instrucciones, donde deberemos ingresar una de las siguientes:

`Agregar inventario`

`Verificar inventario`

`Comprar bebida`

### Agregar inventario

Se le pedirá ingresar las unidades correspondientes a cada ingrediente disponible en la cafetera (números enteros positivos), estos ingredientes poseen un límite de capacidad mostrado a continuación:

* Café : 10
* Leche : 80
* Chocolate : 10
* Azúcar : 40

Se pueden ingresar valores mayores a estos, pero no se excederá el máximo indicado. Además, si no se ingresa un número entero positivo como cantidad de un ingrediente, se volverá a solicitar que se ingrese una cantidad válida de unidades del ingrediente correspondiente.

### Verificar inventario

Esta función muestra cuántas unidades de cada ingrediente en hay presentes en la cafetera.

### Comprar bebida

Luego de ingresar esta instrucción se deberá seleccionar una de las bebidas que tiene guardadas la cafetera:

* Mocaccino
* Capuccino
* Latte
* Chocolate

Cuyos valores son $700, $600, $700 y $500 respectivamente.

Luego de seleccionar la bebida deseada se le pedirá que pague por esta, de no ingresar suficiente dinero su bebida no será preparada por la cafetera y cualquier monto ingresado será devuelto.

Se verificará si la cafetera posee los suficientes ingredientes para preparar su bebida, de no ser así esta no podrá ser preparada y se devolverá el dinero ingresado. En caso contrario, de ser necesario, se le entregará el cambio correspondiente al precio de la bebida y cuánto pagó y esta será entregada.

*Como supuesto se asume que el dinero ingresado será múltiplo de 10, ya que esta es la moneda chilena con menor valor actualmente*

*Este programa genera archivos .log para cada vez que es ejecutado o testeado, estos archivos se guardan con nombre fecha y hora en la que fue ejecutado, en la carpeta src*
