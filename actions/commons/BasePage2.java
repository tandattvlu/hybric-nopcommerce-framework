package commons;

public class BasePage2 {
    // Biến toàn cục
    String fullName;
    public String getFullName(){

        String fullName = null;
        // Trong phạm vi khối lệnh (block code)
        for (int i =0; i< 10; i++) { // cục bộ
            int n = 1;// cục bộ

            if(n > 0){ // cục bộ
                int x = 10;
            }
        }

        return this.fullName;

    }
}
