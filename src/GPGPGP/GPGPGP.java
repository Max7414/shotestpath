package GPGPGP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class GPGPGP {
	static String s = "urchoose";
	static void PATH(int[] path, int choose,int dest)
	{
		s = s +  " -> " + Integer.toString(path[choose]);
		if(path[path[choose]]!=dest)
			PATH(path,path[choose],dest);
		else
			 s = s + " -> " + dest;
	}
	static int minIndex(int numbers[], ArrayList<Boolean> visited) {
		int minValue = 9999999;
		int minIndex = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < minValue && !visited.get(i)) {
				minValue = numbers[i];
				minIndex = i;
			}
		}
		return minIndex;
	}


	public static void main(String[] args) {
		int gp[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				gp[i][j] = 0;
			}
		}
		gp[1][0] = 5;
		gp[0][1] = 5;

		gp[0][2] = 2;
		gp[2][0] = 2;

		gp[1][3] = 2;
		gp[3][1] = 2;

		gp[1][4] = 4;
		gp[4][1] = 4;

		gp[2][4] = 10;
		gp[4][2] = 10;

		gp[1][4] = 4;
		gp[4][1] = 4;

		gp[3][4] = 1;
		gp[4][3] = 1;


		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(gp[i][j]);
				if (j == 5)
					System.out.println("");

			}
		}
		
		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		for (var i = 0; i < 6; i++) {
			visited.add(i, false);
		}
		// boolean[] visited = new boolean[6];

		int[] length = new int[6];

		for (var i = 0; i < length.length; i++) {
			length[i] = 99;
		}

		int[] path = new int[6];

		Queue<Integer> q = new LinkedList<Integer>();

		visited.set(0, true);

		length[0] = 0;

		path[0] = 0;

		q.add(0);

		while (!q.isEmpty()) {
			int top = q.remove();
			visited.set(top, true);
			if (visited.stream().allMatch(Boolean::booleanValue))
				break;
			for (int i = 0; i < 6; i++) {
				if (gp[top][i] > 0 && visited.get(i) == false) {
					if (gp[top][i] + length[top] < length[i]) {// original gp[top][i] + length[path[i]] < length[i]
						path[i] = top;
						length[i] = gp[top][i] + length[path[i]];
					}
				}
			}
			q.add(minIndex(length, visited));

		}
		for (var i = 0; i < length.length; i++) {
			System.out.print(length[i]+" ");
		}
		System.out.println("");
		for (var i = 0; i < path.length; i++) {
			System.out.print(path[i]+" ");
		}
		System.out.println("");
		System.out.println("A B C D E F");
		System.out.print("0 1 2 3 4 5");
		System.out.println("");
		PATH(path,4,0);
		System.out.println(s);
		

	}
}
