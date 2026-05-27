import java.util.*;
import java.io.*;

public class JosephusSim
{
	private PersonNode circle;     // a PersonNode pointer that tracks first node
	private int size;              // the number of people in the circle
	private int eliminationCount;  // the number to count to for elimination
	private PersonNode track;      // a PersonNode pointer to help with elimination

	public JosephusSim(String fileName)
	{
		size = 0;
		try
		{
			// load names from the file in order, generating a singly linked list of PersonNodes
			Scanner file = new Scanner(new File(fileName));
			circle = new PersonNode(file.next());
			size++;
			track = circle;
			while (file.hasNext())
			{
				track.next = new PersonNode(file.next());
				track = track.next;
				size++;
			}

			// make the ring circular by attaching last node's next to front
			track.next = circle;

			// generate, print, and save the random elimination count
			Random rand = new Random();
			eliminationCount = rand.nextInt(size / 2) + 1;
			System.out.println("=== Elimination count is " + eliminationCount + " ===");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Something went wrong with " + fileName);
		}
	}

	public void eliminate()
	{
		// count to the elimination count

		// print who will be eliminated

		// eliminate the person and update "front" of the circle and size

	}

	public boolean isOver()
	{
		// check if there's only one person left in the circle
		return false;
	}

	public String toString()
	{
		// if there's only one person left, print them as the last survivor
		if (isOver())
		{
			return circle.name + " is the last survivor!";
		}

		// print the remaining survivors (watch out for infinite loop since list is circular)
		String result = "";
		PersonNode current = circle;
		int count = 1;

		do
		{
			if (count > 1)
				result += ", ";
			result += count + "-" + current.name;
			current = current.next;
			count++;
		} while (current != circle);

		return "Remaining survivors: " + result;
	}
}
