package com.github.bytecodealliance

import com.intellij.lang.Language

object WitxLanguage : Language("witx") {
    private fun readResolve(): Any = WitxLanguage
}