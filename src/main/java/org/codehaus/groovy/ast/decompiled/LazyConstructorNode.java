/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.codehaus.groovy.ast.decompiled;

import org.apache.groovy.internal.util.Supplier;
import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.AnnotationNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.ConstructorNode;
import org.codehaus.groovy.ast.GenericsType;
import org.codehaus.groovy.ast.GroovyCodeVisitor;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.VariableScope;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.util.ListHashMap;

import java.util.List;
import java.util.Map;

/**
 * Represents lazy constructor node, which will be initialized only when accessed
 *
 * @since 2.5.9
 */
public class LazyConstructorNode extends ConstructorNode {
    private final Supplier<ConstructorNode> constructorNodeSupplier;
    private ConstructorNode delegate;
    private boolean initialized;

    public LazyConstructorNode(Supplier<ConstructorNode> constructorNodeSupplier) {
        this.constructorNodeSupplier = constructorNodeSupplier;
    }

    private void init() {
        if (initialized) return;
        delegate = constructorNodeSupplier.get();

        ClassNode declaringClass = super.getDeclaringClass();
        if (null != declaringClass) delegate.setDeclaringClass(declaringClass);

        initialized = true;
    }

    @Override
    public boolean firstStatementIsSpecialConstructorCall() {
        init();
        return delegate.firstStatementIsSpecialConstructorCall();
    }

    @Override
    public String getTypeDescriptor() {
        init();
        return delegate.getTypeDescriptor();
    }

    @Override
    public boolean isVoidMethod() {
        init();
        return delegate.isVoidMethod();
    }

    @Override
    public Statement getCode() {
        init();
        return delegate.getCode();
    }

    @Override
    public void setCode(Statement code) {
        init();
        delegate.setCode(code);
    }

    @Override
    public int getModifiers() {
        init();
        return delegate.getModifiers();
    }

    @Override
    public void setModifiers(int modifiers) {
        init();
        delegate.setModifiers(modifiers);
    }

    @Override
    public String getName() {
        init();
        return delegate.getName();
    }

    @Override
    public Parameter[] getParameters() {
        init();
        return delegate.getParameters();
    }

    @Override
    public void setParameters(Parameter[] parameters) {
        init();
        delegate.setParameters(parameters);
    }

    @Override
    public ClassNode getReturnType() {
        init();
        return delegate.getReturnType();
    }

    @Override
    public VariableScope getVariableScope() {
        init();
        return delegate.getVariableScope();
    }

    @Override
    public void setVariableScope(VariableScope variableScope) {
        init();
        delegate.setVariableScope(variableScope);
    }

    @Override
    public boolean isDynamicReturnType() {
        init();
        return delegate.isDynamicReturnType();
    }

    @Override
    public boolean isAbstract() {
        init();
        return delegate.isAbstract();
    }

    @Override
    public boolean isStatic() {
        init();
        return delegate.isStatic();
    }

    @Override
    public boolean isPublic() {
        init();
        return delegate.isPublic();
    }

    @Override
    public boolean isPrivate() {
        init();
        return delegate.isPrivate();
    }

    @Override
    public boolean isFinal() {
        init();
        return delegate.isFinal();
    }

    @Override
    public boolean isProtected() {
        init();
        return delegate.isProtected();
    }

    @Override
    public boolean isPackageScope() {
        init();
        return delegate.isPackageScope();
    }

    @Override
    public boolean hasDefaultValue() {
        init();
        return delegate.hasDefaultValue();
    }

    @Override
    public boolean isScriptBody() {
        init();
        return delegate.isScriptBody();
    }

    @Override
    public void setIsScriptBody() {
        init();
        delegate.setIsScriptBody();
    }

    @Override
    public String toString() {
        init();
        return delegate.toString();
    }

    @Override
    public void setReturnType(ClassNode returnType) {
        init();
        delegate.setReturnType(returnType);
    }

    @Override
    public ClassNode[] getExceptions() {
        init();
        return delegate.getExceptions();
    }

    @Override
    public Statement getFirstStatement() {
        init();
        return delegate.getFirstStatement();
    }

    @Override
    public GenericsType[] getGenericsTypes() {
        init();
        return delegate.getGenericsTypes();
    }

    @Override
    public void setGenericsTypes(GenericsType[] genericsTypes) {
        init();
        delegate.setGenericsTypes(genericsTypes);
    }

    @Override
    public void setAnnotationDefault(boolean b) {
        init();
        delegate.setAnnotationDefault(b);
    }

    @Override
    public boolean hasAnnotationDefault() {
        init();
        return delegate.hasAnnotationDefault();
    }

    @Override
    public boolean isStaticConstructor() {
        init();
        return delegate.isStaticConstructor();
    }

    @Override
    public boolean isSyntheticPublic() {
        init();
        return delegate.isSyntheticPublic();
    }

    @Override
    public void setSyntheticPublic(boolean syntheticPublic) {
        init();
        delegate.setSyntheticPublic(syntheticPublic);
    }

    @Override
    public String getText() {
        init();
        return delegate.getText();
    }

    @Override
    public List<AnnotationNode> getAnnotations() {
        init();
        return delegate.getAnnotations();
    }

    @Override
    public List<AnnotationNode> getAnnotations(ClassNode type) {
        init();
        return delegate.getAnnotations(type);
    }

    @Override
    public void addAnnotation(AnnotationNode value) {
        init();
        delegate.addAnnotation(value);
    }

    @Override
    public void addAnnotations(List<AnnotationNode> annotations) {
        init();
        delegate.addAnnotations(annotations);
    }

    @Override
    public boolean isSynthetic() {
        init();
        return delegate.isSynthetic();
    }

    @Override
    public void setSynthetic(boolean synthetic) {
        init();
        delegate.setSynthetic(synthetic);
    }

    @Override
    public ClassNode getDeclaringClass() {
        init();
        return delegate.getDeclaringClass();
    }

    @Override
    public void setDeclaringClass(ClassNode declaringClass) {
        super.setDeclaringClass(declaringClass);
    }

    @Override
    public boolean hasNoRealSourcePosition() {
        init();
        return delegate.hasNoRealSourcePosition();
    }

    @Override
    public void setHasNoRealSourcePosition(boolean value) {
        init();
        delegate.setHasNoRealSourcePosition(value);
    }

    @Override
    public void visit(GroovyCodeVisitor visitor) {
        init();
        delegate.visit(visitor);
    }

    @Override
    public int getLineNumber() {
        init();
        return delegate.getLineNumber();
    }

    @Override
    public void setLineNumber(int lineNumber) {
        init();
        delegate.setLineNumber(lineNumber);
    }

    @Override
    public int getColumnNumber() {
        init();
        return delegate.getColumnNumber();
    }

    @Override
    public void setColumnNumber(int columnNumber) {
        init();
        delegate.setColumnNumber(columnNumber);
    }

    @Override
    public int getLastLineNumber() {
        init();
        return delegate.getLastLineNumber();
    }

    @Override
    public void setLastLineNumber(int lastLineNumber) {
        init();
        delegate.setLastLineNumber(lastLineNumber);
    }

    @Override
    public int getLastColumnNumber() {
        init();
        return delegate.getLastColumnNumber();
    }

    @Override
    public void setLastColumnNumber(int lastColumnNumber) {
        init();
        delegate.setLastColumnNumber(lastColumnNumber);
    }

    @Override
    public void setSourcePosition(ASTNode node) {
        init();
        delegate.setSourcePosition(node);
    }

    @Override
    public <T> T getNodeMetaData(Object key) {
        init();
        return delegate.getNodeMetaData(key);
    }

    @Override
    public void copyNodeMetaData(ASTNode other) {
        init();
        delegate.copyNodeMetaData(other);
    }

    @Override
    public void setNodeMetaData(Object key, Object value) {
        init();
        delegate.setNodeMetaData(key, value);
    }

    @Override
    public Object putNodeMetaData(Object key, Object value) {
        init();
        return delegate.putNodeMetaData(key, value);
    }

    @Override
    public void removeNodeMetaData(Object key) {
        init();
        delegate.removeNodeMetaData(key);
    }

    @Override
    public Map<?, ?> getNodeMetaData() {
        init();
        return delegate.getNodeMetaData();
    }

    @Override
    public ListHashMap getMetaDataMap() {
        init();
        return delegate.getMetaDataMap();
    }

    @Override
    public boolean equals(Object o) {
        init();
        return delegate.equals(o);
    }

    @Override
    public int hashCode() {
        init();
        return delegate.hashCode();
    }
}