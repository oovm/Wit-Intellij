// This is a generated file. Not intended for manual editing.
package com.github.projectfluent.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.projectfluent.language.psi.WitTypes.*;
import com.github.projectfluent.language.mixin.MixinField;
import com.github.projectfluent.language.psi.*;

public class WitRecordFieldNode extends MixinField implements WitRecordField {

  public WitRecordFieldNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WitVisitor visitor) {
    visitor.visitRecordField(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WitVisitor) accept((WitVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public WitIdentifier getIdentifier() {
    return findNotNullChildByClass(WitIdentifier.class);
  }

  @Override
  @NotNull
  public WitTypeHint getTypeHint() {
    return findNotNullChildByClass(WitTypeHint.class);
  }

}