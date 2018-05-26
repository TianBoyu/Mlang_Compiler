set -e; cd "$(dirname "$0")"; mkdir -p bin; find ./src/Code -name *.java | javac -d bin -cp "./lib/*" @/dev/stdin;
