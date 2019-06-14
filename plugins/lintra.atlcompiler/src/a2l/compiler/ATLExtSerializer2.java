package a2l.compiler;

import org.eclipse.emf.ecore.EObject;

import a2l.anatlyzerext.visitor.AbstractAnatlyzerExtVisitor;
import a2l.optimiser.anatlyzerext.NavRefAsSet;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atlext.ATL.Module;

public class ATLExtSerializer2 extends ATLSerializer {
	
	private ExtSerializer ext = new ExtSerializer();
	
	public static String serialize(ATLModel m) {		
		Module mod = m.allObjectsOf(Module.class).get(0);
		ATLExtSerializer2 s = new ATLExtSerializer2();
		s.ext.startVisiting(mod);
		//s.startVisiting(mod);
		return s.g(mod);
	}


	public static String serialize(EObject obj) {
		ATLExtSerializer2 s = new ATLExtSerializer2();
		//s.startVisiting(obj);
		s.ext.startVisiting(obj);
		return s.g(obj);
	}
	
	@Override
	protected void unknownClassOf(EObject obj) {
		// Delegate to a custom serializer...?		
		ext.startVisiting(obj);		
	}
	
	public class ExtSerializer extends AbstractAnatlyzerExtVisitor {
		
		@Override
		public void inNavRefAsSet(NavRefAsSet self) {
			s(g(self.getSource()) + "<NavRefAsSet>." + self.getName());
		}
		
		@Override
		protected void visit(EObject obj) {
			if ( obj instanceof NavRefAsSet ) {
				super.visit(obj);
			} else {
				ATLExtSerializer2.this.visit(obj);
			}
		}
		
		@Override
		protected void unknownClassOf(EObject obj) {
			ATLExtSerializer2.this.startVisiting(obj);
		}
		
	}
	
}
