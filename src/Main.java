public class Main{
    public static void main(String[] args) {


        String login = "cobra1256";
        String password = "drnbf123";
        String confirmPassword = "drnbf123";
        System.out.println(receivingParameters(login,password,confirmPassword));

    }

    public static boolean receivingParameters(String login, String password, String confirmPassword) {
        boolean checkLogin;
        boolean checkPassword;
        boolean lengthLogin;
        boolean lengthPassword;
        boolean equality;
        try {
            lengthLogin = checkLengthLogin(login);
            lengthPassword = checkLengthPassword(password);
            checkLogin = checkingTheContents(login);
            checkPassword = checkingTheContents(password);
            equality = checkEquality(password, confirmPassword);
        } catch (WrongPasswordException | WrongLoginException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return lengthLogin && lengthPassword && checkLogin && checkPassword && equality;
    }


    public static boolean checkLengthLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }
        return true;
    }

    public static boolean checkLengthPassword(String password) {
        if (password.length() > 19) {
            System.out.println("Слишком длинный пароль");
            return false;
        }
        return true;

    }

    public static boolean checkingTheContents(String loginPassword) {
        if (loginPassword==null){
            System.out.println("Значение не задано");
            return false;
        }
        if (loginPassword.matches("\\w+")) {
            return true;
        }
        System.out.println("Должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
        return false;
    }

    public static boolean checkEquality(String password, String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) {
            return true;
        }
        throw new WrongPasswordException("Пароли не совпадают");
    }
}

