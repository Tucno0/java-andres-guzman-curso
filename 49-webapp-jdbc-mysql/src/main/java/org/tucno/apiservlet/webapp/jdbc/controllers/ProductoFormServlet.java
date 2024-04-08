package org.tucno.apiservlet.webapp.jdbc.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.jdbc.models.Categoria;
import org.tucno.apiservlet.webapp.jdbc.models.Producto;
import org.tucno.apiservlet.webapp.jdbc.services.ProductoService;
import org.tucno.apiservlet.webapp.jdbc.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/productos/form")
public class ProductoFormServlet extends HttpServlet {
    private static final Logger logger =  Logger.getLogger("ProductoFormServlet");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Nos conectamos a la base de datos
        Connection connection = (Connection) req.getAttribute("connection");
        // Creamos una instancia de ProductoService
        ProductoService productoService = new ProductoServiceJdbcImpl(connection);

        Long categoriaId;

        try {
            categoriaId = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            categoriaId = 0L;
        }

        Producto producto = new Producto();
        // para evitar null pointer exception en la vista
        producto.setCategoria(new Categoria());

        if ( categoriaId > 0) {
            Optional<Producto> productoOptional = productoService.obtenerPorId(categoriaId);

            if (productoOptional.isPresent()) {
                producto = productoOptional.get();
            }
        }

        // Enviamos la lista de categorias al formulario
        req.setAttribute("categorias", productoService.listarCategorias());
        req.setAttribute("producto", producto);

        // Redirigimos al formulario
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Nos conectamos a la base de datos
        Connection connection = (Connection) req.getAttribute("connection");
        // Creamos una instancia de ProductoService
        ProductoService productoService = new ProductoServiceJdbcImpl(connection);

        // Obtenemos los datos del formulario
        String nombre = req.getParameter("nombre");

        Long categoriaId;
        try {
            categoriaId = Long.valueOf(req.getParameter("categoriaId"));
        } catch (NumberFormatException e) {
            categoriaId = 0L;
        }

        Double precio;
        try {
            precio = Double.valueOf(req.getParameter("precio"));
        } catch (NumberFormatException e) {
            precio = 0.0;
        }

        String sku = req.getParameter("sku");
        String fechaStr = req.getParameter("fechaRegistro");

        // Validamos los datos
        Map<String, String> errores = new HashMap<>();

        if (nombre == null || nombre.isBlank())
            errores.put("nombre", "El nombre es requerido");

        if (categoriaId == 0)
            errores.put("categoriaId", "La categoria es requerida");

        if (precio.equals(0.0))
            errores.put("precio", "El precio es requerido");

        if (sku == null || sku.isBlank()) {
            errores.put("sku", "El SKU es requerido");
        } else if (sku.length() > 20) {
            errores.put("sku", "El SKU debe tener máximo 20 caracteres");
        }

        if (fechaStr == null || fechaStr.isBlank())
            errores.put("fechaRegistro", "La fecha es requerida");

        LocalDate fechaRegistro;
        try {
            fechaRegistro = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            errores.put("fechaRegistro", "La fecha no tiene el formato correcto");
            fechaRegistro = null;
        }

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }

        // Creamos un nuevo producto
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setSku(sku);
        producto.setFechaRegistro(fechaRegistro);

        // Asignamos la categoria al producto
        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);

        producto.setCategoria(categoria);

        if (errores.isEmpty()) {
            // Guardamos el producto
            productoService.guardar(producto);

            // Redirigimos a la lista de productos
            resp.sendRedirect(STR."\{req.getContextPath()}/productos");

        } else {
            // Enviamos los errores al formulario
            req.setAttribute("errores", errores);

            // Enviamos los datos del formulario al formulario
            // Enviamos la lista de categorias al formulario
            req.setAttribute("categorias", productoService.listarCategorias());
            req.setAttribute("producto", producto);

            // Volvemos a mostrar el formulario
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
