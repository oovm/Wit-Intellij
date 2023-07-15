// This is a generated file. Not intended for manual editing.
package com.github.projectfluent.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.projectfluent.language.psi.WitTypes.*;
import com.github.projectfluent.language.psi.WitElement;
import com.github.projectfluent.language.psi.*;

public class WitFunctionSignatureNode extends WitElement implements WitFunctionSignature {

  public WitFunctionSignatureNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WitVisitor visitor) {
    visitor.visitFunctionSignature(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WitVisitor) accept((WitVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WitIdentifier getIdentifier() {
    return findChildByClass(WitIdentifier.class);
  }

  @Override
  @NotNull
  public List<WitParameter> getParameterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WitParameter.class);
  }

  @Override
  @Nullable
  public WitTypeHint getTypeHint() {
    return findChildByClass(WitTypeHint.class);
  }

}