package Lab3;// ArrayNumberSequence.java

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}


	// add code here

	@Override
	public int length() {
		return numbers.length;
	}

	@Override
	public double upperBound() {
		double max = numbers[0];
		for(int i = 1; i < numbers.length; i++){
			if(numbers[i] > max){
			max = numbers[i];
			}
		}
		return max;
	}

	@Override
	public double lowerBound() {
		double min = numbers[0];
		for(int i = 1; i < numbers.length; i++){
			if(numbers[i] < min){
			min = numbers[i];
			}
		}
		return min;
	}

	@Override
	public double numberAt(int position) throws IndexOutOfBoundsException {
		return numbers[position];
	}

	@Override
	public int positionOf(double number) {
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == number) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isIncreasing() {
		for(int i = 0; i < numbers.length - 1; i++){
			if(numbers[i] > numbers[i + 1]){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isDecreasing() {
		for(int i = 0; i < numbers.length - 1; i++)
		{
			if(numbers[i] < numbers[i + 1])
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(double number) 
	{
		for(int i = 0; i < numbers.length; i++) 
		{
			if(numbers[i] == number)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(double number) 
	{
		double[] newArr = new double[numbers.length + 1];
		for (int i = 0; i < numbers.length; i++)
		{
			newArr[i] = numbers[i];
		}
		newArr[numbers.length] = number; 
		numbers = newArr; 
	}

	@Override
	public void insert(int position, double number) 
	{
		double[] newArr = new double[numbers.length + 1];
		for (int i = 0; i < numbers.length + 1; i++)
		{
			if(i < position - 1)
			{
				newArr[i] = numbers[i];
			}
			else if(i == position - 1)
			{
				newArr[i] = number;
			}
			else
			{
				newArr[i] = numbers[i - 1];
			}
			
		}
		numbers = newArr;
	}

	@Override
	public void removeAt(int position) throws IndexOutOfBoundsException 
	{
		double[] newArr = new double[numbers.length - 1];
		for (int i = 0, j = 0; i < numbers.length; i++) 
		{
            if (i == position) 
			{
                continue;
            }
            newArr[j++] = numbers[i];
        }
		numbers = newArr;
	}

	@Override
	public double[] asArray() 
	{
		return numbers;
	}

	public static void main(String[] args){
		double[] array = {4.20, 6.9, 13.37, 9.9, 10.10};
		ArrayNumberSequence sequence = new ArrayNumberSequence(array);
		System.out.println(sequence);
		sequence.insert(1, 8.8);
		System.out.println(sequence);
		sequence.removeAt(0);
		System.out.println(sequence);
	}

}