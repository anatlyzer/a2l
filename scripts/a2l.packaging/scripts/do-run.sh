RUN_COMMAND="Exec with ./$0 std|jesus|loli model [ a2l|atl|both minThreads maxThreads numRuns fooprint|nofootprint optimised|nooptimised]"

case $1 in
  std)
    ECLIPSE_PLUGINS=`echo $(pwd)/../../../eclipse-jars`
    ;;	
  jesus) 
    ECLIPSE_PLUGINS="/home/jesus/usr/a2l-2019/plugins"
    ;;
  loli)
    ECLIPSE_PLUGINS="C:/Users/Loli/Desktop/eclipseNeon/plugins"
    ;;
  *)
    echo $RUN_COMMAND
    exit
    ;;
esac


EMF=`ls $ECLIPSE_PLUGINS/*emf* | paste -s -d ":" -`
ATL=`ls $ECLIPSE_PLUGINS/*atl* | paste -s -d ":" -`
MODISCO=`ls $ECLIPSE_PLUGINS/*modisco* | paste -s -d ":" -`
UML=`ls $ECLIPSE_PLUGINS/*uml* | paste -s -d ":" -`
ANTLR=`ls $ECLIPSE_PLUGINS/*antlr*3* | paste -s -d ":" -`
ECLIPSE=`ls $ECLIPSE_PLUGINS/*org.eclipse.core* | paste -s -d ":" -`
OSGI=`ls $ECLIPSE_PLUGINS/*org.eclipse.osgi* | paste -s -d ":" -`
EQUINOX=`ls $ECLIPSE_PLUGINS/*org.eclipse.equinox*jar | paste -s -d ":" -`
OBJECTWEB=`ls $ECLIPSE_PLUGINS/*org.objectweb.*jar | paste -s -d ":" -`

# Restrict the classpath depending on whether we use std (with
# selected plugins copied) or we target the jars of the Eclipse
# directory
case $1 in
  std)
      CLASSPATH=$(pwd)/../../../scripts/a2l.packaging/build/a2l.jar:$ECLIPSE_PLUGINS/*
      echo $CLASSPATH
      ;;
  *)
    CLASSPATH=$(pwd)/../../../scripts/a2l.packaging/build/a2l.jar:$ECLIPSE:$EQUINOX:$OSGI:$EMF:$ATL:$MODISCO:$UML:$ANTLR:$OBJECTWEB
    ;;
esac


case $2 in
  copydeps)
    rm -rf /tmp/deps
	mkdir /tmp/deps
	cp `echo $EMF | tr ":" " "` /tmp/eclipse-jars
	cp `echo $ATL | tr ":" " "` /tmp/eclipse-jars
	cp `echo $MODISCO | tr ":" " "` /tmp/eclipse-jars
	cp `echo $UML | tr ":" " "` /tmp/eclipse-jars
	cp `echo $ANTLR | tr ":" " "` /tmp/eclipse-jars
	cp `echo $ECLIPSE | tr ":" " "` /tmp/eclipse-jars
	cp `echo $EQUINOX | tr ":" " "` /tmp/eclipse-jars
	cp `echo $OSGI | tr ":" " "` /tmp/eclipse-jars
	cp `echo $OBJECTWEB | tr ":" " "` /tmp/eclipse-jars	
	exit
  ;;
esac

MODEL=$2
if [ -z "$MODEL" ]
  then
    echo $RUN_COMMAND
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
SAVE=$9
BENCHMARK_FOLDER=$10

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

if [ -z "$SAVE" ] 
  then
    SAVE="nosave"
    echo "Using save=$SAVE as default option"
fi

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

java -d64 -server $MEMORY $JAVA_CUSTOM_OPTS -cp $CLASSPATH  $TEST_CASE $MIN $MAX $RUNS $MODEL $KIND $FOOTPRINT $OPTIMISED $SAVE $BENCHMARK_FOLDER
