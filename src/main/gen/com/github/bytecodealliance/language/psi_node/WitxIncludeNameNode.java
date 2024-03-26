// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.bytecodealliance.language.psi.WitxTypes.*;
import com.github.bytecodealliance.language.psi.WitElement;
import com.github.bytecodealliance.language.psi.*;

public class WitxIncludeNameNode extends WitElement implements WitxIncludeName {

  public WitxIncludeNameNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WitxVisitor visitor) {
    visitor.visitIncludeName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WitxVisitor) accept((WitxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WitxIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WitxIdentifier.class);
  }

  @Override
  @NotNull
  public WitxInterfaceName getInterfaceName() {
    return findNotNullChildByClass(WitxInterfaceName.class);
  }

}
