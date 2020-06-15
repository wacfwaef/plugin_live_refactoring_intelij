package highlight;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class Anotatorb implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        holder.createWarningAnnotation(element,
                "class findViewById is energy inefficient. Replace with ViewHolder pattern.");
    }
}