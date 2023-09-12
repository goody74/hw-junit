package ru.netology;

public class PasswordChecker {
    private int minLenght;
    private int maxRepits;

    public PasswordChecker(){
    }
    public PasswordChecker(int minLenght, int maxRepits){
        this.minLenght= minLenght;
        this.maxRepits = maxRepits;
    }



    public void setMinLength(int lenght) {
        try {
            if (lenght < 8) {
                throw new IllegalArgumentException();
            }
            minLenght = lenght;
        } catch (IllegalArgumentException exception) {
            System.out.println("длина должна быть не менее 8 символов ");
            System.exit(1);
        }

    }

    public void setMaxRepits(int repits) {
        try {
            if (repits <= 0) {
                throw new IllegalArgumentException();
            }
            maxRepits = repits;
        } catch (IllegalArgumentException exception) {
            System.out.println("количество повторений должно быть больше 0");
            System.exit(1);
        }
    }


    public boolean verify(String password) {
        try {
            if (minLenght == 0 || maxRepits == 0) {
                throw new IllegalStateException();
            }
        } catch (IllegalStateException exception) {
            System.out.println("Небходимо заполнить параметры проверки пароля");
            System.exit(1);
        }
        int count = 1;
        int passLength = password.length();

        if (passLength < minLenght) {
            return false;
        }
        for (int i = 0; i < passLength - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                count++;
            } else if (count <= maxRepits) {
                count = 1;
            }
        }
        return count <= maxRepits;
    }


}
