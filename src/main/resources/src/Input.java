class Task {
    void m(int a, int b,  int c) {
        boolean flag = false;
         if (a > b ) {
             flag = true;
             a = a + 1;
         }
         if ( a == b ) {
            b = a + 2;
            flag = b > c;
         }
         a = b+c;
         if (flag) {
             System.out.println("Done");

    }
}