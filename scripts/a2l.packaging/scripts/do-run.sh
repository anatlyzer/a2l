
case $1 in
  std)
    ECLIPSE_PLUGINS=`echo $(pwd)/../../../eclipse-jars`
    ;;	
  jesus) 
    ECLIPSE_PLUGINS="/home/jesus/usr/a2l/plugins"
    ;;
  loli)
    ECLIPSE_PLUGINS="C:/Users/Loli/Desktop/eclipseNeon/plugins"
    ;;
  *)
    echo "Exec with ./$0 jesus|loli model [ a2l|atl|both minThreads maxThreads numRuns fooprint|nofootprint optimised|nooptimised]"
    exit
    ;;
esac


MODEL=$2
if [ -z "$MODEL" ]
  then
    echo "Exec with ./$0 jesus|loli model [ a2l|atl|both minThreads maxThreads numRuns ]"
    exit
fi


KIND=$3
if [ -z "$KIND" ]
  then
    KIND="a2l"
    echo "Using default execution type '$KIND' (options are a2l, atl and both)"
fi

MIN=$4
MAX=$5
RUNS=$6
FOOTPRINT=$7
OPTIMISED=$8
BENCHMARK_FOLDER=$9

if [ -z "$MIN" ] 
  then
    MIN=1
    echo "Using default min threads '$MIN'"
fi

if [ -z "$MAX" ] 
  then
    MAX=16
    echo "Using default max threads '$RUNS'"
fi

if [ -z "$RUNS" ] 
  then
    RUNS=15
    echo "Using default number of runs '$RUNS'"
fi

if [ -z "$FOOTPRINT" ] 
  then
    FOOTPRINT="footprint"
    echo "Using footprint as default option"
fi

if [ -z "$OPTIMISED" ] 
  then
    OPTIMISED="optimised"
    echo "Using optimised as default option"
fi

if [ -z "$BENCHMARK_FOLDER" ] 
  then
    BENCHMARK_FOLDER="/tmp/benchmark"
    echo "Using /tmp/benchmark as default option"
fi


#CLASSPATH=$(pwd)/../../../scripts/a2l.packaging/build/a2l.jar:$ECLIPSE_PLUGINS/*

EMF=`ls $ECLIPSE_PLUGINS/*emf* | paste -s -d ":" -`
ATL=`ls $ECLIPSE_PLUGINS/*atl* | paste -s -d ":" -`
MODISCO=`ls $ECLIPSE_PLUGINS/*modisco* | paste -s -d ":" -`
UML=`ls $ECLIPSE_PLUGINS/*uml* | paste -s -d ":" -`
ANTLR=`ls $ECLIPSE_PLUGINS/*antlr*3* | paste -s -d ":" -`
ECLIPSE=`ls $ECLIPSE_PLUGINS/*org.eclipse.core.* | paste -s -d ":" -`

CLASSPATH=$(pwd)/../../../scripts/a2l.packaging/build/a2l.jar:$EMF:$ATL:$MODISCO:$UML:$ANTLR:$ECLIPSE

#Some tests!
#java -d64 -server -XX:+AggressiveOpts -XX:+UseLargePages -Xmn10g 
# -Xms26g -Xmx26g
#java -d64 -server -XX:+AggressiveOpts -Xmn1024m -Xms2048m -Xmx2048m -jar deploy/imdb.jar 1 3 1
#    -XX:GCTimePercentage=NN
#java -d64 -server -XX:+AggressiveOpts -Xms2048m -Xmx2048m -jar deploy/imdb.jar 1 12 10
#java -d64 -server -XX:+AggressiveOpts -Xms2048m -Xmx2048m -jar deploy/imdb.jar 1 3 1
#-XX:NewSize=1600m -XX:MaxNewSize=1800 


if [ -z "$MEMORY" ] 
  then
    MEMORY="-Xms8129m -Xmx8129m"
fi


cd ..
echo "Launching JVM and A2L..."
echo "    with $JAVA_CUSTOM_OPTS"
echo "  memory $MEMORY"
echo
java -d64 -server $MEMORY $JAVA_CUSTOM_OPTS -cp $CLASSPATH  $TEST_CASE $MIN $MAX $RUNS $MODEL $KIND $FOOTPRINT $OPTIMISED nosave $BENCHMARK_FOLDER
