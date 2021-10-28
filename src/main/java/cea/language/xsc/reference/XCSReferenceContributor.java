package cea.language.xsc.reference;

import cea.language.xsc.psi.XCSProperty_;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;


public class XCSReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(XCSProperty_.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        XCSProperty_ e = (XCSProperty_) element;
                        if (!e.getProp().equals("VfeiName")){
                            return PsiReference.EMPTY_ARRAY;
                        }
                        return new PsiReference[]{new XCSReference(e,
                                new TextRange(e.getText().length()-e.getValue().length(),e.getText().length()),
                                e.getReferenceType())};
                    }
                });
    }

}