package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class VentanaDescuentos extends JFrame {
	

	private JPanel contentPane;
	private JTextField textFieldsin;
	private JTextField textFieldprimero;
	private JTextField textFieldsegundo;
	private JTextField textFieldtercero;
	private JTextField textFieldcuarto;
	 LinkedList<Double> listaDescuento;
	 
	 VentanaDescuentos(LinkedList<Double> lista){
		listaDescuento=lista;
		 
	 }
	 
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public LinkedList<Double> VentanaDescuentosabre() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDescuentos = new JLabel("Descuentos");
		
		JLabel lblLosDescuentosSe = new JLabel("Los descuentos se realizaran de acuerdo a la cantidad total a pagar");
		
		JLabel lblTotal = new JLabel("total<$500      %");
		
		JLabel label = new JLabel("$500<=total<$1000    %");
		
		JLabel label_1 = new JLabel("$1000<=total<2000   %");
		
		JLabel label_2 = new JLabel("$2000<=total<3000   %");
		
		JLabel lblTotal_1 = new JLabel("total>$3000      %");
		
		textFieldsin = new JTextField(listaDescuento.get(0).toString());
		textFieldsin.setColumns(10);
		
		textFieldprimero = new JTextField(listaDescuento.get(1).toString());
		textFieldprimero.setColumns(10);
		
		textFieldsegundo = new JTextField(listaDescuento.get(2).toString());
		textFieldsegundo.setColumns(10);
		
		textFieldtercero = new JTextField(listaDescuento.get(3).toString());
		textFieldtercero.setColumns(10);
		
		textFieldcuarto = new JTextField(listaDescuento.get(4).toString());
		textFieldcuarto.setColumns(10);
		
		JButton btnSalir = new JButton("Edita Descueto");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDescuento.set(0,Double.valueOf(textFieldsin.getText()));
				listaDescuento.set(1,Double.valueOf(textFieldprimero.getText()));
				listaDescuento.set(2,Double.valueOf(textFieldsegundo.getText()));
				listaDescuento.set(3,Double.valueOf(textFieldtercero.getText()));
				listaDescuento.set(4,Double.valueOf(textFieldcuarto.getText()));
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(184)
							.addComponent(lblDescuentos))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLosDescuentosSe)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTotal)
										.addComponent(label)
										.addComponent(label_1)
										.addComponent(label_2)
										.addComponent(lblTotal_1))
									.addGap(25)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldcuarto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldtercero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldsegundo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldprimero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldsin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(308, Short.MAX_VALUE)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescuentos)
					.addGap(18)
					.addComponent(lblLosDescuentosSe)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotal)
						.addComponent(textFieldsin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textFieldprimero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textFieldsegundo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(textFieldtercero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotal_1)
						.addComponent(textFieldcuarto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalir)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("Hola");
		listModel.addElement("mundo");
		return listaDescuento;
	}
}
