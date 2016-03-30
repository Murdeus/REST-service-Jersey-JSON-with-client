package rest.client;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by smile on 14-Mar-16.
 */

public class ClientTableModel extends AbstractTableModel {
    private List<String> list;
    private int columnNumb;
    private final String[] header = {"Name", "Surname", "Fathername", "Birth_date", "Form", "Phone_number"};

    public ClientTableModel(List<String> list, int col){
        this.list = list;
        this.columnNumb = col;
    }

    @Override
    public int getRowCount() {
        return (this.list.size()+1)/columnNumb;
    }

    public String getColumnName(int col) {
        return header[col];
    }

    @Override
    public int getColumnCount() {
        return columnNumb;
    }

    @Override
    public Object getValueAt(int x, int y) {
        int g = x*columnNumb +y;
        return list.get(g);
    }

    public void updateList(List<String> list){
        this.list = list;
    }
}
