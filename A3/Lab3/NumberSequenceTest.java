package Lab3;// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers = 
                {1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0};
        NumberSequence sequence = null;
        sequence = new ArrayNumberSequence(realNumbers);
        //sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        // add code here
        int length = sequence.length();
        out.println("length of the sequence is:");
        out.println(length);

        double upperBound = sequence.upperBound();
        out.println("the upper bound is:");
        out.println(upperBound);

        double lowerBound = sequence.lowerBound();
        out.println("the lower bound is:");
        out.println(lowerBound);

        double numberAt = sequence.numberAt(4);
        out.println("the number at the position is:");
        out.println(numberAt);

        int positionOf = sequence.positionOf(8);
        out.println("the given number is at position:");
        out.println(positionOf);

        boolean isIncreasing = sequence.isIncreasing();
        out.println("the sequence is increasing");
        out.println(isIncreasing);

        boolean isDecreasing = sequence.isDecreasing();
        out.println("the sequence is decreasing");
        out.println(isDecreasing);

        boolean contains = sequence.contains(21);
        out.println("the sequence contains: 21");
        out.println(contains);

        sequence.add(34);
        out.println("the number that was added to the sequence was:");
        out.println(sequence);

        sequence.insert( 7, 0.0);
        out.println("the number 0.0 was added to the position 7");
        out.println(sequence);

        sequence.removeAt(7);
        out.println("the number at the position 7 was removed");
        out.println(sequence);

        sequence.asArray();
        out.println("the numbers represented as an array");
        out.println(sequence);
    }
}