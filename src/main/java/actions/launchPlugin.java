package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAwareAction;
import org.jetbrains.annotations.NotNull;
import org.lara.interpreter.weaver.generator.commandline.WeaverGenerator;

import java.io.File;


public class launchPlugin extends AnAction {



    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
    //invoke weaver
        System.out.println("new file" +(new File(".")).getAbsolutePath());
        String[] weaverArgs = {"-w", "PsiWeaver","-p","plugin_psi_weaver","-o","src/main/java","-x","src/main/weavergeneratorxml","-n","com.intellij.psi.PsiElement","-e","-d","-j"};
        WeaverGenerator.main(weaverArgs);
     //read data & highlight

    }
}
