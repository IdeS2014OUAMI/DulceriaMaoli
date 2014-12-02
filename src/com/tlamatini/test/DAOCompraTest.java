package com.tlamatini.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Compra;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Venta;
import com.tlamatini.persistencia.*;

import org.junit.Test;

public class DAOCompraTest {
	
	int folio = 2, idUsuario = 1;
	ArrayList<Producto> productos=new ArrayList<Producto>();
	double importe = 150.5;
	Date fechaOperacion= new Date(2014/02/02);
	String nick = "admin";
	String nombreProveedor = "emp";
	ConexionDB conexion = new ConexionDB();
    boolean iconn = conexion.crearConexion();
	DAOCompra daoCompra = new DAOCompra(conexion);
	Compra c = new Compra(fechaOperacion, idUsuario);
	
	Date fechaInicio = new Date(2014/01/01); 
	Date fechaFin = new Date(2015/01/01);
	private	Compra[] compraTempArreglo = new Compra[daoCompra.buscaCompra(fechaInicio, fechaFin).length];
	
	@Test
	public void testAgregaCompra() {
		assertTrue(daoCompra.agregaCompra(c));
	}

	@Test
	public void testBuscaCompra() {
		assertEquals(compraTempArreglo.length,daoCompra.buscaCompra(fechaInicio, fechaFin).length);
	}

}
