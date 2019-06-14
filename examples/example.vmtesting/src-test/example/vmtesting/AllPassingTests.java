package example.vmtesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import example.vmtesting.ant2maven.Ant2MavenTestCase;
import example.vmtesting.assertionmodification.AssertionModificationTestCase;
import example.vmtesting.bibtex2docbook.BibTeX2DocBookTestCase;
import example.vmtesting.book2publication.Book2PublicationTestCase;
import example.vmtesting.class2relational.Class2RelationalTestCase;
import example.vmtesting.dsl2km3.DSL2KM3TestCase;
import example.vmtesting.dslmodel2km2.DSLModel2KM2TestCase;
import example.vmtesting.ecore2class.Ecore2ClassTestCase;
import example.vmtesting.families2persons.Families2PersonsTestCase;
import example.vmtesting.flattentest.FlattenTestTestCase;
import example.vmtesting.km32atl.KM32ATL_KM22MMTestCase;
import example.vmtesting.maven2xml.Maven2XMLTestCase;
import example.vmtesting.trace2performancemetrics.Trace2PerformanceMetricsTestCase;
import example.vmtesting.uml2relational.UML2RelationalTestCase;
import example.vmtesting.xml2ant.XML2AntTestCase;
import example.vmtesting.xml2book.XML2BookTestCase;
import example.vmtesting.xml2dslmodel.XML2DSLModelTestCase;

@RunWith(Suite.class)
@SuiteClasses({

	Ant2MavenTestCase.class,
	AssertionModificationTestCase.class,
	
////	ATL2ProblemTestCase.class,  // Do not work
	BibTeX2DocBookTestCase.class,
	Book2PublicationTestCase.class,
	Class2RelationalTestCase.class,
//	DSL2KM3TestCase.class,  // Not passing
	DSLModel2KM2TestCase.class, 
	Ecore2ClassTestCase.class,
	Families2PersonsTestCase.class,	
//	FlattenTestTestCase.class,  // Not passing
//	KM32ATL_KM22MMTestCase.class,   // Not passing
	Maven2XMLTestCase.class,
	Trace2PerformanceMetricsTestCase.class,
	XML2AntTestCase.class,
	XML2BookTestCase.class,

//	XML2DSLTestCase.class,
//	XML2DSLModelTestCase.class,  // Not passing
	UML2RelationalTestCase.class
})
public class AllPassingTests {

}
