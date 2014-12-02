package com.tlamatini.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Venta;
import com.tlamatini.persistencia.DAOVenta;

public class DAOVentaTest {
	
	int folio=1, idUsuario = 1;
	ArrayList<Producto> productos=new ArrayList<Producto>();;
	double importe = 123.4;
	Date fechaOperacion = new Date(2014/02/02);
	String nick = "admin";
	ConexionDB conexion = new ConexionDB();
	boolean iconn = conexion.crearConexion();
	DAOVenta daoVenta = new DAOVenta(conexion);
	Venta v = new Venta(fechaOperacion, idUsuario);
	
	Date fechaInicio = new Date(2014/01/01); 
	Date fechaFin = new Date(2015/01/01);
	private	Venta[] ventaTempArreglo = new Venta[daoVenta.buscaVenta(fechaInicio, fechaFin).length];
	
	@Test
	public void testAgregaVenta() {
		assertTrue(daoVenta.agregaVenta(v));
	}

	@Test
	public void testBuscaVenta() {
		assertEquals(ventaTempArreglo.length,daoVenta.buscaVenta(fechaInicio, fechaFin).length);
	}
}
