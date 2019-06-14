//package a2l.tests.imdb.findcouples.performance;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//
//import org.eclipse.emf.common.util.TreeIterator;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.resource.Resource;
//
//import a2l.tests.findcouples.FindCouplesIMDb;
//import imdb.movies.Actor;
//import imdb.movies.Actress;
//import imdb.movies.Movie;
//import lintra.emf.EMFDataSource;
//import lintra.emf.EMFTargetIdMapper;
//import lintra.evaluation.StatsCollector;
//import lintra2.runners.MTLauncherOutplace;
//
//
//public class FindCouples_LintraExplicitScheduling {
//
//	protected Collection<Object> objects = new ArrayList<Object>();
//	protected HashMap<EObject, EObject> trace = new HashMap<EObject, EObject>();
//	private StatsCollector stats;
//	
//	
//	public FindCouples_LintraExplicitScheduling(StatsCollector stats) {
//		this.stats = stats;
//	}
//
//	public Resource transform(Resource input) {
//		objects = new ArrayList<Object>();
//
//		org.eclipse.emf.ecore.resource.ResourceSet rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
//		org.eclipse.emf.ecore.resource.Resource res = rs
//				.createResource(org.eclipse.emf.common.util.URI.createFileURI("test.xmi"));
//
//		stats.begin("Configure model");
//			TreeIterator<EObject> it = input.getAllContents();
//			while ( it.hasNext() ) {
//				EObject obj = it.next();
//				
//				if ( obj instanceof Movie ) {
//					objects.add(obj);
//				} else if ( obj instanceof Actor ) {
//					objects.add(obj);
//				} else if ( obj instanceof Actress ) {
//					objects.add(obj);
//				}
//			}
//		stats.end();
//
//		
//		MTLauncherOutplace mtLauncher = new MTLauncherOutplace();
//		try {
//			mtLauncher.createBlackboard();
//			mtLauncher.createSrcArea("srcArea", new EMFDataSource(input));
//			System.out.println("Model loaded");
//			
//			mtLauncher.createTrgArea("trgArea", new EMFTargetIdMapper());
//
//			FindCouplesIMDb trafo = new FindCouplesIMDb(		
//					mtLauncher.getArea(mtLauncher.getSrcAreas(), "srcArea"), 
//					mtLauncher.getArea(mtLauncher.getTrgAreas(), "trgArea"), 
//					mtLauncher.getCachingArea());
//						
//			// Init all classes
//			stats.begin("Transform");
//				trafo.transform(objects, null);
//			stats.end();
//
//			stats.begin("Postprocessing");
//				trafo.postprocessing();
//			stats.end();			
//		} catch ( Exception e ) {
//			e.printStackTrace();
//		}
//		
////		Collection objects = null;
////		objects = _area_UCD.read(_area_UCD.size());
////		for (Object object : objects) {
////			org.eclipse.emf.ecore.EObject obj = (org.eclipse.emf.ecore.EObject) object;
////			if (obj.eContainer() == null) {
////				res.getContents().add(obj);
////			}
////		}
////		return res;
//		
//
//		
//		return res;
//	}
//	
//	
//}
