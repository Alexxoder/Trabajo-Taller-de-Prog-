package src.presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.datatypes.DTActividadTuristica;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class AceptarRechazarActividad extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBoxActividadesAcep = new JComboBox<String>();
	private ButtonGroup grupoBoton;
	private JRadioButton rdbtnConfirmar = new JRadioButton("Confirmar");
	private JRadioButton rdbtnRechazar = new JRadioButton("Rechazar");
	
	public AceptarRechazarActividad() {
		setTitle("Aceptar / Rechazar Actividad Turística");
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{192, 0, 0};
		gbl_contentPane.rowHeights = new int[]{47, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel labelActividadesAceptadas = new JLabel("Actividades agregadas:");
		GridBagConstraints gbc_labelActividadesAceptadas = new GridBagConstraints();
		gbc_labelActividadesAceptadas.insets = new Insets(0, 0, 5, 5);
		gbc_labelActividadesAceptadas.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_labelActividadesAceptadas.gridx = 0;
		gbc_labelActividadesAceptadas.gridy = 0;
		contentPane.add(labelActividadesAceptadas, gbc_labelActividadesAceptadas);
		
		GridBagConstraints gbc_comboBoxActividadesAcep = new GridBagConstraints();
		gbc_comboBoxActividadesAcep.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxActividadesAcep.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxActividadesAcep.gridx = 1;
		gbc_comboBoxActividadesAcep.gridy = 0;
		contentPane.add(comboBoxActividadesAcep, gbc_comboBoxActividadesAcep);
		
		GridBagConstraints gbc_rdbtnConfirmar = new GridBagConstraints();
		gbc_rdbtnConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnConfirmar.gridx = 0;
		gbc_rdbtnConfirmar.gridy = 1;
		contentPane.add(rdbtnConfirmar, gbc_rdbtnConfirmar);
		
		GridBagConstraints gbc_rdbtnRechazar = new GridBagConstraints();
		gbc_rdbtnRechazar.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnRechazar.gridx = 1;
		gbc_rdbtnRechazar.gridy = 1;
		contentPane.add(rdbtnRechazar, gbc_rdbtnRechazar);
		
		grupoBoton = new ButtonGroup();
		grupoBoton.add(rdbtnConfirmar);
		grupoBoton.add(rdbtnRechazar);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 2;
		contentPane.add(btnAceptar, gbc_btnAceptar);
		
		//evento al aceptar
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				accionBtnAceptar();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 2;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		
		//evento al cancelar
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				limpiarFormulario();
				setVisible(false);
			}
		});
	}
	
	public void agregarDatos() {
		comboBoxActividadesAcep.removeAllItems();
		Fabrica fabrica = new Fabrica();
		IActividad controlA = fabrica.getIActividad();
		Map<String, DTActividadTuristica> colActividades = controlA.obtenerActividadesTuristicasAgregadas();
		colActividades.forEach((key, value) -> {
			comboBoxActividadesAcep.addItem(value.getNombre());
		});
	}
	
	private void accionBtnAceptar() {
		if (checkFormulario()) {
			String actividad = comboBoxActividadesAcep.getSelectedItem().toString();
			if (rdbtnConfirmar.isSelected()) {
				Fabrica fabrica = new Fabrica();
				IActividad controlA = fabrica.getIActividad();
				controlA.confirmarActividad(actividad);
				JOptionPane.showMessageDialog(this, "Actividad confirmada con exito.", "Aceptar / Rechazar Actividad Turística", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				Fabrica fabrica = new Fabrica();
				IActividad controlA = fabrica.getIActividad();
				controlA.rechazarActividad(actividad);
				JOptionPane.showMessageDialog(this, "Actividad rechazada con exito.", "Aceptar / Rechazar Actividad Turística", JOptionPane.INFORMATION_MESSAGE);
			}
			limpiarFormulario();
			setVisible(false);
		}
	}
	
	private boolean checkFormulario() {
		if (comboBoxActividadesAcep.getItemCount() == 0) {
			JOptionPane.showMessageDialog(this, "No hay actividades en estado 'Agregada' en el sistema.", "Aceptar / Rechazar Actividad Turística", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!rdbtnConfirmar.isSelected() && rdbtnRechazar.isSelected()) {
			JOptionPane.showMessageDialog(this, "Por favor, seleccione una de las opciones.", "Aceptar / Rechazar Actividad Turística", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	private void limpiarFormulario() {
		comboBoxActividadesAcep.removeAllItems();
		rdbtnConfirmar.setSelected(false);
		rdbtnRechazar.setSelected(false);
	}

}
