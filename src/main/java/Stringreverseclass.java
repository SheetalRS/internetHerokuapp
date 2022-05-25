
public class Stringreverseclass {

	public static void main(String[] args) {
		String s = "test12pop34type";
		String result="";
		int p=0;
		int start=0;
		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i)>='0'&& s.charAt(i)<='9') {
				
				if ((i-1)>=0) {
					 if (s.charAt(i-1)>='a'|| s.charAt(i-1)<='z'||s.charAt(i-1)>='A'|| s.charAt(i-1)<='Z') {
							p=i;
							
							for (int j =(p-1); j >=start; j--) 
							{
								result=result+s.charAt(j);
							}
							
						}
					 
					 
				}
				
				start=i;
			}else {
				continue;
			}
				
			
			
			
		}
		
		System.out.println(result);
		
	}
}
