package src.presentacion;

import static org.junit.Assert.fail;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.excepciones.ActividadRepetidaException;
import src.excepciones.DepartamentoRepetidoException;
import src.excepciones.ExcepcionAltaCategoria;
import src.excepciones.PaqueteRepetidoException;
import src.excepciones.UsuarioRepetidoException;
import src.excepciones.ExcepcionAltaSalida;
import src.logica.clases.Fabrica;
import src.logica.clases.IUsuario;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	

	private JPanel contentPane;
	//private CrearPaquete crearPaqueteInternalFrame;
	private ConsultaActividad consultaActividadInternalFrame;
	private ConsultaSalidaTuristica consultaSalidaInternalFrame;
	private InscripcionASalidaTuristica inscripcionASalidaTuristicaInternalFrame;
	private AltaDeActividadTuristica altaDeActividadTuristicaInternalFrame;
	private AltaSalidaTuristica altaSalidaInternalFrame;
	private ConsultaUsuario consultaUsuarioInternalFrame;
	private AltaUsuario altaUsuarioInternalFrame;
	private AltaDepartamento altaDepartamentoInternalFrame;
	//los realiza el administrador
	private AltaCategoria altaCategoriaIntenalFrame;
	private CrearPaquete crearPaqueteInternalFrame;
	private AceptarRechazarActividad aceptarRechazarInternalFrame;
    
	private IUsuario iControladorUsuario;
    @SuppressWarnings("unused")
	
    private Prueba prueba;
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Publicador publicador = new Publicador();
		publicador.publicar();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					Principal frame = new Principal();
					frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		Fabrica fabrica = new Fabrica();
		iControladorUsuario = fabrica.getIUsuario();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuSistema = new JMenu("Sistema");
		menuBar.add(menuSistema);

		JMenuItem menuItemDatosPrueba = new JMenuItem("Datos de Prueba");
		menuItemDatosPrueba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	try {
            		prueba = new Prueba();
            		JOptionPane.showMessageDialog(null, "Carga de datos con exito", "Datos de Prueba", JOptionPane.INFORMATION_MESSAGE);
            	}
            	catch(ActividadRepetidaException a) {
            		fail(a.getMessage());
        			a.printStackTrace();
            	}
            	catch(DepartamentoRepetidoException b) {
            		fail(b.getMessage());
        			b.printStackTrace();
            	}
            	catch(PaqueteRepetidoException c) {
            		fail(c.getMessage());
        			c.printStackTrace();
            	}
            	catch(ExcepcionAltaSalida d) {
            		fail(d.getMessage());
        			d.printStackTrace();
            	}
            	catch(UsuarioRepetidoException f) {
            		fail(f.getMessage());
        			f.printStackTrace();
            	} catch (ExcepcionAltaCategoria e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            }
        });
		menuSistema.add(menuItemDatosPrueba);

		JMenuItem menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// salgo de la aplicacion
				setVisible(false);
				dispose();
			}
		});
		;
		menuSistema.add(menuItemSalir);
		
		JMenu menuCategoria = new JMenu("Categoría");
		menuBar.add(menuCategoria);
		
		JMenuItem menuItemAltaCategoria = new JMenuItem("Alta de Categoría");
		menuItemAltaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				altaCategoriaIntenalFrame.setVisible(true);
			}
		});
		menuCategoria.add(menuItemAltaCategoria);

		JMenu menuUsuario = new JMenu("Usuario");
		menuBar.add(menuUsuario);

		JMenuItem menuItemAltaUsuario = new JMenuItem("Alta de Usuario");
		menuItemAltaUsuario.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent event) {
        		altaUsuarioInternalFrame.setVisible(true);
    		}
		});
		menuUsuario.add(menuItemAltaUsuario);

		JMenuItem menuItemConsultaUsuario = new JMenuItem("Consulta de Usuario");
		menuItemConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				consultaUsuarioInternalFrame.recargarDatos();
				consultaUsuarioInternalFrame.setVisible(true);
            }
        });
		menuUsuario.add(menuItemConsultaUsuario);

		JMenuItem menuItemModificarUsuario = new JMenuItem("Modificar Datos de Usuario");
		menuUsuario.add(menuItemModificarUsuario);

		JMenu menuActividad = new JMenu("Actividad Turistica");
		menuBar.add(menuActividad);

		JMenuItem menuItemAltaActividad = new JMenuItem("Alta de Actividad Turística");
		menuItemAltaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				altaDeActividadTuristicaInternalFrame.agregarDatos();
				altaDeActividadTuristicaInternalFrame.setVisible(true);
			}
		});
		menuActividad.add(menuItemAltaActividad);

		JMenuItem menuItemConsultaActividad = new JMenuItem("Consulta de Actividad Turística");
		menuItemConsultaActividad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//muestro el InternalFrame para consulta de actividad
				consultaActividadInternalFrame.regargarDatosConsultaActividad();
				consultaActividadInternalFrame.setVisible(true);
			}
		});
		menuActividad.add(menuItemConsultaActividad);
		
		JMenuItem menuItemAceptarRechazar = new JMenuItem("Aceptar / Rechazar Actividad Turística");
		menuItemAceptarRechazar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aceptarRechazarInternalFrame.agregarDatos();
				aceptarRechazarInternalFrame.setVisible(true);
			}
		});
		menuActividad.add(menuItemAceptarRechazar);
		
		JMenu menuSalida = new JMenu("Salida Turística");
		menuBar.add(menuSalida);

		JMenuItem menuItemAltaSalida = new JMenuItem("Alta de Salida Turística");
		menuItemAltaSalida.addActionListener(new ActionListener() {
            		public void actionPerformed(ActionEvent event) {
                		//muestro el InternalFrame para registrar un usuario
            			altaSalidaInternalFrame.rellenarDatos();
            			altaSalidaInternalFrame.setVisible(true);
            		}
        	});
		menuSalida.add(menuItemAltaSalida);

		JMenuItem menuItemConsultaSalida = new JMenuItem("Consulta de Salida Turística");
		menuItemConsultaSalida.addActionListener(new ActionListener() {
           		 public void actionPerformed(ActionEvent event) {
                	//muestro el InternalFrame para ver información de un usuario
           			consultaSalidaInternalFrame.recargarDatos();
                	consultaSalidaInternalFrame.setVisible(true);
            	}
        	});
		menuSalida.add(menuItemConsultaSalida);

		JMenuItem menuItemInscripcion = new JMenuItem("Inscripción a Salida Turística");
		menuItemInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				inscripcionASalidaTuristicaInternalFrame.recargarDatos();
				inscripcionASalidaTuristicaInternalFrame.setVisible(true);
			}
		});
		menuSalida.add(menuItemInscripcion);

		JMenu menuPaquete = new JMenu("Paquete de Actividades Turísticas");
		menuBar.add(menuPaquete);

		JMenuItem menuItemCrearPaquete = new JMenuItem("Crear Paquete de Actividades Turísticas");
		menuItemCrearPaquete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// muestro el InternalFrame para crear un paquete
				crearPaqueteInternalFrame.setVisible(true);
			}
		});
		menuPaquete.add(menuItemCrearPaquete);

		JMenuItem menuItemAgregarActividad = new JMenuItem("Agregar Actividad Turística a Paquete");
		menuPaquete.add(menuItemAgregarActividad);

		JMenuItem menuItemConsultaPaquete = new JMenuItem("Consulta de Paquete de Actividades Turísticas");
		menuPaquete.add(menuItemConsultaPaquete);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		crearPaqueteInternalFrame = new CrearPaquete();
		crearPaqueteInternalFrame.setVisible(false);
		contentPane.add(crearPaqueteInternalFrame);

		altaDeActividadTuristicaInternalFrame = new AltaDeActividadTuristica();
		altaDeActividadTuristicaInternalFrame.setVisible(false);
		contentPane.add(altaDeActividadTuristicaInternalFrame);

		inscripcionASalidaTuristicaInternalFrame = new InscripcionASalidaTuristica();
		inscripcionASalidaTuristicaInternalFrame.setVisible(false);
		contentPane.add(inscripcionASalidaTuristicaInternalFrame);
		
		
		altaSalidaInternalFrame = new AltaSalidaTuristica();
		altaSalidaInternalFrame.setVisible(false);
		contentPane.add(altaSalidaInternalFrame);
		
		consultaSalidaInternalFrame = new ConsultaSalidaTuristica();
		consultaSalidaInternalFrame.setVisible(false);
		contentPane.add(consultaSalidaInternalFrame);
		
		consultaActividadInternalFrame = new ConsultaActividad(consultaSalidaInternalFrame);
		consultaActividadInternalFrame.setVisible(false);
		contentPane.add(consultaActividadInternalFrame);
		
		consultaUsuarioInternalFrame = new ConsultaUsuario(consultaSalidaInternalFrame, consultaActividadInternalFrame);
		consultaUsuarioInternalFrame.setVisible(false);
		contentPane.add(consultaUsuarioInternalFrame);
		
		altaDepartamentoInternalFrame = new AltaDepartamento();
		altaDepartamentoInternalFrame.setVisible(false);
		contentPane.add(altaDepartamentoInternalFrame);
		
		altaUsuarioInternalFrame = new AltaUsuario(iControladorUsuario);
		altaUsuarioInternalFrame.setVisible(false);
		contentPane.add(altaUsuarioInternalFrame);
		
		altaCategoriaIntenalFrame = new AltaCategoria();
		altaCategoriaIntenalFrame.setVisible(false);
		contentPane.add(altaCategoriaIntenalFrame);
		
		aceptarRechazarInternalFrame = new AceptarRechazarActividad();
		aceptarRechazarInternalFrame.setVisible(false);
		contentPane.add(aceptarRechazarInternalFrame);
	}
}
