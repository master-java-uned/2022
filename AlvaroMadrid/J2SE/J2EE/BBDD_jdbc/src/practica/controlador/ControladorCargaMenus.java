package practica.controlador;

import practica.modelo.CargaMenus;
import practica.vista.Marco_Aplicacion;
import java.awt.event.*;

public class ControladorCargaMenus extends WindowAdapter {

    public ControladorCargaMenus(Marco_Aplicacion elmarco){
        this.elmarco=elmarco;
    }

    public void windowOpened(WindowEvent e){

        obj.ejecutaConsultas();
        try{
            while(obj.rs.next()){
                elmarco.secciones.addItem(obj.rs.getString(1));
            }
            while(obj.rs2.next()){
                elmarco.paises.addItem(obj.rs2.getString(1));
            }
        } catch(Exception e2){
            e2.printStackTrace();
        }

    }

    CargaMenus obj = new CargaMenus();
    private Marco_Aplicacion elmarco;

}
