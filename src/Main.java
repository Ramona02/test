import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        int i, j, linie, coloana;
        int[][] table = new int[3][3];
        boolean turn = true;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Jucatorul trebuie sa introduca linia: ");
            linie = sc.nextInt();
            System.out.print("Jucatorul trebuie sa introduca coloana: ");
            coloana = sc.nextInt();
            if (isValidInput(linie, coloana)) {
                if (validareCelula(table, linie, coloana)) {
                    table[linie][coloana] = (turn == true ? 1 : 2);
                    turn = !turn;
                } else
                    System.out.println("Pozitia dorita nu este libera, alegeti alte coordonate");
            } else
                System.out.println("Coordonatele depasesc tabla de joc, alegeti alte coordonate");

            showTable(table);
            int cod = jocTerminat(table);
            if( cod!=0)
            {
                System.out.println("A castigat "+cod);
                break;
            }

            if (completareMatrice(table)) {
                if(cod==0);
                System.out.print("Remiza");
                break;
            }
        }
    }
    public static boolean validareCelula(int v[][], int i, int j) //celula libera pt completare
    {
        if (v[i][j] != 1 && v[i][j] != 2)
            return true;
        else return false;
    }

    public static boolean isValidInput(int a, int b) //coordonatele sunt cuprinse in matrice 3x3
    {
        if (a >= 0 && a <= 2 && b >= 0 && b <= 2)
            return true;
        else
            return false;
    }

    public static void showTable(int table[][]) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j)
                System.out.print(table[i][j]);
            System.out.println();
        }
    }

    public static int jocTerminat(int table[][]) {

        if (table[0][0] == table[0][1] && table[0][1] == table[0][2]) {
            return table[0][0];
        }
        if (table[1][0] == table[1][1] && table[1][1] == table[1][2]) {
            return table[1][0];
        }
        if (table[2][0] == table[2][1] && table[2][1] == table[2][2]) {
            return table[2][0];
        }
        if (table[0][0] == table[1][0] && table[1][0] == table[2][0]) {
            return table[0][0];
        }
        if (table[0][1] == table[1][1] && table[1][1] == table[2][1]) {
            return table[0][1];
        }
        if (table[0][2] == table[1][2] && table[1][2] == table[2][2]) {
            return table[0][2];
        }
        if (table[0][0] == table[1][1] && table[1][1] == table[2][2]) {
            return table[0][0];
        }
        if (table[2][0] == table[1][1] && table[1][1] == table[0][2]) {
            return table[2][0];
        }
        return 0;
    }
    public static boolean completareMatrice(int v[][]){
        int k=0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (v[i][j] == 0)
                    k++;
            }
        }
        if(k==0)
            return true;
        else
            return false;

    }
}