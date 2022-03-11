package com.github.suxin1.pont

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.components.JBLabel
import com.intellij.uiDesigner.core.AbstractLayout
import com.intellij.util.ui.GridBag
import com.intellij.util.ui.JBUI
import com.intellij.util.ui.UIUtil
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextField

class MyDialog(val project: Project) : DialogWrapper(true) {
    private val firstName: JTextField = JTextField()
    private val lastName: JTextField = JTextField()

    val centerPanel: JPanel = JPanel(GridBagLayout())

    init {
        init()
        title = "输入你的名字"
    }

    override fun createCenterPanel(): JComponent? {
        val gridBag = GridBag()
                .setDefaultWeightX(1.0)
                .setDefaultFill(GridBagConstraints.HORIZONTAL)
                .setDefaultInsets(Insets(0, 0, AbstractLayout.DEFAULT_VGAP, AbstractLayout.DEFAULT_HGAP))
        centerPanel.preferredSize = Dimension(400, 50)
        centerPanel.add(getLabel("First Name: "), gridBag.nextLine().next().weightx(0.2))
        centerPanel.add(firstName, gridBag.next().weightx(0.8))

        centerPanel.add(getLabel("Last Name: "), gridBag.nextLine().next().weightx(0.2))
        centerPanel.add(lastName, gridBag.next().weightx(0.8))

        return centerPanel
    }

    private fun getLabel(text: String): JComponent {
        val label = JBLabel(text)
        label.componentStyle = UIUtil.ComponentStyle.SMALL
        label.fontColor = UIUtil.FontColor.BRIGHTER
        label.border = JBUI.Borders.empty(0, 5, 2, 0)
        return label
    }

    override fun doOKAction() {
        if(firstName.text.isNullOrEmpty()) {
            NotificationManager.createAndShowNotification(project, "First Name 不能为空")
            return
        }
        if(lastName.text.isNullOrEmpty()) {
            NotificationManager.createAndShowNotification(project, "Last Name 不能为空")
            return
        }
        NotificationManager.createAndShowNotification(project, "欢迎使用 suxin 的插件 ${firstName.text}, ${lastName.text}")
        super.doOKAction()
    }

    override fun doCancelAction() {
        NotificationManager.createAndShowNotification(project, "你取消了")
        super.doCancelAction()
    }
}