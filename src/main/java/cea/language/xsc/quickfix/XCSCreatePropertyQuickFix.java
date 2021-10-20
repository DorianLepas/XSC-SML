package cea.language.xsc.quickfix;

import cea.language.xsc.filetype.XCSFileType;
import cea.language.xsc.psi.*;
import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class XCSCreatePropertyQuickFix extends BaseIntentionAction {

    private final String key;
    private final PsiElement element;

    public XCSCreatePropertyQuickFix(String key, PsiElement element) {
        this.key = key;
        this.element = element;
    }

    @NotNull
    @Override
    public String getText() {
        return "Create property '" + key + "'";
    }

    @NotNull
    @Override
    public String getFamilyName() {
        return "Create property";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return true;
    }

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws
            IncorrectOperationException {
        ApplicationManager.getApplication().invokeLater(() -> {
            Collection<VirtualFile> virtualFiles =
                    FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
            if (virtualFiles.size() == 1) {
                createProperty(project, virtualFiles.iterator().next());
            } else {
                final FileChooserDescriptor descriptor =
                        FileChooserDescriptorFactory.createSingleFileDescriptor(XCSFileType.INSTANCE);
                descriptor.setRoots(ProjectUtil.guessProjectDir(project));
                final VirtualFile file1 = FileChooser.chooseFile(descriptor, project, null);
                if (file1 != null) {
                    createProperty(project, file1);
                }
            }
        });
    }

    private String getType() {
        PsiElement valueNode = element.getNode().getPsi().getParent();
        valueNode = valueNode.getPrevSibling();
        while (!valueNode.getText().equals("<")) {
            if (valueNode.getText().equals("CEID") || valueNode.getText().equals("DVID") || valueNode.getText().equals("ECID") || valueNode.getText().equals("SVID")) {
                return valueNode.getText();
            }
            valueNode = valueNode.getPrevSibling();
        }
        return "";
    }

    private void createProperty(final Project project, final VirtualFile file) {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            ASTNode lastChildNode = null;
            VirtualFile dir = (VirtualFile) PsiManager.getInstance(project).findFile(file).getContainingDirectory().getVirtualFile();
            String section = getType();
            if(section.equals("CEID")) {
                XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findDirectory(dir).findFile("collection_event.xsc");
                ASTNode @NotNull [] children = xcsFile.getNode().getChildren(TokenSet.ANY);
                for (ASTNode child : children) {
                    if (child.getFirstChildNode() != null) {
                        if (child.getFirstChildNode().getElementType().equals(XCSTypes.COLLECTION_EVENT)) {
                            if (child.getPsi().getChildren()[0].getChildren().length != 0) {
                                lastChildNode = child.getPsi().getChildren()[0].getChildren()[child.getPsi().getChildren()[0].getChildren().length - 1].getNode();
                            } else {
                                return;
                            }
                        }
                    }
                }
                if (lastChildNode != null) {
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                }
                lastChildNode = XCSElementFactory.createPropertyCe(lastChildNode, "VfeiName", key);
            }
            if(section.equals("SVID")) {
                XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findDirectory(dir).findFile("status_variables.xsc");
                ASTNode @NotNull [] children = xcsFile.getNode().getChildren(TokenSet.ANY);
                for (ASTNode child : children) {
                    if (child.getFirstChildNode() != null) {
                        if (child.getFirstChildNode().getElementType().equals(XCSTypes.STATUS_VARIABLE)) {
                            if (child.getPsi().getChildren()[0].getChildren().length != 0) {
                                lastChildNode = child.getPsi().getChildren()[0].getChildren()[child.getPsi().getChildren()[0].getChildren().length - 1].getNode();
                            } else {
                                return;
                            }
                        }
                    }
                }
                if (lastChildNode != null) {
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                }
                lastChildNode = XCSElementFactory.createPropertySv(lastChildNode, "VfeiName", key);
            }
            if(section.equals("ECID")) {
                XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findDirectory(dir).findFile("equipment_constants.xsc");
                ASTNode @NotNull [] children = xcsFile.getNode().getChildren(TokenSet.ANY);
                for (ASTNode child : children) {
                    if (child.getFirstChildNode() != null) {
                        if (child.getFirstChildNode().getElementType().equals(XCSTypes.EQUIPMENT_CONSTANT)) {
                            if (child.getPsi().getChildren()[0].getChildren().length != 0) {
                                lastChildNode = child.getPsi().getChildren()[0].getChildren()[child.getPsi().getChildren()[0].getChildren().length - 1].getNode();
                            } else {
                                return;
                            }
                        }
                    }
                }
                if (lastChildNode != null) {
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                }
                lastChildNode = XCSElementFactory.createPropertyEc(lastChildNode, "VfeiName", key);
            }
            if(section.equals("DVID")) {
                XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findDirectory(dir).findFile("data_variables.xsc");
                ASTNode @NotNull [] children = xcsFile.getNode().getChildren(TokenSet.ANY);
                for (ASTNode child : children) {
                    if (child.getFirstChildNode() != null) {
                        if (child.getFirstChildNode().getElementType().equals(XCSTypes.DATA_VARIABLE)) {
                            if (child.getPsi().getChildren()[0].getChildren().length != 0) {
                                lastChildNode = child.getPsi().getChildren()[0].getChildren()[child.getPsi().getChildren()[0].getChildren().length - 1].getNode();
                            } else {
                                return;
                            }
                        }
                    }
                }
                if (lastChildNode != null) {
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                }
                lastChildNode = XCSElementFactory.createPropertyDv(lastChildNode, "VfeiName", key);
            }
            ((Navigatable) lastChildNode.getTreeNext().getPsi().getNavigationElement()).navigate(true);
            FileEditorManager.getInstance(project).getSelectedTextEditor().getCaretModel().moveCaretRelatively(2, 0, false, false, false);
        });
    }

}
