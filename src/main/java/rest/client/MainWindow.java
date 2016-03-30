package rest.client;


import test.web.rest.ColNumbers;
import test.web.rest.ResponseList;

import javax.swing.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * Created by smile on 14-Mar-16.
 */
public class MainWindow extends JFrame {

    private JTable table;
    private ClientTableModel model;
    private List<String> list;
    private int columns;
    private Client client;

    public MainWindow(Client client){
        this.client = client;
        this.setSize(900,500);
        this.setLocation(250,150);
        this.setTitle("GUI Client   Service type: REST");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JToolBar toolBar = new JToolBar(1);
        JButton addButt = new JButton("Add");
        JButton findButt = new JButton("Change");
        JButton delButt = new JButton("Delete");
        addButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContent();
            }
        });
        findButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeContent();
            }
        });
        delButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContent();
            }
        });
        toolBar.add(addButt);
        toolBar.addSeparator();
        toolBar.add(findButt);
        toolBar.addSeparator();
        toolBar.add(delButt);
        this.add(toolBar, BorderLayout.WEST);
        setContent();
        table = new JTable();
        model = new ClientTableModel(list, columns);
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        this.add(scroll, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void setContent(){
        try{
            WebTarget webResource = client
                    .target("http://localhost:8080/resttest-1.0-SNAPSHOT/students/get");
            Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON + ";charset=utf-8");
            Response postResponse = invocationBuilder.get();
            GenericType<ResponseList> genericType = new GenericType<ResponseList>() {  };
            ResponseList litt = postResponse.readEntity(genericType);
            list = litt.getList();
            webResource = client
                    .target("http://localhost:8080/resttest-1.0-SNAPSHOT/students/columns");
            invocationBuilder = webResource.request(MediaType.APPLICATION_JSON + ";charset=utf-8");
            postResponse = invocationBuilder.get();
            GenericType<ColNumbers> genType = new GenericType<ColNumbers>() {  };
            ColNumbers resl = postResponse.readEntity(genType);
            columns = resl.getColumns();
         } catch (Exception e) {
            e.printStackTrace();
         }
    }

    public void updateContent(){
        WebTarget webResource = client
                .target("http://localhost:8080/resttest-1.0-SNAPSHOT/students/get");
        Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON + ";charset=utf-8");
        Response postResponse = invocationBuilder.get();
        GenericType<ResponseList> genericType = new GenericType<ResponseList>() {  };
        ResponseList litt = postResponse.readEntity(genericType);
        list = litt.getList();
        model.updateList(this.list);
        getContentPane();
        this.table.updateUI();
    }

    private void addContent(){
        AddFrame frame = new AddFrame(this);
    }

    private void changeContent(){
        ChangeFrame frame = new ChangeFrame(this);
    }

    private void deleteContent(){
        DelFrame frame = new DelFrame(this);
    }

    public Client getClient(){
        return this.client;
    }

    public List<String> getList(){
        return this.list;
    }

    public int getColumns(){
        return this.columns;
    }
}
