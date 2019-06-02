GS = -g
JC = javac
JVM= java 
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AYJDatabaseRunner.java \
	AYJDatabase.java \
	ComputerStudies.java \
	Course.java \
	Department.java \
	Mathematics.java \
	Music.java \
	Name.java \
	Person.java \
	Student.java \
	Teacher.java \
	TimeTable.java

MAIN = AYJDatabaseRunner

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN)

clean:
	$(RM) *.class