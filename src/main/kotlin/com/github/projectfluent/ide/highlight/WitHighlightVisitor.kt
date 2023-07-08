package com.github.projectfluent.ide.highlight


import com.github.projectfluent.ide.highlight.WitHighlightColor.*
import com.github.projectfluent.language.file.FluentFile
import com.github.projectfluent.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class WitHighlightVisitor : WitVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitUseItems(o: FluentUseItems) {
        o.identifierList.forEach { highlight(it, SYM_TYPE) }
    }

    override fun visitImport(o: FluentImport) {
        super.visitImport(o)
    }

    override fun visitResource(o: FluentResource) {
        o.identifier?.let { highlight(it, SYM_TYPE) }
    }

    override fun visitRecord(o: FluentRecord) {
        o.identifier?.let { highlight(it, SYM_TYPE) }
    }

    override fun visitRecordField(o: FluentRecordField) {
        highlight(o.identifier, SYM_FIELD)
    }


    override fun visitFunction(o: FluentFunction) {
        highlight(o.identifier, SYM_FUNCTION)
    }

    override fun visitFunctionSignature(o: FluentFunctionSignature) {
        o.identifier?.let { highlight(it, KEYWORD) }
    }

    override fun visitParameter(o: FluentParameter) {
        highlight(o.identifier, SYM_FIELD)
    }

    override fun visitType(o: FluentType) {
        super.visitType(o)
    }

    override fun visitTypeHint(o: FluentTypeHint) {
        when (o.identifier.text) {
            "_", "bool",
            "u8", "u16", "u32", "u64",
            "s8", "s16", "s32", "s64",
            "f32", "f64", "float32", "float64",
            -> {
                highlight(o.identifier, KEYWORD)
            }
            "list", "string",
            "option", "result",
            "borrow", "own",
            -> {
                highlight(o.identifier, SYM_BUILTIN)
            }

            else -> {
                highlight(o.identifier, SYM_TYPE)
            }
        }
    }

    override fun visitInterfaceName(o: FluentInterfaceName) {
        highlight(o, SYM_INTERFACE)
    }

//    override fun visitSchemaStatement(o: JssSchemaStatement) {
//        //
//        val head = o.firstChild;
//        highlight(head, FluentColor.KEYWORD)
//        //
//        val prop = head.nextLeaf { it.elementType == JssTypes.SYMBOL }!!
//        highlight(prop, FluentColor.SYM_SCHEMA)
//
//        super.visitSchemaStatement(o)
//    }


    private fun highlight(element: PsiElement, color: WitHighlightColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    override fun clone(): HighlightVisitor = WitHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is FluentFile

    override fun visit(element: PsiElement) = element.accept(this)
}