package src.presentacion;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;



import src.logica.clases.ActividadTuristica;

import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTDepartamento;
import src.logica.datatypes.DTSalidaTuristica;
import src.logica.datatypes.DTTurista;


import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.IUsuario;
import src.logica.clases.Manejador;
import src.logica.clases.SalidaTuristica;




import javax.swing.JOptionPane;

import javax.swing.SpinnerNumberModel;

import src.excepciones.InscripcionCapacidadExcedidaException;
import src.excepciones.InscripcionYaExisteException;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Map;



public class InscripcionASalidaTuristica extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private Fabrica fabrica = new Fabrica();
	private Manejador manejador = Manejador.getInstancia();
	private IUsuario controladorU = fabrica.getIUsuario();
	private IActividad controladorA = fabrica.getIActividad();
	private JLabel lblDepto = new JLabel("Seleccione departamento:");
	private JLabel lblActividadTuristica = new JLabel("Seleccione actividad tur\u00EDstica:");
	private JLabel lblDatosSalida = new JLabel("Datos de las salidas:");
	private JLabel lblNombreSalida = new JLabel("Nombre:");
	private JLabel fecha = new JLabel("Fecha(a/m/d):");
	private JLabel lblHora = new JLabel("Hora");
	private JLabel lblInscripcionTurista = new JLabel("Inscripci\u00F3n a la salida:");
	private JComboBox<String> cbTuristas = new JComboBox<String>();
	private JLabel lblTuristaResponsable = new JLabel("Responsable:");
	private JLabel lblCantidadParticipantesSalida = new JLabel("Participante/s:");
	private JSpinner spinnerParticipantesInscripcion = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
	private JComboBox<String> comboBoxDepto = new JComboBox<String>();
	private JComboBox<String> comboBoxActividades = new JComboBox<String>();
	private JLabel lblNewLabel = new JLabel("Lugar de salida:");
	private JComboBox<String> comboBoxSalidaInscripcion = new JComboBox<String>();
	private JButton btnCancelar = new JButton("Cancelar");
	private JLabel label = new JLabel("New label");
	private JLabel lblNombreSalidaMostrado = new JLabel("");
	private JLabel lblLugarSalidaMostrado = new JLabel("");
	private JLabel lblFechaMostrada = new JLabel("");
	private JLabel lblHoraMostrada = new JLabel("");
	private JButton btnConfirmar = new JButton("Aceptar"); 
	private JButton btnVerDatos = new JButton("Ver Datos");
	private JLabel lblCupos = new JLabel("cupos");
	private final JLabel lblCuposMostrados = new JLabel("");
	private Map<String, DTTurista> dtTuristas;  

	/**
	 * Create the frame.
	 */
	public InscripcionASalidaTuristica(){
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		
		
		
		setTitle("Inscripci\u00F3n a Salida Tur\u00EDstica");
		setBounds(100, 100, 626, 342);
		getContentPane().setLayout(null);
		
		
		lblDepto.setBounds(10, 11, 188, 14);
		getContentPane().add(lblDepto);
		
		
		lblActividadTuristica.setBounds(273, 11, 219, 14);
		getContentPane().add(lblActividadTuristica);
		
		
		lblDatosSalida.setBounds(10, 69, 119, 14);
		getContentPane().add(lblDatosSalida);
		
		
		lblNombreSalida.setBounds(10, 94, 103, 14);
		getContentPane().add(lblNombreSalida);
		
		
		fecha.setBounds(273, 94, 82, 14);
		getContentPane().add(fecha);
		
		
		lblHora.setBounds(320, 126, 119, 14);
		getContentPane().add(lblHora);
		
		
		lblInscripcionTurista.setBounds(10, 165, 114, 14);
		getContentPane().add(lblInscripcionTurista);
		
		
		cbTuristas.setBounds(96, 190, 119, 20);
		getContentPane().add(cbTuristas);
		
		
		lblTuristaResponsable.setBounds(10, 190, 103, 14);
		getContentPane().add(lblTuristaResponsable);
		
		
		lblCantidadParticipantesSalida.setBounds(10, 215, 103, 14);
		getContentPane().add(lblCantidadParticipantesSalida);
		
		
		spinnerParticipantesInscripcion.setBounds(96, 212, 30, 20);
		getContentPane().add(spinnerParticipantesInscripcion);
		
		
		comboBoxDepto.setBounds(10, 36, 159, 22);
		getContentPane().add(comboBoxDepto);
		
		
		comboBoxActividades.setBounds(233, 37, 219, 20);
		getContentPane().add(comboBoxActividades);
		
		
		lblNewLabel.setBounds(10, 126, 103, 14);
		getContentPane().add(lblNewLabel);
		
		
		comboBoxSalidaInscripcion.setBounds(156, 67, 154, 18);
		getContentPane().add(comboBoxSalidaInscripcion);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				limpiarFormulario(lblNombreSalidaMostrado, lblLugarSalidaMostrado, lblFechaMostrada, lblHoraMostrada, lblCuposMostrados);
			}
		});
		
		
		btnCancelar.setBounds(325, 262, 114, 23);
		getContentPane().add(btnCancelar);
		
		
		label.setBounds(145, 36, -101, -57);
		getContentPane().add(label);
		
		
		lblNombreSalidaMostrado.setBounds(66, 94, 166, 14);
		getContentPane().add(lblNombreSalidaMostrado);
		
		
		lblLugarSalidaMostrado.setBounds(110, 126, 200, 14);
		getContentPane().add(lblLugarSalidaMostrado);
		
		
		lblFechaMostrada.setBounds(358, 94, 82, 14);
		getContentPane().add(lblFechaMostrada);
		
		
		
		
		lblHoraMostrada.setBounds(396, 126, 119, 14);
		getContentPane().add(lblHoraMostrada);
		
				
		
		btnConfirmar.setBounds(145, 262, 114, 23);
		getContentPane().add(btnConfirmar);
		
		
		
		btnVerDatos.setBounds(368, 65, 97, 23);
		getContentPane().add(btnVerDatos);
		
		
		lblCupos.setBounds(458, 94, 46, 14);
		getContentPane().add(lblCupos);
		lblCuposMostrados.setBounds(497, 94, 46, 14);
		
		getContentPane().add(lblCuposMostrados);
		
		
		
		
			//relleno comboBoxDepto
				
				
				Map<String, DTDepartamento> dtDeptos = controladorA.obtenerDTDepartamentos();
				dtDeptos.forEach((key, value)-> {
					comboBoxDepto.addItem(value.getNombreDepto());			
				});
				


				//cambio actividades cuando cambia de Depto
				comboBoxDepto.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						if (comboBoxDepto.getItemCount() != 0) {
							comboBoxActividades.removeAllItems();
							String depto = (String) comboBoxDepto.getSelectedItem();
							comboBoxActividades.removeAllItems();
							//Relleno actividadBox
							Map<String, DTActividadTuristica> dtacts = controladorA.obtenerDTActividadesConfirmadasDepto(depto);
							dtacts.forEach((key, value)-> {
								comboBoxActividades.addItem(value.getNombre());			
							});
						}
						
					}
				});
				
				//cambio salidas cuando cambio de actividades
				comboBoxActividades.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						comboBoxSalidaInscripcion.removeAllItems();
						//Relleno actividadBox
						if (comboBoxActividades.getItemCount() != 0){
							comboBoxSalidaInscripcion.removeAllItems();
							String actividad = (String) comboBoxActividades.getSelectedItem();
							
							Map<String, DTSalidaTuristica> dtSalidas = controladorA.obtenerDTSalidasVigentes(actividad);
							dtSalidas.forEach((key, value)-> {
							comboBoxSalidaInscripcion.addItem(value.getNombre());			
							});
						}
						
						
					}
				});
				
				
				
				
				
				
				
				//accion de los bottones
			
		btnVerDatos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if (chequeoSalida()){
					String nombreSalida = (String) comboBoxSalidaInscripcion.getSelectedItem();
					String nombreActividad = (String) comboBoxActividades.getSelectedItem();
					ActividadTuristica actividad = manejador.getActividad(nombreActividad);
					Map<String, SalidaTuristica> salidas = actividad.getSalidas();
					DTSalidaTuristica dtSalida = salidas.get(nombreSalida).obtenerDT();
					lblNombreSalidaMostrado.setText(dtSalida.getNombre());
					lblLugarSalidaMostrado.setText(dtSalida.getLugarSalida());
					lblFechaMostrada.setText(dtSalida.getFechaSalida().toString()); //fijarse si pasa bien
					lblHoraMostrada.setText(dtSalida.getHoraSalida().toString()); // fijarse si devuelve bien
					lblCuposMostrados.setText(String.valueOf(dtSalida.getCuposDisponibles())); 	
				}
			}
		});
			
		
		btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				actionBtnAceptarInscripcion();
			}
		});
				
		
		
		
		//Selecciono al responsable e ingreso los valores que quedan. En caso de cantidad de turistas > tope o el turista ya estuviera registrado en la actividad hay que modificar los datos.
		// Hay que poner excepciones ahi.
	
	};
	
	
	protected boolean chequeoFormulario(JComboBox<String> turistas, JComboBox<String> salidas){
		if (turistas.getItemCount() == 0 || salidas.getItemCount() == 0 || comboBoxActividades.getItemCount() == 0){
			JOptionPane.showMessageDialog(this, "debe haber actividad, salida y responsable", "Inscripcion a Salida", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	protected boolean chequeoSalida() {
		if (comboBoxSalidaInscripcion.getItemCount() == 0){
			JOptionPane.showMessageDialog(this, "La salida no puede estar Vacia", "cbSalida", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	protected void limpiarFormulario(JLabel nombre, JLabel lugar, JLabel fecha, JLabel hora, JLabel  cupos) {
		nombre.setText("");
		lugar.setText("");
		fecha.setText("");
		hora.setText("");
		cupos.setText("");
	}
	
	protected void actionBtnAceptarInscripcion()  {
		if (chequeoFormulario(cbTuristas, comboBoxSalidaInscripcion)) {
			String turista = (String) cbTuristas.getSelectedItem();
			String salida = (String) comboBoxSalidaInscripcion.getSelectedItem();
			String actividad = (String) comboBoxActividades.getSelectedItem();
			int cantidadTuristas =  (int) spinnerParticipantesInscripcion.getValue();
					
			LocalDate fechaInscripcion = LocalDate.now();
			
			try {
				
				controladorU.aceptarInscripcion(turista, salida, actividad, cantidadTuristas, fechaInscripcion);
				JOptionPane.showMessageDialog(this, "Inscripción a salida con éxito", "Inscripción a salida turistica", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario(lblNombreSalidaMostrado, lblLugarSalidaMostrado, lblFechaMostrada, lblHoraMostrada, lblCuposMostrados);
			} catch (InscripcionYaExisteException e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage(), "error al ingresar", JOptionPane.ERROR_MESSAGE);
			} catch (InscripcionCapacidadExcedidaException e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage(), "error al ingresar", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public void recargarDatos(){
		comboBoxDepto.removeAllItems();
		cbTuristas.removeAllItems();
		
		dtTuristas = controladorU.obtenerDTTuristas();
		Map<String, DTDepartamento> dtDeptos = controladorA.obtenerDTDepartamentos();
		dtDeptos.forEach((key, value)-> {
			comboBoxDepto.addItem(value.getNombreDepto());			
		});
		
		//relleno Turistas
		
		dtTuristas.forEach((key, value)-> {
			cbTuristas.addItem(key); 			
		});
		
		
		
	}
}


