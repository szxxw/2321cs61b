

public class hw0_practiceit{
    public static void DrawingTriangle( int x ) {
        int i = 1;
        while (i <= x) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
            i++;
        }
    }
    public static void main(String[] args){
        DrawingTriangle( 5);
        }
}

