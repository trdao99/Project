package ra.utils;

import java.util.List;
import java.util.Scanner;

public class Pagination {
    public static <T> void pagination(List<T> list) {
        try {
            Scanner sc = new Scanner(System.in);
            int k = 0;
            boolean flag;
            boolean flag2;
            out:
            do {
                int j = k + 3;
                for (int i = k; i < j; i++) {
                    System.out.println(list.get(i).toString());
                }
                System.out.println("════════════════════════════════════════════════");
                if (k >= 1) {
                    System.out.print("<==1. Trang trước\t");
                    flag2 = true;
                } else {
                    flag2 = false;
                }

                if (j <= list.size() - 1) {
                    System.out.println("2. Trang sau==>");
                    flag = true;
                } else {
                    flag = false;
                }
                System.out.println("3. Thoát");
                System.out.print("Chọn: ");
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        if (flag2) {
                            k -= 1;
                        }
                        break;
                    case 2:
                        if (flag) {
                            k += 1;
                        }
                        break;
                    case 3:
                        break out;
                }
            } while (true);
        }catch (IndexOutOfBoundsException e) {
            System.out.println(" ");
        }
    }
}

