package com.tlamatini.modelo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;

public class Ticket implements Iterable<Producto>
{
	int indice;
	ArrayList<Producto> productosVenta =null;

	void imprime() throws FileNotFoundException, DocumentException{
		FileOutputStream archivo = new FileOutputStream("C:");
		Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();
		documento.add(new Paragraph("Hola Mundo!"));
		documento.add(new Paragraph("Luis Enrique Acosta Meza"));
		documento.close();
	}

	
	public String guardarVentaPDF(ArrayList<Producto> productosVenta,double total_descuento){
		Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
		PdfWriter writer = null;

		Calendar fecha = new GregorianCalendar();

	    int año = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH);
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    int hora = fecha.get(Calendar.HOUR_OF_DAY);
	    int minuto = fecha.get(Calendar.MINUTE);
	    int segundo = fecha.get(Calendar.SECOND);
	    double costo;
	    int cont=0;
	    String fecha1="fecha-"+año+"-"+(mes+1)+"-"+dia+"-hora-"+hora+"-"+minuto+"-"+segundo;
	    String dato="../"+fecha1+".pdf";
	    System.out.println("Fecha Actual: "+fecha1);
	    System.out.println(dato);
	    try {      
	    	writer = PdfWriter.getInstance(documento, new FileOutputStream(dato));
	    	documento.addTitle("Tiket de compra");
	    	documento.addAuthor("Maoli");
	    	System.out.println("Imprime 2");

	    	documento.open();
	    	Paragraph parrafo = new Paragraph();
	    	parrafo.setAlignment(Paragraph.ALIGN_CENTER);
	    	parrafo.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLUE));
	    	parrafo.add("Gracias Por Su Compra\n");
	    	Paragraph parrafo1 = new Paragraph();
	    	parrafo1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	    	parrafo1.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLUE));
	    	parrafo1.add("\nNOMBRE"+"   "+"PRECIO"+"  "+"CANTIDAD"+"     "+"TOTAL");
	    	System.out.println("Imprime 3");

	    	Paragraph ventas = new Paragraph();
	    	parrafo.setAlignment(Paragraph.ALIGN_RIGHT);
	    	ventas.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLACK));
	    	float acumulado=0;
	    	System.out.println("Imprime 4");

	    	for(indice = 0; indice < productosVenta.size(); indice++){
	    		System.out.println("Imprime 5");
	    		
	    		costo=productosVenta.get(indice).getCostoUnitario()*.10;
	    	   	costo=costo+productosVenta.get(indice).getCostoUnitario();
	    	   	ventas.add(productosVenta.get(indice).getNombre()+": \t          "+costo+": \t     "+productosVenta.get(indice).getCantidad()+"        : \t "+costo*productosVenta.get(indice).getCantidad()+"\n");  
	    	   	
	    	   	acumulado=(float) (acumulado+costo*productosVenta.get(indice).getCantidad());
	    	   	//Iterator i = (Iterator) productosVenta.iterator();
	    	   	System.out.println(productosVenta.get(indice).getNombre()+"            "+productosVenta.get(indice).getCostoUnitario()+"    cantidad        "+productosVenta.get(indice).getCantidad()+"\n");
	    	}
	    	ventas.add("Precio total a pagar:                              "+acumulado);
	    	Paragraph totalcondescuento = new Paragraph();
	    	parrafo.setAlignment(Paragraph.ALIGN_RIGHT);
	    	totalcondescuento.add("Precio total a pagar con descuento:                              "+total_descuento);
	    	Paragraph fechapdf = new Paragraph();
	    	parrafo.setAlignment(Paragraph.ALIGN_RIGHT);
	    	fechapdf.add(fecha1);
	    	   
	    	ventas.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLACK));
	    	documento.add(parrafo);
	    	documento.add(parrafo1);
	    	documento.add(ventas);
	    	documento.add(totalcondescuento);
	    	documento.add(fechapdf);
	    	//documento.add(fecha2);
	    	writer.close(); 
	    	documento.close(); 
	    	return dato;
	    	} catch (Exception ex) {
	    		ex.getMessage();
	    		
	    	}
	    	return dato;
	}
	@Override
	public java.util.Iterator<Producto> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}