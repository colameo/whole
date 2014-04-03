package org.whole.lang.changes.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ChangesForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements IChangesVisitor {

    public ChangesForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RevisionFrame entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RevisionTrack entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Revisions entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Revision entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RevisionChanges entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RevisionChange entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ChangeSides entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ChangeRevisions entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(UnifiedCompare entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SideBySideCompare entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Nothing entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Changes entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Relate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Cut entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Copy entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Paste entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Delete entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Insert entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Replace entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Wrap entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Comment entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Text entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Clipboard entity) {
        wGetVisitor1().visit(entity);
    }
}
