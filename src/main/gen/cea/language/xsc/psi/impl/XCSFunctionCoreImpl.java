// This is a generated file. Not intended for manual editing.
package cea.language.xsc.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static cea.language.xsc.psi.XCSTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import cea.language.xsc.psi.*;

public class XCSFunctionCoreImpl extends ASTWrapperPsiElement implements XCSFunctionCore {

  public XCSFunctionCoreImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull XCSVisitor visitor) {
    visitor.visitFunctionCore(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof XCSVisitor) accept((XCSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<XCSFunctionCore> getFunctionCoreList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, XCSFunctionCore.class);
  }

  @Override
  @Nullable
  public XCSProperty getProperty() {
    return findChildByClass(XCSProperty.class);
  }

}
