public class Data {
    public static void main(String[] args) {
        System.out.println(checkCredentials("logIn","passWord","passWord"));
        System.out.println(checkCredentials("logIn123456789login_123456789","passWord","passWord"));
        System.out.println(checkCredentials("logIn","passWord7","passWord"));
        System.out.println(checkCredentials("logIn","passWord7123456789123456789","passWord7123456789123456789"));
        System.out.println(checkCredentials("ффффogIn","passWord7123456789123456789","passWord7123456789123456789"));
        System.out.println(checkCredentials("logIn","ффpassWord71236789","ффpassWord71236789"));

    }
    public static boolean checkCredentials(String login, String password,String confirmPassword) {
        try {
            return CredentialsValidator.validateCredentials(login,password,confirmPassword);
        }catch (WrongLoginException e){
            System.out.println("Ошибка проверки логина: " + e.getMessage());
            return false;
        }catch (WrongPasswordException e){
            System.out.println("Ошибка проверки пароля: "+ e.getMessage());
            return false;
        }
    }
}
