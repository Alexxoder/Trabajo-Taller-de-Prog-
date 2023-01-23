package src.presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import src.excepciones.ExcepcionAltaCategoria;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

public class AltaCategoria extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private Fabrica fabrica;
	private JTextField textFieldNombre;

	/**
	 * Create the frame.
	 */
	public AltaCategoria() {
		fabrica = new Fabrica();
		
		setTitle("Alta de Categoría");
		setBounds(100, 100, 618, 416);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{87, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel labelNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		getContentPane().add(labelNombre, gbc_labelNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{30, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 0;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		//evento boton aceptar
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				accionBtnAltaCategoria();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 0;
		panel.add(btnCancelar, gbc_btnCancelar);
		
		//evento boton cancelar
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});

	}
	
	protected void accionBtnAltaCategoria() {
		//obtengo los datos de la GUI
		String nombreC = this.textFieldNombre.getText();
		
		//reviso que los datos no esten vacios
		if (checkFormulario()) {
			try {
				//ejecuto el CU
				IActividad controlA = fabrica.getIActividad();
				controlA.aceptarAltaCategoria(nombreC);
				
				//mensaje de exito
				JOptionPane.showMessageDialog(this, "Categoría creada con éxito", "Alta de Categoría", JOptionPane.INFORMATION_MESSAGE);
			} catch (ExcepcionAltaCategoria e) {
				//mensaje de error
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta de Categoría", JOptionPane.ERROR_MESSAGE);
			}
			//limpio las entradas antes de cerrar
			limpiarFormulario();
			setVisible(false);
		}
	}
	
	protected boolean checkFormulario() {
		String nombreC = this.textFieldNombre.getText();
		
		if (nombreC.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta de Categoría", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiarFormulario() {
		textFieldNombre.setText("");
	}
}
