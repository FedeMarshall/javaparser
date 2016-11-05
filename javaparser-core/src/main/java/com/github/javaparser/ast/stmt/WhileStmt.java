/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2016 The JavaParser Team.
 *
 * This file is part of JavaParser.
 * 
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License 
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
 
package com.github.javaparser.ast.stmt;

import com.github.javaparser.Range;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.nodeTypes.NodeWithBody;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metric.utilities.HalsteadComplexityMeasures;

/**
 * @author Julio Vilmar Gesser
 */
public final class WhileStmt extends Statement implements NodeWithBody<WhileStmt> {

	private Expression condition;

	private Statement body;

	public WhileStmt() {
	}

	public WhileStmt(final Expression condition, final Statement body) {
		setCondition(condition);
		setBody(body);
	}

	public WhileStmt(Range range, final Expression condition, final Statement body) {
		super(range);
		setCondition(condition);
		setBody(body);
	}

	@Override public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
		return v.visit(this, arg);
	}

	@Override public <A> void accept(final VoidVisitor<A> v, final A arg) {
		v.visit(this, arg);
	}

	@Override
	public void halsteadNumbers(HalsteadComplexityMeasures halsteadMetrics) {
		halsteadMetrics.agregarOperador("while");
		halsteadMetrics.agregarOperador("(");
		halsteadMetrics.agregarOperador(")");
		
		condition.halsteadNumbers(halsteadMetrics);
		body.halsteadNumbers(halsteadMetrics);
	}

	@Override
    public Statement getBody() {
		return body;
	}

	public Expression getCondition() {
		return condition;
	}

	@Override
    public WhileStmt setBody(final Statement body) {
		this.body = body;
		setAsParentNodeOf(this.body);
        return this;
	}

	public void setCondition(final Expression condition) {
		this.condition = condition;
		setAsParentNodeOf(this.condition);
	}
}
