package src.presentacion;

import javax.swing.JFrame;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import src.excepciones.UsuarioRepetidoException;
import src.logica.clases.IUsuario;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class AltaUsuario extends JInternalFrame {
	private IUsuario controlUser;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldCorreo;
	private JTextField textFieldNick;
	private JTextField textFieldNacionalidad;
	private JTextField textFieldLink;
	private JRadioButton btnTurista;
	private JRadioButton btnProvdor;
	private JTextArea textAreaDescrip;
	private JSpinner dia, mes, anio;
	private ButtonGroup grupoboton;
	private JLabel naclabel;
	private JLabel linklabel;
	private JLabel descripLabel;
	private JPasswordField passwFieldContrasenia;
	private JPasswordField passwFieldconfirmarcontra;
	private JLabel contralabel;
	private JLabel confirmarcontraLbl;
	
	public AltaUsuario(IUsuario icontroluser) {
		
		
		controlUser = icontroluser;
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame,
        // etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar un Usuario");
        setBounds(10, 40, 414, 490);
     
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{30, 92, 42, 42, 43, 50, 69, 0};
        gridBagLayout.rowHeights = new int[]{30, 20, 20, 20, 20, 20, 0, 0, 27, 0, 0, 28, 28, 27, 0, 47, 47, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        
      //campos datos basicos 
        JLabel lblNewLabel = new JLabel("Nombre");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        textFieldNombre = new JTextField();
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.anchor = GridBagConstraints.NORTH;
        gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldNombre.gridwidth = 4;
        gbc_textFieldNombre.gridx = 2;
        gbc_textFieldNombre.gridy = 1;
        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
        textFieldNombre.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Apellido");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 2;
        getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        textFieldApellido = new JTextField();
        GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
        gbc_textFieldApellido.anchor = GridBagConstraints.NORTH;
        gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldApellido.gridwidth = 4;
        gbc_textFieldApellido.gridx = 2;
        gbc_textFieldApellido.gridy = 2;
        getContentPane().add(textFieldApellido, gbc_textFieldApellido);
        textFieldApellido.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Correo");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 3;
        getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textFieldCorreo = new JTextField();
        GridBagConstraints gbc_textFieldCorreo = new GridBagConstraints();
        gbc_textFieldCorreo.anchor = GridBagConstraints.NORTH;
        gbc_textFieldCorreo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldCorreo.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldCorreo.gridwidth = 4;
        gbc_textFieldCorreo.gridx = 2;
        gbc_textFieldCorreo.gridy = 3;
        getContentPane().add(textFieldCorreo, gbc_textFieldCorreo);
        textFieldCorreo.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Nickname");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 4;
        getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        textFieldNick = new JTextField();
        GridBagConstraints gbc_textFieldNick = new GridBagConstraints();
        gbc_textFieldNick.anchor = GridBagConstraints.NORTH;
        gbc_textFieldNick.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNick.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldNick.gridwidth = 4;
        gbc_textFieldNick.gridx = 2;
        gbc_textFieldNick.gridy = 4;
        getContentPane().add(textFieldNick, gbc_textFieldNick);
        textFieldNick.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Fecha Nacimiento");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.gridwidth = 2;
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 5;
        getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        dia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        GridBagConstraints gbc_dia = new GridBagConstraints();
        gbc_dia.fill = GridBagConstraints.HORIZONTAL;
        gbc_dia.anchor = GridBagConstraints.NORTH;
        gbc_dia.insets = new Insets(0, 0, 5, 5);
        gbc_dia.gridx = 2;
        gbc_dia.gridy = 5;
        getContentPane().add(dia, gbc_dia);
        
        mes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        GridBagConstraints gbc_mes = new GridBagConstraints();
        gbc_mes.fill = GridBagConstraints.HORIZONTAL;
        gbc_mes.anchor = GridBagConstraints.NORTH;
        gbc_mes.insets = new Insets(0, 0, 5, 5);
        gbc_mes.gridx = 4;
        gbc_mes.gridy = 5;
        getContentPane().add(mes, gbc_mes);
        
        anio = new JSpinner(new SpinnerNumberModel(0, 0, 2030, 1));
        GridBagConstraints gbc_anio = new GridBagConstraints();
        gbc_anio.fill = GridBagConstraints.HORIZONTAL;
        gbc_anio.insets = new Insets(0, 0, 5, 0);
        gbc_anio.anchor = GridBagConstraints.NORTH;
        gbc_anio.gridx = 6;
        gbc_anio.gridy = 5;
        getContentPane().add(anio, gbc_anio);
        
        contralabel = new JLabel("Contraseña");
        GridBagConstraints gbc_contralabel = new GridBagConstraints();
        gbc_contralabel.insets = new Insets(0, 0, 5, 5);
        gbc_contralabel.anchor = GridBagConstraints.EAST;
        gbc_contralabel.gridx = 1;
        gbc_contralabel.gridy = 6;
        getContentPane().add(contralabel, gbc_contralabel);
        
        passwFieldContrasenia = new JPasswordField();
        GridBagConstraints gbc_ContraseniaTextfield = new GridBagConstraints();
        gbc_ContraseniaTextfield.gridwidth = 4;
        gbc_ContraseniaTextfield.insets = new Insets(0, 0, 5, 5);
        gbc_ContraseniaTextfield.fill = GridBagConstraints.HORIZONTAL;
        gbc_ContraseniaTextfield.gridx = 2;
        gbc_ContraseniaTextfield.gridy = 6;
        getContentPane().add(passwFieldContrasenia, gbc_ContraseniaTextfield);
        passwFieldContrasenia.setColumns(10);
        
        confirmarcontraLbl = new JLabel("Confirmar contraseña");
        GridBagConstraints gbc_confirmarcontraLbl = new GridBagConstraints();
        gbc_confirmarcontraLbl.insets = new Insets(0, 0, 5, 5);
        gbc_confirmarcontraLbl.anchor = GridBagConstraints.EAST;
        gbc_confirmarcontraLbl.gridx = 1;
        gbc_confirmarcontraLbl.gridy = 7;
        getContentPane().add(confirmarcontraLbl, gbc_confirmarcontraLbl);
        
        passwFieldconfirmarcontra= new JPasswordField();
        GridBagConstraints gbc_confirmarcontratextField = new GridBagConstraints();
        gbc_confirmarcontratextField.gridwidth = 4;
        gbc_confirmarcontratextField.insets = new Insets(0, 0, 5, 5);
        gbc_confirmarcontratextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_confirmarcontratextField.gridx = 2;
        gbc_confirmarcontratextField.gridy = 7;
        getContentPane().add(passwFieldconfirmarcontra, gbc_confirmarcontratextField);
        passwFieldconfirmarcontra.setColumns(10);
        
        
        
  //campo para turista
        
        naclabel = new JLabel("Nacionalidad");
        GridBagConstraints gbc_naclabel = new GridBagConstraints();
        gbc_naclabel.gridwidth = 2;
        gbc_naclabel.insets = new Insets(0, 0, 5, 5);
        gbc_naclabel.gridx = 0;
        gbc_naclabel.gridy = 11;
        getContentPane().add(naclabel, gbc_naclabel);
        naclabel.setVisible(false);
        
        textFieldNacionalidad = new JTextField();
        GridBagConstraints gbc_textFieldNacionalidad = new GridBagConstraints();
        gbc_textFieldNacionalidad.gridwidth = 2;
        gbc_textFieldNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldNacionalidad.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNacionalidad.gridx = 2;
        gbc_textFieldNacionalidad.gridy = 11;
        getContentPane().add(textFieldNacionalidad, gbc_textFieldNacionalidad);
        textFieldNacionalidad.setColumns(10);
        textFieldNacionalidad.setVisible(false);
        
        
//campo para proveedor
        
        linklabel = new JLabel("Link");
        GridBagConstraints gbc_linklabel = new GridBagConstraints();
        gbc_linklabel.insets = new Insets(0, 0, 5, 5);
        gbc_linklabel.gridx = 1;
        gbc_linklabel.gridy = 12;
        getContentPane().add(linklabel, gbc_linklabel);
        linklabel.setVisible(false);
        
        textFieldLink = new JTextField();
        GridBagConstraints gbc_textFieldLink = new GridBagConstraints();
        gbc_textFieldLink.gridwidth = 2;
        gbc_textFieldLink.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldLink.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldLink.gridx = 2;
        gbc_textFieldLink.gridy = 12;
        getContentPane().add(textFieldLink, gbc_textFieldLink);
        textFieldLink.setColumns(10);
        textFieldLink.setVisible(false);
        
        descripLabel = new JLabel("Descripcion");
        GridBagConstraints gbc_Descriplabel = new GridBagConstraints();
        gbc_Descriplabel.insets = new Insets(0, 0, 5, 5);
        gbc_Descriplabel.gridx = 1;
        gbc_Descriplabel.gridy = 13;
        getContentPane().add(descripLabel, gbc_Descriplabel);
        descripLabel.setVisible(false);
        
        textAreaDescrip = new JTextArea();
        GridBagConstraints gbc_textAreaDescrip = new GridBagConstraints();
        gbc_textAreaDescrip.gridheight = 2;
        gbc_textAreaDescrip.gridwidth = 3;
        gbc_textAreaDescrip.insets = new Insets(0, 0, 5, 5);
        gbc_textAreaDescrip.fill = GridBagConstraints.BOTH;
        gbc_textAreaDescrip.gridx = 2;
        gbc_textAreaDescrip.gridy = 13;
        getContentPane().add(textAreaDescrip, gbc_textAreaDescrip);
        textAreaDescrip.setVisible(false);
        
      //boton turista
        btnTurista = new JRadioButton("Turista");
        btnTurista.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {

        		naclabel.setVisible(true);
        		textFieldNacionalidad.setText("");
        		textFieldNacionalidad.setVisible(true);
        		//ocultar y llenar para el check
        		linklabel.setVisible(false);
        		textFieldLink.setVisible(false);
        		descripLabel.setVisible(false);
        		textAreaDescrip.setVisible(false);
        		textAreaDescrip.setText("a");
        	}
        });
        GridBagConstraints gbc_btnTurista = new GridBagConstraints();
        gbc_btnTurista.gridwidth = 2;
        gbc_btnTurista.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnTurista.insets = new Insets(0, 0, 5, 5);
        gbc_btnTurista.gridx = 1;
        gbc_btnTurista.gridy = 9;
        getContentPane().add(btnTurista, gbc_btnTurista);
        
        //boton proveedor
        btnProvdor = new JRadioButton("Proveedor");
        btnProvdor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) { 
        		
        		naclabel.setVisible(false);
        		textFieldNacionalidad.setVisible(false);
        		textFieldNacionalidad.setText("a");
        		textAreaDescrip.setText("");
        		textFieldLink.setText("");
        		linklabel.setVisible(true);
        		textFieldLink.setVisible(true);
        		descripLabel.setVisible(true);
        		textAreaDescrip.setVisible(true);
        		
        	}
        });
        
        GridBagConstraints gbc_btnProvdor = new GridBagConstraints();
        gbc_btnProvdor.anchor = GridBagConstraints.WEST;
        gbc_btnProvdor.gridwidth = 2;
        gbc_btnProvdor.insets = new Insets(0, 0, 5, 5);
        gbc_btnProvdor.gridx = 1;
        gbc_btnProvdor.gridy = 10;
        getContentPane().add(btnProvdor, gbc_btnProvdor);
        
        //agrupar botones
        grupoboton = new ButtonGroup();
        grupoboton.add(btnProvdor);
        grupoboton.add(btnTurista);
        
        
        JButton btnaceptar = new JButton("Aceptar");
        btnaceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	boolean turista = btnTurista.isSelected();
        	boolean proveedor = btnProvdor.isSelected();
        	cmdRegistroUsuarioActionPerformed(arg0, turista, proveedor);
        	 	
        	}
        });
        GridBagConstraints gbc_btnaceptar = new GridBagConstraints();
        gbc_btnaceptar.anchor = GridBagConstraints.EAST;
        gbc_btnaceptar.gridwidth = 2;
        gbc_btnaceptar.insets = new Insets(0, 0, 5, 5);
        gbc_btnaceptar.gridx = 1;
        gbc_btnaceptar.gridy = 15;
        getContentPane().add(btnaceptar, gbc_btnaceptar);
        
        JButton btncancelar = new JButton("Cancelar");
        btncancelar.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		limpiarFormulario();
        		setVisible(false);
        	}
        });
        GridBagConstraints gbc_btncancelar = new GridBagConstraints();
        gbc_btncancelar.gridwidth = 2;
        gbc_btncancelar.insets = new Insets(0, 0, 5, 5);
        gbc_btncancelar.gridx = 4;
        gbc_btncancelar.gridy = 15;
        getContentPane().add(btncancelar, gbc_btncancelar);
        
       
	}
	
	protected void cmdRegistroUsuarioActionPerformed(ActionEvent arg0, boolean botonturista, boolean botonproveedor) {
		String nombreU = this.textFieldNombre.getText();
  	    String apellidoU = this.textFieldApellido.getText();
  	    String nicknameU = this.textFieldNick.getText();
  	    String correoU   = this.textFieldCorreo.getText();
  	    String NacionU   = this.textFieldNacionalidad.getText();
  	    String descripU  = this.textAreaDescrip.getText();
  	    String linkU = this.textFieldLink.getText();
  	    char[] passwordchar = this.passwFieldContrasenia.getPassword();
  	    String contraU = new String(passwordchar);
  	    int diaU = (int) dia.getValue();
  	    int mesU = (int) mes.getValue();
  	    int anioU = (int) anio.getValue();
  	    LocalDate fechaNac= LocalDate.of(anioU, mesU, diaU);
   		if (checkFormulario()) {
   			
   			try {
   				
           		if (botonproveedor) {
           			controlUser.aceptarAltaProveedor(nombreU, apellidoU, nicknameU, correoU, contraU, fechaNac, null, descripU, linkU);
           			 // Muestro éxito de la operación
                       JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
                               JOptionPane.INFORMATION_MESSAGE);
                       		   setVisible(false);
   				}
           		
           		if (botonturista) {
           			controlUser.aceptarAltaTurista(nicknameU, nombreU, apellidoU, correoU, contraU, fechaNac, null, NacionU);
           			 // Muestro éxito de la operación
                       JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
                               JOptionPane.INFORMATION_MESSAGE);
                               setVisible(false);
   				}
   				
				} catch (UsuarioRepetidoException e) {
					// Muestro error de registro
	                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
				}
   			
   			limpiarFormulario();
   			
   	}
		
	}
	
	private boolean checkFormulario() {
		
		String nombreU = this.textFieldNombre.getText();
        String apellidoU = this.textFieldApellido.getText();
        String nicknameU = this.textFieldNick.getText();
        String correoU   = this.textFieldCorreo.getText();
        String NacionU   = this.textFieldNacionalidad.getText();
        String descripU  = this.textAreaDescrip.getText();
        char[] arrConfirmarContra = this.passwFieldconfirmarcontra.getPassword();
        char[] arrContra = this.passwFieldContrasenia.getPassword();
        String contraU = new String(arrContra);
  	    String confirmarContraU = new String(arrConfirmarContra);
        
        if (nombreU.isEmpty() || apellidoU.isEmpty() || nicknameU.isEmpty() || correoU.isEmpty() ||NacionU.isEmpty() || descripU.isEmpty()||contraU.isEmpty()||confirmarContraU.isEmpty()) {
        	
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //chequeo que la contrasenia y la confirmacion de la contra sean iguales
        //si las contras no coinciden tiro un mensaje
        if(!contraU.equals(confirmarContraU)) {
        	JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
   
        return true;
    }
	
	
	
	private void limpiarFormulario() {
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldNick.setText("");
        textFieldNacionalidad.setText("");
        textFieldCorreo.setText("");
        textFieldLink.setText("");
        textAreaDescrip.setText("");
        passwFieldconfirmarcontra.setText("");
        passwFieldContrasenia.setText("");
        grupoboton.clearSelection();
        textFieldNacionalidad.setVisible(false);
        textFieldLink.setVisible(false);
        textAreaDescrip.setVisible(false);
        naclabel.setVisible(false);
        linklabel.setVisible(false);
    	descripLabel.setVisible(false);
        
        //no anda el reset de spinner
    }

}
