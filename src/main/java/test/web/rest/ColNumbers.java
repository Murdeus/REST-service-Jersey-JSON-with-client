package test.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by smile on 25-Mar-16.
 */
//@XmlRootElement(name = "colNumbers")
public class ColNumbers {

    private int columns;

    public void setColumns(int i){
        this.columns = i;
    }

    public int getColumns(){
        return this.columns;
    }
}
