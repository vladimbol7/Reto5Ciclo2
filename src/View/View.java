package View;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Data.*;
import Controller.*;

public class View extends JFrame implements ItemListener{
    
    private static Reportes Controlador;
    //private JFrame frame;
    private JComboBox<String> cbListaInforme;
    private JTable lstListado;
    private DefaultTableModel modelo;
    private JLabel lblTitulo;

    public View(){
        Controlador = new Reportes();
        inicio();
        tabla();
        
    }

    public void inicio(){
        //frame = new JFrame("Informes");
        cbListaInforme = new JComboBox<String>();
        lblTitulo = new JLabel();
 
        
        add(cbListaInforme);
        add(lblTitulo);

        cbListaInforme.setBounds(10, 10, 100, 20);
        cbListaInforme.addItem("");
        cbListaInforme.addItem("Informe 1");
        cbListaInforme.addItem("Informe 2");
        cbListaInforme.addItem("Informe 3");
        cbListaInforme.addItemListener(this);
        cbListaInforme.setVisible(true);

        lblTitulo.setBounds(150, 10, 100, 20);
        lblTitulo.setVisible(true);
        lblTitulo.setText("");
    }

    public void tabla(){
        lstListado = new JTable(modelo);
        lstListado.setPreferredScrollableViewportSize(new Dimension(500,200));
        add(lstListado);
        JScrollPane pane = new JScrollPane(lstListado);
        add(pane);
        pane.setVisible(true); 

        
    }

    public void ListarInforme1() {
        try{
            List<Informe1Data> data = Controlador.listarInforme1();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Lider");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for(Informe1Data date: data){
                Object[] fila = new Object[4];
                fila[0]= date.getIdLider();
                fila[1]= date.getNombre();
                fila[2]= date.getPrimer_Apellido();
                fila[3]= date.getCiudad_Residencia();   
                modelo.addRow(fila);                 
            }
            lstListado.setModel(modelo);
            modelo.fireTableDataChanged(); //actualizo el modelo de la tabla
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void ListarInforme2() {
        try{
            List<Informe2Data> data = Controlador.listarInforme2();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Nro habitaciones");
            modelo.addColumn("Ciudad");
            for(Informe2Data date: data){
                Object[] fila = new Object[4];
                fila[0]= date.getIdProyecto();
                fila[1]= date.getConstructora();
                fila[2]= date.getNumero_habitaciones();
                fila[3]= date.getCiudad();   
                modelo.addRow(fila);                 
            }
            lstListado.setModel(modelo);
            modelo.fireTableDataChanged(); //actualizo el modelo de la tabla
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void ListarInforme3() {
        try{
            List<Informe3Data> data = Controlador.listarInforme3();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco vinculado");
            for(Informe3Data date: data){
                Object[] fila = new Object[3];
                fila[0]= date.getIdCompra();
                fila[1]= date.getConstructora();
                fila[2]= date.getBancoVinculado();   
                modelo.addRow(fila);                 
            }
            lstListado.setModel(modelo);
            modelo.fireTableDataChanged(); //actualizo el modelo de la tabla
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void BorrarTabla() {
        try{
            modelo = new DefaultTableModel();
            lstListado.setModel(modelo);
            modelo.fireTableDataChanged(); //actualizo el modelo de la tabla
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == cbListaInforme){
            String seleccionado = (String)cbListaInforme.getSelectedItem();
            lblTitulo.setText(seleccionado);
            if(seleccionado.equals("Informe 1")){
                ListarInforme1();
            }
            if(seleccionado.equals("Informe 2")){
                ListarInforme2();
            }
            if(seleccionado.equals("Informe 3")){
                ListarInforme3();
            }
            if(seleccionado.equals("")){
                BorrarTabla();
            }
        }
        
    }
}
