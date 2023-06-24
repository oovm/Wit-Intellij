// This is a generated file. Not intended for manual editing.
package com.github.projectfluent.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.projectfluent.language.psi.FluentTypes.*;
import com.github.projectfluent.language.psi.FluentElement;
import com.github.projectfluent.language.psi.*;

public class FluentTermReferenceNode extends FluentElement implements FluentTermReference {

  public FluentTermReferenceNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FluentVisitor visitor) {
    visitor.visitTermReference(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FluentVisitor) accept((FluentVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FluentCallArguments getCallArguments() {
    return findChildByClass(FluentCallArguments.class);
  }

  @Override
  @NotNull
  public FluentTermID getTermID() {
    return findNotNullChildByClass(FluentTermID.class);
  }

}
