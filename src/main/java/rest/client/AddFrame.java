package rest.client;


import test.web.rest.ResponseList;

import javax.swing.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by smile on 15-Mar-16.
 */
public class AddFrame extends JFrame {

    private JTextField name;
    private JTextField surname;
    private JTextField fathername;
    private JTextField birthdate;
    private JTextField form;
    private JTextField phone;
    private MainWindow window;

    public AddFrame(MainWindow window){
        this.window = window;
        this.setSize(400,430);
        this.setLocation(450,150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Add student");
        name = new JTextField("", 20);
        JLabel namel = new JLabel("Name");
        surname = new JTextField("", 20);
        JLabel surnamel = new JLabel("Surname");
        fathername = new JTextField("", 20);
        JLabel fathernamel = new JLabel("FatherName");
        birthdate  = new JTextField("", 20);
        JLabel birthdatel = new JLabel("Birth Date (YY.MM.DD)");
        form = new JTextField("", 20);
        JLabel forml = new JLabel("Form");
        phone = new JTextField("", 20);
        JLabel phonel = new JLabel("Phone");
        namel.setBounds(180,10,70,20);
        name.setBounds(100,30,200, 25);
        surnamel.setBounds(170,60,70,20);
        surname.setBounds(100,80,200, 25);
        fathernamel.setBounds(165,110,70,20);
        fathername.setBounds(100,130,200, 25);
        birthdatel.setBounds(140,160,150,20);
        birthdate.setBounds(100,180,200, 25);
        forml.setBounds(185,210,70,20);
        form.setBounds(100, 230, 200, 25);
        phonel.setBounds(185,260,70,20);
        phone.setBounds(100, 280, 200, 25);
        this.add(namel);
        this.add(name);
        this.add(surnamel);
        this.add(surname);
        this.add(fathernamel);
        this.add(fathername);
        this.add(birthdatel);
        this.add(birthdate);
        this.add(forml);
        this.add(form);
        this.add(phonel);
        this.add(phone);
        JButton button = new JButton("Submit");
        button.setBounds(150, 350, 100,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateSubmit();
            }
        });
        this.add(button);
        this.setVisible(true);
    }

    private void validateSubmit(){
        List<String>listContent = new ArrayList<String>();
        if((!(this.name.getText().equals(""))) && (!(this.surname.getText().equals("")))
                && (!(this.fathername.getText().equals(""))) && (!(this.birthdate.getText().equals("")))
                && (!(this.form.getText().equals(""))) && (!(this.phone.getText().equals("")))){
            listContent.add(this.name.getText());
            listContent.add(this.surname.getText());
            listContent.add(this.fathername.getText());
            listContent.add(this.birthdate.getText());
            listContent.add(this.form.getText());
            listContent.add(this.phone.getText());
            WebTarget webResource = window.getClient()
                    .target("http://localhost:8080/resttest-1.0-SNAPSHOT/students/post");
            Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON + ";charset=utf-8");
            ResponseList rl = new ResponseList();
            rl.setList(listContent);
            Response postResponse = invocationBuilder.post(Entity.entity(rl,MediaType.APPLICATION_JSON + ";charset=utf-8"));
            window.updateContent();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Incorect input");
        }
    }
}
