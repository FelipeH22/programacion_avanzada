package uml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador2 implements ActionListener{
    vista v = new vista();
    modelo m = new modelo();
    
    public controlador2(vista v, modelo m){
        this.v=v;
        this.m=m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Creado herencia");
    }   
}
