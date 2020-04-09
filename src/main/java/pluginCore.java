import com.intellij.lang.FileASTNode;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiElementProcessor;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.util.PsiUtilCore;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.project.Project;

import net.sf.cglib.asm.$ClassWriter;
import org.lara.interpreter.weaver.generator.commandline.WeaverGenerator;
import plugin_psi_weaver.PsiWeaver;
import pt.up.fe.specs.lara.WeaverLauncher;

import javax.swing.*;

public class pluginCore {

    static private Project project;

    private pluginCore(@NotNull final Project proj) {
        this.project = proj;
    }
    public static void main(String[] args){
        //get psi file
        Document currentDoc = FileEditorManager.getInstance(project).getSelectedTextEditor().getDocument();
        PsiFile pfile = PsiDocumentManager.getInstance(project).getPsiFile(currentDoc);
        //launch weaver
        new WeaverLauncher(new PsiWeaver(pfile/* PsiFile target that programmer is using */).launch(args));
    }





    /* ver no main os argumentos do import (generator - messenger)
    // ver os xml do weaver generator
    WeaverGenerator w = new WeaverGenerator();

    public WeaverGenerator getW() {
        return w;
    }


    // psifiles - ver como percorrer ast e alterar a ast (favoritos opera)
    // https://upsource.jetbrains.com/idea-ce/file/idea-ce-e2d423f42b53eafd5c625b93149a0ebc7e49756c/platform/core-api/src/com/intellij/psi/PsiFile.java
    // psi interface
    //psi element transformar codigo ast



    // ver outros plugins - FindBugs
    // resolver problema android-studio-path (versao intelij) e ver utils

*/
}
