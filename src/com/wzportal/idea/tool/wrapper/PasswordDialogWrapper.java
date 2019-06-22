package com.wzportal.idea.tool.wrapper;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.wzportal.idea.tool.form.PasswordForm;
import com.wzportal.idea.tool.util.RandomUtil;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordDialogWrapper extends DialogWrapper {

    public PasswordDialogWrapper() {
        super(true); // use current window as parent
        init();
        setTitle("Random Password Generator");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        PasswordForm passwordForm = new PasswordForm();

        // 下拉框赋值，默认选择第二个
        JComboBox lengthBox = passwordForm.getComboBox1();
        lengthBox.addItem("8");
        lengthBox.addItem("16");
        lengthBox.addItem("24");
        lengthBox.addItem("32");
        lengthBox.setSelectedIndex(1);

        JButton okButton = passwordForm.getButton1();
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBox upperBox = passwordForm.getCheckBox1();
                JCheckBox lowerBox = passwordForm.getCheckBox2();
                JCheckBox numBox = passwordForm.getCheckBox3();
                JCheckBox specialBox = passwordForm.getCheckBox4();

                JTextField resultField = passwordForm.getTextField1();
                resultField.setText(RandomUtil.random(upperBox.isSelected(), lowerBox.isSelected(), numBox.isSelected(), specialBox.isSelected(), Integer.parseInt(lengthBox.getSelectedItem().toString())));
                resultField.repaint();
            }
        });

        JButton copyButton = passwordForm.getButton2();
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField resultField = passwordForm.getTextField1();
                String text = resultField.getText();
                if (null == text || text.trim().isEmpty()) {
                    return;
                }
                resultField.setSelectionStart(0);
                resultField.setSelectionEnd(text.length());
                resultField.copy();
                resultField.repaint();
            }
        });

        JButton aboutButton = passwordForm.getAboutButton();
        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Messages.showMessageDialog("By Wenzheng Jiang, please visit the web site www.wzportal.com for more info.", "Thank you for using it", Messages.getInformationIcon());
            }
        });

        return passwordForm.getPanel1();
    }
}
