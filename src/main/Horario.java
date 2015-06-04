/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;
//import javax.microedition.global.Formatter;
//import java.util.Calendar;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;
import java.util.Vector;
/**
 * @author pabiagioli
 */
public class Horario extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    //StringItem [][] stlist ;
    Vector []  stlist1 = new Vector [7];
    DBHorario dbH;
    
    //DBHorario dbList[]  = new DBHorario[7];
    //DBHorario dbList[0] = new DBHorario("lunes");
    //DBHorario dbList[1] = new DBHorario("martes");
    //DBHorario dbList[2] = new DBHorario("miercoles");
    //DBHorario dbList[3] = new DBHorario("jueves");
    //DBHorario dbList[4] = new DBHorario("viernes");
    //DBHorario dbList[5] = new DBHorario("sabado");
    //DBHorario dbList[6] = new DBHorario("domingo");
    //private Formatter f;
    //private Calendar cal;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private java.util.Hashtable __previousDisplayables = new java.util.Hashtable();
    private List semana;
    private Form newHora;
    private TextField textMateria;
    private TextField posicionTextField;
    private TextField aulaTextField;
    private DateField dateField1;
    private DateField dateField;
    private Form diaForm;
    private Form deleteForm;
    private TextField borraTextField;
    private Command exitSemana;
    private Command okSemana;
    private Command itemNewCommand;
    private Command backDia;
    private Command okMateria;
    private Command cancelMateria;
    private Command itemCommand;
    private Command backCommand;
    private Command itemRead;
    private Command itemSave;
    private Command backCommand1;
    private Command itemDelete;
    private Command itemSaveDia;
    private Command cancelCommand;
    private Command okDeleteCommand;
    private Command itemNewFile;
    private Command itemDeleteAll;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The Horario constructor.
     */
    public Horario() {
        //f = new Formatter();
        //cal = Calendar.getInstance();
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    /**
     * Switches a display to previous displayable of the current displayable.
     * The <code>display</code> instance is obtain from the <code>getDisplay</code> method.
     */
    private void switchToPreviousDisplayable() {
        Displayable __currentDisplayable = getDisplay().getCurrent();
        if (__currentDisplayable != null) {
            Displayable __nextDisplayable = (Displayable) __previousDisplayables.get(__currentDisplayable);
            if (__nextDisplayable != null) {
                switchDisplayable(null, __nextDisplayable);
            }
        }
    }
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        this.switchDisplayable(null, this.getSemana());
        lectura();
//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        Displayable __currentDisplayable = display.getCurrent();
        if (__currentDisplayable != null  &&  nextDisplayable != null) {
            __previousDisplayables.put(nextDisplayable, __currentDisplayable);
        }
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == deleteForm) {//GEN-BEGIN:|7-commandAction|1|81-preAction
            if (command == cancelCommand) {//GEN-END:|7-commandAction|1|81-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|2|81-postAction
                // write post-action user code here
            } else if (command == okDeleteCommand) {//GEN-LINE:|7-commandAction|3|83-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|4|83-postAction
                // write post-action user code here
                borraItem(this.getBorraTextField().getString());
            }//GEN-BEGIN:|7-commandAction|5|61-preAction
        } else if (displayable == diaForm) {
            if (command == backCommand) {//GEN-END:|7-commandAction|5|61-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|6|61-postAction
                // write post-action user code here
                this.getDiaForm().deleteAll();
                this.switchDisplayable(null, getSemana());
            } else if (command == itemCommand) {//GEN-LINE:|7-commandAction|7|63-preAction
                // write pre-action user code here
                switchDisplayable(null, getNewHora());//GEN-LINE:|7-commandAction|8|63-postAction
                // write post-action user code here
            } else if (command == itemDelete) {//GEN-LINE:|7-commandAction|9|74-preAction
                // write pre-action user code here
                switchDisplayable(null, getDeleteForm());//GEN-LINE:|7-commandAction|10|74-postAction
                // write post-action user code here
            } else if (command == itemDeleteAll) {//GEN-LINE:|7-commandAction|11|91-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|12|91-postAction
                // write post-action user code here
                this.getDiaForm().deleteAll();
                this.stlist1[this.getSemana().getSelectedIndex()].removeAllElements();
            } else if (command == itemSaveDia) {//GEN-LINE:|7-commandAction|13|76-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|14|76-postAction
                // write post-action user code here
                guardaDatos();
            }//GEN-BEGIN:|7-commandAction|15|57-preAction
        } else if (displayable == newHora) {
            if (command == cancelMateria) {//GEN-END:|7-commandAction|15|57-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|16|57-postAction
                // write post-action user code here
            } else if (command == okMateria) {//GEN-LINE:|7-commandAction|17|55-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|18|55-postAction
                // write post-action user code here
                String hora = this.getDateField().getDate().toString().substring(11, 16);
                hora += " - "+ this.getDateField1().getDate().toString().substring(11, 16);
                String aula = getAulaTextField().getString();
                String materia = getTextMateria().getString();
                materia = materia + " (Aula "+aula+")";
                try{
                    int pos = Integer.parseInt(this.getPosicionTextField().getString());
                    nuevaEntrada(pos,getSemana().getSelectedIndex(), hora /*getTextTitulo().getString()*/,materia);
                }catch (Exception e){
                    nuevaEntrada(getSemana().getSelectedIndex(), hora /*getTextTitulo().getString()*/,materia);
                    this.switchToPreviousDisplayable();
                }

            }//GEN-BEGIN:|7-commandAction|19|25-preAction
        } else if (displayable == semana) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|19|25-preAction
                // write pre-action user code here
                semanaAction();//GEN-LINE:|7-commandAction|20|25-postAction
                // write post-action user code here
            } else if (command == exitSemana) {//GEN-LINE:|7-commandAction|21|32-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|22|32-postAction
                // write post-action user code here
            } else if (command == itemNewFile) {//GEN-LINE:|7-commandAction|23|96-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|24|96-postAction
                // write post-action user code here
                this.nuevoArchivo();
            } else if (command == itemRead) {//GEN-LINE:|7-commandAction|25|66-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|26|66-postAction
                // write post-action user code here
                lectura();
            } else if (command == itemSave) {//GEN-LINE:|7-commandAction|27|68-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|28|68-postAction
                // write post-action user code here
                guardaDatos();
            } else if (command == okSemana) {//GEN-LINE:|7-commandAction|29|36-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|30|36-postAction
                // write post-action user code here
                nuevoDia(semana.getString(semana.getSelectedIndex()));
            }//GEN-BEGIN:|7-commandAction|31|7-postCommandAction
        }//GEN-END:|7-commandAction|31|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|32|
    //</editor-fold>//GEN-END:|7-commandAction|32|


public void nuevoArchivo(){

    for(int i= 0;i<stlist1.length;i++)
        if(stlist1[i].size() > 0)
            stlist1[i].removeAllElements();

}


public void lectura(){
    

    //Formato del String : dia "+" tit "+" texto
    int tokdia = 0;int toktit = 0; int toktexto= 0;
    int d;
    String tit,texto;
    //NUEVO: si se le da a Read File por segunda vez,
    //hay que vaciar los vectores o no volver a leer.
    //vamos a vaciar los vectores y reiniciar la lectura
    //pero primero vamos a preguntar cosas:
    /*boolean hayDatos = false;
    for(int i = 0; i<stlist1.length;i++){
        if(stlist1[i].size() >0){
            hayDatos = true;break;
        }
    }
    if(hayDatos){
        Alert alerta = new Alert("Importante!!!","Si continúa se borrará cualquier entrada que no haya guardado todavía.\n\nDesea Continuar?",null,AlertType.WARNING);
        alerta.setTimeout(Alert.FOREVER);
        this.switchDisplayable(alerta, semana);
    }*/
    for(int i= 0;i<stlist1.length;i++)
        if(stlist1[i].size() > 0)
            stlist1[i].removeAllElements();
    try{
    
        if(dbH.getRecordStore().getNumRecords() > 0){
        
            RecordEnumeration enum1 = dbH.enumerate();
            while(enum1.hasNextElement()){
                String tmp = new String(enum1.nextRecord());
                while(tmp.charAt(tokdia)!= '+')
                    tokdia++;
                d = Integer.parseInt(tmp.substring(2, tokdia));
                toktit = tokdia +1;
                while(tmp.charAt(toktit) != '+')
                    toktit++;
                tit = tmp.substring(tokdia+1, toktit);
                toktexto = toktit+1;
                while(tmp.charAt(toktexto) != '+')
                    toktexto++;
                texto = tmp.substring(toktit+1,toktexto);
            
                //Todo parseado, ahora hay que agregarlo al Vector
                nuevaEntrada(d,tit,texto);
            
            }
        }else{
            //Si no hay ningun registro en la BD
            Alert alerta = new Alert("Aviso","La Base de Datos está vacía.\nElija un dia y para añadir una nueva entrada seleccione \"Nuevo\" en el menú.",null,AlertType.INFO);
            alerta.setTimeout(Alert.FOREVER);
            this.switchDisplayable(alerta, semana);
        
        }
    
        
    }catch(NumberFormatException nfe){
        Alert alerta = new Alert("Error de Lectura (Archivo Corrupto)",nfe.getMessage(),null,AlertType.ERROR);
        alerta.setTimeout(Alert.FOREVER);
        this.switchDisplayable(alerta, semana);
    }catch(Exception e){
        Alert alerta = new Alert("Error de Lectura ",e.getMessage(),null,AlertType.ERROR);
        alerta.setTimeout(Alert.FOREVER);
        this.switchDisplayable(alerta, semana);
    }
    
}

public void nuevaEntrada(int pos,int dia, String tit, String text){
    
    
    //El metodo insertElementAt(i, Elemento) mueve el resto uno para adelante, 
    //con lo cual no necesito hacer bucles ni nada!!!
    try{
        if(pos < 0)
            throw new Exception("Posición no válida, tiene que ser mayor que cero");
        StringItem tmp = new StringItem(tit,text,Item.PLAIN);
        this.stlist1[dia].insertElementAt(tmp, pos);
        this.getDiaForm().insert(pos,tmp);
        this.switchDisplayable(null, this.getDiaForm());
    }catch(Exception e){
        e.printStackTrace();
        Alert alerta = new Alert("Error de Inserción","La posición no es valida: "+e.getMessage(),null,AlertType.ERROR);
        alerta.setTimeout(Alert.FOREVER);
        this.switchDisplayable(alerta, this.getSemana());
        
    }
        
    
    
    
}

public void nuevaEntrada(int dia, String tit, String text){
    if (tit == null)
        stlist1[dia].addElement(new StringItem("-",text,Item.PLAIN));
    else
        stlist1[dia].addElement(new StringItem(tit,text,Item.PLAIN));
    
    getDiaForm().append((StringItem)stlist1[dia].lastElement());
    
}

public void guardaDatos(){
        
    try {
            String tmp;
            //Formato del Vector: Vector <StringItem> [7]
            if (dbH.getRecordStore().getNumRecords() > 0) {
                dbH.close();
                RecordStore.deleteRecordStore("horario");
                dbH = new DBHorario("horario");
            }
            
            for (int i = 0; i < stlist1.length; i++) {
                for (int j = stlist1[i].size()-1; j >= 0; j--) {
                    if(stlist1[i].elementAt(j) != null){
                        tmp = String.valueOf(i) + "+" + ((StringItem) stlist1[i].elementAt(j)).getLabel() + "+" + ((StringItem) stlist1[i].elementAt(j)).getText() + "+";
                        dbH.addNewHora(tmp);
                    }
                }
            }
    } catch (RecordStoreNotOpenException ex) {
            Alert alerta = new Alert("Error de Guardado","La Base de datos no está abierta: "+ex.getMessage(),null,AlertType.WARNING);
            alerta.setTimeout(Alert.FOREVER);
            this.switchDisplayable(alerta, semana);
    } catch (RecordStoreException ex) {
            Alert alerta = new Alert("Error de Guardado","Error al Guardar: "+ex.getMessage(),null,AlertType.WARNING);
            alerta.setTimeout(Alert.FOREVER);
            this.switchDisplayable(alerta, semana);
    }

}

public void borraItem(String cual){
    if(getDiaForm().size()>0){
    try{
        int cuales = Integer.parseInt(cual);
        this.getDiaForm().delete(cuales-1);
        stlist1[getSemana().getSelectedIndex()].removeElementAt(cuales-1);
        this.switchDisplayable(null, semana);
    }catch (NumberFormatException nfe){
        Alert alerta = new Alert("Error de Borrado",nfe.getMessage(),null,AlertType.ERROR);
        alerta.setTimeout(Alert.FOREVER);
        this.switchDisplayable(alerta, semana);
    }
    }else{
        Alert alerta = new Alert("Error de Borrado","No Hay Entradas en este Dia",null,AlertType.WARNING);
        alerta.setTimeout(Alert.FOREVER);
        this.switchDisplayable(alerta, semana);
    }

}
public void RellenarDia(int dia){

    try{
        
    getDiaForm().deleteAll();
    if(stlist1[dia] == null){
        stlist1[dia] = new Vector();
    }else{
        for(int i = 0; i< stlist1[dia].size();i++)
            getDiaForm().append((StringItem)stlist1[dia].elementAt(i));
    }
    
    }catch(IllegalStateException ise){
        Alert alerta = new Alert("Error","Error en form.append: "+ise.getMessage(),null,AlertType.ERROR);
        alerta.setTimeout(Alert.FOREVER);
        this.switchDisplayable(alerta, semana);
    }
    
   
    
}

public void nuevoDia(String dia){

    this.switchDisplayable(null, this.getDiaForm());
    getDiaForm().setTitle(dia);
    RellenarDia(getSemana().getSelectedIndex());
    
}





//<editor-fold defaultstate="collapsed" desc=" Generated Getter: semana ">//GEN-BEGIN:|23-getter|0|23-preInit
/**
 * Returns an initiliazed instance of semana component.
 * @return the initialized component instance
 */
public List getSemana() {
    if (semana == null) {//GEN-END:|23-getter|0|23-preInit
            // write pre-init user code here
        semana = new List("Dia de la Semana", Choice.IMPLICIT);//GEN-BEGIN:|23-getter|1|23-postInit
        semana.append("Lunes", null);
        semana.append("Martes", null);
        semana.append("Miercoles", null);
        semana.append("Jueves", null);
        semana.append("Viernes", null);
        semana.append("Sabado", null);
        semana.append("Domingo", null);
        semana.addCommand(getExitSemana());
        semana.addCommand(getOkSemana());
        semana.addCommand(getItemNewFile());
        semana.addCommand(getItemRead());
        semana.addCommand(getItemSave());
        semana.setCommandListener(this);
        semana.setSelectedFlags(new boolean[] { false, false, false, false, false, false, false });//GEN-END:|23-getter|1|23-postInit
            // write post-init user code here
    }//GEN-BEGIN:|23-getter|2|
    return semana;
}
//</editor-fold>//GEN-END:|23-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: semanaAction ">//GEN-BEGIN:|23-action|0|23-preAction
/**
 * Performs an action assigned to the selected list element in the semana component.
 */
public void semanaAction() {//GEN-END:|23-action|0|23-preAction
        // enter pre-action user code here
    String __selectedString = getSemana().getString(getSemana().getSelectedIndex());//GEN-BEGIN:|23-action|1|27-preAction
    if (__selectedString != null) {
        if (__selectedString.equals("Lunes")) {//GEN-END:|23-action|1|27-preAction
                // write pre-action user code here
//GEN-LINE:|23-action|2|27-postAction
                // write post-action user code here
            nuevoDia("Lunes");
        } else if (__selectedString.equals("Martes")) {//GEN-LINE:|23-action|3|28-preAction
                // write pre-action user code here
//GEN-LINE:|23-action|4|28-postAction
                // write post-action user code here
            nuevoDia("Martes");
        } else if (__selectedString.equals("Miercoles")) {//GEN-LINE:|23-action|5|29-preAction
                // write pre-action user code here
//GEN-LINE:|23-action|6|29-postAction
                // write post-action user code here
            nuevoDia("Miercoles");
        } else if (__selectedString.equals("Jueves")) {//GEN-LINE:|23-action|7|30-preAction
                // write pre-action user code here
//GEN-LINE:|23-action|8|30-postAction
                // write post-action user code here
            nuevoDia("Jueves");
        } else if (__selectedString.equals("Viernes")) {//GEN-LINE:|23-action|9|34-preAction
                // write pre-action user code here
//GEN-LINE:|23-action|10|34-postAction
                // write post-action user code here
            nuevoDia("Viernes");
        } else if (__selectedString.equals("Sabado")) {//GEN-LINE:|23-action|11|71-preAction
            // write pre-action user code here
//GEN-LINE:|23-action|12|71-postAction
            // write post-action user code here
            nuevoDia("Sabado");
        } else if (__selectedString.equals("Domingo")) {//GEN-LINE:|23-action|13|72-preAction
            // write pre-action user code here
//GEN-LINE:|23-action|14|72-postAction
            // write post-action user code here
            nuevoDia("Domingo");
        }//GEN-BEGIN:|23-action|15|23-postAction
    }//GEN-END:|23-action|15|23-postAction
        // enter post-action user code here
}//GEN-BEGIN:|23-action|16|
//</editor-fold>//GEN-END:|23-action|16|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitSemana ">//GEN-BEGIN:|31-getter|0|31-preInit
/**
 * Returns an initiliazed instance of exitSemana component.
 * @return the initialized component instance
 */
public Command getExitSemana() {
    if (exitSemana == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
        exitSemana = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|31-getter|1|31-postInit
            // write post-init user code here
    }//GEN-BEGIN:|31-getter|2|
    return exitSemana;
}
//</editor-fold>//GEN-END:|31-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okSemana ">//GEN-BEGIN:|35-getter|0|35-preInit
/**
 * Returns an initiliazed instance of okSemana component.
 * @return the initialized component instance
 */
public Command getOkSemana() {
    if (okSemana == null) {//GEN-END:|35-getter|0|35-preInit
            // write pre-init user code here
        okSemana = new Command("Ok", Command.OK, 0);//GEN-LINE:|35-getter|1|35-postInit
            // write post-init user code here
    }//GEN-BEGIN:|35-getter|2|
    return okSemana;
}
//</editor-fold>//GEN-END:|35-getter|2|





//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backDia ">//GEN-BEGIN:|40-getter|0|40-preInit
/**
 * Returns an initiliazed instance of backDia component.
 * @return the initialized component instance
 */
public Command getBackDia() {
    if (backDia == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
        backDia = new Command("Back", Command.BACK, 0);//GEN-LINE:|40-getter|1|40-postInit
            // write post-init user code here
    }//GEN-BEGIN:|40-getter|2|
    return backDia;
}
//</editor-fold>//GEN-END:|40-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemNewCommand ">//GEN-BEGIN:|42-getter|0|42-preInit
/**
 * Returns an initiliazed instance of itemNewCommand component.
 * @return the initialized component instance
 */
public Command getItemNewCommand() {
    if (itemNewCommand == null) {//GEN-END:|42-getter|0|42-preInit
            // write pre-init user code here
        itemNewCommand = new Command("New", Command.ITEM, 0);//GEN-LINE:|42-getter|1|42-postInit
            // write post-init user code here
    }//GEN-BEGIN:|42-getter|2|
    return itemNewCommand;
}
//</editor-fold>//GEN-END:|42-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: newHora ">//GEN-BEGIN:|51-getter|0|51-preInit
/**
 * Returns an initiliazed instance of newHora component.
 * @return the initialized component instance
 */
public Form getNewHora() {
    if (newHora == null) {//GEN-END:|51-getter|0|51-preInit
        // write pre-init user code here
        newHora = new Form("New Entry", new Item[] { getPosicionTextField(), getDateField(), getDateField1(), getTextMateria(), getAulaTextField() });//GEN-BEGIN:|51-getter|1|51-postInit
        newHora.addCommand(getOkMateria());
        newHora.addCommand(getCancelMateria());
        newHora.setCommandListener(this);//GEN-END:|51-getter|1|51-postInit
        // write post-init user code here
    }//GEN-BEGIN:|51-getter|2|
    return newHora;
}
//</editor-fold>//GEN-END:|51-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textMateria ">//GEN-BEGIN:|53-getter|0|53-preInit
/**
 * Returns an initiliazed instance of textMateria component.
 * @return the initialized component instance
 */
public TextField getTextMateria() {
    if (textMateria == null) {//GEN-END:|53-getter|0|53-preInit
        // write pre-init user code here
        textMateria = new TextField("Materia", null, 32, TextField.ANY | TextField.NON_PREDICTIVE);//GEN-LINE:|53-getter|1|53-postInit
        // write post-init user code here
    }//GEN-BEGIN:|53-getter|2|
    return textMateria;
}
//</editor-fold>//GEN-END:|53-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okMateria ">//GEN-BEGIN:|54-getter|0|54-preInit
/**
 * Returns an initiliazed instance of okMateria component.
 * @return the initialized component instance
 */
public Command getOkMateria() {
    if (okMateria == null) {//GEN-END:|54-getter|0|54-preInit
        // write pre-init user code here
        okMateria = new Command("Ok", Command.OK, 0);//GEN-LINE:|54-getter|1|54-postInit
        // write post-init user code here
    }//GEN-BEGIN:|54-getter|2|
    return okMateria;
}
//</editor-fold>//GEN-END:|54-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelMateria ">//GEN-BEGIN:|56-getter|0|56-preInit
/**
 * Returns an initiliazed instance of cancelMateria component.
 * @return the initialized component instance
 */
public Command getCancelMateria() {
    if (cancelMateria == null) {//GEN-END:|56-getter|0|56-preInit
        // write pre-init user code here
        cancelMateria = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|56-getter|1|56-postInit
        // write post-init user code here
    }//GEN-BEGIN:|56-getter|2|
    return cancelMateria;
}
//</editor-fold>//GEN-END:|56-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: diaForm ">//GEN-BEGIN:|59-getter|0|59-preInit
/**
 * Returns an initiliazed instance of diaForm component.
 * @return the initialized component instance
 */
public Form getDiaForm() {
    if (diaForm == null) {//GEN-END:|59-getter|0|59-preInit
        // write pre-init user code here
        diaForm = new Form("form");//GEN-BEGIN:|59-getter|1|59-postInit
        diaForm.addCommand(getBackCommand());
        diaForm.addCommand(getItemCommand());
        diaForm.addCommand(getItemDelete());
        diaForm.addCommand(getItemSaveDia());
        diaForm.addCommand(getItemDeleteAll());
        diaForm.setCommandListener(this);//GEN-END:|59-getter|1|59-postInit
        // write post-init user code here
    }//GEN-BEGIN:|59-getter|2|
    return diaForm;
}
//</editor-fold>//GEN-END:|59-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|60-getter|0|60-preInit
/**
 * Returns an initiliazed instance of backCommand component.
 * @return the initialized component instance
 */
public Command getBackCommand() {
    if (backCommand == null) {//GEN-END:|60-getter|0|60-preInit
        // write pre-init user code here
        backCommand = new Command("Atras", Command.BACK, 0);//GEN-LINE:|60-getter|1|60-postInit
        // write post-init user code here
    }//GEN-BEGIN:|60-getter|2|
    return backCommand;
}
//</editor-fold>//GEN-END:|60-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|62-getter|0|62-preInit
/**
 * Returns an initiliazed instance of itemCommand component.
 * @return the initialized component instance
 */
public Command getItemCommand() {
    if (itemCommand == null) {//GEN-END:|62-getter|0|62-preInit
        // write pre-init user code here
        itemCommand = new Command("Nuevo", Command.ITEM, 0);//GEN-LINE:|62-getter|1|62-postInit
        // write post-init user code here
    }//GEN-BEGIN:|62-getter|2|
    return itemCommand;
}
//</editor-fold>//GEN-END:|62-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemRead ">//GEN-BEGIN:|65-getter|0|65-preInit
/**
 * Returns an initiliazed instance of itemRead component.
 * @return the initialized component instance
 */
public Command getItemRead() {
    if (itemRead == null) {//GEN-END:|65-getter|0|65-preInit
        // write pre-init user code here
        itemRead = new Command("Leer Horario", Command.ITEM, 0);//GEN-LINE:|65-getter|1|65-postInit
        // write post-init user code here
    }//GEN-BEGIN:|65-getter|2|
    return itemRead;
}
//</editor-fold>//GEN-END:|65-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemSave ">//GEN-BEGIN:|67-getter|0|67-preInit
/**
 * Returns an initiliazed instance of itemSave component.
 * @return the initialized component instance
 */
public Command getItemSave() {
    if (itemSave == null) {//GEN-END:|67-getter|0|67-preInit
        // write pre-init user code here
        itemSave = new Command("Guardar Horario", Command.ITEM, 0);//GEN-LINE:|67-getter|1|67-postInit
        // write post-init user code here
    }//GEN-BEGIN:|67-getter|2|
    return itemSave;
}
//</editor-fold>//GEN-END:|67-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemDelete ">//GEN-BEGIN:|73-getter|0|73-preInit
/**
 * Returns an initiliazed instance of itemDelete component.
 * @return the initialized component instance
 */
public Command getItemDelete() {
    if (itemDelete == null) {//GEN-END:|73-getter|0|73-preInit
        // write pre-init user code here
        itemDelete = new Command("Borrar", Command.ITEM, 0);//GEN-LINE:|73-getter|1|73-postInit
        // write post-init user code here
    }//GEN-BEGIN:|73-getter|2|
    return itemDelete;
}
//</editor-fold>//GEN-END:|73-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemSaveDia ">//GEN-BEGIN:|75-getter|0|75-preInit
/**
 * Returns an initiliazed instance of itemSaveDia component.
 * @return the initialized component instance
 */
public Command getItemSaveDia() {
    if (itemSaveDia == null) {//GEN-END:|75-getter|0|75-preInit
        // write pre-init user code here
        itemSaveDia = new Command("Guardar Datos", Command.ITEM, 0);//GEN-LINE:|75-getter|1|75-postInit
        // write post-init user code here
    }//GEN-BEGIN:|75-getter|2|
    return itemSaveDia;
}
//</editor-fold>//GEN-END:|75-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: deleteForm ">//GEN-BEGIN:|77-getter|0|77-preInit
/**
 * Returns an initiliazed instance of deleteForm component.
 * @return the initialized component instance
 */
public Form getDeleteForm() {
    if (deleteForm == null) {//GEN-END:|77-getter|0|77-preInit
        // write pre-init user code here
        deleteForm = new Form("Borrar Entrada", new Item[] { getBorraTextField() });//GEN-BEGIN:|77-getter|1|77-postInit
        deleteForm.addCommand(getCancelCommand());
        deleteForm.addCommand(getOkDeleteCommand());
        deleteForm.setCommandListener(this);//GEN-END:|77-getter|1|77-postInit
        // write post-init user code here
    }//GEN-BEGIN:|77-getter|2|
    return deleteForm;
}
//</editor-fold>//GEN-END:|77-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: borraTextField ">//GEN-BEGIN:|85-getter|0|85-preInit
/**
 * Returns an initiliazed instance of borraTextField component.
 * @return the initialized component instance
 */
public TextField getBorraTextField() {
    if (borraTextField == null) {//GEN-END:|85-getter|0|85-preInit
        // write pre-init user code here
        borraTextField = new TextField("#Entrada", null, 32, TextField.NUMERIC | TextField.NON_PREDICTIVE);//GEN-LINE:|85-getter|1|85-postInit
        // write post-init user code here
    }//GEN-BEGIN:|85-getter|2|
    return borraTextField;
}
//</editor-fold>//GEN-END:|85-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|78-getter|0|78-preInit
/**
 * Returns an initiliazed instance of backCommand1 component.
 * @return the initialized component instance
 */
public Command getBackCommand1() {
    if (backCommand1 == null) {//GEN-END:|78-getter|0|78-preInit
        // write pre-init user code here
        backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|78-getter|1|78-postInit
        // write post-init user code here
    }//GEN-BEGIN:|78-getter|2|
    return backCommand1;
}
//</editor-fold>//GEN-END:|78-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|80-getter|0|80-preInit
/**
 * Returns an initiliazed instance of cancelCommand component.
 * @return the initialized component instance
 */
public Command getCancelCommand() {
    if (cancelCommand == null) {//GEN-END:|80-getter|0|80-preInit
        // write pre-init user code here
        cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|80-getter|1|80-postInit
        // write post-init user code here
    }//GEN-BEGIN:|80-getter|2|
    return cancelCommand;
}
//</editor-fold>//GEN-END:|80-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okDeleteCommand ">//GEN-BEGIN:|82-getter|0|82-preInit
/**
 * Returns an initiliazed instance of okDeleteCommand component.
 * @return the initialized component instance
 */
public Command getOkDeleteCommand() {
    if (okDeleteCommand == null) {//GEN-END:|82-getter|0|82-preInit
        // write pre-init user code here
        okDeleteCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|82-getter|1|82-postInit
        // write post-init user code here
    }//GEN-BEGIN:|82-getter|2|
    return okDeleteCommand;
}
//</editor-fold>//GEN-END:|82-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: aulaTextField ">//GEN-BEGIN:|88-getter|0|88-preInit
/**
 * Returns an initiliazed instance of aulaTextField component.
 * @return the initialized component instance
 */
public TextField getAulaTextField() {
    if (aulaTextField == null) {//GEN-END:|88-getter|0|88-preInit
        // write pre-init user code here
        aulaTextField = new TextField("Aula", null, 32, TextField.ANY | TextField.NON_PREDICTIVE);//GEN-LINE:|88-getter|1|88-postInit
        // write post-init user code here
    }//GEN-BEGIN:|88-getter|2|
    return aulaTextField;
}
//</editor-fold>//GEN-END:|88-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: posicionTextField ">//GEN-BEGIN:|89-getter|0|89-preInit
/**
 * Returns an initiliazed instance of posicionTextField component.
 * @return the initialized component instance
 */
public TextField getPosicionTextField() {
    if (posicionTextField == null) {//GEN-END:|89-getter|0|89-preInit
        // write pre-init user code here
        posicionTextField = new TextField("Posicion en la Lista", null, 32, TextField.NUMERIC | TextField.NON_PREDICTIVE);//GEN-LINE:|89-getter|1|89-postInit
        // write post-init user code here
    }//GEN-BEGIN:|89-getter|2|
    return posicionTextField;
}
//</editor-fold>//GEN-END:|89-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemDeleteAll ">//GEN-BEGIN:|90-getter|0|90-preInit
/**
 * Returns an initiliazed instance of itemDeleteAll component.
 * @return the initialized component instance
 */
public Command getItemDeleteAll() {
    if (itemDeleteAll == null) {//GEN-END:|90-getter|0|90-preInit
        // write pre-init user code here
        itemDeleteAll = new Command("Borrar Todos", Command.ITEM, 0);//GEN-LINE:|90-getter|1|90-postInit
        // write post-init user code here
    }//GEN-BEGIN:|90-getter|2|
    return itemDeleteAll;
}
//</editor-fold>//GEN-END:|90-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemNewFile ">//GEN-BEGIN:|95-getter|0|95-preInit
/**
 * Returns an initiliazed instance of itemNewFile component.
 * @return the initialized component instance
 */
public Command getItemNewFile() {
    if (itemNewFile == null) {//GEN-END:|95-getter|0|95-preInit
        // write pre-init user code here
        itemNewFile = new Command("Nuevo Horario", Command.ITEM, 0);//GEN-LINE:|95-getter|1|95-postInit
        // write post-init user code here
    }//GEN-BEGIN:|95-getter|2|
    return itemNewFile;
}
//</editor-fold>//GEN-END:|95-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: dateField ">//GEN-BEGIN:|98-getter|0|98-preInit
/**
 * Returns an initiliazed instance of dateField component.
 * @return the initialized component instance
 */
public DateField getDateField() {
    if (dateField == null) {//GEN-END:|98-getter|0|98-preInit
        // write pre-init user code here
        dateField = new DateField("Hora (inicio)", DateField.TIME);//GEN-BEGIN:|98-getter|1|98-postInit
        dateField.setDate(new java.util.Date(System.currentTimeMillis()));//GEN-END:|98-getter|1|98-postInit
        // write post-init user code here
    }//GEN-BEGIN:|98-getter|2|
    return dateField;
}
//</editor-fold>//GEN-END:|98-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: dateField1 ">//GEN-BEGIN:|100-getter|0|100-preInit
/**
 * Returns an initiliazed instance of dateField1 component.
 * @return the initialized component instance
 */
public DateField getDateField1() {
    if (dateField1 == null) {//GEN-END:|100-getter|0|100-preInit
        // write pre-init user code here
        dateField1 = new DateField("Hora (final)", DateField.TIME);//GEN-BEGIN:|100-getter|1|100-postInit
        dateField1.setDate(new java.util.Date(System.currentTimeMillis()));//GEN-END:|100-getter|1|100-postInit
        // write post-init user code here
    }//GEN-BEGIN:|100-getter|2|
    return dateField1;
}
//</editor-fold>//GEN-END:|100-getter|2|



    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        try {
            dbH.close();
            switchDisplayable(null, null);
            destroyApp(true);
            notifyDestroyed();
        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            stlist1[0] = new Vector();
            stlist1[1] = new Vector();
            stlist1[2] = new Vector();
            stlist1[3] = new Vector();
            stlist1[4] = new Vector();
            stlist1[5] = new Vector();
            stlist1[6] = new Vector();
            dbH = new DBHorario("horario");
            
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
