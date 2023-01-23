package src.presentacion;


import java.util.Map;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTProveedorExtendido;
import src.logica.datatypes.DTSalidaTuristica;
import src.logica.datatypes.DTTuristaExtendido;
import src.logica.datatypes.DTUsuario;
import src.logica.datatypes.DTUsuarioExtendido;
import src.logica.clases.Fabrica;
import src.logica.clases.IUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class ConsultaUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private JComboBox<String> boxUsuario;
	
	private Fabrica fabrica = new Fabrica();
	private IUsuario controlador = fabrica.getIUsuario();
	
	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(ConsultaSalidaTuristica consultarSalidaInternalFrame, ConsultaActividad  consultaActividadInternalFrame) {
		setMaximizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		
		setTitle("ConsultaUsuario");
		setBounds(100, 100, 601, 415);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar usuario:");
		lblNewLabel.setBounds(10, 11, 136, 14);
		getContentPane().add(lblNewLabel);
		
		boxUsuario = new JComboBox<String>();
		boxUsuario.setBounds(180, 7, 211, 22);
		getContentPane().add(boxUsuario);
		
		JButton mostrarInfo = new JButton("Aceptar");
		mostrarInfo.setBounds(10, 351, 89, 23);
		getContentPane().add(mostrarInfo);
		
		JLabel asdasd = new JLabel("Nombre:");
		asdasd.setBounds(10, 107, 76, 14);
		getContentPane().add(asdasd);
		
		JLabel asdgfas = new JLabel("Nickname:");
		asdgfas.setBounds(10, 145, 136, 14);
		getContentPane().add(asdgfas);
		
		JLabel sdad = new JLabel("Apellido:");
		sdad.setBounds(256, 107, 106, 14);
		getContentPane().add(sdad);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento (a/m/d):");
		lblNewLabel_4.setBounds(257, 145, 178, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel tipoUsuario = new JLabel("");
		tipoUsuario.setBounds(147, 58, 152, 14);
		getContentPane().add(tipoUsuario);
		
		JLabel gasdfa = new JLabel("Correo:");
		gasdfa.setBounds(10, 192, 89, 14);
		getContentPane().add(gasdfa);
		
		JLabel labelNacimiento = new JLabel("");
		labelNacimiento.setBounds(445, 145, 112, 14);
		getContentPane().add(labelNacimiento);
		
		JLabel labelApellido = new JLabel("");
		labelApellido.setBounds(445, 107, 112, 14);
		getContentPane().add(labelApellido);
		
		JLabel labelNombre = new JLabel("");
		labelNombre.setBounds(96, 107, 136, 14);
		getContentPane().add(labelNombre);
		
		JLabel labelNick = new JLabel("");
		labelNick.setBounds(96, 145, 136, 14);
		getContentPane().add(labelNick);
		
		JLabel labelCorreo = new JLabel("");
		labelCorreo.setBounds(96, 192, 136, 14);
		getContentPane().add(labelCorreo);
		
		JLabel tituloNacionalidad = new JLabel("Nacionalidad:");
		tituloNacionalidad.setBounds(10, 251, 89, 14);
		getContentPane().add(tituloNacionalidad);
		tituloNacionalidad.setVisible(false);
		
		JComboBox<String> boxSalidas = new JComboBox<String>();
		boxSalidas.setBounds(258, 247, 169, 22);
		getContentPane().add(boxSalidas);
		 boxSalidas.setVisible(false);
		
		JLabel tituloSalidas = new JLabel("Salidas:");
		tituloSalidas.setBounds(257, 232, 110, 14);
		getContentPane().add(tituloSalidas);
		tituloSalidas.setVisible(false);
		
		JLabel labelNacionalidad = new JLabel("");
		labelNacionalidad.setBounds(96, 251, 169, 14);
		getContentPane().add(labelNacionalidad);
		labelNacionalidad.setVisible(false);
		
		JLabel tituloDescri = new JLabel("Descripcion:");
		tituloDescri.setBounds(10, 301, 110, 14);
		getContentPane().add(tituloDescri);
		tituloDescri.setVisible(false);
		
		JLabel labelDescri = new JLabel("");
		labelDescri.setBounds(22, 326, 517, 14);
		getContentPane().add(labelDescri);
		labelDescri.setVisible(false);
		
		JLabel tituloEnlace = new JLabel("Enlace:");
		tituloEnlace.setBounds(256, 301, 115, 14);
		getContentPane().add(tituloEnlace);
		tituloEnlace.setVisible(false);
		
		JLabel labelEnlace = new JLabel("");
		labelEnlace.setBounds(388, 301, 151, 14);
		getContentPane().add(labelEnlace);
		labelEnlace.setVisible(false);
		
		JButton terminarBut = new JButton("Cancelar");
		terminarBut.setBounds(486, 351, 89, 23);
		getContentPane().add(terminarBut);
		
		JLabel tituloAct = new JLabel("Actividades:");
		tituloAct.setBounds(256, 179, 120, 14);
		getContentPane().add(tituloAct);
		tituloAct.setVisible(false);
		
		JComboBox<String> boxActividades = new JComboBox<String>();
		boxActividades.setBounds(256, 192, 171, 22);
		getContentPane().add(boxActividades);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de Usuario:");
		lblNewLabel_1.setBounds(10, 58, 127, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnMostrarSalida = new JButton("Mostrar salida");
		btnMostrarSalida.setBounds(445, 247, 140, 23);
		getContentPane().add(btnMostrarSalida);
		btnMostrarSalida.setVisible(false);
		
		JButton btnMostrarActividad = new JButton("Mostrar Actividad");
		btnMostrarActividad.setBounds(445, 192, 138, 23);
		getContentPane().add(btnMostrarActividad);
		boxActividades.setVisible(false);
		btnMostrarActividad.setVisible(false);
		

		Map<String, DTUsuario> dtusuarios = controlador.obtenerDTUsuarios();
		dtusuarios.forEach((key, value)-> { 
		boxUsuario.addItem(value.getNickname());
		});
	
		
		mostrarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				if (boxUsuario.getItemCount() != 0)  {
					String nickUsu = boxUsuario.getSelectedItem().toString();
					
					DTUsuarioExtendido dtusu = controlador.obtenerDTUsuarioExtendido(nickUsu);
					
					labelNombre.setText(dtusu.getNombre());
					labelCorreo.setText(dtusu.getCorreo());
					labelNacimiento.setText(dtusu.getFechaNacimiento().toString());
					labelApellido.setText(dtusu.getApellido());
					labelNick.setText(dtusu.getNickname());

					    if (dtusu instanceof DTProveedorExtendido) {
					    	tipoUsuario.setText("Proveedor");
					    	
					    	boxSalidas.removeAllItems();
					    	boxActividades.removeAllItems();
					    
					    	DTProveedorExtendido dtProveedor =  (DTProveedorExtendido) dtusu;
					    	Map<String, DTActividadTuristica> actividades = dtProveedor.getActividades();
					    	String enlace = dtProveedor.getLink();
					    	String descripcion = dtProveedor.getDescripcion();
					    	
					    	
					    	tituloNacionalidad.setVisible(false);
					    	labelNacionalidad.setVisible(false);
					    	boxSalidas.setVisible(true);
					    	tituloSalidas.setVisible(true);
					    	boxActividades.setVisible(true);
					    	btnMostrarActividad.setVisible(true);
					    	btnMostrarSalida.setVisible(true);
					    	labelEnlace.setVisible(true);
					    	tituloEnlace.setVisible(true);
					    	labelEnlace.setText(enlace);
					    	labelDescri.setVisible(true);
					    	tituloDescri.setVisible(true);
					    	labelDescri.setText(descripcion);
					    	
					    	tituloAct.setVisible(true);
					    	actividades.forEach((key, value)-> {
					    		boxActividades.addItem(key);
					    		Map<String, DTSalidaTuristica> salidas = value.getSalidas();
					    		salidas.forEach((key2, value2)-> {
					    			boxSalidas.addItem(value2.getNombre());
					    		});
					    		
					    	});
					    	
					    }
					    else {
					    	tipoUsuario.setText("Turista");
					    	
					    	boxSalidas.removeAllItems();
					    	boxActividades.removeAllItems();
					    	
					    	DTTuristaExtendido dtTurista =  (DTTuristaExtendido) dtusu;
					    	Map<String, DTSalidaTuristica> salidas = dtTurista.getSalidas();
					    	String nacionalidad = dtTurista.getNacionalidad();
					    	
					    	tituloEnlace.setVisible(false);
					    	labelEnlace.setVisible(false);
					    	tituloDescri.setVisible(false);
					    	labelDescri.setVisible(false);
					    	boxActividades.setVisible(false);
					    	tituloAct.setVisible(false);
					    	btnMostrarActividad.setVisible(false);
					    	
					    	
					    	labelNacionalidad.setVisible(true);
					    	tituloNacionalidad.setVisible(true);
					    	btnMostrarSalida.setVisible(true);
					    	labelNacionalidad.setText(nacionalidad);
					    	
					    	boxSalidas.setVisible(true);
					    	tituloSalidas.setVisible(true);
					    	salidas.forEach((key, value)-> {
					    	boxSalidas.addItem(key);
					    	});
						
					    }
				}else {
					JOptionPane.showMessageDialog(null, "No puede haber campos vacios", "Consulta de Usuario", JOptionPane.ERROR_MESSAGE);
				}
				}
			});
		
		
		terminarBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				labelNacionalidad.setText("");
				labelCorreo.setText("");
				labelDescri.setText("");
				labelEnlace.setText("");
				labelApellido.setText("");
				labelNombre.setText("");
				labelNombre.setText("");
				labelNick.setText("");
				boxSalidas.removeAllItems();
				boxActividades.removeAllItems();
				boxUsuario.removeAllItems();
				setVisible(false);
				
			}
		});
		
		btnMostrarSalida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				if (boxSalidas.getItemCount() != 0) {
					String nombreSalida = (String) boxSalidas.getSelectedItem();
					//consultarSalidaInternalFrame.limpiarFormulario();					
					// crear mostrar en constultarSalida
					consultarSalidaInternalFrame.mostrarSalida(nombreSalida);
					consultarSalidaInternalFrame.setVisible(true);
				}
			}
		});	
		
		btnMostrarActividad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				if (boxActividades.getItemCount() != 0) {
					String nombreActividad = (String) boxActividades.getSelectedItem();
					consultaActividadInternalFrame.mostrarAcividad(nombreActividad);
					consultaActividadInternalFrame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "debe existir alguna actividad", "Consulta Actividad", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
			}
		});
	
	}
	
	
	
	public void recargarDatos() {
		boxUsuario.removeAllItems();
		Map<String, DTUsuario> dtusuarios = controlador.obtenerDTUsuarios();
		dtusuarios.forEach((key, value)-> { 
		boxUsuario.addItem(value.getNickname());
		});
	}
}
