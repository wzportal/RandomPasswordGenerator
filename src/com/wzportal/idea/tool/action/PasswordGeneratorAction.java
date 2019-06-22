package com.wzportal.idea.tool.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wzportal.idea.tool.wrapper.PasswordDialogWrapper;

/**
 * @author Wenzheng Jiang
 */
public class PasswordGeneratorAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        PasswordDialogWrapper pdw = new PasswordDialogWrapper();
        pdw.setResizable(true);
        pdw.show();
    }
}
