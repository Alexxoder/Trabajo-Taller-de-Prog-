package src.presentacion;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.excepciones.ActividadRepetidaException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
//import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import src.logica.clases.ControladorActividad;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.IUsuario;
import src.logica.datatypes.DTCategoria;
import src.logica.datatypes.DTDepartamento;
import src.logica.datatypes.DTProveedor;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;


public class AltaDeActividadTuristica extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfDescripcion;
	private JTextField tfCiudad;
	private JComboBox<String> cbDepartamentos = new JComboBox<String>();
	private JComboBox<String> cbProvedores = new JComboBox<String>();
	private JSpinner costo = new JSpinner(new SpinnerNumberModel( 0, 0, 30000, 1));
	private JList<String> listaCategorias;
	private Fabrica fabrica = new Fabrica();
	private IUsuario controladorU = fabrica.getIUsuario();
	private IActividad controladorA = fabrica.getIActividad();
	private int indice;
	String [] categorias;
	public AltaDeActividadTuristica() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent event) {
			}
		});
		setMaximizable(true);
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		setTitle("Alta de actividad turistica");
		
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 470, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		

		cbProvedores.setBounds(237, 11, 161, 22);
		contentPane.add(cbProvedores);
		

		cbDepartamentos.setBounds(237, 39, 161, 22);
		contentPane.add(cbDepartamentos);
		
		listaCategorias = new JList<String>();
		listaCategorias.setBounds(138, 252, 152, 129);
		contentPane.add(listaCategorias);
		
		JLabel lblTitulo = new JLabel("Ingrese Datos de Actividad");
		lblTitulo.setBounds(149, 72, 158, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 97, 55, 14);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(138, 97, 152, 20);
		contentPane.add(tfNombre);   
		tfNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(29, 122, 58, 14);
		contentPane.add(lblDescripcion);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(138, 128, 152, 20);
		contentPane.add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion(h/m)");
		lblDuracion.setBounds(29, 159, 77, 14);
		contentPane.add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo(pesos)");
		lblCosto.setBounds(29, 193, 77, 14);
		contentPane.add(lblCosto);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(29, 224, 46, 14);
		contentPane.add(lblCiudad);
		
		tfCiudad = new JTextField();
		tfCiudad.setBounds(138, 221, 152, 20);
		contentPane.add(tfCiudad);
		tfCiudad.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de Alta(d/m/a)");
		lblFecha.setBounds(29, 392, 125, 14);
		contentPane.add(lblFecha);
		
		
		
		
		
		JSpinner dia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
		dia.setBounds(164, 389, 44, 20);
		contentPane.add(dia);
		((JSpinner.DefaultEditor) dia.getEditor()).getTextField().setEditable(false);
		
		JSpinner mes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
		mes.setBounds(237, 389, 46, 20);
		contentPane.add(mes);
		((JSpinner.DefaultEditor) mes.getEditor()).getTextField().setEditable(false);
		
		JSpinner anio = new JSpinner(new SpinnerNumberModel(2022, 0, 2030, 1));
		anio.setBounds(320, 389, 59, 20);
		contentPane.add(anio);
		
		JSpinner horas = new JSpinner(new SpinnerNumberModel(0, 0, 24, 1));
		horas.setBounds(138, 156, 30, 20);
		contentPane.add(horas);
		((JSpinner.DefaultEditor) horas.getEditor()).getTextField().setEditable(false);
		
		JSpinner minutos = new JSpinner(new SpinnerNumberModel(0, 0, 60, 1));
		minutos.setBounds(178, 156, 30, 20);
		contentPane.add(minutos);
		((JSpinner.DefaultEditor) minutos.getEditor()).getTextField().setEditable(false);
		
		
		costo.setBounds(138, 190, 30, 20);
		contentPane.add(costo);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(102, 486, 89, 23);
		contentPane.add(btnAceptar);
		//accion
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if (chequeoFormulario(cbProvedores, cbDepartamentos, listaCategorias)) {
					accionBtnAceptarAltaActividad(cbProvedores, cbDepartamentos, dia, mes, anio, horas, minutos, costo, listaCategorias);
					
	
				}
	
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(237, 486, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Proovedor:");
		lblNewLabel.setBounds(29, 15, 161, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccionar Departamento:");
		lblNewLabel_1.setBounds(29, 43, 198, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel categorialbl = new JLabel("Categoria");
		categorialbl.setBounds(29, 260, 77, 14);
		contentPane.add(categorialbl);
		//listo las categorias
		//pido el tamanio -1 del conjunto de categorias y lo guardo en un array de string
		//Map<String,DTCategoria> mapcategorias = controladorA.obtenerDTCategorias();
//		String [] categorias = new String[4];
//		categorias[0] = "1";
//		categorias[1] = "2";
//		categorias[2] = "3";
//		categorias[3] = "4";
		//String [] categorias = new String[mapcategorias.size()];
		//indice = 0;
//		System.out.println(mapcategorias.size());
//		mapcategorias.forEach((key,value)->{
//			categorias[indice] = key;
//			indice++;
//		});
		//listaCategorias = new JList(categorias);
		//listaCategorias.setBounds(138, 252, 152, 129);
		//contentPane.add(listaCategorias);
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				limpiarFormulario(dia, mes, anio, horas, minutos, costo,listaCategorias);
				setVisible(false);
				
			}
		});
		


		
	
		
	}
	

	
	
	@SuppressWarnings("unused")
	private class SwingAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent event) {
		}
	}
	
	private boolean chequeoFormulario(JComboBox<String> proveedor, JComboBox<String> departamento, JList<String> categorias) {
		String nombre = tfNombre.getText();
		String descripcion = tfDescripcion.getText();
		String ciudad = tfCiudad.getText();
		
		
		
		
		if (nombre.isEmpty() || descripcion.isEmpty() || ciudad.isEmpty() || proveedor.getItemCount() == 0 || departamento.getItemCount() == 0 || categorias.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta de Actividad Turistica", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
	}
	
	private void limpiarFormulario(JSpinner jDia, JSpinner JMes, JSpinner Janio, JSpinner jHoras, JSpinner jMinutos, JSpinner jCosto, JList<String> listaCategorias) {
        tfNombre.setText("");
        tfDescripcion.setText("");
        tfCiudad.setText("");
        jDia.setValue(1);
        JMes.setValue(1);
        Janio.setValue(0);
        jHoras.setValue(0);
        jMinutos.setValue(0);
        jCosto.setValue(0);
        listaCategorias.clearSelection();
		listaCategorias.removeAll();
		Map<String,DTCategoria> mapcategorias = controladorA.obtenerDTCategorias();
		String [] categorias = new String[mapcategorias.size()];
		indice = 0;
		mapcategorias.forEach((key,value)->{
			categorias[indice] = key;
			indice++;
		});
		listaCategorias.setListData(categorias);
	}
	
	protected void accionBtnAceptarAltaActividad(JComboBox<String> cbProveedor, JComboBox<String> cbDepartamento, JSpinner jDia, JSpinner JMes, JSpinner jAnio, JSpinner jHoras, JSpinner jMinutos, JSpinner jCosto, JList<String> listaCategorias) {
		 ControladorActividad controladorActividad = new ControladorActividad();
		 String nickProveedor = (String) cbProveedor.getSelectedItem();
		 String nombreDepartamento = (String) cbDepartamento.getSelectedItem();
		 //pido los valores de categorias que son seleccionados para cargarlos en la coleccion de la actividad
		 List<String> valores = listaCategorias.getSelectedValuesList();
		 Map<String,DTCategoria> categoriaparaAct = new HashMap<String, DTCategoria>();
		 for(String valor: valores) {
			 categoriaparaAct.put(valor,controladorActividad.obtenerDTCategoria(valor));
		 }
		 int dia = (int) jDia.getValue();
		 int mes = (int) JMes.getValue();
		 int anio = (int) jAnio.getValue();
		 int costo = (int) jCosto.getValue();
		 String nombreActividad = tfNombre.getText();
		 String descripcion = tfDescripcion.getText();
		 String ciudad = tfCiudad.getText();
		 
		 int duracion = 1;
		 LocalDate fecha = LocalDate.of(anio, mes, dia);
		 
		 try {
			 controladorActividad.aceptarAltaActividad(nickProveedor, nombreDepartamento, nombreActividad, descripcion, ciudad, duracion, costo, fecha, categoriaparaAct, null);
			 JOptionPane.showMessageDialog(this, "Se ingreso correctamente la Actividad", "ingreso con exito", JOptionPane.INFORMATION_MESSAGE);
			 limpiarFormulario(jDia, JMes, jAnio, jHoras,  jMinutos, jCosto, listaCategorias);
		} catch (ActividadRepetidaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "error al ingresar", JOptionPane.ERROR_MESSAGE);
			tfNombre.setText("");
		}
		 
	}
	
	public void agregarDatos() {
		
		cbDepartamentos.removeAllItems();
		Map<String, DTDepartamento> dtdeptos = controladorA.obtenerDTDepartamentos();
		dtdeptos.forEach((key, value)-> {
			cbDepartamentos.addItem(value.getNombreDepto());			
		});
		
		cbProvedores.removeAllItems();
		Map<String, DTProveedor> dtProveedores = controladorU.obtenerDTProveedores();
		dtProveedores.forEach((key, value)-> {
			cbProvedores.addItem(key);			
		});
		
		listaCategorias.removeAll();
		Map<String,DTCategoria> mapcategorias = controladorA.obtenerDTCategorias();
		String [] categorias = new String[mapcategorias.size()];
		indice = 0;
		mapcategorias.forEach((key,value)->{
			categorias[indice] = key;
			indice++;
		});
		listaCategorias.setListData(categorias);

		//listaCategorias = new JList<String>(categorias);
		//listaCategorias.setBounds(138, 252, 152, 129);
		//contentPane.add(listaCategorias);
	}
}
