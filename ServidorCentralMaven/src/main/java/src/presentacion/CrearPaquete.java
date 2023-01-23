package src.presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import src.excepciones.PaqueteRepetidoException;
import src.logica.clases.Fabrica;
import src.logica.clases.IPaquete;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class CrearPaquete extends JInternalFrame {
	private Fabrica fabrica;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;

	/**
	 * Create the frame.
	 */
	public CrearPaquete() {
		fabrica = new Fabrica();
		
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Crear Paquete de Actividades Turísticas");
		setBounds(100, 100, 520, 350);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{115, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 35, 35, 35, 35, 35, 40, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel labelNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 1;
		getContentPane().add(labelNombre, gbc_labelNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelDescripcion = new JLabel("Descripción:");
		GridBagConstraints gbc_labelDescripcion = new GridBagConstraints();
		gbc_labelDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_labelDescripcion.gridx = 0;
		gbc_labelDescripcion.gridy = 2;
		getContentPane().add(labelDescripcion, gbc_labelDescripcion);
		
		textFieldDescripcion = new JTextField();
		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescripcion.gridx = 1;
		gbc_textFieldDescripcion.gridy = 2;
		getContentPane().add(textFieldDescripcion, gbc_textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel labelValidez = new JLabel("Validez (en días):");
		GridBagConstraints gbc_labelValidez = new GridBagConstraints();
		gbc_labelValidez.insets = new Insets(0, 0, 5, 5);
		gbc_labelValidez.gridx = 0;
		gbc_labelValidez.gridy = 3;
		getContentPane().add(labelValidez, gbc_labelValidez);
		
		JSpinner spinnerValidez = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
		GridBagConstraints gbc_spinnerValidez = new GridBagConstraints();
		gbc_spinnerValidez.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerValidez.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerValidez.gridx = 1;
		gbc_spinnerValidez.gridy = 3;
		getContentPane().add(spinnerValidez, gbc_spinnerValidez);
		
		JLabel labelDescuento = new JLabel("Descuento (sin %):");
		GridBagConstraints gbc_labelDescuento = new GridBagConstraints();
		gbc_labelDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_labelDescuento.gridx = 0;
		gbc_labelDescuento.gridy = 4;
		getContentPane().add(labelDescuento, gbc_labelDescuento);
		
		JSpinner spinnerDescuento = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		GridBagConstraints gbc_spinnerDescuento = new GridBagConstraints();
		gbc_spinnerDescuento.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerDescuento.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerDescuento.gridx = 1;
		gbc_spinnerDescuento.gridy = 4;
		getContentPane().add(spinnerDescuento, gbc_spinnerDescuento);
		
		JLabel labelAlta = new JLabel("Fecha de Alta:");
		GridBagConstraints gbc_labelAlta = new GridBagConstraints();
		gbc_labelAlta.insets = new Insets(0, 0, 5, 5);
		gbc_labelAlta.gridx = 0;
		gbc_labelAlta.gridy = 5;
		getContentPane().add(labelAlta, gbc_labelAlta);
		
		JPanel panelFecha = new JPanel();
		GridBagConstraints gbc_panelFecha = new GridBagConstraints();
		gbc_panelFecha.insets = new Insets(0, 0, 5, 0);
		gbc_panelFecha.fill = GridBagConstraints.BOTH;
		gbc_panelFecha.gridx = 1;
		gbc_panelFecha.gridy = 5;
		getContentPane().add(panelFecha, gbc_panelFecha);
		GridBagLayout gbl_panelFecha = new GridBagLayout();
		gbl_panelFecha.columnWidths = new int[]{40, 50, 0, 40, 50, 0, 40, 50, 0};
		gbl_panelFecha.rowHeights = new int[]{0, 0};
		gbl_panelFecha.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelFecha.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelFecha.setLayout(gbl_panelFecha);
		
		JLabel labelDia = new JLabel("Día:");
		GridBagConstraints gbc_labelDia = new GridBagConstraints();
		gbc_labelDia.anchor = GridBagConstraints.EAST;
		gbc_labelDia.insets = new Insets(0, 0, 0, 5);
		gbc_labelDia.gridx = 0;
		gbc_labelDia.gridy = 0;
		panelFecha.add(labelDia, gbc_labelDia);
		
		JSpinner spinnerDia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_spinnerDia = new GridBagConstraints();
		gbc_spinnerDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerDia.insets = new Insets(0, 0, 0, 5);
		gbc_spinnerDia.gridx = 1;
		gbc_spinnerDia.gridy = 0;
		panelFecha.add(spinnerDia, gbc_spinnerDia);
		
		JLabel labelMes = new JLabel("Mes:");
		GridBagConstraints gbc_labelMes = new GridBagConstraints();
		gbc_labelMes.anchor = GridBagConstraints.EAST;
		gbc_labelMes.insets = new Insets(0, 0, 0, 5);
		gbc_labelMes.gridx = 3;
		gbc_labelMes.gridy = 0;
		panelFecha.add(labelMes, gbc_labelMes);
		
		JSpinner spinnerMes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_spinnerMes = new GridBagConstraints();
		gbc_spinnerMes.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerMes.insets = new Insets(0, 0, 0, 5);
		gbc_spinnerMes.gridx = 4;
		gbc_spinnerMes.gridy = 0;
		panelFecha.add(spinnerMes, gbc_spinnerMes);
		
		JLabel labelAnio = new JLabel("Año:");
		GridBagConstraints gbc_labelAnio = new GridBagConstraints();
		gbc_labelAnio.anchor = GridBagConstraints.EAST;
		gbc_labelAnio.insets = new Insets(0, 0, 0, 5);
		gbc_labelAnio.gridx = 6;
		gbc_labelAnio.gridy = 0;
		panelFecha.add(labelAnio, gbc_labelAnio);
		
		JSpinner spinnerAnio = new JSpinner(new SpinnerNumberModel(0, 0, 2030, 1));
		GridBagConstraints gbc_spinnerAnio = new GridBagConstraints();
		gbc_spinnerAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerAnio.gridx = 7;
		gbc_spinnerAnio.gridy = 0;
		panelFecha.add(spinnerAnio, gbc_spinnerAnio);
		
		JPanel panelBotones = new JPanel();
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 1;
		gbc_panelBotones.gridy = 6;
		getContentPane().add(panelBotones, gbc_panelBotones);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[]{0, 0, 0};
		gbl_panelBotones.rowHeights = new int[]{0, 0};
		gbl_panelBotones.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelBotones.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelBotones.setLayout(gbl_panelBotones);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 0;
		panelBotones.add(btnAceptar, gbc_btnAceptar);
		
		//evento para el boton aceptar
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				accionBtnCrearPaquete(event, spinnerValidez, spinnerDescuento, spinnerDia, spinnerMes, spinnerMes);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 0;
		panelBotones.add(btnCancelar, gbc_btnCancelar);
		
		//evento para el boton cancelar
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				limpiarFormulario(spinnerValidez, spinnerDescuento, spinnerDia, spinnerMes, spinnerAnio);
				setVisible(false);
			}
		});

	}
	
	protected void accionBtnCrearPaquete(ActionEvent arg0, JSpinner validez, JSpinner descuento, JSpinner dia, JSpinner mes, JSpinner anio) {
		//obtengo los datos de la GUI
		String nombreP = this.textFieldNombre.getText();
		String descripcionP = this.textFieldDescripcion.getText();
		int validezP = (int) validez.getValue();
		double descuentoP = ((int) descuento.getValue()) / 100;
		LocalDate fechaAltaP = LocalDate.of((int) anio.getValue(), (int) mes.getValue(), (int) dia.getValue());
		
		//reviso que los datos no esten vacios
		if (checkFormulario()) {
			try {
				//ejecuto el CU
				IPaquete controlPaquete = fabrica.getIPaquete();
				controlPaquete.crearNuevoPaquete(nombreP, descripcionP, validezP, descuentoP, fechaAltaP, null);
				
				//mensaje de exito
				JOptionPane.showMessageDialog(this, "Paquete de Actividades Turísticas creado con éxito", "Crear Paquete de Actividades Turísticas", JOptionPane.INFORMATION_MESSAGE);
			} catch (PaqueteRepetidoException e) {
				//mensaje de error
				JOptionPane.showMessageDialog(this, e.getMessage(), "Crear Paquete de Actividades Turísticas", JOptionPane.ERROR_MESSAGE);
			}
			//limpio las entradas antes de cerrar
			limpiarFormulario(validez, descuento, dia, mes, anio);
			setVisible(false);
		}
	}
	
	protected boolean checkFormulario() {
		String nombreP = this.textFieldNombre.getText();
		String descripcionP = this.textFieldDescripcion.getText();
		
		if (nombreP.isEmpty() || descripcionP.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Crear Paquete de Actividades Turísticas", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiarFormulario(JSpinner validez, JSpinner descuento, JSpinner dia, JSpinner mes, JSpinner anio) {
		textFieldNombre.setText("");
		textFieldDescripcion.setText("");
		validez.setValue(0);
		descuento.setValue(0);
		dia.setValue(1);
		mes.setValue(1);
		anio.setValue(0);	
	}

}
