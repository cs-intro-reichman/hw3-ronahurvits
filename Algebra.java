// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
    public static int plus(int x1, int x2) {
        int sum=x1;
        if (x2>0) {
            for(int i=1; i<=x2;i++){
                sum++;
        } }
        else {
            for(int i=1;i<=minus(0, x2);i++){
                sum--;
            }
        }
        
        return sum;
    }

    // Returns x1 - x2
    public static int minus(int x1, int x2) {
        int sum=x1;
        if(x2>0){
            for(int i=1;i<=x2;i++){
                sum--;
        }}
        else {
            for(int i=x2;i<0;i++){
                sum++;
            }
        }
        
        
        return sum;
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        int sum=0;
        if(x1==0 || x2==0) {
            sum=0;}
        if(x1>0 && x2>0){
        for(int i=1;i<=x2;i++){
            sum=plus(sum, x1);
        }}

        if(x1>0 &&x2<0){
            x2=minus(0, x2);
            for(int i=1;i<=x2;i++){
                sum=plus(sum, x1);
        }}

        if(x1<0 && x2>0){
           x1=minus(0, x1);
           for(int i=1;i<=x2;i++){
                sum=plus(sum, x1);
                }
                sum=minus(0, sum);
            }
        if(x1<0 && x2<0){
           x1=minus(0, x1);
           x2=minus(0, x2);
           for(int i=1;i<=x2;i++){
              sum=plus(sum, x1);
        }}
        
        return sum;
    }

    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        int sum=x;
            if (n==0) {
                return 1;
            }
            if (x==0) {
                return 0;
            }
            if (x>0) {
                for(int i=0; i<n-1;i++){
                    sum= times(sum, x); }
            }
            else { 
                x=minus(0, x);
                for(int i=0; i<n-1;i++){
                    sum= times(sum, x);
            }
            if (mod(n, 2)==0) {
                sum=minus(0, sum);
            }}
        
            
            return sum;
    
    }

    // Returns the integer part of x1 / x2 
    public static int div(int x1, int x2) {
       int c=0;
       boolean negNum=false;
       if (x1==0) {
        return 0;
       }
       if (x1<0 && x2<0) {
        x1=minus(0, x1);
        x2=minus(0, x2);
       }
       if (x1<0 && x2>0) {
        x1=minus(0, x1);
        negNum=true;
       }
       if (x1>0 && x2<0) {
        x2=minus(0, x2);
        negNum=true;
       }
       int sum=x1;
       while (sum>0 && ( sum>x2 || sum==x2) ){
        sum=minus(sum, x2);
        c++;
       }

       if (negNum== true) {
        return minus(0, c);
       } 
       else return c;
    }

    // Returns x1 % x2
    public static int mod(int x1, int x2) {
        int n1=x1;
        while (n1>0 && (n1==x2 || n1>x2)) {
            n1=minus(n1, x2);
        }
    
    return n1; }

    // Returns the integer part of sqrt(x) 
    public static int sqrt(int x) {
        int num=1;
     while(times(num, num)<x){
        num++;
     }
     if (times(num, num)==x ) {
        return num;
     }
     else
        return num-1;
    }         
}