// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.bytecodealliance.language.psi.WitxTypes.*;
import com.github.bytecodealliance.language.mixin.MixinFlags;
import com.github.bytecodealliance.language.psi.*;

public class WitxFlagsNode extends MixinFlags implements WitxFlags {

  public WitxFlagsNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WitxVisitor visitor) {
    visitor.visitFlags(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WitxVisitor) accept((WitxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WitxIdentifier getIdentifier() {
    return findChildByClass(WitxIdentifier.class);
  }

  @Override
  @NotNull
  public List<WitxSemanticNumber> getSemanticNumberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WitxSemanticNumber.class);
  }

}
