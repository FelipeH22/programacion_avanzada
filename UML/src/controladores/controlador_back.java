package controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uml.cuadros;
import uml.vista;

public class controlador_back implements ActionListener{
    cuadros c = new cuadros();
    vista v = new vista();
    
    public controlador_back(cuadros c){
        this.c=c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controlador_fin.agrega.clear();
        controlador_fin.compo.clear();
        c.frame.setVisible(false);
        v.setVisible(true);
        v.componentes();  
    }
}
