package src.presentacion;



import javax.swing.JInternalFrame;

import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTDepartamento;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import src.excepciones.ExcepcionAltaSalida;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import java.util.Map;

import javax.swing.JSpinner;
import java.time.LocalTime;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AltaSalidaTuristica extends JInternalFrame {
	private JTextField nombreSalida;
	private JTextField lugarSalida;
	private JSpinner anioFechaAlta;
	private JSpinner mesFechaAlta;
	private JSpinner diaFechaAlta;
	private JSpinner anioFechaSalida;
	private JSpinner mesFechaSalida;
	private JSpinner diaFechaSalida;
	private JSpinner spinTopeTuristas;
	private JSpinner horaSalida;
	private JSpinner minutoSalida;
	private JComboBox<String> boxActividades;
	private JComboBox<String> boxDeptos;
	
	private Fabrica fabrica = new Fabrica();
	private IActividad controlador = fabrica.getIActividad();
	
	public AltaSalidaTuristica() {
		setMaximizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		setTitle("Alta de Salida");
		setBounds(100, 100, 549, 359);
		setClosable(true);
		getContentPane().setLayout(null);
		
		boxDeptos = new JComboBox<String>();
		boxDeptos.setBounds(10, 28, 241, 22);
		getContentPane().add(boxDeptos);
		
		boxActividades = new JComboBox<String>();
		boxActividades.setBounds(10, 95, 241, 22);
		getContentPane().add(boxActividades);
		
	
		JLabel lblNewLabel = new JLabel("Seleccione Departamento:");
		lblNewLabel.setBounds(10, 0, 207, 30);
		getContentPane().add(lblNewLabel);
		
		JButton aceptarButton = new JButton("Aceptar");
		aceptarButton.setBounds(10, 295, 89, 23);
		getContentPane().add(aceptarButton);
				
		
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setBounds(434, 295, 89, 23);
		getContentPane().add(cancelarButton);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccionar Actividad:");
		lblNewLabel_1.setBounds(10, 70, 229, 14);
		getContentPane().add(lblNewLabel_1);
			
		
		JLabel lblNewLabel_2 = new JLabel("Ingresar nombre de la salida:");
		lblNewLabel_2.setBounds(10, 150, 186, 14);
		getContentPane().add(lblNewLabel_2);
		
		nombreSalida = new JTextField();
		nombreSalida.setBounds(206, 147, 96, 20);
		getContentPane().add(nombreSalida);
		nombreSalida.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ingresar Fecha de Alta (a/m/d):");
		lblNewLabel_3.setBounds(45, 225, 223, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ingresar Fecha de Salida (a/m/d):");
		lblNewLabel_4.setBounds(45, 262, 223, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ingresar Hora de Salida(h/m):");
		lblNewLabel_5.setBounds(10, 181, 207, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Lugar de Salida:");
		lblNewLabel_6.setBounds(305, 150, 129, 14);
		getContentPane().add(lblNewLabel_6);
		
		lugarSalida = new JTextField();
		lugarSalida.setBounds(428, 147, 105, 20);
		getContentPane().add(lugarSalida);
		lugarSalida.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Tope de Turistas: ");
		lblNewLabel_7.setBounds(305, 181, 129, 14);
		getContentPane().add(lblNewLabel_7);
		
		SpinnerModel valor = new SpinnerNumberModel(2022, 1, 2030, 1);
		anioFechaAlta = new JSpinner(valor);
		anioFechaAlta.setBounds(285, 222, 68, 20);
		getContentPane().add(anioFechaAlta);
		
		valor = new SpinnerNumberModel(1, 1, 12, 1);
		mesFechaAlta = new JSpinner(valor);
		mesFechaAlta.setBounds(357, 222, 40, 20);
		getContentPane().add(mesFechaAlta);
		
		valor = new SpinnerNumberModel(1, 1, 31, 1);
		diaFechaAlta = new JSpinner(valor);
		diaFechaAlta.setBounds(407, 222, 42, 20);
		getContentPane().add(diaFechaAlta);
		
		valor = new SpinnerNumberModel(2022, 1, 2030, 1);
		anioFechaSalida = new JSpinner(valor);
		anioFechaSalida.setBounds(285, 259, 68, 20);
		getContentPane().add(anioFechaSalida);
		
		valor = new SpinnerNumberModel(1, 1, 12, 1);
		mesFechaSalida = new JSpinner(valor);
		mesFechaSalida.setBounds(357, 259, 40, 20);
		getContentPane().add(mesFechaSalida);
		
		valor = new SpinnerNumberModel(1, 1, 31, 1);
		diaFechaSalida = new JSpinner(valor);
		diaFechaSalida.setBounds(407, 259, 42, 20);
		getContentPane().add(diaFechaSalida);
		
		valor = new SpinnerNumberModel(0, 0, 23, 1);
		horaSalida = new JSpinner(valor);
		horaSalida.setBounds(226, 178, 42, 20);
		getContentPane().add(horaSalida);
		
		valor = new SpinnerNumberModel(0, 0, 59, 1);
		minutoSalida = new JSpinner(valor);
		minutoSalida.setBounds(261, 178, 41, 20);
		getContentPane().add(minutoSalida);
		
		valor = new SpinnerNumberModel(0, 0, 1000, 1);
		spinTopeTuristas = new JSpinner(valor);
		spinTopeTuristas.setBounds(482, 178, 41, 20);
		getContentPane().add(spinTopeTuristas);



		boxDeptos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (boxDeptos.getItemCount() != 0) {
				String depto = boxDeptos.getSelectedItem().toString();
				boxActividades.removeAllItems();
				//Relleno actividadBox
				Map<String, DTActividadTuristica> dtacts = controlador.obtenerDTActividadesConfirmadasDepto(depto);
				dtacts.forEach((key, value)-> {
					boxActividades.addItem(value.getNombre());			
				});
			}
		}	
		});
		 

	
		//en caso de aceptar
		aceptarButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (checkFormulario(nombreSalida.getText(), lugarSalida.getText())) {
				String salidaNombre = nombreSalida.getText();
				String salidaLugar = lugarSalida.getText();
				String act = boxActividades.getSelectedItem().toString();
				int tope = (int) spinTopeTuristas.getValue();
				
				int diaFA = (int) diaFechaAlta.getValue();
				int mesFA = (int) mesFechaAlta.getValue();
				int anioFA = (int) anioFechaAlta.getValue();
				LocalDate fechaAlta = LocalDate.of(anioFA, mesFA, diaFA); 
				
				int diaFS = (int) diaFechaSalida.getValue();
				int mesFS = (int) mesFechaSalida.getValue();
				int anioFS = (int) anioFechaSalida.getValue();
				LocalDate fechaSalida = LocalDate.of(anioFS, mesFS, diaFS);
				
				int hora = (int) horaSalida.getValue();
				int min = (int) minutoSalida.getValue();
				LocalTime horaDeSalida = LocalTime.of(hora, min);
				cmdAltaSalidaTuristica(event, act, tope, fechaAlta, fechaSalida, horaDeSalida, controlador, salidaNombre, salidaLugar);		
			}
			
		}
	});

		
		cancelarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				nombreSalida.setText("");
				lugarSalida.setText("");
				
		        nombreSalida.setText("");
		        lugarSalida.setText("");
		        anioFechaSalida.setValue(2022);
		        mesFechaSalida.setValue(1);
		        diaFechaSalida.setValue(1);
		        anioFechaAlta.setValue(2022);
		        mesFechaAlta.setValue(1);
		        diaFechaAlta.setValue(1);
		        spinTopeTuristas.setValue(0);
		    	horaSalida.setValue(0);
		    	minutoSalida.setValue(0);
				setVisible(false);
			}
		});
		
		
		
		

}	
	
		

	
		protected void cmdAltaSalidaTuristica(ActionEvent event, String act, int tope, LocalDate fechaAlta, LocalDate fechaSalida, LocalTime horaDeSalida, IActividad controlador, String salidaNombre, String salidaLugar) {
			
			
			if (checkFormulario(salidaNombre, salidaLugar)) {  
				try {			
							//ejecuto el alta
							controlador.ingresarDatosSalidaTuristica(act, salidaNombre, tope, fechaAlta, fechaSalida, horaDeSalida, salidaLugar, null);
							
							JOptionPane.showMessageDialog(this, "Alta de Salida Turistica con éxito", "Alta de Salida Turistica", JOptionPane.INFORMATION_MESSAGE);
			
							}		catch (ExcepcionAltaSalida excepcion) {
										//mensaje de error
										JOptionPane.showMessageDialog(this, excepcion.getMessage(), "Alta de Salida", JOptionPane.ERROR_MESSAGE);

										
							}
				limpiarFormulario();
					
				}

		}
		
	    private boolean checkFormulario(String salidaNombre, String salidaLugar) {

	        if (salidaNombre.isEmpty() || salidaLugar.isEmpty() || boxActividades.getItemCount() == 0) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }


	        return true;
	    }
		
	   private void limpiarFormulario() {
	        nombreSalida.setText("");
	        lugarSalida.setText("");
	        anioFechaSalida.setValue(2022);
	        mesFechaSalida.setValue(1);
	        diaFechaSalida.setValue(1);
	        anioFechaAlta.setValue(2022);
	        mesFechaAlta.setValue(1);
	        diaFechaAlta.setValue(1);
	        spinTopeTuristas.setValue(0);
	    	horaSalida.setValue(0);
	    	minutoSalida.setValue(0);
	        
	        
	        
	    }
		
		
		public void rellenarDatos() {
			boxDeptos.removeAllItems();
			Map<String, DTDepartamento> dtdeptos = controlador.obtenerDTDepartamentos();
			dtdeptos.forEach((key, value)-> {
				boxDeptos.addItem(value.getNombreDepto());			
			});
		}
		
		
		
		
		
		
		
		

}
