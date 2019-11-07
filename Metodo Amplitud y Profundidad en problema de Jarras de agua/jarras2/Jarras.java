package jarras2;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
public class Jarras extends JFrame {
	
	int j4, j3;
	List<Jarras> hijos;
	int nodosAnalizados, largoBusqueda;
	
	private JLabel label1, label2, label3, label4,labelobj,labelobj2;
	private JButton b1, b2,b3;
	private JScrollPane scrollpane1;
	private static JTable tabla1;
    public static String headers[] = { "Jarra 4 Litros", "Jarra 3 Litros" };
    public static DefaultTableModel dtm = new DefaultTableModel(headers, 13);
    
    

	public Jarras(int j4, int j3){		
		super("Problema de las jarras de agua...");
		setLayout(null);
		label1=new JLabel("Problema de las jarras de agua.");
        label1.setBounds(10,10,300,20);
        add(label1);
        labelobj=new JLabel("Disponemos de 2 jarras de agua, una de 4"
        		+ " litros  y otra de 3 litros.  ");
        labelobj2=new JLabel("El objetivo es que la jarra de 4 litros "
        		+ "contenga 2 litros de agua.");
        labelobj.setBounds(10,30,3000,20);
        labelobj2.setBounds(10,50,3000,20);
        add(labelobj);
        add(labelobj2);
        label2=new JLabel("Tipo de búsqueda:");
        label2.setBounds(10,95,300,20);
        add(label2);
        label3=new JLabel("Nodos:");
        label3.setBounds(10,390,300,20);
        add(label3);
        JTextField textField = new JTextField(20);
        textField.setBounds(60,390,100,20);
        add(textField);
        JTextField textField2 = new JTextField(20);
        textField2.setBounds(60,410,100,20);
        add(textField2);
        label4=new JLabel("Largo:");
        label4.setBounds(10,410,300,20);
        add(label4);
        b1=new JButton("Amplitud");
        b1.setBounds(10,120,180,30);
        
        add(b1);
        
        
        b2=new JButton("Profundidad");
        b2.setBounds(195,120,180,30);
        add(b2);
        
        b3=new JButton("Borrar");
        b3.setBounds(195,410,180,30);
        add(b3);
        
        tabla1=new JTable(dtm);
        scrollpane1=new JScrollPane(tabla1);
        scrollpane1.setBounds(10,160,365,230);
        add(scrollpane1);
        
		this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.j4 = j4;
		this.j3 = j3;
		hijos = new ArrayList<Jarras>();
		
		b1.addActionListener(new ActionListener(){

		      public void actionPerformed(ActionEvent ae){

		            //aqui pones lo que quieras hacer al presionar el boton  
		    	  for (int i = 0; i < 13; i++) {
						for (int j=0; j<2; j++) {
							dtm.setValueAt("", i, j);
						}
		    	  }
		    	   busquedaAnchura();
		    	   b1.setEnabled(false);
		    	   b2.setEnabled(false);
		           textField.setText(Integer.toString(getNodosAnalizados()));
		           textField2.setText(Integer.toString(getLargoBusqueda()));

		      }});
		b2.addActionListener(new ActionListener(){

		      public void actionPerformed(ActionEvent ae){

		            //aqui pones lo que quieras hacer al presionar el boton
		    	  for (int i = 0; i < 13; i++) {
						for (int j=0; j<2; j++) {
							dtm.setValueAt("", i, j);
						}
		    	  }
		    	   busquedaProfundidad();
		    	   b1.setEnabled(false);
		    	   b2.setEnabled(false);
		           textField.setText(Integer.toString(getNodosAnalizados()));
		           textField2.setText(Integer.toString(getLargoBusqueda()));

		      }});
		
		b3.addActionListener(new ActionListener(){

		      public void actionPerformed(ActionEvent ae){

		            //aqui pones lo que quieras hacer al presionar el boton
		    	  for (int i = 0; i < 13; i++) {
						for (int j=0; j<2; j++) {
							dtm.setValueAt("", i, j);
						}
		    	  }

		           
		    	   AppJarras.main(null);
		    	   textField.setText("");
		    	   textField2.setText("");
		    	 

		      }});
		
		
		
	}
	
	public void addHijos(Jarras hijo)
	   {
	   	hijos.add(hijo);
	   }
	 
	 
	    public void Estados()
	    {
	    	int ij4;
	    	int ij3;
	 
	    	for (int operador = 0; operador < 6;operador++)
	    	{
	 
	 
	 
	                       //llenar jarra de 4L
	                        if (operador == 0 && this.j4<4 ){
	                                ij4 = 4;
	                                ij3 = this.j3;
	                                Jarras nodo = new Jarras(ij4,ij3);
	                                hijos.add(nodo);
	                        } 
	 
	                        //llenar jarra de 3L
	                        if (operador == 1 && this.j3<3 ){
	                        	 	ij4 = this.j4;
	                                ij3 = 3;   
	                                Jarras nodo = new Jarras(ij4,ij3);
	                                hijos.add(nodo);
	                        }
	 
	                        //llenar jarra de 4L
	                        if (operador == 2 && this.j4>0 ){
	                                ij4 = 0;
	                                ij3 = this.j3;
	                                Jarras nodo = new Jarras(ij4,ij3);
	                                hijos.add(nodo);
	                        }
	                        //vaciar jarra de 3L
	                        if (operador == 3 && this.j3>0 ){
	                                ij4 = this.j4;
	                                ij3 = 0;
	                                Jarras nodo = new Jarras(ij4,ij3);
	                                hijos.add(nodo);
	                        }
	                        //vaciar jarra de 3L sobre jarra de 4L
	                        if (operador == 4 && this.j3>0 && this.j4<4 ){
	                                if (this.j3+this.j4 <= 4){
	                                        ij4=this.j3+this.j4;
	                                        ij3=0;
	                                        Jarras nodo = new Jarras(ij4,ij3);
	                               			 hijos.add(nodo);
	                                }
	                                else {
	                                        ij4 = 4;
	                                        ij3 = (this.j3+this.j4)-4;
	                                        Jarras nodo = new Jarras(ij4,ij3);
	                               			 hijos.add(nodo);
	                                }
	 
	                        }
	                        //vaciar jarra de 4L sobre jarra de 3L
	                        if (operador == 5 && this.j4>0 && this.j3<3 ){
	                                if (this.j3+this.j4 <= 3){
	                                        ij3=this.j3+this.j4;
	                                        ij4=0;
	                                        Jarras nodo = new Jarras(ij4,ij3);
	                               			 hijos.add(nodo);
	                                }
	                                else {
	                                        ij3 = 3;
	                                        ij4 = this.j4-(3-this.j3);
	                                        Jarras nodo = new Jarras(ij4,ij3);
	                               			 hijos.add(nodo);
	                                }
	 
	                        }
	    	}
	 
	    }
	 
	 
	    public String getEstado()
	    {
	    	return "("+j4+","+j3+")";
	    }
	 
	 
	     public List<Jarras> getHijos() {
	 
	 
	        return hijos;
	 
	 
	    }
	    
	 
	    public int getNodosAnalizados()
	    {
	    	return nodosAnalizados;
	    }
	 
	    public int getLargoBusqueda()
	    {
	    	return largoBusqueda;
	    }
	 
	 
	 
	 
	 
		public boolean busquedaAnchura() {
	 
	 
		    List<Jarras> recorridos = new ArrayList<Jarras>();
	        Queue<Jarras> colaAuxiliar = new LinkedList<Jarras>();
	        colaAuxiliar.add(this);
			Iterator<Jarras> nombreIterator;
			boolean estado;
			nodosAnalizados = 0;
			largoBusqueda = 0;
	 
	 
	        while(colaAuxiliar.size() != 0) 
	        {
	 
	            Jarras cabeza = colaAuxiliar.poll();
				estado = true;
				nombreIterator = recorridos.iterator();
	 
				while(nombreIterator.hasNext())
				{
					Jarras compar = nombreIterator.next();
	 
					if((cabeza.j4 == compar.j4) && (cabeza.j3 == compar.j3))
					{
						estado = false;
						break;
					}
				}
	 
				if(estado == true)
				{
					dtm.setValueAt(cabeza.j4+" Litros", nodosAnalizados, 0);
					dtm.setValueAt(cabeza.j3+" Litros", nodosAnalizados, 1);
	            	System.out.println(cabeza.getEstado() );  
					recorridos.add(cabeza);
					nodosAnalizados++;
	 
	           		 if(cabeza.j4 == 2 )
	           		 {
	           		     return true;
	          	 	 }
	 
	          		 else
	        	    {
						cabeza.Estados();
	             	   for(Jarras hijo : cabeza.getHijos())
	             	   {
	             	   	largoBusqueda++;
	               	     colaAuxiliar.add(hijo);
	             	   }                   
	          	    }	
			   }			
	        }
	 
	        return false;
	 
	 
	    }
	 
	 
	 
	   	public boolean busquedaProfundidad() {
	 
	 
		    List<Jarras> recorridos = new ArrayList<Jarras>();
	        Stack<Jarras> pilaAuxiliar = new Stack<Jarras>();
	        pilaAuxiliar.push(this);
			Iterator<Jarras> nombreIterator;
			boolean estado;
			nodosAnalizados = 0;
			largoBusqueda = 0;
	 
	        while(pilaAuxiliar.size() != 0) 
	        {
	 
	            Jarras cabeza = pilaAuxiliar.pop();
				estado = true;
				nombreIterator = recorridos.iterator();
	 
				while(nombreIterator.hasNext())
				{
					Jarras compar = nombreIterator.next();
	 
					if((cabeza.j4 == compar.j4) && (cabeza.j3 == compar.j3))
					{
						estado = false;
						break;
					}
				}
	 
				if(estado == true)
				{
					dtm.setValueAt(cabeza.j4+" Litros", nodosAnalizados, 0);
					dtm.setValueAt(cabeza.j3+" Litros", nodosAnalizados, 1);
	            	System.out.println(cabeza.getEstado() );  
					recorridos.add(cabeza);
					nodosAnalizados++;
	 
	           		 if(cabeza.j4 == 2 )
	           		 {
	           		     return true;
	          	 	 }
	 
	          		 else
	        	    {
	 
						cabeza.Estados();
	 
						for(int i = 0;i < pilaAuxiliar.size(); i++)
						{
							Jarras p = pilaAuxiliar.get(i);
							for(int j=0; j < cabeza.getHijos().size();j++)
							{
								Jarras p2 = cabeza.getHijos().get(j);
								if((p2.j4 == p.j4) && (p2.j3 == p.j3))
								{
									cabeza.hijos.remove(j);
								}
							}
	 
						}		
	             	   		for(int i = cabeza.getHijos().size() -1; i >= 0;i--)
	             	   		{
	             	   			largoBusqueda++;
	               	     		pilaAuxiliar.push(cabeza.getHijos().get(i));
	             	   		} 
						}                  
	          	    }	
			   }
			    return false;			
	        }
	 
	 
	 
	 
	    }
	 
	 
	 
	 
	 
	


