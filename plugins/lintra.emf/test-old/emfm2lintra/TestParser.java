package emfm2lintra;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import movies.*;
import movies.Enums.MovieType;
import abc.Enums.Colors;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import runners.MTLauncherOutplace;

public class TestParser {

	public static void main(String[] args) throws Exception {
		
//		ModelParser.xmi2lintra("C:\\Users\\Atenea\\Desktop\\ee\\Graph.ecore",
//			 "C:\\Users\\Atenea\\Desktop\\ee\\graph.xmi",
//			 "C:\\Users\\Atenea\\Desktop\\ee\\graph.ser");
//
//		ModelParser.lintra2xmi("C:\\Users\\Atenea\\Desktop\\ee\\Graph.ecore",
//				 "C:\\Users\\Atenea\\Desktop\\ee\\graph.ser",
//				 "C:\\Users\\Atenea\\Desktop\\ee\\graph2.xmi");
		 

		
		
//		ModelParser.xmi2lintra("C:\\Users\\Atenea\\Desktop\\ee\\java.ecore",
////			 "C:\\Users\\Atenea\\Desktop\\Gits\\LinTraCompilerGit\\emfm2lintra\\xmiModels\\helloworld_java.xmi",
//			 "C:\\Users\\Atenea\\Desktop\\ee\\eclipseModel-0.1.xmi",
//			 "C:\\Users\\Atenea\\Desktop\\ee\\helloworld_java.ser");
//		 
//		ModelParser.lintra2xmi("C:\\Users\\Atenea\\Desktop\\ee\\java.ecore",
//			 "C:\\Users\\Atenea\\Desktop\\ee\\helloworld_java.ser",
//			 "C:\\Users\\Atenea\\Desktop\\ee\\eclipseModel-0.1_2.xmi");
////			 "C:\\Users\\Atenea\\Desktop\\Gits\\LinTraCompilerGit\\emfm2lintra\\xmiModels\\helloworld_java2.xmi");
		 
		 
		

//		 ModelParser.xmi2lintra("C:\\Users\\Atenea\\Desktop\\ee\\DBLP.ecore",
//			 "C:/Users/Atenea/Desktop/ee/simpleDBLP.xmi",
//			 "C:/Users/Atenea/Desktop/ee/simpleDBLP.ser");
//
//		 ModelParser.lintra2xmi("C:\\Users\\Atenea\\Desktop\\ee\\DBLP.ecore",
//			 "C:/Users/Atenea/Desktop/ee/simpleDBLP.ser",
//			 "C:/Users/Atenea/Desktop/ee/simpleDBLP2.xmi");

		
		

		
//		 ModelParser.xmi2lintra("C:\\Users\\Atenea\\Desktop\\ee\\Proceedings.ecore",
//		 "C:\\Users\\Atenea\\Desktop\\ee\\proceedings.xmi",
//		 "C:\\Users\\Atenea\\Desktop\\ee\\proceedings.ser");
//		 
//		ModelParser.lintra2xmi("C:\\Users\\Atenea\\Desktop\\ee\\Proceedings.ecore",
//				"C:\\Users\\Atenea\\Desktop\\ee\\proceedings.ser",
////				"C:\\Users\\Atenea\\Desktop\\ee\\proceedings2.xmi");
//				"C:\\Users\\Atenea\\Desktop\\Gits\\LinTraCompilerGit\\emfm2lintra\\xmiModels\\proceedings2.xmi");

		
		
		
		
//		 ModelParser.xmi2lintra("C:\\Users\\Atenea\\Desktop\\ee\\movies.ecore",
//		 "C:\\Users\\Atenea\\Desktop\\ee\\simple_imdb.xmi",
//		 "C:\\Users\\Atenea\\Desktop\\ee\\simple_imdb.ser");
//		
//		ModelParser.lintra2xmi("C:\\Users\\Atenea\\Desktop\\ee\\movies.ecore",
//				"C:\\Users\\Atenea\\Desktop\\ee\\simple_imdb.ser",
//				"C:\\Users\\Atenea\\Desktop\\ee\\simple_movies.xmi");
		
//		MTLauncherOutplace mtLauncher = new MTLauncherOutplace();
//		mtLauncher.createBlackboard();
//		createSyntheticData(1, mtLauncher.getSrcArea());
//		ModelParser.lintra2xmi("C:\\Users\\Atenea\\Desktop\\ee\\movies.ecore",
//				mtLauncher.getSrcArea(),
//				"C:\\Users\\Atenea\\Desktop\\ee\\movies.xmi");
		
		
		
		
//		ModelParser.xmi2lintra("C:/Users/Atenea/Desktop/Gits/LinTraCompilerGit/emf2lintra/input/ABC.ecore",
//				 "C:/Users/Atenea/Desktop/Gits/LinTraCompilerGit/emf2lintra/input/A.xmi",
//				 "C:/Users/Atenea/Desktop/Gits/LinTraCompilerGit/emf2lintra/input/A.ser");
//		
//		ModelParser.lintra2xmi("C:/Users/Atenea/Desktop/Gits/LinTraCompilerGit/emf2lintra/input/ABC.ecore",
//				 "C:/Users/Atenea/Desktop/Gits/LinTraCompilerGit/emf2lintra/input/A.ser",
//				 "C:/Users/Atenea/Desktop/Gits/LinTraCompilerGit/emf2lintra/input/A2.xmi");

		System.out.println("Done!");
	}
	
	public static void createSyntheticData(int n, IArea area)
			throws BlackboardException {

		for (int i = 0; i < n; i++) {
			try {
				createPoSitive(area, i);
				createNegative(area, i);
			} catch (OutOfMemoryError | NumberFormatException e) {
				System.out.println(i - 1);
				e.printStackTrace();
			}
		}
	}

	private static void createNegative(IArea area, int i)
			throws BlackboardException {

		List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();

		String[] personsIds6 = { Double.toString(20 * i + 16),
				Double.toString(20 * i + 17) };
		Movie m6 = new Movie(Double.toString(20 * i + 11), personsIds6, "movie6",
				10 * i + 5, 2014, MovieType.MOVIE);

		String[] personsIds7 = { Double.toString(20 * i + 16),
				Double.toString(20 * i + 17), Double.toString(20 * i + 18) };
		Movie m7 = new Movie(Double.toString(20 * i + 12), personsIds7, "movie7",
				10 * i + 6, 2014, MovieType.TV);

		String[] personsIds8 = { Double.toString(20 * i + 17),
				Double.toString(20 * i + 18), Double.toString(20 * i + 19) };
		Movie m8 = new Movie(Double.toString(20 * i + 13), personsIds8, "movie8",
				10 * i + 7, 2014, MovieType.VIDEO);

		String[] personsIds9 = { Double.toString(20 * i + 18),
				Double.toString(20 * i + 19), Double.toString(20 * i + 20) };
		Movie m9 = new Movie(Double.toString(20 * i + 14), personsIds9, "movie9",
				10 * i + 8, 2014, MovieType.TV);

		String[] personsIds10 = { Double.toString(20 * i + 19),
				Double.toString(20 * i + 20) };
		Movie m10 = new Movie(Double.toString(20 * i + 15), personsIds10, "movie10",
				10 * i + 9, 2014, MovieType.MOVIE);
		/***/
		String[] moviesIds11 = { Double.toString(20 * i + 11),
				Double.toString(20 * i + 12) };
		Actor a11 = new Actor(Double.toString(20 * i + 16), moviesIds11, "a"
				+ Double.toString(10 * i + 5));

		String[] moviesIds12 = { Double.toString(20 * i + 11),
				Double.toString(20 * i + 12), Double.toString(20 * i + 13) };
		Actor a12 = new Actor(Double.toString(20 * i + 17), moviesIds12, "a"
				+ Double.toString(10 * i + 6));

		String[] moviesIds13 = { Double.toString(20 * i + 12),
				Double.toString(20 * i + 13), Double.toString(20 * i + 14) };
		Actor a13 = new Actor(Double.toString(20 * i + 18), moviesIds13, "a"
				+ Double.toString(10 * i + 7));

		String[] moviesIds14 = { Double.toString(20 * i + 13),
				Double.toString(20 * i + 14), Double.toString(20 * i + 15) };
		Actor a14 = new Actor(Double.toString(20 * i + 19), moviesIds14, "a"
				+ Double.toString(10 * i + 8));

		String[] moviesIds15 = { Double.toString(20 * i + 14),
				Double.toString(20 * i + 15) };
		Actor a15 = new Actor(Double.toString(20 * i + 20), moviesIds15, "a"
				+ Double.toString(10 * i + 9));

		elems.add(m6);
		elems.add(m7);
		elems.add(m8);
		elems.add(m9);
		elems.add(m10);
		elems.add(a11);
		elems.add(a12);
		elems.add(a13);
		elems.add(a14);
		elems.add(a15);

		area.writeAll(elems);
	}

	private static void createPoSitive(IArea area, int i)
			throws BlackboardException {

		List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();

		String[] personsIds1 = { Double.toString(20 * i + 6),
				Double.toString(20 * i + 7) };
		Movie m1 = new Movie(Double.toString(20 * i + 1), personsIds1, "movie1",
				10 * i, 2014, null);

		String[] personsIds2 = { Double.toString(20 * i + 6),
				Double.toString(20 * i + 7), Double.toString(20 * i + 8),
				Double.toString(20 * i + 9), Double.toString(20 * i + 10) };
		Movie m2 = new Movie(Double.toString(20 * i + 2), personsIds2, "movie2",
				10 * i + 1, 2014, null);

		String[] personsIds3 = { Double.toString(20 * i + 6),
				Double.toString(20 * i + 7), Double.toString(20 * i + 8),
				Double.toString(20 * i + 9), Double.toString(20 * i + 10) };
		Movie m3 = new Movie(Double.toString(20 * i + 3), personsIds3, "movie3",
				10 * i + 2, 2014, null);

		String[] personsIds4 = { Double.toString(20 * i + 6),
				Double.toString(20 * i + 7), Double.toString(20 * i + 8),
				Double.toString(20 * i + 9), Double.toString(20 * i + 10) };
		Movie m4 = new Movie(Double.toString(20 * i + 4), personsIds4, "movie4",
				10 * i + 3, 2014, null);

		String[] personsIds5 = { Double.toString(20 * i + 9),
				Double.toString(20 * i + 10) };
		Movie m5 = new Movie(Double.toString(20 * i + 5), personsIds5, "movie5",
				10 * i + 4, 2014, null);
		/***/
		String[] moviesIds1 = { m1.getId(), m2.getId(), m3.getId(), m4.getId() };
		Actor a1 = new Actor(Double.toString(20 * i + 6), moviesIds1, "a"
				+ Double.toString(10 * i));

		String[] moviesIds2 = { m1.getId(), m2.getId(), m3.getId(), m4.getId() };
		Actor a2 = new Actor(Double.toString(20 * i + 7), moviesIds2, "a"
				+ Double.toString(10 * i + 1));

		String[] moviesIds3 = { m2.getId(), m3.getId(), m4.getId() };
		Actor a3 = new Actor(Double.toString(20 * i + 8), moviesIds3, "a"
				+ Double.toString(10 * i + 2));

		String[] moviesIds4 = { m2.getId(), m3.getId(), m4.getId(), m5.getId() };
		Actor a4 = new Actor(Double.toString(20 * i + 9), moviesIds4, "a"
				+ Double.toString(10 * i + 3));

		String[] moviesIds5 = { m2.getId(), m3.getId(), m4.getId(), m5.getId(),
				m5.getId() };
		Actor a5 = new Actor(Double.toString(20 * i + 10), moviesIds5, "a"
				+ Double.toString(10 * i + 4));

		elems.add(m1);
		elems.add(m2);
		elems.add(m3);
		elems.add(m4);
		elems.add(m5);
		elems.add(a1);
		elems.add(a2);
		elems.add(a3);
		elems.add(a4);
		elems.add(a5);

		area.writeAll(elems);
	}


}
