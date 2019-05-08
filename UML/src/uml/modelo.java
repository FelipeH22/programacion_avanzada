package uml;

import controladores.controlador_fin;

public class modelo extends modelo_abstract implements modelo_interface{
    
    @Override
    public void llena_arrays(){
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            for(j=0;j<controlador_fin.clases[i].size();j++)
            {
                if(!controlador_fin.clases[i].get(j).contains("new")&& !controlador_fin.clases[i].get(j).contains("class") && !controlador_fin.clases[i].get(j).contains("interface"))
                {
                    controlador_fin.atributos[i].add(controlador_fin.clases[i].get(j));
                }
                if(controlador_fin.clases[i].get(j).contains("new"))
                {
                    controlador_fin.instancias[i].add(controlador_fin.clases[i].get(j));
                }
                
            }
        }
    }
   
    @Override
    public void determina_privacidad(){
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            for(j=0;j<controlador_fin.clases[i].size();j++)
            {
                if(controladores.controlador_fin.clases[i].get(j).contains("public"))
                {
                    temp = controladores.controlador_fin.clases[i].get(j);
                    temp = temp.replace("public","+ ");
                    temp = temp.trim();
                    controladores.controlador_fin.clases[i].set(j, temp);
                }
                if(controladores.controlador_fin.clases[i].get(j).contains("private"))
                {
                    temp = controladores.controlador_fin.clases[i].get(j);
                    temp = temp.replace("private","- ");
                    temp = temp.trim();
                    controladores.controlador_fin.clases[i].set(j, temp);
                }
                if(controladores.controlador_fin.clases[i].get(j).contains("protected"))
                {
                    temp = controladores.controlador_fin.clases[i].get(j);
                    temp = temp.replace("protected","# ");
                    temp = temp.trim();
                    controladores.controlador_fin.clases[i].set(j, temp);
                }                
            }
        }
        
    }
    
    @Override
    public void evalua_instancias() {
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            for(j=0;j<controladores.controlador_fin.clases[i].size();j++)
            {                
                if(controladores.controlador_fin.clases[i].get(j).contains("new"))
                {
                    temp3 = controladores.controlador_fin.clases[i].get(j);
                    temp3 = temp3.trim();
                    controladores.controlador_fin.clases[i].remove(j);
                    controladores.controlador_fin.clases[i].add(j,temp3);                   
                }                    
            }
        }
        
    }
    
    @Override
    public void evalua_composicion(){
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            for(j=0;j<controlador_fin.clases[i].size();j++)
            {
                if(controlador_fin.clases[i].get(j).contains("[]")&&controlador_fin.clases[i].get(j).contains("new"))
                {
                    temp3 = controlador_fin.clases[i].get(j);
                    temp3 = temp3.replace("new", "class");
                    temp3 = temp3.replace("+","");
                    temp3 = temp3.replace("-","");
                    temp3 = temp3.replace("#","");
                    temp3 = temp3.trim();
                    controlador_fin.agrega.put(controlador_fin.clases[i].get(0), temp3);
                    uml.cuadros.clase1_agrega=i;
                    agregacion=true;
                    composicion=false;
                }
                if(controlador_fin.clases[i].get(j).contains("new")&& !controlador_fin.clases[i].get(j).contains("[]"))
                {
                    temp1 = controlador_fin.clases[i].get(j);
                    temp1 = temp1.replace("new", "class");
                    temp1 = temp1.replace("+","");
                    temp1 = temp1.replace("-","");
                    temp1 = temp1.replace("#","");
                    temp1 = temp1.trim();
                    controlador_fin.compos.put(controlador_fin.clases[i].get(0), temp1);
                    uml.cuadros.clase1_compo=i;
                    agregacion=false;
                    composicion=true;
                }
            }
        }
        for(h=0;h<controlador_fin.num_clases;h++)
        {
            if(controlador_fin.clases[h].get(0).equals(temp1))
            {
                uml.cuadros.clase2_compo=h;
            }
        }
        for(h=0;h<controlador_fin.num_clases;h++)
        {
            if(controlador_fin.clases[h].get(0).equals(temp3))
            {
                uml.cuadros.clase2_agrega=h;
            }
        }        
        cuadros.agregacion=this.agregacion;
        cuadros.composicion=this.composicion;
    }

    @Override
    public void evalua_herencias(){
        for(i=0;i<controlador_fin.herencias.size();i++)
        {
            if(controlador_fin.herencias.get(i).contains("implements"))
            {
                temp3 = controlador_fin.herencias.get(i);
                temp3 = temp3.replace("implements", ",");
                temp3 = temp3.trim();
                String[] arrOfStr;
                arrOfStr=temp3.split(",");
                arrOfStr[1]=arrOfStr[1].replaceAll(arrOfStr[1], "interface"+arrOfStr[1]);
                System.out.println(arrOfStr[0]);
                controlador_fin.implementss.put(arrOfStr[0], arrOfStr[1]);
                i_mplements=true;
                e_xtends=false;
            }
            if(controlador_fin.herencias.get(i).contains("extends"))
            {
                temp2 = controlador_fin.herencias.get(i);
                temp2 = temp2.replace("extends", ",");
                temp2 = temp2.trim();
                String[] arrOfStr;
                arrOfStr=temp2.split(",");
                arrOfStr[1]=arrOfStr[1].replaceAll(arrOfStr[1], "class"+arrOfStr[1]);
                controlador_fin.extendss.put(arrOfStr[0], arrOfStr[1]);
                i_mplements=false;
                e_xtends=true;
            }
            
        }
        
    }
}
