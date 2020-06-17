package actions;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import highlight.*;
import org.jetbrains.annotations.NotNull;
import org.suikasoft.jOptions.Interfaces.DataStore;
import pt.up.fe.specs.intellij.psiweaver.PsiWeaver;
import pt.up.fe.specs.util.providers.ResourceProvider;


public class launchPlugin extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {


        PsiFile rootFile = e.getData(LangDataKeys.PSI_FILE);



        Project currentProject = e.getProject();
        PsiDocumentManager psiDocumentManager = PsiDocumentManager.getInstance(currentProject);
        Document document = psiDocumentManager.getDocument(rootFile);
        if (rootFile == null) {
            Messages.showMessageDialog(currentProject, "No file selected!",
                    "PsiWeaver Execution", Messages.getErrorIcon());
            return;
        }

        ResourceProvider laraFile = () -> "lara/Test.lara";
        DataStore results = PsiWeaver.run(rootFile, laraFile.read());

        Messages.showMessageDialog(currentProject, "Lara results:\n" + results,
                "LARA Execution", Messages.getInformationIcon());

        //create anotators & holder
        Anotatora aa = new Anotatora();
        Anotatorb ab = new Anotatorb();
        Anotatorc ac = new Anotatorc();
        Anotatord ad = new Anotatord();
        AnnotationHolder holder = null;


        PsiElement[] pe = rootFile.getChildren();
        int a = 0;
        for (int i = 0; i == pe.length; i++) {
            int textOffset = pe[i].getTextOffset();
            int lineNumber = document.getLineNumber(textOffset);
            switch (a) {
                case 0:
                    GroupNoti.createNotificationa(lineNumber, currentProject);
                    aa.annotate(pe[i], holder);
                case 1:
                    GroupNoti.createNotificationb(lineNumber, currentProject);
                    ab.annotate(pe[i], holder);
                case 2:
                    GroupNoti.createNotificationc(lineNumber, currentProject);
                    ac.annotate(pe[i], holder);
                case 3:
                    GroupNoti.createNotificationd(lineNumber, currentProject);
                    ad.annotate(pe[i], holder);
                default:
                    GroupNoti.createNotificationNo(currentProject); //this one finished auto-disappears
            }
        }
    }
}
