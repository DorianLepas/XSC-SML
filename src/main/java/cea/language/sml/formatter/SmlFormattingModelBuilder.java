package cea.language.sml.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.tree.TokenSet;
import cea.language.sml.fileType.SmlLanguage;
import cea.language.sml.parser.SmlParserDefinition;
import cea.language.sml.psi.SmlTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SmlFormattingModelBuilder implements FormattingModelBuilder
{
  // Inner classes

  // Instance fields

  // Static code

  // Constructors

  // Methods
  private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
    return new SpacingBuilder(settings, SmlLanguage.INSTANCE)

            /* Pas d'espace autour des . et : */
            .around(SmlTypes.DOT_SEPARATOR).none()
            .around(SmlTypes.SEPARATOR).spaces(0)
            /* Espace avant et après les seprateur */
            .around(SmlTypes.EQUALS_SEPARATOR).spaces(1)
            .around(SmlTypes.TRACE_MESSAGE_SEPARATOR).spaces(1)
            .around(SmlTypes.COMP_CONDS).spaces(1)
            .around(SmlTypes.OP_CONDS).spaces(1)
            /* Espaces entre un début de bloc et n'importe quel type de tokens */
            .between(TokenSet.ANY, SmlTypes.BEGIN_BLOCK)
            .spaces(1)
            /* Espaces entres les noms d'événements et les séparateurs de noms d'événements
            * dans une définition d'événements */
            .between(SmlTypes.EVENT_NAME, SmlTypes.EVENT_NAME_SEPARATOR)
            .spaces(0)
            .between(SmlTypes.EVENT_NAME_SEPARATOR, SmlTypes.EVENT_NAME)
            .spaces(1)
            /* Espaces pour un bloc */
            .before(SmlParserDefinition.BLOCKS)
            .blankLines(1)
            /* Espaces pour une instruction */
            .around(SmlParserDefinition.INSTRUCTIONS)
            .lineBreakInCode()
            .before(SmlParserDefinition.INSTRUCTIONS)
            .spaces(0)
            /* Espaces pour les conditions */
            .after(SmlTypes.CONDITIONS)
            .lineBreakInCode()
            .after(SmlTypes.BEGIN_PARENTHESE)
            .spaces(0)
            .before(SmlTypes.END_PARENTHESE)
            .spaces(0)
            /* Espaces pour les liens */
            .after(SmlTypes.BIND)
            .lineBreakInCode();
  }

  @NotNull
  @Override
  public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
    return FormattingModelProvider
            .createFormattingModelForPsiFile(element.getContainingFile(),
                    new SmlBlock(element.getNode(),
                            Wrap.createWrap(WrapType.NONE, false),
                            Alignment.createAlignment(),
                            createSpaceBuilder(settings)),
                    settings);
  }

  @Nullable
  @Override
  public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
    return null;
  }
}
