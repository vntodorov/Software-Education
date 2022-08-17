package ForLoop;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int period = Integer.parseInt(scanner.nextLine());
        int doctors = 7;
        int TreatedPatients = 0;
        int UntreatedPatients = 0;
        for (int i = 1; i <= period; i++) {
            int AllPatients = Integer.parseInt(scanner.nextLine());
            if (i % 3 == 0 && UntreatedPatients > TreatedPatients){
                doctors++;
            }
            if (AllPatients <= doctors) {
                TreatedPatients += AllPatients;
            } else {
                TreatedPatients += doctors;
                UntreatedPatients += AllPatients - doctors;
            }
        }
        System.out.printf("Treated patients: %d.%n", TreatedPatients);
        System.out.printf("Untreated patients: %d.", UntreatedPatients);
    }
}
