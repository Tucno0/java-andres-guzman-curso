package tarea;

import java.util.Date;

public class OrdenCompra {
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;
    private static int identificador = 0;

    public OrdenCompra(String descripcion) {
        this.descripcion = descripcion;
        this.fecha = new Date();
        this.productos = new Producto[4];
        identificador++;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public static int getIdentificador() {
        return identificador;
    }

    public boolean addProducto( Producto producto ) {
        for (int i = 0; i < this.productos.length; i++) {
            if (this.productos[i] != null) {
                if (this.productos[i].getNombre().equals(producto.getNombre())) {
                    System.out.println("El producto ya existe, ingrese uno nuevo");
                    return true;
                }
                continue;
            }

            this.productos[i] = producto;
            break;
        }

        return false;
    }

    public int getGranTotal() {
        int granTotal = 0;

        for (int i = 0; i < this.productos.length; i++) {
            granTotal += this.productos[i].getPrecio();
        }

        return granTotal;
    }

    public void verDetalle() {
        System.out.println("\nOrden de compra #" + identificador);
        System.out.println("\nFecha: " + this.fecha);
        System.out.println("Cliente: " + this.cliente.toString());
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Productos: ");

        System.out.println("\nNombre\t\tFabricante\t\tPrecio");
        System.out.println("------\t\t----------\t\t------");
        for ( Producto producto : this.productos ) {
            if ( producto != null ) {
                System.out.println(producto.toString());
            }
        }

        System.out.println("\nGran total: " + this.getGranTotal());
    }
}
