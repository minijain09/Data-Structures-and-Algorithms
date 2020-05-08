import java.util.*;

public class PoliceAndThieves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		char array[] = new char[] {'T', 'T', 'P', 'P', 'T', 'P'};
		Queue<Integer> q = new LinkedList<>();
		int k = 2;
		int count = 0;
		int j = 0;
		while (j < n) {
			if (array[j] == 'N') {
				j++;
			} else if (array[j] == 'T') {
				q.add(j);
				j++;
			} else {
				if (!q.isEmpty()) {
					int x = q.peek();
					if (x < j - k)
						q.poll();
					else {
						q.poll();
						count++;
						j++;
					}
				} else {
					for (int h = j + 1; j <= j + k; j++) {
						if (array[h] == 'T') {
							count++;
							array[h] = 'N';
							break;
						}
					}
				}
			}
		}
		System.out.println(count);
	}

}
