package src.presentacion;

import src.excepciones.DepartamentoRepetidoException;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AltaDepartamento extends JInternalFrame {
	private Fabrica fabrica;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldURL;

	public AltaDepartamento() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fabrica = new Fabrica();
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Alta de Departamento");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 325, 0};
		gridBagLayout.rowHeights = new int[]{35, 35, 35, 35, 0, 40, 0, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel labelDescripcion = new JLabel("Descripcion:");
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
		
		JLabel labelURL = new JLabel("URL:");
		GridBagConstraints gbc_labelURL = new GridBagConstraints();
		gbc_labelURL.insets = new Insets(0, 0, 5, 5);
		gbc_labelURL.gridx = 0;
		gbc_labelURL.gridy = 3;
		getContentPane().add(labelURL, gbc_labelURL);
		
		textFieldURL = new JTextField();
		GridBagConstraints gbc_textFieldURL = new GridBagConstraints();
		gbc_textFieldURL.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldURL.gridx = 1;
		gbc_textFieldURL.gridy = 3;
		getContentPane().add(textFieldURL, gbc_textFieldURL);
		textFieldURL.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 0;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		//evento para el boton aceptar
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				cmdAltaDepartamento(event);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 0;
		panel.add(btnCancelar, gbc_btnCancelar);
		
		//evento para el boton cancelar
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				limpiarFormulario();
				setVisible(false);
			}
		});

	}
	
	protected void cmdAltaDepartamento(ActionEvent arg0) {
		//obtengo los datos de la GUI
		String nombreD = this.textFieldNombre.getText();
		String descripcionD = this.textFieldDescripcion.getText();
		String urlD = this.textFieldURL.getText();
		
		//reviso que los datos no esten vacios
		if (checkFormulario()) {
			try {
				//ejecuto el CU
				IActividad controlActividad = fabrica.getIActividad();
				controlActividad.altaDepartamento(nombreD, descripcionD, urlD);
				
				//mensaje de exito
				JOptionPane.showMessageDialog(this, "Alta de Departamento con éxito", "Alta de Departamento", JOptionPane.INFORMATION_MESSAGE);
			
			} catch (DepartamentoRepetidoException e) {
				//mensaje de error
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta de Departamento", JOptionPane.ERROR_MESSAGE);
			}
			//limpio las entradas antes de cerrar
			limpiarFormulario();
			setVisible(false);
		}
	}
	
	private boolean checkFormulario() {
		String nombreD = this.textFieldNombre.getText();
        String descripcionD = this.textFieldDescripcion.getText();
        String urlD = this.textFieldURL.getText();

        if (nombreD.isEmpty() || descripcionD.isEmpty() || urlD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta de Departamento",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
	}

	private void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldDescripcion.setText("");
		textFieldURL.setText("");
	}
}
