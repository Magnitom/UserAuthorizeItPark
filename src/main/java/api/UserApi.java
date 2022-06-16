package api;

 public abstract class UserApi {

    String login;
    String pass;
    String secondName;
    String name;
    String thirdName;
    int age;
    String permission;


     public String getLogin() {
         return login;
     }

     public String getPass() {
         return pass;
     }

     public UserApi(String login, String pass, String permission) {
         this.login = login;
         this.pass = pass;
         this.permission = permission;
     }

     public String getPermission() {
         return permission;
     }

     public void setSecondName(String secondName) {
         this.secondName = secondName;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setThirdName(String thirdName) {
         this.thirdName = thirdName;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public String getSecondName() {
         return secondName;
     }

     public String getName() {
         return name;
     }

     public String getThirdName() {
         return thirdName;
     }

     public int getAge() {
         return age;
     }

 }
