
public class Arrayrev {

	public static void main(String[] args) {
		
		int[] arr= {1,2,3,4,5,6,7,8,9};
		int k= arr.length-1;
		for(k=arr.length-1;k>=0;k--) {
			System.out.println(arr[k]-1+" ");
		}
	}
}
		