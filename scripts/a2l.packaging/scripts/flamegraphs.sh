#!/bin/bash

# $1  --> pid

PID=$1
if [ -z "$PID" ]
  then
    echo "Exec with $0 PID"
    exit
fi

NAME=$2
if [ -z "$NAME" ]
  then
    NAME="$1"
fi



perf_agent="$HOME/thirdparty/perf-map-agent"
flames="$HOME/thirdparty/FlameGraph"

sudo $perf_agent/bin/perf-java-record-stack $1
sudo perf script -i /tmp/perf-$1.data > /tmp/out-$1.stacks
sudo $flames/stackcollapse-perf.pl /tmp/out-$1.stacks | tee /tmp/out-$1.collapsed | $flames/flamegraph.pl --color=java --hash > /tmp/flamegraph-$NAME.svg


