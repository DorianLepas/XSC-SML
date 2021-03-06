package cea.language.sml.psi;

import cea.language.sml.fileType.SmlLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SmlElementType extends IElementType
{
  // Inner classes

  // Instance fields

  // Static code

  // Constructors
  public SmlElementType(@NotNull @NonNls String debugName) {
    super(debugName, SmlLanguage.INSTANCE);
  }

  // Methods
}
