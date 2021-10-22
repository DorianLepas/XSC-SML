package cea.language.xsc.completion;

import cea.language.xsc.filetype.XCSIcons;
import cea.language.xsc.filetype.XCSLanguage;
import cea.language.xsc.psi.XCSProperty_;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import cea.language.xsc.psi.XCSTypes;
import org.jetbrains.annotations.NotNull;


public class XCSCompletionContributor extends CompletionContributor {

    public XCSCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf("{"),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("AllowedSecsItemValues"));
                        resultSet.addElement(LookupElementBuilder.create("CheckAck"));
                        resultSet.addElement(LookupElementBuilder.create("Disabled"));
                        resultSet.addElement(LookupElementBuilder.create("EventLevel8"));
                        resultSet.addElement(LookupElementBuilder.create("IsTemplate"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceItems"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceVfeiName"));
                        resultSet.addElement(LookupElementBuilder.create("ReplyMatch"));
                        resultSet.addElement(LookupElementBuilder.create("ReuseProperties"));
                        resultSet.addElement(LookupElementBuilder.create("ReusePropertiesNoArrays"));
                        resultSet.addElement(LookupElementBuilder.create("SecsItemsToCheck"));
                        resultSet.addElement(LookupElementBuilder.create("SecsName"));
                        resultSet.addElement(LookupElementBuilder.create("SecsType"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValue"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueAlignment"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueToVfeiText"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueWidth"));
                        resultSet.addElement(LookupElementBuilder.create("SendAsList"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiName"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiNameTemplateNames"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiQualifier"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiType"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiValue"));
                        resultSet.addElement(LookupElementBuilder.create("WrapInList"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.PROPERTY_VALUE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("AllowedSecsItemValues"));
                        resultSet.addElement(LookupElementBuilder.create("CheckAck"));
                        resultSet.addElement(LookupElementBuilder.create("Disabled"));
                        resultSet.addElement(LookupElementBuilder.create("EventLevel8"));
                        resultSet.addElement(LookupElementBuilder.create("IsTemplate"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceItems"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceVfeiName"));
                        resultSet.addElement(LookupElementBuilder.create("ReplyMatch"));
                        resultSet.addElement(LookupElementBuilder.create("ReuseProperties"));
                        resultSet.addElement(LookupElementBuilder.create("ReusePropertiesNoArrays"));
                        resultSet.addElement(LookupElementBuilder.create("SecsItemsToCheck"));
                        resultSet.addElement(LookupElementBuilder.create("SecsName"));
                        resultSet.addElement(LookupElementBuilder.create("SecsType"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValue"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueAlignment"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueToVfeiText"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueWidth"));
                        resultSet.addElement(LookupElementBuilder.create("SendAsList"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiName"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiNameTemplateNames"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiQualifier"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiType"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiValue"));
                        resultSet.addElement(LookupElementBuilder.create("WrapInList"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(XCSTypes.FUNCTION_NAME).afterSibling(PlatformPatterns.psiElement().whitespace()),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("COLLECTIONEVENT_VARIABLES:\n<L\n>\n.")
                                .withPresentableText("COLLECTIONEVENT_VARIABLES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("EQUIPMENTCONSTANTS:\n<L\n>\n.")
                                .withPresentableText("EQUIPMENTCONSTANTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("EVENTS:\n<L\n>\n.")
                                .withPresentableText("EVENTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("FORMATTED_RECIPES:\n<L\n>\n.")
                                .withPresentableText("FORMATTED_RECIPES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("OVERWRITTEN_SECS_STANDARD_MESSAGES:\n<L\n>\n.")
                                .withPresentableText("OVERWRITTEN_SECS_STANDARD_MESSAGES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("POLLING_EVENT_DEFINITIONS:\n<L\n>\n.")
                                .withPresentableText("POLLING_EVENT_DEFINITIONS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("PREDEFINED_FORMATTED_STATUS_LISTS:\n<L\n>\n.")
                                .withPresentableText("PREDEFINED_FORMATTED_STATUS_LISTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("PREDEFINED_UNIQUE_CEID_REPORTS:\n<L\n>\n.")
                                .withPresentableText("PREDEFINED_UNIQUE_CEID_REPORTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("PREDEFINED_UNIQUE_REPORT_ID_REPORTS:\n<L\n>\n.")
                                .withPresentableText("PREDEFINED_UNIQUE_REPORT_ID_REPORTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("REMOTE_COMMANDS:\n<L\n>\n.")
                                .withPresentableText("REMOTE_COMMANDS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("SCENARIOS:\n<L\n>\n.")
                                .withPresentableText("SCENARIOS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("SECSIEM_TYPES:\n<L\n>\n.")
                                .withPresentableText("SECSIEM_TYPES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("SECSVALUE_TO_VFEITEXTVALUE_VARIABLES:\n<L\n>\n.")
                                .withPresentableText("SECSVALUE_TO_VFEITEXTVALUE_VARIABLES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("STATUSVARIABLES:\n<L\n>\n.")
                                .withPresentableText("STATUSVARIABLES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("TRACE_DEFINITIONS:\n<L\n>\n.")
                                .withPresentableText("TRACE_DEFINITIONS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("VFEI_SECS_SEQUENCES:\n<L\n>\n.")
                                .withPresentableText("VFEI_SECS_SEQUENCES")
                                .withTypeText("Standart Section"));
                    }
                }
        );


        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.CORE_START)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("F4"));
                        resultSet.addElement(LookupElementBuilder.create("F8"));
                        resultSet.addElement(LookupElementBuilder.create("I1"));
                        resultSet.addElement(LookupElementBuilder.create("I2"));
                        resultSet.addElement(LookupElementBuilder.create("I4"));
                        resultSet.addElement(LookupElementBuilder.create("I8"));
                        resultSet.addElement(LookupElementBuilder.create("U1"));
                        resultSet.addElement(LookupElementBuilder.create("U2"));
                        resultSet.addElement(LookupElementBuilder.create("U4"));
                        resultSet.addElement(LookupElementBuilder.create("U8"));
                        //resultSet.addElement(LookupElementBuilder.create("Boolean"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.ASCII_TYPE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("CEID"));
                        resultSet.addElement(LookupElementBuilder.create("DVID"));
                        resultSet.addElement(LookupElementBuilder.create("ECID"));
                        resultSet.addElement(LookupElementBuilder.create("INITIALIZE"));
                        resultSet.addElement(LookupElementBuilder.create("SVID"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.VARIABLE_TYPE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("CEID"));
                        resultSet.addElement(LookupElementBuilder.create("DVID"));
                        resultSet.addElement(LookupElementBuilder.create("ECID"));
                        resultSet.addElement(LookupElementBuilder.create("INITIALIZE"));
                        resultSet.addElement(LookupElementBuilder.create("SVID"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement().withLanguage(XCSLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement element = parameters.getOriginalPosition();
                        if ( element.getNode() != null &&
                                element.getNode().getElementType().toString().equals("XCSTokenType.PROPERTY_VALUE") &&
                                element.getNode().getTreeParent().getElementType().toString().equals("PROPERTY_")){
                            XCSProperty_ e = (XCSProperty_) element.getNode().getTreeParent().getPsi();
                            Object[] result = new LookupElement[0];
                            result = e.getReference().getVariants();
                            for (Object LUElement : result){
                                resultSet.addElement((LookupElement) LUElement);
                            }
                        }
                    }
                }
        );
    }
}