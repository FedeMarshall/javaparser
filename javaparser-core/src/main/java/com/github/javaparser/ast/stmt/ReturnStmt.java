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
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metrics.utilities.HalsteadComplexityMeasures;

/**
 * @author Julio Vilmar Gesser
 */
public final class ReturnStmt extends Statement {

	private Expression expr;

	public ReturnStmt() {
	}

	public ReturnStmt(final Expression expr) {
		setExpr(expr);
	}

	public ReturnStmt(Range range, final Expression expr) {
		super(range);
		setExpr(expr);
	}

    /**
     * Will create a NameExpr with the string param
     * 
     * @param expr
     */
    public ReturnStmt(String expr) {
        setExpr(new NameExpr(expr));
    }

    @Override
    public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
		return v.visit(this, arg);
	}

	@Override public <A> void accept(final VoidVisitor<A> v, final A arg) {
		v.visit(this, arg);
	}

	@Override
	public void halsteadNumbers(HalsteadComplexityMeasures halsteadMetrics) {
		halsteadMetrics.agregarOperador("return");
		
		if (expr != null){
			expr.halsteadNumbers(halsteadMetrics);		
		}
	}

	public Expression getExpr() {
		return expr;
	}

	public void setExpr(final Expression expr) {
		this.expr = expr;
		setAsParentNodeOf(this.expr);
	}
}
