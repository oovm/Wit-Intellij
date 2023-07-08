package com.github.projectfluent.ide.highlight


import com.github.projectfluent.language.psi.FluentLexerAdapter
import com.github.projectfluent.language.psi.FluentTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class FluentSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return FluentLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): FluentHighlightColor? {
        return when (tokenType) {
            //
            // AS, SCHEMA, PROP -> JssColor.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            //
            KW_PACKAGE, KW_WORLD, KW_INTERFACE,
            KW_INCLUDE, KW_USE, KW_IMPORT, KW_EXPORT,
            KW_TYPE, KW_RESOURCE, KW_RECORD, KW_FUNCTION,
            -> FluentHighlightColor.KEYWORD

            PARENTHESIS_L, PARENTHESIS_R -> FluentHighlightColor.PARENTHESES
            BRACKET_L, BRACKET_R -> FluentHighlightColor.BRACKETS
            BRACE_L, BRACE_R -> FluentHighlightColor.BRACES
            COLON, EQ -> FluentHighlightColor.SET
            STAR -> FluentHighlightColor.STAR
            COMMA -> FluentHighlightColor.COMMA
            // atom
            INTEGER -> FluentHighlightColor.INTEGER
            DECIMAL -> FluentHighlightColor.DECIMAL

            TEXT_LINE, SELECTION_LINE -> FluentHighlightColor.TEXT
            STRING_QUOTE, STRING_CHAR -> FluentHighlightColor.STRING
            STRING_ESCAPE -> FluentHighlightColor.STRING_ESCAPED
//            STRING -> AwslColor.STRING
            SYMBOL -> FluentHighlightColor.IDENTIFIER
            // 注释
            COMMENT_LINE -> FluentHighlightColor.LINE_COMMENT
            COMMENT_BLOCK -> FluentHighlightColor.BLOCK_COMMENT
            COMMENT_DOCUMENT -> FluentHighlightColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> FluentHighlightColor.BAD_CHARACTER
            else -> null
        }
    }
}
