/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame {

    public JLabel lblnombre, lblcodigo, lbltipo, lblcantidad, lblprecio, lbldisponibilidad;
    public JTextField nombre, codigo, precio, cantidad;
    public JComboBox tipo;
    public JRadioButton si, no;
    public JButton buscar, eliminar, insertar, limpiar, actualizar;
    public JTable resultados;
    public JPanel table;
     ButtonGroup disponibilidad = new ButtonGroup();
    private static final int ANCHOC = 130, ALTOC = 30;

    DefaultTableModel tm;

    public Consulta() {

        super("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblnombre);
        container.add(lblcodigo);
        container.add(lbltipo);
        container.add(lblcantidad);
        container.add(lblprecio);
        container.add(lbldisponibilidad);
        container.add(nombre);
        container.add(codigo);
        container.add(precio);
        container.add(cantidad);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(600, 600);
        eventos();
    }

    private void agregarLabels() {
        lblnombre = new JLabel("Nombre");
        lblcodigo = new JLabel("Codigo");
        lbltipo = new JLabel("Tipo");
        lblcantidad = new JLabel("Cantidad");
        lblprecio = new JLabel("Precio");
        lbldisponibilidad = new JLabel("Disponibiliad");
        lblnombre.setBounds(10, 10, ANCHOC, ALTOC);
        lblcodigo.setBounds(10, 60, ANCHOC, ALTOC);
        lbltipo.setBounds(10, 100, ANCHOC, ALTOC);
        lblcantidad.setBounds(10, 140, ANCHOC, ALTOC);
        lblprecio.setBounds(10, 180, ANCHOC, ALTOC);
        lbldisponibilidad.setBounds(10, 200, ANCHOC, ALTOC);

    }

    private void formulario() {
        nombre = new JTextField();
        codigo = new JTextField();
        precio = new JTextField();
        cantidad = new JTextField();
        tipo = new JComboBox();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");

        table = new JPanel();
        
        
        
        tipo.addItem("Fruta");
        tipo.addItem("Verdura");
        tipo.addItem("Bebida");
        tipo.addItem("Dulce");
        
        disponibilidad = new ButtonGroup();
        disponibilidad.add(si);
        disponibilidad.add(no);
        
        codigo.setBounds(140, 10,ANCHOC,ALTOC);
        nombre.setBounds(140,60,ANCHOC,ALTOC);
        precio.setBounds(140,100,ANCHOC,ALTOC);
        cantidad.setBounds(140,140,ANCHOC,ALTOC); 
        si.setBounds(140,140,50,ALTOC);
        no.setBounds(210,140,50,ALTOC);
        
        buscar.setBounds(300,10,ANCHOC,ALTOC);
        insertar.setBounds(10,210,ANCHOC,ALTOC);
        actualizar.setBounds(150,210,ANCHOC,ALTOC);
        eliminar.setBounds(300,210,ANCHOC,ALTOC);
        limpiar.setBounds(450,210,ANCHOC,ALTOC);
        resultados = new JTable();
        table.setBounds(10,250,500,200);
        table.add(new JScrollPane(resultados));
    }

    private void llenarTabla() {
           tm = new DefaultTableModel(){
          public Class<?> getColumnClass(int column){
              switch(column)
              {
                  case 0:
                      return String.class;
                  case 1:
                      return String.class;
                  case 2:
                      return String.class;
                  default:
                      return Boolean.class;
              }
          }  
        };
           
        tm.addColumn("Nombre");
        tm.addColumn("Precio");
        tm.addColumn("Cantidad");
        tm.addColumn("Tipo");
        tm.addColumn("Disponibilidad");
        tm.addColumn("Tipo");
    }

    private void eventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
