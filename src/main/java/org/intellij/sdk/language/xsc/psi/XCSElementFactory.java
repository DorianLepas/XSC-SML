package org.intellij.sdk.language.xsc.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import org.intellij.sdk.language.xsc.filetype.XCSFileType;

public class XCSElementFactory {

    public static XCSProperty_ createProperty(Project project, String name) {
        System.out.println("JE PASSE DANS XCSElementFactory");
        final XCSFile file = createFile(project, name);
        return (XCSProperty_) file.findChildByClass(XCSProperty_.class);
    }

    public static XCSFile createFile(Project project, String text) {
        System.out.println("JE PASSE DANS XCSElementFactory");
        String name = "dummy.xsc";
        return (XCSFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, XCSFileType.INSTANCE, text);
    }

}