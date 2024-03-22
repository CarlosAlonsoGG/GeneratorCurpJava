package segundasemana;
import java.util.Random;
import java.util.random.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;
public class CurpNuevo extends JFrame{
	Random rnd = new Random();
	JPanel panel = new JPanel();
	JLabel etiquetaApellidoPaterno, etiquetaApellidoMaterno, etiquetaNombre, anio,mes, dia, sexo, estado, m, f =  new JLabel();
	JButton boton = new JButton();
	JRadioButton hombre, mujer = new JRadioButton();
	JTextField mostrar, cajaNombre ,cajaApellidoPaterno, cajaApellidoMaterno = new JTextField();
	JComboBox comboAnio, comboMes,comboDias,comboEstados = new JComboBox();
	String letrasRadio = "";
	String [] estados = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", 
							"Chihuahua", "Durango", "Distrito Federal", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Mexico"," Michoacan", 
							"Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro", "Quintana Roo","San Luis Potosi", "Sinaloa", 
							"Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas", "Extranjero"
						};
	
	String [] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	public CurpNuevo() {
		this.setTitle("CURP");
		this.setSize(700,430);
		this.setResizable(false);
		componentes();
	}
	private void componentes() {
		paneles();
		etiquetas();
		botones();
		cajasDeTexto();
		comboboxes();
		radioboton();
		 
	}
	private void paneles() {
		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
	private void etiquetas() {

		etiquetaApellidoPaterno = new JLabel();
		etiquetaApellidoPaterno.setText("Apellido Paterno:");
		etiquetaApellidoPaterno.setBounds(30,0,100,50);
		panel.add(etiquetaApellidoPaterno);
		
		etiquetaApellidoMaterno = new JLabel();
		etiquetaApellidoMaterno.setText("Apellido Materno:");
		etiquetaApellidoMaterno.setBounds(30,60,100,50);
		panel.add(etiquetaApellidoMaterno);
		
		etiquetaNombre = new JLabel();
		etiquetaNombre.setText("Nombre:");
		etiquetaNombre.setBounds(30,120,50,50);
		panel.add(etiquetaNombre);	
		
		anio = new JLabel();
		anio.setText("Anio");
		anio.setBounds(460, 0, 50, 50);
		panel.add(anio);
		
		mes = new JLabel();
		mes.setText("Mes:");
		mes.setBounds(460, 60, 40, 40);
		panel.add(mes);
		
		dia = new JLabel();
		dia.setText("Dia:");
		dia.setBounds(460, 120, 40, 40);
		panel.add(dia);
		
		estado = new JLabel();
		estado.setText("Estado:");
		estado.setBounds(460, 180, 60, 40);
		panel.add(estado);
		
		sexo = new JLabel();
		sexo.setText("Sexo:");
		sexo.setBounds(460, 260, 60, 40);
		panel.add(sexo);
		
		
	}
	private void comboboxes(){
		comboAnio = new JComboBox();
		comboAnio.setBounds(460, 40, 70, 20);
		for(int i = 2023; i >= 1900; i--){
			comboAnio.addItem(String.valueOf(i));
		}
		panel.add(comboAnio);
		comboMes = new JComboBox();
		comboMes.setBounds(460, 100, 90, 20);
		for(int i =1; i <=12; i++) {
			
			if(i<=9){
				comboMes.addItem(String.valueOf("0"+i));
			}else{
				comboMes.addItem(String.valueOf(i));
			}
		}
		
		panel.add(comboMes);
		
		comboDias = new JComboBox();
		comboDias.setBounds(460, 160, 70, 20);
		panel.add(comboDias);
		for(int i = 1; i <=31; i++) {
			if(i<=9){
				comboDias.addItem(String.valueOf("0"+i));
			}else {
				comboDias.addItem(String.valueOf(i));
			}
		}
		panel.add(comboDias);
		
		comboEstados = new JComboBox(estados);
		comboEstados.setBounds(460, 220, 120, 20);
		panel.add(comboEstados);
		
	}
	private void cajasDeTexto() {
		//caja apellidoPaterno
		cajaApellidoPaterno = new JTextField();
		cajaApellidoPaterno.setBounds(30, 40, 150, 20);
		panel.add(cajaApellidoPaterno);
		
		//caja apellidoMaterno
		cajaApellidoMaterno = new JTextField();
		cajaApellidoMaterno.setBounds(30, 100, 150, 20);
		panel.add(cajaApellidoMaterno);
		
		//caja nombre
		cajaNombre = new JTextField();
		cajaNombre.setBounds(30, 160, 150, 20);
		panel.add(cajaNombre);
		
	}
	private void radioboton() {
		 hombre = new JRadioButton();
		 hombre.setText("M");
		 hombre.setBounds(460, 300, 80, 20);
		 panel.add(hombre);
		 
		 mujer = new JRadioButton();
		 mujer.setText("F");
		 mujer.setBounds(540, 300, 80, 20);
		 panel.add(mujer);
		 
		 ActionListener evtRadioBoton = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hombre.isSelected()){
					letrasRadio+="h";
				}else if(mujer.isSelected()) {
					letrasRadio += "m";
				}
				
			}
		};
		boton.addActionListener(evtRadioBoton);
	}
	private void botones() {
		boton = new JButton();
		boton.setBounds(30,250,180,20);
		boton.setText("generar curp");
		panel.add(boton);
		
		mostrar=new JTextField();
		mostrar.setBounds(30, 220, 200, 20);
		panel.add(mostrar);
		
		ActionListener evento = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//tomando las primeras letras de el apellido de la persona
				int anio = Integer.parseInt(String.valueOf(comboAnio.getSelectedItem()));
				
				if(anio <= 1999){
						String ap= cajaApellidoPaterno.getText(); 
						String primerosDosCharacteres=String.valueOf(ap.charAt(0));
						primerosDosCharacteres+=String.valueOf(ap.charAt(1));

						//tomando la primera letra del segundo apellido
						String am = cajaApellidoMaterno.getText();
						String primerCha = String.valueOf(am.charAt(0));

						//Sacando el primer caracter de la primer letra del primer nombre de la persona
						String nombre = cajaNombre.getText();
						String primerLetraDelNombre = String.valueOf(nombre.charAt(0));

						//Sacando los dos ultimos valores de el anio que digito el usuario
						String anioString = String.valueOf(comboAnio.getSelectedItem());
						String ultimosDosNumeros = String.valueOf(anioString.charAt(2));
						ultimosDosNumeros += String.valueOf(anioString.charAt(3));

						String mesString = String.valueOf(comboMes.getSelectedItem());
						String dosDigitosMes = String.valueOf(mesString.charAt(0));
						dosDigitosMes += String.valueOf(mesString.charAt(1));
						
						String diaString = String.valueOf(comboDias.getSelectedItem());
						String dosDigitosDias = String.valueOf(diaString.charAt(0));
						dosDigitosDias += String.valueOf(diaString.charAt(1));
						
						String estados = String.valueOf(comboEstados.getSelectedItem());
						String siglasEstados = "";
						if(estados == "Aguascalientes") {
							siglasEstados+= "as";
						}else if(estados == "Baja California") {
							siglasEstados += "bc";
						}else if(estados == "Baja California Sur") {
							siglasEstados += "bs";
						}else if(estados == "Campeche"){
							siglasEstados += "cc";
						}else if(estados == "Coahuila"){
							siglasEstados += "cl";
						}else if(estados == "Chiapas"){
							siglasEstados += "cs";
						}else if(estados == "Chihuahua"){
							siglasEstados += "ch";
						}else if(estados == "Distrito Federal"){
							siglasEstados += "df";
						}else if(estados == "Durango"){
							siglasEstados += "dg";
						}else if(estados == "Guanajuato"){
							siglasEstados+="gt";
						}else if(estados == "Guerrero"){
							siglasEstados += "gr";
						}else if(estados == "Hidalgo"){
							siglasEstados += "hg";
						}else if(estados == "Jalisco"){
							siglasEstados += "jc";
						}else if(estados == "Mexico"){
							siglasEstados += "mc";
						}else if(estados == "Michoacan"){
							siglasEstados += "mc";
						}else if(estados == "Morelos") {
							siglasEstados += "ms";
						}else if(estados == "Nayarit"){
							siglasEstados += "nt";
						}else if(estados == "Nuevo leon"){
							siglasEstados += "nl";
						}else if(estados == "Oaxaca"){
							siglasEstados += "oc";
						}else if(estados == "Puebla"){
							siglasEstados += "pl";
						}else if(estados == "Queretaro"){
							siglasEstados += "qt";
						}else if(estados == "Quintaan Roo"){
							siglasEstados += "qr";
						}else if(estados == "San Luis Potosi"){
							siglasEstados += "sp";
						}else if(estados == "Sinaloa"){
							siglasEstados += "sl";
						}else if(estados == "Sonora"){
							siglasEstados += "sr";
						}else if(estados == "Tabasco"){
							siglasEstados += "tc";
						}else if(estados == "Tamaulipas"){
							siglasEstados += "ts";
						}else if(estados == "Tlaxcala"){
							siglasEstados += "tl";
						}else if(estados == "Veracruz"){
							siglasEstados += "vz";
						}else if(estados == "Yucatan"){
							siglasEstados += "yn";
						}else if(estados == "Zacatecas"){
							siglasEstados += "zs";
						}else if(estados == "Extranjero"){
							siglasEstados+="ne";	
						}
						
						//primera consonante del primer apellido
						String consonantePrimerApellido = "";
						for(int i = 1;i<ap.length();i++) {
							if(ap.charAt(i) != 'a' && ap.charAt(i) != 'e' && ap.charAt(i) != 'i'  && ap.charAt(i) != 'o' && ap.charAt(i) != 'u'){
								consonantePrimerApellido += String.valueOf(ap.charAt(i));
								break;
							}
						
						}
						String consonanteSegundoApellido = "";
						for(int j = 1; j < am.length(); j++){
							if(am.charAt(j) != 'a' && am.charAt(j) != 'e' && am.charAt(j) != 'i' && am.charAt(j) != 'o' && am.charAt(j) != 'u') {
								consonanteSegundoApellido += String.valueOf(am.charAt(j));
								break;
							}
							
						}
						String consonantePrimerNombre = "";
						for(int k = 1; k < nombre.length(); k++) {
							if(nombre.charAt(k) != 'a' && nombre.charAt(k) != 'e' && nombre.charAt(k) != 'i' && nombre.charAt(k) != 'o' && nombre.charAt(k) != 'u'){
								consonantePrimerNombre += String.valueOf(nombre.charAt(k));
								break;
							}
						
						}
						rnd = new Random();
						String numeros = String.valueOf(rnd.nextInt(100));
						
						mostrar.setText(primerosDosCharacteres.toUpperCase()+primerCha.toUpperCase()+primerLetraDelNombre.toUpperCase()+ 
										ultimosDosNumeros.toUpperCase()+ dosDigitosMes.toUpperCase()+ 
										dosDigitosDias.toUpperCase() + letrasRadio.toUpperCase()+ siglasEstados.toUpperCase()+ 
										consonantePrimerApellido.toUpperCase()+ consonanteSegundoApellido.toUpperCase()+ consonantePrimerNombre.toUpperCase()+
										numeros
										);
					

				}else {
					String ap= cajaApellidoPaterno.getText(); 
					String primerosDosCharacteres=String.valueOf(ap.charAt(0));
					primerosDosCharacteres+=String.valueOf(ap.charAt(1));

					//tomando la primera letra del segundo apellido
					String am = cajaApellidoMaterno.getText();
					String primerCha = String.valueOf(am.charAt(0));

					//Sacando el primer caracter de la primer letra del primer nombre de la persona
					String nombre = cajaNombre.getText();
					String primerLetraDelNombre = String.valueOf(nombre.charAt(0));

					//Sacando los dos ultimos valores de el anio que digito el usuario
					String anioString = String.valueOf(comboAnio.getSelectedItem());
					String ultimosDosNumeros = String.valueOf(anioString.charAt(2));
					ultimosDosNumeros += String.valueOf(anioString.charAt(3));

					String mesString = String.valueOf(comboMes.getSelectedItem());
					String dosDigitosMes = String.valueOf(mesString.charAt(0));
					dosDigitosMes += String.valueOf(mesString.charAt(1));
					
					String diaString = String.valueOf(comboDias.getSelectedItem());
					String dosDigitosDias = String.valueOf(diaString.charAt(0));
					dosDigitosDias += String.valueOf(diaString.charAt(1));
					
					String estados = String.valueOf(comboEstados.getSelectedItem());
					String siglasEstados = "";
					if(estados == "Aguascalientes") {
						siglasEstados+= "as";
					}else if(estados == "Baja California") {
						siglasEstados += "bc";
					}else if(estados == "Baja California Sur") {
						siglasEstados += "bs";
					}else if(estados == "Campeche"){
						siglasEstados += "cc";
					}else if(estados == "Coahuila"){
						siglasEstados += "cl";
					}else if(estados == "Chiapas"){
						siglasEstados += "cs";
					}else if(estados == "Chihuahua"){
						siglasEstados += "ch";
					}else if(estados == "Distrito Federal"){
						siglasEstados += "df";
					}else if(estados == "Durango"){
						siglasEstados += "dg";
					}else if(estados == "Guanajuato"){
						siglasEstados+="gt";
					}else if(estados == "Guerrero"){
						siglasEstados += "gr";
					}else if(estados == "Hidalgo"){
						siglasEstados += "hg";
					}else if(estados == "Jalisco"){
						siglasEstados += "jc";
					}else if(estados == "Mexico"){
						siglasEstados += "mc";
					}else if(estados == "Michoacan"){
						siglasEstados += "mc";
					}else if(estados == "Morelos") {
						siglasEstados += "ms";
					}else if(estados == "Nayarit"){
						siglasEstados += "nt";
					}else if(estados == "Nuevo leon"){
						siglasEstados += "nl";
					}else if(estados == "Oaxaca"){
						siglasEstados += "oc";
					}else if(estados == "Puebla"){
						siglasEstados += "pl";
					}else if(estados == "Queretaro"){
						siglasEstados += "qt";
					}else if(estados == "Quintaan Roo"){
						siglasEstados += "qr";
					}else if(estados == "San Luis Potosi"){
						siglasEstados += "sp";
					}else if(estados == "Sinaloa"){
						siglasEstados += "sl";
					}else if(estados == "Sonora"){
						siglasEstados += "sr";
					}else if(estados == "Tabasco"){
						siglasEstados += "tc";
					}else if(estados == "Tamaulipas"){
						siglasEstados += "ts";
					}else if(estados == "Tlaxcala"){
						siglasEstados += "tl";
					}else if(estados == "Veracruz"){
						siglasEstados += "vz";
					}else if(estados == "Yucatan"){
						siglasEstados += "yn";
					}else if(estados == "Zacatecas"){
						siglasEstados += "zs";
					}else {
						siglasEstados+="ne";	
					}
					
					//primera consonante del primer apellido
					String consonantePrimerApellido = "";
					for(int i = 1;i<ap.length();i++) {
						if(ap.charAt(i) != 'a' && ap.charAt(i) != 'e' && ap.charAt(i) != 'i'  && ap.charAt(i) != 'o' && ap.charAt(i) != 'u'){
							consonantePrimerApellido += String.valueOf(ap.charAt(i));
							break;
						}
					
					}
					String consonanteSegundoApellido = "";
					for(int j = 1; j < am.length(); j++){
						if(am.charAt(j) != 'a' && am.charAt(j) != 'e' && am.charAt(j) != 'i' && am.charAt(j) != 'o' && am.charAt(j) != 'u') {
							consonanteSegundoApellido += String.valueOf(am.charAt(j));
							break;
						}
						
					}
					String consonantePrimerNombre = "";
					for(int k = 1; k < nombre.length(); k++) {
						if(nombre.charAt(k) != 'a' && nombre.charAt(k) != 'e' && nombre.charAt(k) != 'i' && nombre.charAt(k) != 'o' && nombre.charAt(k) != 'u'){
							consonantePrimerNombre += String.valueOf(nombre.charAt(k));
							break;
						}
					
					}
					
					int pos1 = rnd.nextInt(letras.length);
					int pos2 = rnd.nextInt(letras.length);
					
					
					
					mostrar.setText(primerosDosCharacteres.toUpperCase()+primerCha.toUpperCase()+primerLetraDelNombre.toUpperCase()+ 
									ultimosDosNumeros.toUpperCase()+ dosDigitosMes.toUpperCase()+ 
									dosDigitosDias.toUpperCase() + letrasRadio.toUpperCase()+ siglasEstados.toUpperCase()+ 
									consonantePrimerApellido.toUpperCase()+ consonanteSegundoApellido.toUpperCase()+ consonantePrimerNombre.toUpperCase()+
									letras[pos1].toUpperCase() + letras[pos2].toUpperCase()
									);
				}
				 
			}
		};
		
		boton.addActionListener(evento);
	}
	
	public static void main(String[] args) {
		 CurpNuevo obj = new  CurpNuevo();
		 obj.setVisible(true);
	}
	
}
