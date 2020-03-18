import org.lara.interpreter.weaver.generator.commandline.WeaverGenerator;

import java.io.File;


public class weavergen {
    public static void main(String[] args){
        System.out.println("new file" +(new File(".")).getAbsolutePath());
        String[] weaverArgs = {"-w", "PsiWeaver","-p","plugin_psi_weaver","-o","src/main/java","-x","src/main/weavergeneratorxml","-n","com.intellij.psi.PsiElement","-e","-d","-j"};
        WeaverGenerator.main(weaverArgs);

    }
}
