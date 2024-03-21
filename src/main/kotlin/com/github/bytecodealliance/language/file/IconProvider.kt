package com.github.bytecodealliance.language.file

import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon

class IconProvider : com.intellij.ide.IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val fileName = psiElement.containingFile.name

        return when {
            fileName.endsWith(".wit") -> FILE
            else -> null
        }
    }

    companion object {
        val FILE = IconLoader.getIcon("/icons/wit.svg", IconProvider::class.java)
    }
}