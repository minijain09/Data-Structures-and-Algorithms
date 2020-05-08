import java.util.*;
public class RoomsAndBookings {
	
	
	public static boolean hotel(int booking[][], int k)
	{
		int rooms=k;
		int starttime=booking[0][0];
		int endtime=booking[0][1];
		rooms--;
		for (int i=1;i<booking.length;i++)
		{
			if (booking[i][0]>=endtime)
			{
				rooms=k-1;
				starttime=booking[i][0];
				endtime=booking[i][1];
			}
			else
			{
				if (rooms==0)
					return false;
				else
				{
					rooms--;
					starttime=booking[i][0];
					endtime=booking[i][1];
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		int booking[][]=new int[][] {{ 1, 3, 5 },{ 2, 6, 8 }};
		int k=2;
		System.out.println(hotel(booking, k));
		
	}

}
