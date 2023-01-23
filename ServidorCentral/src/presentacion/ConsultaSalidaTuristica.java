package src.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Map;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTDepartamento;
import src.logica.datatypes.DTSalidaTuristica;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ConsultaSalidaTuristica extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> actividadBox;
	private JComboBox<String> salidaBox;
	private JComboBox<String> departamentoBox;
	private JLabel labelNombre;
	private JLabel labelFechaAlta;
	private JLabel labelFechaSalida;
	private JLabel labelHoraSalida;
	private JLabel labelTopeTuristas;
	private JLabel labelLugarSalida;
	private JLabel labelselecdepart;
	private JLabel lblActividadTuristica;
	private JButton mostrarInfo;
	private JLabel lblSeleccioneSalida;

	private Fabrica fabrica = new Fabrica();
	private IActividad controlador = fabrica.getIActividad();

	/**
	 * Create the frame.
	 */
	public ConsultaSalidaTuristica() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		setTitle("Consulta Salida Turistica");
		setBounds(100, 100, 470, 445);
		getContentPane().setLayout(null);
		
		lblActividadTuristica = new JLabel("Seleccione Actividad Turistica:");
		lblActividadTuristica.setBounds(10, 57, 178, 14);
		getContentPane().add(lblActividadTuristica);
		
		salidaBox = new JComboBox<String>();
		salidaBox.setBounds(197, 96, 201, 22);
		getContentPane().add(salidaBox);
		
		lblSeleccioneSalida = new JLabel("Seleccione Salida:");
		lblSeleccioneSalida.setBounds(10, 100, 144, 14);
		getContentPane().add(lblSeleccioneSalida);
		
		JButton terminarBut = new JButton("Cancelar");
		terminarBut.setBounds(335, 359, 89, 23);
		getContentPane().add(terminarBut);
		
		JLabel lblNewLabel_2 = new JLabel("Tope de turistas:");
		lblNewLabel_2.setBounds(10, 171, 123, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de alta (a/m/d):");
		lblNewLabel_3.setBounds(10, 210, 165, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de salida (a/m/d):");
		lblNewLabel_4.setBounds(10, 253, 165, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hora de salida (h/m):");
		lblNewLabel_5.setBounds(10, 289, 144, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Lugar de salida:");
		lblNewLabel_6.setBounds(10, 324, 111, 14);
		getContentPane().add(lblNewLabel_6);
		
		actividadBox = new JComboBox<String>();
		actividadBox.setBounds(198, 53, 200, 22);
		getContentPane().add(actividadBox);
		
		labelTopeTuristas = new JLabel("");
		labelTopeTuristas.setBounds(197, 171, 201, 14);
		getContentPane().add(labelTopeTuristas);
		
		labelFechaAlta = new JLabel("");
		labelFechaAlta.setBounds(171, 210, 227, 14);
		getContentPane().add(labelFechaAlta);
		
		labelFechaSalida = new JLabel("");
		labelFechaSalida.setBounds(182, 253, 216, 14);
		getContentPane().add(labelFechaSalida);
		
		labelHoraSalida = new JLabel("");
		labelHoraSalida.setBounds(192, 289, 206, 14);
		getContentPane().add(labelHoraSalida);
		
		labelLugarSalida = new JLabel("");
		labelLugarSalida.setBounds(197, 324, 200, 14);
		getContentPane().add(labelLugarSalida);
		
		mostrarInfo = new JButton("Aceptar");
		mostrarInfo.setBounds(10, 359, 89, 23);
		getContentPane().add(mostrarInfo);
		
		labelNombre = new JLabel("");
		labelNombre.setBounds(197, 140, 102, 14);
		getContentPane().add(labelNombre);
		
		JLabel lblNewLabel_7 = new JLabel("Nombre:");
		lblNewLabel_7.setBounds(10, 140, 111, 14);
		getContentPane().add(lblNewLabel_7);
		
		labelselecdepart = new JLabel("Seleccione Departamento:");
		labelselecdepart.setBounds(10, 15, 144, 14);
		getContentPane().add(labelselecdepart);
		
		departamentoBox = new JComboBox<String>();
		departamentoBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				actividadBox.removeAllItems();
				salidaBox.removeAllItems();
				if (departamentoBox.getItemCount() != 0) {
					Map<String, DTActividadTuristica> dtactividades = controlador.obtenerDTActividadesConfirmadasDepto(departamentoBox.getSelectedItem().toString());
					dtactividades.forEach((key, value)-> { 
						actividadBox.addItem(value.getNombre());			
					});
				}
			}
		});
		departamentoBox.setBounds(197, 11, 201, 22);
		getContentPane().add(departamentoBox);
		
		actividadBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
		
		//Relleno salidaBox
				if (actividadBox.getItemCount() != 0) {
				String actividad = actividadBox.getSelectedItem().toString();
				salidaBox.removeAllItems();
				Map<String, DTSalidaTuristica> dtsalidas = controlador.obtenerDTSalidasTuristicas(actividad);
				dtsalidas.forEach((key, value)-> {
					salidaBox.addItem(value.getNombre());			
				});
			}
			}
		});
				
				
				
				mostrarInfo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evento) {
						accionBtnConsultarSalida();	
					}
				});

				
				terminarBut.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evento) {
						limpiarFormulario();
						setVisible(false);
					}
				});
		

	}
	
	protected void accionBtnConsultarSalida() {
		if (actividadBox.getItemCount() != 0 && salidaBox.getItemCount() != 0) {
			String actividad = actividadBox.getSelectedItem().toString();
			
			String salida = salidaBox.getSelectedItem().toString();
			labelNombre.setText(salida);
			
			DTSalidaTuristica dtsalida = controlador.obtenerDTSalidaTuristica(salida);
			int tope = dtsalida.getTopeTuristas();
			String stope = Integer.toString(tope);
			
			LocalDate fAlta = dtsalida.getFechaAlta();
			labelFechaAlta.setText(fAlta.toString());
			
			LocalDate fSalida = dtsalida.getFechaSalida();
			labelFechaSalida.setText(fSalida.toString());
			
			LocalTime hSalida = dtsalida.getHoraSalida();
			labelHoraSalida.setText(hSalida.toString());
									
			labelTopeTuristas.setText(stope);
		
			labelLugarSalida.setText(dtsalida.getLugarSalida());	
		}else {
			JOptionPane.showMessageDialog(null, "no puede haber campos vacios", "Consultar Salida Turistica", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void recargarDatos() {
		departamentoBox.setVisible(true);
		actividadBox.setVisible(true);
		mostrarInfo.setVisible(true);
		lblActividadTuristica.setVisible(true);
		labelselecdepart.setVisible(true);
		lblSeleccioneSalida.setVisible(true);
		
		departamentoBox.removeAllItems();
		Map<String, DTDepartamento> deptos = controlador.obtenerDTDepartamentos();
		deptos.forEach((key, value)-> {
			departamentoBox.addItem(value.getNombreDepto());
		});
		actividadBox.removeAllItems();
		

	}
	
	public void mostrarSalida(String departamento, String actividad, String salida) {
		departamentoBox.addItem(departamento);
		actividadBox.removeAllItems();
		actividadBox.addItem(actividad);
		salidaBox.removeAllItems();
		salidaBox.addItem(salida);
		accionBtnConsultarSalida();
	}
	
	public void mostrarSalida(String nombreSalida) {
		salidaBox.removeAllItems();
		salidaBox.addItem(nombreSalida);
		
		DTSalidaTuristica dtsalida = controlador.obtenerDTSalidaTuristica(nombreSalida);
		int tope = dtsalida.getTopeTuristas();
		String stope = Integer.toString(tope);
		
		LocalDate fAlta = dtsalida.getFechaAlta();
		labelFechaAlta.setText(fAlta.toString());
		
		LocalDate fSalida = dtsalida.getFechaSalida();
		labelFechaSalida.setText(fSalida.toString());
		
		LocalTime hSalida = dtsalida.getHoraSalida();
		labelHoraSalida.setText(hSalida.toString());
								
		labelTopeTuristas.setText(stope);
	
		labelLugarSalida.setText(dtsalida.getLugarSalida());	
		
		departamentoBox.setVisible(false);
		actividadBox.setVisible(false);
		labelselecdepart.setVisible(false);
		lblActividadTuristica.setVisible(false);
		mostrarInfo.setVisible(false);
		
	}
	
	public void limpiarFormulario() {
		labelTopeTuristas.setText("");
		labelLugarSalida.setText("");
		labelHoraSalida.setText("");
		labelFechaSalida.setText("");
		labelFechaAlta.setText("");
		labelNombre.setText("");
		departamentoBox.removeAllItems();
		actividadBox.removeAllItems();
		salidaBox.removeAllItems();
	}
	
}
