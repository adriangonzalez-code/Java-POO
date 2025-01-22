# Gestión de Pedidos con Fichero

Realizar un programa que permita realizar la gestión de pedidos de un almacen. Un pedido se caracteriza por los siguientes datos:

* producto
* precioUnitario
* unidades
* fecha

Los pedidos se almacenarán en un archivo de texto, donde cada pedido se guardará con el formato: producto|precioUnitario|unidades|fecha
La fecha se almacenará con el formato año-mes-dia

Al iniciarse el programa, aparecerá un menú con las siguientes opciones:

1. Nuevo pedido.
2. Pedido mayor.
3. Total facturado.
4. Pedidos entre fechas
5. Salir

La opción 1 solicitará la introducción de los cuatro datos del pedido y lo grabará en el fichero

Al elegir la opción 2, se mostrará los datos del pedido que tenga más unidades. Si hubiera dos pedidos con el mismo número de unidades, se mostrará cualquiera de ellos

Con la opción 3 se mostrará el total facturado, es decir, la suma de todos los pedidos

Al seleccionar la opción 4, se solicitará la introducción de dos fechas y nos mostrará los datos de todos los pedidos realizados entre esas dos fechas.