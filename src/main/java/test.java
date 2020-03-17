import com.intellij.lang.FileASTNode;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.util.PsiUtilCore;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.sf.cglib.asm.$ClassWriter;
import org.lara.interpreter.weaver.generator.commandline.WeaverGenerator;

public class test {
    // ver no main os argumentos do import (generator - messenger)
    // ver os xml do weaver generator
    WeaverGenerator w = new WeaverGenerator();

    public WeaverGenerator getW() {
        return w;
    }


    // psifiles - ver como percorrer ast e alterar a ast (favoritos opera)
    // https://upsource.jetbrains.com/idea-ce/file/idea-ce-e2d423f42b53eafd5c625b93149a0ebc7e49756c/platform/core-api/src/com/intellij/psi/PsiFile.java
    // psi interface


    // actions - ver se transforma codigo

    // ver outros plugins - FindBugs
    // resolver problema android-studio-path (versao intelij) e ver utils


}
