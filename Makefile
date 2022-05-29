ifeq ($(OS), Windows_NT)
	CLASSPATH = ".;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar;build/*.class"
else
	CLASSPATH = .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:build/*.class
endif

SOURCEFILES=$(wildcard src/*.java)
OBJFILES=$(SOURCEFILES:%.java=%.class)

test: $(OBJFILES)
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore  MarkdownParseTest
$(OBJFILES): $(SOURCEFILES)
	javac -cp $(CLASSPATH) -d build $(SOURCEFILES)