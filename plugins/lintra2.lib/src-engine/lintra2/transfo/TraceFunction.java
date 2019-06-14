package lintra2.transfo;

import java.util.UUID;
import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.IArea;

public class TraceFunction {
	
	
	private static String f(String id, String ruleName) {
		return id+"_"+ ruleName;
	}

	private static String f(String id, int pos, String ruleName) {
		return id+"_"+ ruleName + "." + pos;
	}
	
	private static String f(String n, String m, String ruleName) {
		if (n!=null && m!=null){
			if (Double.parseDouble(n) < Double.parseDouble(m)) {
				return n + "-" + m + "_" + ruleName;
			} else {
				return m + "-" + n + "_" + ruleName;
			}
		} else {
			return null;
		}
	}
				
	private static String f(String n, String m, int pos, String ruleName) {
		if (Double.parseDouble(n) < Double.parseDouble(m)){
			return n+"-"+ m + "_" + ruleName + "." + pos;			
		}
		else {
			return m+"-"+ n + "_" + ruleName + "." + pos;
		}
	}
	
	public static String create(String id, String ruleName) {
		return f(id, ruleName);
	}
	
	public static String create(String id, int pos, String ruleName) {
		return f(id, pos, ruleName);
	}
	
	public static String create(String n, String m, String ruleName) {
		return f(n, m, ruleName);
	}
	
	public static String create(String n, String m, int pos, String ruleName) {
		return f(n, m, pos, ruleName);
	}
	
	public static String resolve(String id, String ruleName) {
		return f(id, ruleName);
	}
	
	public static String resolve(Object id, int pos, String ruleName) {		
		return resolve((String) id, pos, ruleName);
	}

	
	public static String resolve(String id, int pos, String ruleName) {
		return f(id, pos, ruleName);
	}
	
	public static String resolve(String n, String m, String ruleName) {
		return f(n, m, ruleName);
	}
	
	public static String resolve(String n, String m, int pos, String ruleName) {
		return f(n, m, pos, ruleName);
	}
	
	public static String[] resolveAll(String[] ids, String ruleName) {
		if (ids != null){
			String[] outIds = new String[ids.length];
			for (int i=0; i<ids.length; i++){
				outIds[i] = f(ids[i], ruleName);
			}
			return outIds;
		} else {
			return null;
		}
	}
	
	public static String[] resolveAll(String[] ids, int pos, String ruleName) {
		if (ids != null){	
			String[] outIds = new String[ids.length];
			for (int i=0; i<ids.length; i++){
				outIds[i] = f(ids[i], pos, ruleName);
			}
			return outIds;
		} else {
			return null;
		}
	}
	

	public static String createUniqueId(String ruleName) {
		return UUID.randomUUID().toString() + "_" + ruleName;
	}
	
	/* Identifiers for elements created from no input element */
	
	public static String create(String ruleName, IArea ids4RuleWNoInputElem) throws BlackboardException{
		ids4RuleWNoInputElem.lock();
		CurrentId cid = (CurrentId) ids4RuleWNoInputElem.read(LinTraParameters.CURRENT_AREA_ID);
		double id = cid.getCurrentId();
		cid.increase(1);
		ids4RuleWNoInputElem.write(cid);
		ids4RuleWNoInputElem.unlock();
		
		return id+"_"+ruleName;
	}

	public static String create(String ruleName, int pos, IArea ids4RuleWNoInputElem) throws BlackboardException{
		String id = TraceFunction.create(ruleName, ids4RuleWNoInputElem);
		return id+"."+pos;
	}
	
	/* Reverse function */
	
	private String fInv(String id){
		// ...
		return "";
	}
	
	public String[] resolveInvGetIds(String id){
		
		return null;
	}
	
	public String resolveInvGetRuleName(String id){
		return "";
	}
	
	public int resolveInvGetPos(String id){
		return -1;
	}

	
}
