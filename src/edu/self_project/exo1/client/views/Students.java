package edu.self_project.exo1.client.views;

import edu.self_project.exo1.client.Client;
import edu.self_project.exo1.communication.Communication;
import edu.self_project.exo1.communication.ERequestType;
import edu.self_project.exo1.communication.ETarget;
import edu.self_project.exo1.server.model.Entities.Student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Students extends JFrame implements ListSelectionListener, ActionListener {
    private List<Student> students;

    private JFrame window = new JFrame();
    JList<String> names;
    JScrollPane namesList;
    JLabel select;
    JTextArea selected;
    JButton test;

    public Students() {
        setStudents();
        setJLabels();
        setJTextAreas();
        setJButtons();
        setJLists();
        setWindow();

    }

    private void setStudents() {
        try {
            students = (List<Student>) (new Client()).request(
                    new Communication(ERequestType.READ, ETarget.STUDENT, null, true)
            ).getContent();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    private void setJLabels() {
        select = new JLabel("Selected");
        select.setBounds(20, 230, 50, 20);
        select.setBackground(Color.WHITE);
    }

    private void setJTextAreas() {
        selected = new JTextArea();
        selected.setBounds(20, 250, 50, 20);
        selected.setBackground(Color.ORANGE);
    }

    private void setJButtons() {
        test = new JButton("test");
        test.setBounds(200, 0, 100, 50);
        test.addActionListener(this);
    }


    private void setJLists() {
        names = setNamesJList();
        names.setPreferredSize(new Dimension(200, 100));
        names.setBackground(Color.YELLOW);
        names.addListSelectionListener(this);
        namesList = new JScrollPane(null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        namesList.setViewportView(names);
        namesList.setBounds(0, 0, 100, 200);
    }

    private JList setNamesJList() {
        List<String> namesList = new ArrayList<>();
        for (Student s : students) namesList.add(s.getName());
        return new JList(namesList.toArray());
    }

    private void setWindow() {
        window.setBounds(500, 200, 1000, 800);
        window.setVisible(true);
        window.setLayout(null);
        window.add(selected);
        window.add(select);
        window.add(test);
        window.add(namesList);
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && e.getSource().equals(names)) {
            System.out.println(names.getSelectedValue());
            selected.setText(names.getSelectedValue());
            window.revalidate();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(test)) System.out.println("test");
    }
}
