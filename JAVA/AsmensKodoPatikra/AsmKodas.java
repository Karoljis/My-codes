public class AsmKodas {
    public static void main(String[] args) {
        String asmKodas = "66666666661";
        int[] akMasyvas = new int[11];
        for (int i = 0; i < asmKodas.length(); i++) {
            akMasyvas[i] = Integer.parseInt(String.valueOf(asmKodas.charAt(i)));
        }
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < asmKodas.length() - 1; i++) {
            if (i < 9) {
                sum = sum + akMasyvas[i] * (i + 1);
            }
            if (i == 9) {
                sum1 = sum1 + akMasyvas[i] * 1;
            }
        }
        int k1 = (sum + sum1) % 11;

        int sum2 = 0;
        int sum3 = 0;
        if (k1 == 10) {
            for (int i = 0; i < asmKodas.length() - 1; i++) {
                if (i < 7) {
                    sum2 = sum2 + akMasyvas[i] * (i + 3);
                }
                if (i >= 7) {
                    sum3 = sum3 + akMasyvas[i] * (i - 6);
                }
            }
            int k2 = (sum2 + sum3) % 11;
            if (k2 == 10) {
                int k3 = 0;
                if (k3==akMasyvas[asmKodas.length()-1]){
                    System.out.println("Jūsų kodas įvestas geras");
                }else{
                    System.out.println("Jūsų kodas įvestas blogas");
                }
            }
            else{if (k2==akMasyvas[asmKodas.length()-1]){
                System.out.println("Jūsų kodas įvestas geras");
            }else{
                System.out.println("Jūsų kodas įvestas blogas");
            }

            }
        }else{
            if (k1==akMasyvas[asmKodas.length()-1]){
                System.out.println("Jūsų kodas įvestas geras");
            }else{
                System.out.println("Jūsų kodas įvestas blogas");
            }
        }


    }
}

