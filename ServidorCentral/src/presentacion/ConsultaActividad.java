package src.presentacion;


import src.logica.datatypes.DTActividadExtendida;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTCategoria;
import src.logica.datatypes.DTDepartamento;
import src.logica.datatypes.DTPaqueteActividad;
import src.logica.datatypes.DTSalidaTuristica;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.IPaquete;


import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ConsultaActividad extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private Fabrica fabrica;
	private IActividad controladorA;
	private String departamentoSeleccionado = "";
	private String actividadSeleccionada = "";
	private JComboBox<String> comboBoxDepartamentos;
	
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldCiudad;
	private JTextField textFieldFechaAlta;
	private JComboBox<String> comboBoxActividades;
	private JComboBox<String> comboBoxSalidas;
	private JComboBox<String> comboBoxPaquetes;
	private JComboBox<String> comboBoxCategorias;
	private JButton btnAceptar;


	
	public ConsultaActividad(ConsultaSalidaTuristica consultarSalidaInternalFrame){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fabrica = new Fabrica();
		controladorA = fabrica.getIActividad();
		
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Actividad Turística");
		setBounds(100, 100, 640, 550);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{320, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 35, 35, 35, 29, 35, 35, 35, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel labelDepartamentos = new JLabel("  Departamentos:");
		GridBagConstraints gbc_labelDepartamentos = new GridBagConstraints();
		gbc_labelDepartamentos.anchor = GridBagConstraints.WEST;
		gbc_labelDepartamentos.insets = new Insets(0, 0, 5, 5);
		gbc_labelDepartamentos.gridx = 0;
		gbc_labelDepartamentos.gridy = 0;
		getContentPane().add(labelDepartamentos, gbc_labelDepartamentos);
		
		JPanel panelDepartamentos = new JPanel();
		GridBagConstraints gbc_panelDepartamentos = new GridBagConstraints();
		gbc_panelDepartamentos.insets = new Insets(0, 0, 5, 5);
		gbc_panelDepartamentos.fill = GridBagConstraints.BOTH;
		gbc_panelDepartamentos.gridx = 0;
		gbc_panelDepartamentos.gridy = 1;
		getContentPane().add(panelDepartamentos, gbc_panelDepartamentos);
		GridBagLayout gbl_panelDepartamentos = new GridBagLayout();
		gbl_panelDepartamentos.columnWidths = new int[]{370, 100, 0};
		gbl_panelDepartamentos.rowHeights = new int[]{35, 0};
		gbl_panelDepartamentos.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelDepartamentos.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelDepartamentos.setLayout(gbl_panelDepartamentos);
		
		comboBoxDepartamentos = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxDepartamentos = new GridBagConstraints();
		gbc_comboBoxDepartamentos.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxDepartamentos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepartamentos.gridx = 0;
		gbc_comboBoxDepartamentos.gridy = 0;
		panelDepartamentos.add(comboBoxDepartamentos, gbc_comboBoxDepartamentos);
		
		
		JButton btnDepartamento = new JButton("Seleccionar");
		GridBagConstraints gbc_btnDepartamento = new GridBagConstraints();
		gbc_btnDepartamento.gridx = 1;
		gbc_btnDepartamento.gridy = 0;
		panelDepartamentos.add(btnDepartamento, gbc_btnDepartamento);
		
		JLabel labelActividades = new JLabel("  Actividades Turísticas:");
		GridBagConstraints gbc_labelActividades = new GridBagConstraints();
		gbc_labelActividades.anchor = GridBagConstraints.WEST;
		gbc_labelActividades.insets = new Insets(0, 0, 5, 5);
		gbc_labelActividades.gridx = 0;
		gbc_labelActividades.gridy = 2;
		getContentPane().add(labelActividades, gbc_labelActividades);
		
		JPanel panelActividades = new JPanel();
		GridBagConstraints gbc_panelActividades = new GridBagConstraints();
		gbc_panelActividades.insets = new Insets(0, 0, 5, 5);
		gbc_panelActividades.fill = GridBagConstraints.BOTH;
		gbc_panelActividades.gridx = 0;
		gbc_panelActividades.gridy = 3;
		getContentPane().add(panelActividades, gbc_panelActividades);
		GridBagLayout gbl_panelActividades = new GridBagLayout();
		gbl_panelActividades.columnWidths = new int[]{380, 100, 0};
		gbl_panelActividades.rowHeights = new int[]{0, 0};
		gbl_panelActividades.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelActividades.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelActividades.setLayout(gbl_panelActividades);
		
		comboBoxActividades = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxActividades = new GridBagConstraints();
		gbc_comboBoxActividades.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxActividades.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxActividades.gridx = 0;
		gbc_comboBoxActividades.gridy = 0;
		panelActividades.add(comboBoxActividades, gbc_comboBoxActividades);
		
		JButton btnActividad = new JButton("Seleccionar");
		GridBagConstraints gbc_btnActividad = new GridBagConstraints();
		gbc_btnActividad.gridx = 1;
		gbc_btnActividad.gridy = 0;
		panelActividades.add(btnActividad, gbc_btnActividad);
		
		JLabel labelInfo = new JLabel("Información Actividad Turística:");
		GridBagConstraints gbc_labelInfo = new GridBagConstraints();
		gbc_labelInfo.insets = new Insets(0, 0, 5, 5);
		gbc_labelInfo.gridx = 0;
		gbc_labelInfo.gridy = 5;
		getContentPane().add(labelInfo, gbc_labelInfo);
		
		JPanel panelInfo = new JPanel();
		GridBagConstraints gbc_panelInfo = new GridBagConstraints();
		gbc_panelInfo.insets = new Insets(0, 0, 5, 5);
		gbc_panelInfo.fill = GridBagConstraints.BOTH;
		gbc_panelInfo.gridx = 0;
		gbc_panelInfo.gridy = 6;
		getContentPane().add(panelInfo, gbc_panelInfo);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[]{100, 0, 0};
		gbl_panelInfo.rowHeights = new int[]{35, 35, 35, 35, 35, 32, 35, 35, 0};
		gbl_panelInfo.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelInfo.setLayout(gbl_panelInfo);
		
		JLabel labelDescripcion = new JLabel("Descripción:");
		GridBagConstraints gbc_labelDescripcion = new GridBagConstraints();
		gbc_labelDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_labelDescripcion.gridx = 0;
		gbc_labelDescripcion.gridy = 0;
		panelInfo.add(labelDescripcion, gbc_labelDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setEditable(false);
		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescripcion.gridx = 1;
		gbc_textFieldDescripcion.gridy = 0;
		panelInfo.add(textFieldDescripcion, gbc_textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel labelDuracion = new JLabel("Duración:");
		GridBagConstraints gbc_labelDuracion = new GridBagConstraints();
		gbc_labelDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_labelDuracion.gridx = 0;
		gbc_labelDuracion.gridy = 1;
		panelInfo.add(labelDuracion, gbc_labelDuracion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setEditable(false);
		GridBagConstraints gbc_textFieldDuracion = new GridBagConstraints();
		gbc_textFieldDuracion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDuracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDuracion.gridx = 1;
		gbc_textFieldDuracion.gridy = 1;
		panelInfo.add(textFieldDuracion, gbc_textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo:");
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 0;
		gbc_lblCosto.gridy = 2;
		panelInfo.add(lblCosto, gbc_lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setEditable(false);
		GridBagConstraints gbc_textFieldCosto = new GridBagConstraints();
		gbc_textFieldCosto.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCosto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCosto.gridx = 1;
		gbc_textFieldCosto.gridy = 2;
		panelInfo.add(textFieldCosto, gbc_textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel labelCiudad = new JLabel("Ciudad:");
		GridBagConstraints gbc_labelCiudad = new GridBagConstraints();
		gbc_labelCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_labelCiudad.gridx = 0;
		gbc_labelCiudad.gridy = 3;
		panelInfo.add(labelCiudad, gbc_labelCiudad);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setEditable(false);
		GridBagConstraints gbc_textFieldCiudad = new GridBagConstraints();
		gbc_textFieldCiudad.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCiudad.gridx = 1;
		gbc_textFieldCiudad.gridy = 3;
		panelInfo.add(textFieldCiudad, gbc_textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		JLabel labelFechaAlta = new JLabel("Fecha de Alta:");
		GridBagConstraints gbc_labelFechaAlta = new GridBagConstraints();
		gbc_labelFechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_labelFechaAlta.gridx = 0;
		gbc_labelFechaAlta.gridy = 4;
		panelInfo.add(labelFechaAlta, gbc_labelFechaAlta);
		
		textFieldFechaAlta = new JTextField();
		textFieldFechaAlta.setEditable(false);
		GridBagConstraints gbc_textFieldFechaAlta = new GridBagConstraints();
		gbc_textFieldFechaAlta.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFechaAlta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaAlta.gridx = 1;
		gbc_textFieldFechaAlta.gridy = 4;
		panelInfo.add(textFieldFechaAlta, gbc_textFieldFechaAlta);
		textFieldFechaAlta.setColumns(10);
		
		JLabel lblCategorias = new JLabel("Categorias:");
		GridBagConstraints gbc_lblCategorias = new GridBagConstraints();
		gbc_lblCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategorias.gridx = 0;
		gbc_lblCategorias.gridy = 5;
		panelInfo.add(lblCategorias, gbc_lblCategorias);
		
		comboBoxCategorias = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxCategorias = new GridBagConstraints();
		gbc_comboBoxCategorias.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxCategorias.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCategorias.gridx = 1;
		gbc_comboBoxCategorias.gridy = 5;
		panelInfo.add(comboBoxCategorias, gbc_comboBoxCategorias);
		
		JLabel labelSalidas = new JLabel("Salidas Turísticas:");
		GridBagConstraints gbc_labelSalidas = new GridBagConstraints();
		gbc_labelSalidas.insets = new Insets(0, 0, 5, 5);
		gbc_labelSalidas.gridx = 0;
		gbc_labelSalidas.gridy = 6;
		panelInfo.add(labelSalidas, gbc_labelSalidas);
		
		JPanel panelSalidas = new JPanel();
		GridBagConstraints gbc_panelSalidas = new GridBagConstraints();
		gbc_panelSalidas.insets = new Insets(0, 0, 5, 0);
		gbc_panelSalidas.fill = GridBagConstraints.BOTH;
		gbc_panelSalidas.gridx = 1;
		gbc_panelSalidas.gridy = 6;
		panelInfo.add(panelSalidas, gbc_panelSalidas);
		GridBagLayout gbl_panelSalidas = new GridBagLayout();
		gbl_panelSalidas.columnWidths = new int[]{0, 100, 0};
		gbl_panelSalidas.rowHeights = new int[]{0, 0};
		gbl_panelSalidas.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelSalidas.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelSalidas.setLayout(gbl_panelSalidas);
		
		comboBoxSalidas = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxSalidas = new GridBagConstraints();
		gbc_comboBoxSalidas.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxSalidas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSalidas.gridx = 0;
		gbc_comboBoxSalidas.gridy = 0;
		panelSalidas.add(comboBoxSalidas, gbc_comboBoxSalidas);
		
		JButton btnConsultaSalidas = new JButton("Consultar Salida");
		GridBagConstraints gbc_btnConsultaSalidas = new GridBagConstraints();
		gbc_btnConsultaSalidas.gridx = 1;
		gbc_btnConsultaSalidas.gridy = 0;
		panelSalidas.add(btnConsultaSalidas, gbc_btnConsultaSalidas);
		
		JLabel labelPaquetes = new JLabel("Paquetes:");
		GridBagConstraints gbc_labelPaquetes = new GridBagConstraints();
		gbc_labelPaquetes.insets = new Insets(0, 0, 0, 5);
		gbc_labelPaquetes.gridx = 0;
		gbc_labelPaquetes.gridy = 7;
		panelInfo.add(labelPaquetes, gbc_labelPaquetes);
		
		JPanel panelPaquetes = new JPanel();
		GridBagConstraints gbc_panelPaquetes = new GridBagConstraints();
		gbc_panelPaquetes.fill = GridBagConstraints.BOTH;
		gbc_panelPaquetes.gridx = 1;
		gbc_panelPaquetes.gridy = 7;
		panelInfo.add(panelPaquetes, gbc_panelPaquetes);
		GridBagLayout gbl_panelPaquetes = new GridBagLayout();
		gbl_panelPaquetes.columnWidths = new int[]{0, 100, 0};
		gbl_panelPaquetes.rowHeights = new int[]{0, 0};
		gbl_panelPaquetes.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelPaquetes.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelPaquetes.setLayout(gbl_panelPaquetes);
		
		comboBoxPaquetes = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxPaquetes = new GridBagConstraints();
		gbc_comboBoxPaquetes.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxPaquetes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPaquetes.gridx = 0;
		gbc_comboBoxPaquetes.gridy = 0;
		panelPaquetes.add(comboBoxPaquetes, gbc_comboBoxPaquetes);
		
		JButton btnaConsultaPaquete = new JButton("Consultar Paquete");
		GridBagConstraints gbc_btnaConsultaPaquete = new GridBagConstraints();
		gbc_btnaConsultaPaquete.gridx = 1;
		gbc_btnaConsultaPaquete.gridy = 0;
		panelPaquetes.add(btnaConsultaPaquete, gbc_btnaConsultaPaquete);
		
		JPanel panelBotones = new JPanel();
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 0, 5);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 0;
		gbc_panelBotones.gridy = 7;
		getContentPane().add(panelBotones, gbc_panelBotones);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[]{0, 0, 0};
		gbl_panelBotones.rowHeights = new int[]{0, 0};
		gbl_panelBotones.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelBotones.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelBotones.setLayout(gbl_panelBotones);
		
		btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 0;
		panelBotones.add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 0;
		panelBotones.add(btnCancelar, gbc_btnCancelar);
		
		

		

		
		//relleno el comboBoxDepartamentos
		IActividad controlActividad = fabrica.getIActividad();
		Map<String, DTDepartamento> colDeptos = controlActividad.obtenerDTDepartamentos();
		colDeptos.forEach((key, value)-> {
			comboBoxDepartamentos.addItem(value.getNombreDepto());
		});
				

		
		//evento al seleccionar departamento
		btnDepartamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//obtengo el departamento
				if (comboBoxDepartamentos.getItemCount() != 0) {
					departamentoSeleccionado = comboBoxDepartamentos.getSelectedItem().toString();
							
					//limpio los demas comboBox
					comboBoxActividades.removeAllItems();
					comboBoxSalidas.removeAllItems();
					comboBoxPaquetes.removeAllItems();
					comboBoxCategorias.removeAllItems();
					
					//relleno el comboBoxActividades
					IActividad controlActividad = fabrica.getIActividad();
					Map<String, DTActividadTuristica> colActividades = controlActividad.obtenerDTActividadesConfirmadasDepto(departamentoSeleccionado);
					//System.out.print(colActividades.get(e))
					colActividades.forEach((key, value)-> {
						comboBoxActividades.addItem(value.getNombre());
					});
				}
			}
		});
				
		//evento al seleccionar actividad
		btnActividad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				accionBotonSeleccionarActividad();
			}
		});
				
		//evento al aceptar
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				
				accionBtnConsultaActividad(comboBoxActividades, comboBoxSalidas, comboBoxPaquetes,comboBoxCategorias);
			}
		});
				
		//evento de cancelar
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//limpio la entrada antes de cerrar
				limpiarFormulario();
				setVisible(false);
			}
		});
				
		//evento de consulta salida
		btnConsultaSalidas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (comboBoxSalidas.getItemCount() != 0) {
					String departamento = (String) comboBoxDepartamentos.getSelectedItem();
					String actividad = (String) comboBoxActividades.getSelectedItem();
					String salida = (String) comboBoxSalidas.getSelectedItem();
					consultarSalidaInternalFrame.limpiarFormulario();
;					consultarSalidaInternalFrame.mostrarSalida(departamento, actividad, salida);
					consultarSalidaInternalFrame.setVisible(true);
				}
			}
		});
				
		//evento de consultar paquete
		/*btnaConsultaPaquete.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxPaquetes.getItemCount() != 0) {
							
				}
			}
		});*/
	}
	
	protected void accionBtnConsultaActividad(JComboBox<String> comboBoxActividades, JComboBox<String> comboBoxSalidas, JComboBox<String> comboBoxPaquetes,JComboBox<String> comboBoxCategorias) {
		if (comboBoxSalidas.getItemCount() == 0 && comboBoxPaquetes.getItemCount() == 0) {
		//reviso que los datos no esten vacios
		if (checkFormulario(comboBoxActividades)) {
			//ejecuto el CU
			IPaquete controlPaquete = fabrica.getIPaquete();
			DTActividadExtendida DTExtendido = controlPaquete.obtenerDTActividadExtendido(actividadSeleccionada);
			
			//muestro la info
			textFieldDescripcion.setText(DTExtendido.getDescripcion());
			
			int duracion = DTExtendido.getDuracion();
			textFieldDuracion.setText(String.valueOf(duracion));
			textFieldCosto.setText(String.valueOf(DTExtendido.getCosto()));
			textFieldCiudad.setText(DTExtendido.getCiudad());
			
			int altaDia = DTExtendido.getFechaAlta().getDayOfMonth();
			int altaMes = DTExtendido.getFechaAlta().getMonthValue();
			int altaAnio = DTExtendido.getFechaAlta().getYear();
			textFieldFechaAlta.setText(String.valueOf(altaDia) + "/" + String.valueOf(altaMes) + "/" + String.valueOf(altaAnio));
			
			//relleno el comboBoxCategorias
			Map<String, DTCategoria> colcategorias = DTExtendido.getCategorias();
			if (colcategorias.isEmpty()) {
				System.out.println("hola");
			}
			colcategorias.forEach((key,value)->{
				comboBoxCategorias.addItem(value.getNombre());
			});
			//relleno el comboBoxSalidas
			Map<String, DTSalidaTuristica> colSalidas = DTExtendido.getSalidas();
			colSalidas.forEach((key, value)-> {
				comboBoxSalidas.addItem(value.getNombre());
			});
			
			//relleno el comboBoxPaquetes
			Map<String, DTPaqueteActividad> colPaquetes = DTExtendido.getPaquetes();
			colPaquetes.forEach((key, value)-> {
				comboBoxPaquetes.addItem(value.getNombre());
			});
		}
		}
		}
	
	protected boolean checkFormulario(JComboBox<String> comboBoxActividades) {
		if (comboBoxDepartamentos.getItemCount() == 0 || comboBoxActividades.getItemCount() == 0) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Consulta de Actividad Turística", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiarFormulario() {
		comboBoxDepartamentos.removeAllItems();
		comboBoxActividades.removeAllItems();
		comboBoxCategorias.removeAllItems();
		textFieldDescripcion.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
		textFieldCiudad.setText("");
		textFieldFechaAlta.setText("");
		comboBoxSalidas.removeAllItems();
		comboBoxPaquetes.removeAllItems();
	}

	public void regargarDatosConsultaActividad() {
		limpiarFormulario();
		IActividad controlActividad = fabrica.getIActividad();
		Map<String, DTDepartamento> colDeptos = controlActividad.obtenerDTDepartamentos();
		colDeptos.forEach((key, value)-> {
			comboBoxDepartamentos.addItem(value.getNombreDepto());
		});
		btnAceptar.setVisible(true);
	}
	
	public void mostrarAcividad(String nombreActividad) {
		comboBoxActividades.removeAllItems();
		comboBoxDepartamentos.removeAllItems();
		comboBoxActividades.addItem(nombreActividad);
		DTActividadTuristica dtActividad = controladorA.obtenerDTActividadTuristica(nombreActividad);
		comboBoxDepartamentos.addItem(dtActividad.getDepartamento());
		accionBotonSeleccionarActividad();
		accionBtnConsultaActividad(comboBoxActividades, comboBoxSalidas, comboBoxPaquetes, comboBoxCategorias);
		btnAceptar.setVisible(false);
		
	}
	
	public void accionBotonSeleccionarActividad() {
		if (comboBoxActividades.getItemCount() != 0) {
			actividadSeleccionada = (String) comboBoxActividades.getSelectedItem();
			//limpio los demas comboBox
			comboBoxSalidas.removeAllItems();
			comboBoxPaquetes.removeAllItems();
			comboBoxCategorias.removeAllItems();
			textFieldDescripcion.setText("");
            textFieldDuracion.setText("");
            textFieldCosto.setText("");
            textFieldFechaAlta.setText("");
            textFieldCiudad.setText("");
		
		}
	}
}