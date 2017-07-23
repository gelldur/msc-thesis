 
javac -cp SampleJavaCode.jar Test.java
javac -cp SampleJavaCode-after-obfuscation.jar TestObfuscated.java

# To run
java -cp SampleJavaCode.jar:. Test
java -cp SampleJavaCode-after-obfuscation.jar:. TestObfuscated
