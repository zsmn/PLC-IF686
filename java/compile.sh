find . -type f -name "*.java" -exec basename {} \;  | sed "s/\.java//" > out.txt

mkdir $(<out.txt cut -d/ -f1)

while read p; do
  cd "$p"
  mv ../"$p".java .
  javac "$p".java
  cd ..
  echo "$p"
done <out.txt
