package a2l.compiler;

import org.eclipse.emf.ecore.EObject;

import a2l.anatlyzerext.visitor.AbstractAnatlyzerExtVisitor;
import a2l.optimiser.anatlyzerext.IteratorChainExp;
import a2l.optimiser.anatlyzerext.MutableIteratorExp;
import a2l.optimiser.anatlyzerext.NavRefAsSet;
import a2l.optimiser.anatlyzerext.ShortCircuitOperatorCallExp;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atlext.ATL.Module;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.processing.AbstractVisitor;

public class ATLExtSerializer extends ATLSerializer {
	
	private ExtSerializer ext = new ExtSerializer(this);
	
	public static String serialize(ATLModel m) {		
		Module mod = m.allObjectsOf(Module.class).get(0);
		ATLExtSerializer s = new ATLExtSerializer();
		s.startVisiting(mod);
		return s.g(mod);
	}


	public static String serialize(EObject obj) {
		ATLExtSerializer s = new ATLExtSerializer();
		s.startVisiting(obj);
		return s.g(obj);
	}
	
	@Override
	protected void unknownClassOf(EObject obj) {
		// Delegate to a custom serializer...?		
		ext.startVisiting(obj);		
	}
	
	public class ExtSerializer extends AbstractAnatlyzerExtVisitor.DelegatedVisitor {
		
		public ExtSerializer(AbstractVisitor delegate) {
			super(delegate);
		}

		@Override
		public void inNavRefAsSet(NavRefAsSet self) {
			s(g(self.getSource()) + "<NavRefAsSet>." + self.getName());
		}
		
		@Override
		public void inMutableIteratorExp(MutableIteratorExp self) {
			inIteratorExp(self);
		}
		
		@Override
		public void inIteratorChainExp(IteratorChainExp self) {
			s(g(self.getSource()) + ".<IteratorChain>[" + self.getName() + "]");
		}
		
		@Override
		public void inShortCircuitOperatorCallExp(ShortCircuitOperatorCallExp self) {
			super.inOperatorCallExp(self);
		}
		
		@Override
		protected void unknownClassOf(EObject obj) {
			ATLExtSerializer.this.startVisiting(obj);
		}
		
	}
	
}
