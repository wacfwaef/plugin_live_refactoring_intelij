package plugin_psi_weaver.abstracts.joinpoints;

import org.lara.interpreter.weaver.interf.JoinPoint;
import com.intellij.psi.PsiElement;
import java.util.List;
import org.lara.interpreter.weaver.interf.events.Stage;
import java.util.Optional;
import org.lara.interpreter.exception.ActionException;
import org.lara.interpreter.exception.AttributeException;
import plugin_psi_weaver.PsiWeaver;
import org.lara.interpreter.weaver.interf.SelectOp;

/**
 * Abstract class containing the global attributes and default action exception.
 * This class is overwritten when the weaver generator is executed.
 * @author Lara Weaver Generator
 */
public abstract class AJoinPoint extends JoinPoint {

    /**
     * 
     */
    @Override
    public boolean same(JoinPoint iJoinPoint) {
        if (this.get_class().equals(iJoinPoint.get_class())) {
        
                return this.compareNodes((AJoinPoint) iJoinPoint);
            }
            return false;
    }

    /**
     * Compares the two join points based on their node reference of the used compiler/parsing tool.<br>
     * This is the default implementation for comparing two join points. <br>
     * <b>Note for developers:</b> A weaver may override this implementation in the editable abstract join point, so
     * the changes are made for all join points, or override this method in specific join points.
     */
    public boolean compareNodes(AJoinPoint aJoinPoint) {
        return this.getNode().equals(aJoinPoint.getNode());
    }

    /**
     * Returns the tree node reference of this join point.<br><b>NOTE</b>This method is essentially used to compare two join points
     * @return Tree node reference
     */
    public abstract PsiElement getNode();

    /**
     * 
     */
    @Override
    public void defImpl(String attribute, Object value) {
        switch(attribute){
        case "line": {
        	if(value instanceof Integer){
        		this.defLineImpl((Integer)value);
        		return;
        	}
        	if(value instanceof String){
        		this.defLineImpl((String)value);
        		return;
        	}
        	this.unsupportedTypeForDef(attribute, value);
        }
        default: throw new UnsupportedOperationException("Join point "+get_class()+": attribute '"+attribute+"' cannot be defined");
        }
    }

    /**
     * 
     */
    @Override
    protected void fillWithActions(List<String> actions) {
        actions.add("insertBefore(AJoinPoint node)");
        actions.add("insertBefore(String code)");
        actions.add("insertAfter(AJoinPoint node)");
        actions.add("insertAfter(String code)");
        actions.add("insertReplace(AJoinPoint jp)");
        actions.add("insertReplace(String code)");
        actions.add("copy()");
        actions.add("remove()");
    }

    /**
     * 
     * @param node 
     */
    public AJoinPoint insertBeforeImpl(AJoinPoint node) {
        throw new UnsupportedOperationException(get_class()+": Action insertBefore not implemented ");
    }

    /**
     * 
     * @param node 
     */
    public final AJoinPoint insertBefore(AJoinPoint node) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "insertBefore", this, Optional.empty(), node);
        	}
        	AJoinPoint result = this.insertBeforeImpl(node);
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "insertBefore", this, Optional.ofNullable(result), node);
        	}
        	return result;
        } catch(Exception e) {
        	throw new ActionException(get_class(), "insertBefore", e);
        }
    }

    /**
     * 
     * @param code 
     */
    public AJoinPoint insertBeforeImpl(String code) {
        throw new UnsupportedOperationException(get_class()+": Action insertBefore not implemented ");
    }

    /**
     * 
     * @param code 
     */
    public final AJoinPoint insertBefore(String code) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "insertBefore", this, Optional.empty(), code);
        	}
        	AJoinPoint result = this.insertBeforeImpl(code);
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "insertBefore", this, Optional.ofNullable(result), code);
        	}
        	return result;
        } catch(Exception e) {
        	throw new ActionException(get_class(), "insertBefore", e);
        }
    }

    /**
     * 
     * @param node 
     */
    public AJoinPoint insertAfterImpl(AJoinPoint node) {
        throw new UnsupportedOperationException(get_class()+": Action insertAfter not implemented ");
    }

    /**
     * 
     * @param node 
     */
    public final AJoinPoint insertAfter(AJoinPoint node) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "insertAfter", this, Optional.empty(), node);
        	}
        	AJoinPoint result = this.insertAfterImpl(node);
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "insertAfter", this, Optional.ofNullable(result), node);
        	}
        	return result;
        } catch(Exception e) {
        	throw new ActionException(get_class(), "insertAfter", e);
        }
    }

    /**
     * 
     * @param code 
     */
    public AJoinPoint insertAfterImpl(String code) {
        throw new UnsupportedOperationException(get_class()+": Action insertAfter not implemented ");
    }

    /**
     * 
     * @param code 
     */
    public final AJoinPoint insertAfter(String code) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "insertAfter", this, Optional.empty(), code);
        	}
        	AJoinPoint result = this.insertAfterImpl(code);
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "insertAfter", this, Optional.ofNullable(result), code);
        	}
        	return result;
        } catch(Exception e) {
        	throw new ActionException(get_class(), "insertAfter", e);
        }
    }

    /**
     * 
     * @param jp 
     */
    public AJoinPoint insertReplaceImpl(AJoinPoint jp) {
        throw new UnsupportedOperationException(get_class()+": Action insertReplace not implemented ");
    }

    /**
     * 
     * @param jp 
     */
    public final AJoinPoint insertReplace(AJoinPoint jp) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "insertReplace", this, Optional.empty(), jp);
        	}
        	AJoinPoint result = this.insertReplaceImpl(jp);
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "insertReplace", this, Optional.ofNullable(result), jp);
        	}
        	return result;
        } catch(Exception e) {
        	throw new ActionException(get_class(), "insertReplace", e);
        }
    }

    /**
     * 
     * @param code 
     */
    public AJoinPoint insertReplaceImpl(String code) {
        throw new UnsupportedOperationException(get_class()+": Action insertReplace not implemented ");
    }

    /**
     * 
     * @param code 
     */
    public final AJoinPoint insertReplace(String code) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "insertReplace", this, Optional.empty(), code);
        	}
        	AJoinPoint result = this.insertReplaceImpl(code);
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "insertReplace", this, Optional.ofNullable(result), code);
        	}
        	return result;
        } catch(Exception e) {
        	throw new ActionException(get_class(), "insertReplace", e);
        }
    }

    /**
     * 
     */
    public AJoinPoint copyImpl() {
        throw new UnsupportedOperationException(get_class()+": Action copy not implemented ");
    }

    /**
     * 
     */
    public final AJoinPoint copy() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "copy", this, Optional.empty());
        	}
        	AJoinPoint result = this.copyImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "copy", this, Optional.ofNullable(result));
        	}
        	return result;
        } catch(Exception e) {
        	throw new ActionException(get_class(), "copy", e);
        }
    }

    /**
     * 
     */
    public void removeImpl() {
        throw new UnsupportedOperationException(get_class()+": Action remove not implemented ");
    }

    /**
     * 
     */
    public final void remove() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "remove", this, Optional.empty());
        	}
        	this.removeImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "remove", this, Optional.empty());
        	}
        } catch(Exception e) {
        	throw new ActionException(get_class(), "remove", e);
        }
    }

    /**
     * 
     */
    @Override
    protected void fillWithAttributes(List<String> attributes) {
        //Attributes available for all join points
        attributes.add("code");
        attributes.add("ast");
        attributes.add("numChildren");
        attributes.add("children");
        attributes.add("child(Integer index)");
        attributes.add("parent");
        attributes.add("ancestor(String type)");
        attributes.add("line");
        attributes.add("descendants");
        attributes.add("isStatement");
        attributes.add("isBlock");
        attributes.add("modifiers");
    }

    /**
     * The source code corresponding to this join point
     */
    public abstract String getCodeImpl();

    /**
     * The source code corresponding to this join point
     */
    public final Object getCode() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "code", Optional.empty());
        	}
        	String result = this.getCodeImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "code", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "code", e);
        }
    }

    /**
     * A string representation of the AST corresponding to this node
     */
    public abstract String getAstImpl();

    /**
     * A string representation of the AST corresponding to this node
     */
    public final Object getAst() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "ast", Optional.empty());
        	}
        	String result = this.getAstImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "ast", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "ast", e);
        }
    }

    /**
     * Returns the number of children of the node
     */
    public abstract Integer getNumChildrenImpl();

    /**
     * Returns the number of children of the node
     */
    public final Object getNumChildren() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "numChildren", Optional.empty());
        	}
        	Integer result = this.getNumChildrenImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "numChildren", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "numChildren", e);
        }
    }

    /**
     * Get value on attribute children
     * @return the attribute's value
     */
    public abstract AJoinPoint[] getChildrenArrayImpl();

    /**
     * Returns an array with the children of the node
     */
    public Object getChildrenImpl() {
        AJoinPoint[] aJoinPointArrayImpl0 = getChildrenArrayImpl();
        Object nativeArray0 = getWeaverEngine().getScriptEngine().toNativeArray(aJoinPointArrayImpl0);
        return nativeArray0;
    }

    /**
     * Returns an array with the children of the node
     */
    public final Object getChildren() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "children", Optional.empty());
        	}
        	Object result = this.getChildrenImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "children", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "children", e);
        }
    }

    /**
     * 
     * @param index
     * @return 
     */
    public abstract AJoinPoint childImpl(Integer index);

    /**
     * 
     * @param index
     * @return 
     */
    public final Object child(Integer index) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "child", Optional.empty(), index);
        	}
        	AJoinPoint result = this.childImpl(index);
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "child", Optional.ofNullable(result), index);
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "child", e);
        }
    }

    /**
     * Get value on attribute parent
     * @return the attribute's value
     */
    public abstract AJoinPoint getParentImpl();

    /**
     * Get value on attribute parent
     * @return the attribute's value
     */
    public final Object getParent() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "parent", Optional.empty());
        	}
        	AJoinPoint result = this.getParentImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "parent", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "parent", e);
        }
    }

    /**
     * 
     * @param type
     * @return 
     */
    public abstract AJoinPoint ancestorImpl(String type);

    /**
     * 
     * @param type
     * @return 
     */
    public final Object ancestor(String type) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "ancestor", Optional.empty(), type);
        	}
        	AJoinPoint result = this.ancestorImpl(type);
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "ancestor", Optional.ofNullable(result), type);
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "ancestor", e);
        }
    }

    /**
     * Get value on attribute line
     * @return the attribute's value
     */
    public abstract Integer getLineImpl();

    /**
     * 
     */
    public void defLineImpl(Integer value) {
        throw new UnsupportedOperationException("Join point "+get_class()+": Action def line with type Integer not implemented ");
    }

    /**
     * 
     */
    public void defLineImpl(String value) {
        throw new UnsupportedOperationException("Join point "+get_class()+": Action def line with type String not implemented ");
    }

    /**
     * Get value on attribute line
     * @return the attribute's value
     */
    public final Object getLine() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "line", Optional.empty());
        	}
        	Integer result = this.getLineImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "line", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "line", e);
        }
    }

    /**
     * Get value on attribute descendants
     * @return the attribute's value
     */
    public abstract AJoinPoint[] getDescendantsArrayImpl();

    /**
     * Get value on attribute descendants
     * @return the attribute's value
     */
    public Object getDescendantsImpl() {
        AJoinPoint[] aJoinPointArrayImpl0 = getDescendantsArrayImpl();
        Object nativeArray0 = getWeaverEngine().getScriptEngine().toNativeArray(aJoinPointArrayImpl0);
        return nativeArray0;
    }

    /**
     * Get value on attribute descendants
     * @return the attribute's value
     */
    public final Object getDescendants() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "descendants", Optional.empty());
        	}
        	Object result = this.getDescendantsImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "descendants", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "descendants", e);
        }
    }

    /**
     * true if this node is considered a statement
     */
    public abstract Boolean getIsStatementImpl();

    /**
     * true if this node is considered a statement
     */
    public final Object getIsStatement() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "isStatement", Optional.empty());
        	}
        	Boolean result = this.getIsStatementImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "isStatement", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "isStatement", e);
        }
    }

    /**
     * true if this node is considered a block of statements
     */
    public abstract Boolean getIsBlockImpl();

    /**
     * true if this node is considered a block of statements
     */
    public final Object getIsBlock() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "isBlock", Optional.empty());
        	}
        	Boolean result = this.getIsBlockImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "isBlock", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "isBlock", e);
        }
    }

    /**
     * Get value on attribute modifiers
     * @return the attribute's value
     */
    public abstract String[] getModifiersArrayImpl();

    /**
     * an array of modifiers (e.g., final, static) applied to this node. If no modifiers are applied, or if the node does not support modifiers, returns an empty array
     */
    public Object getModifiersImpl() {
        String[] stringArrayImpl0 = getModifiersArrayImpl();
        Object nativeArray0 = getWeaverEngine().getScriptEngine().toNativeArray(stringArrayImpl0);
        return nativeArray0;
    }

    /**
     * an array of modifiers (e.g., final, static) applied to this node. If no modifiers are applied, or if the node does not support modifiers, returns an empty array
     */
    public final Object getModifiers() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "modifiers", Optional.empty());
        	}
        	Object result = this.getModifiersImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "modifiers", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "modifiers", e);
        }
    }

    /**
     * Defines if this joinpoint is an instanceof a given joinpoint class
     * @return True if this join point is an instanceof the given class
     */
    @Override
    public boolean instanceOf(String joinpointClass) {
        boolean isInstance = get_class().equals(joinpointClass);
        if(isInstance) {
        	return true;
        }
        return super.instanceOf(joinpointClass);
    }

    /**
     * Returns the Weaving Engine this join point pertains to.
     */
    @Override
    public PsiWeaver getWeaverEngine() {
        return PsiWeaver.getPsiWeaver();
    }

    /**
     * Generic select function, used by the default select implementations.
     */
    public abstract <T extends AJoinPoint> List<? extends T> select(Class<T> joinPointClass, SelectOp op);
}